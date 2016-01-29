/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.server.blocklyprop.jsp;

import com.google.inject.Inject;
import org.apache.commons.configuration.Configuration;

/**
 *
 * @author Michel
 */
public class Properties {

    private static Configuration configuration;

    @Inject
    public void setConfiguration(Configuration configuration) {
        Properties.configuration = configuration;
    }

    public static String getDownloadFilesBaseUrl(String file) {
        return configuration.getString("downloadfiles.baseurl") + (file.startsWith("/") ? "" : "/") + file;
    }

    public static String getAuthenticationServerBaseUrl(String path) {
        return configuration.getString("blocklyprop-auth.baseurl") + (path.startsWith("/") ? "" : "/") + path;
    }

}
