#!/usr/bin/python
# Compresses the Propeller C BlocklyProp generator files into a 
# single JavaScript file.
#
# Copyright 2012 Google Inc.
# http://blockly.googlecode.com/
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# This script generates two files:
#   propc_js_compressed.js
#   propc_js_uncompressed.js
# The compressed file is a concatenation of all of Blockly's core files which
# have been run through Google's Closure Compiler.  This is done using the
# online API (which takes a few seconds and requires an Internet connection).
# The uncompressed file is a script that loads in each of Blockly's core files
# one by one.  This takes much longer for a browser to load, but may be useful
# when debugging code since line numbers are meaningful and variables haven't
# been renamed.  The uncompressed file also allows for a faster development
# cycle since there is no need to rebuild or recompile, just reload.

import httplib, json, urllib, sys

filenames_libs = [
    "lib/chartist.min.js",
    "lib/jquery-1.11.3.min.js",
    "lib/beautify.js",
    "lib/bootstrap/core/js/bootstrap.min.js",
    "lib/bootstrap/plugins/bootbox.min.js"
]

filenames_setups = [
    "propterm.js",
    "detect.js",
    "blocklypropclient.js",
    "blocklyc.js",
    "utils.js",
    "editor.js"
]

filenames_cores = [
    "blockly/apps/blockly_compressed.js",
    "blockly/generators/propc.js",
    "blockly/generators/field_range.js",
    "blockly/language/en/_messages.js"
]

filenames_gens = [
    "blockly/generators/propc/base.js",
    "blockly/generators/propc/control.js",
    "blockly/generators/propc/variables.js",
    "blockly/generators/propc/procedures.js",
    "blockly/generators/propc/gpio.js",
    "blockly/generators/propc/communicate.js",
    "blockly/generators/propc/sensors.js",
    "blockly/generators/propc/heb.js",
    "blockly/generators/propc/s3.js"
]

filenames_styles = [
        "lib/chartist.min.css",
        "lib/bootstrap/core/css/bootstrap.min.css",
        "style-editor.css",
        "style-clientdownload.css",
]

header = ('// Do not edit this file; automatically generated by build_propc.py.\n'
          '"use strict";')

def gen_compressed_css(filenames, target_filename):
  inc = ''
  for filename in filenames:
    f = open(filename)
    inc = inc + f.read()
    f.close()

  inc = inc.replace("url('images", "url('../images")

  params = [('input', inc)]


  headers = { "Content-type": "application/x-www-form-urlencoded" }
  conn = httplib.HTTPSConnection('cssminifier.com')
  conn.request('POST', '/raw', urllib.urlencode(params), headers)
  response = conn.getresponse()
  res = response.read()
  conn.close

  f = open(target_filename, 'w')
  f.write(res)
  f.close()

  original_kb = int(len(inc) / 1024 + 0.5)
  compressed_kb = int(len(res) / 1024 + 0.5)
  ratio = int(float(compressed_kb) / float(original_kb) * 100 + 0.5)
  print 'SUCCESS: ' + target_filename
  print 'Size changed from %d KB to %d KB (%d%%).' % (original_kb, compressed_kb, ratio)


def gen_uncompressed(filenames, target_filename):
  #target_filename = 'propc_js_uncompressed.js'
  inc = ''

  for filename in filenames:
    f = open(filename)
    inc = inc + f.read() + '\n'
    f.close()


  f = open(target_filename, 'w')
  f.write(inc)
  f.close()
  print 'SUCCESS: ' + target_filename

def gen_compressed(filenames, target_filename):
  #target_filename = 'propc_js_compressed.js'
  # Define the parameters for the POST request.
  params = [
      ('compilation_level', 'SIMPLE_OPTIMIZATIONS'),
      ('use_closure_library', 'true'),
      ('output_format', 'json'),
      ('output_info', 'compiled_code'),
      ('output_info', 'warnings'),
      ('output_info', 'errors'),
      ('output_info', 'statistics'),
    ]

  # Read in all the source files.
  for filename in filenames:
    f = open(filename)
    params.append(('js_code', ''.join(f.readlines())))
    f.close()

  # Send the request to Google.
  headers = { "Content-type": "application/x-www-form-urlencoded" }
  conn = httplib.HTTPConnection('closure-compiler.appspot.com')
  conn.request('POST', '/compile', urllib.urlencode(params), headers)
  response = conn.getresponse()
  json_str = response.read()
  conn.close

  # Parse the JSON response.
  json_data = json.loads(json_str)

  def file_lookup(name):
    if not name.startswith('Input_'):
      return '???'
    n = int(name[6:])
    return filenames[n]

  if json_data.has_key('errors'):
    errors = json_data['errors']
    for error in errors:
      print 'FATAL ERROR'
      print error['error']
      print '%s at line %d:' % (
          file_lookup(error['file']), error['lineno'])
      print error['line']
      print (' ' * error['charno']) + '^'
  else:
    if json_data.has_key('warnings'):
      warnings = json_data['warnings']
      for warning in warnings:
        print 'WARNING'
        print warning['warning']
        print '%s at line %d:' % (
            file_lookup(warning['file']), warning['lineno'])
        print warning['line']
        print (' ' * warning['charno']) + '^'
      print

    code = header + '\n' + json_data['compiledCode']

    stats = json_data['statistics']
    original_b = stats['originalSize']
    compressed_b = stats['compressedSize']
    if original_b > 0 and compressed_b > 0:
      f = open(target_filename, 'w')
      f.write(code)
      f.close()

      original_kb = int(original_b / 1024 + 0.5)
      compressed_kb = int(compressed_b / 1024 + 0.5)
      ratio = int(float(compressed_b) / float(original_b) * 100 + 0.5)
      print 'SUCCESS: ' + target_filename
      print 'Size changed from %d KB to %d KB (%d%%).' % (
          original_kb, compressed_kb, ratio)
    else:
      print 'UNKNOWN ERROR'

if __name__ == '__main__':
  gen_uncompressed(filenames_cores, 'compressed/propc_cores.js')
  gen_uncompressed(filenames_libs, 'compressed/propc_libs.js')
  gen_compressed(filenames_setups, 'compressed/propc_setups.min.js')
  gen_compressed(filenames_gens, 'compressed/propc_gens.min.js')
  gen_compressed_css(filenames_styles, 'compressed/propc_styles.css')