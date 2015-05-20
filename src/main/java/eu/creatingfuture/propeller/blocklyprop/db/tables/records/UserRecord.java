/**
 * This class is generated by jOOQ
 */
package eu.creatingfuture.propeller.blocklyprop.db.tables.records;


import eu.creatingfuture.propeller.blocklyprop.db.tables.User;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record8<Integer, String, String, String, String, Byte, Timestamp, Timestamp> {

	private static final long serialVersionUID = -763913553;

	/**
	 * Setter for <code>blocklyprop.user.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>blocklyprop.user.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>blocklyprop.user.screenname</code>.
	 */
	public void setScreenname(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>blocklyprop.user.screenname</code>.
	 */
	public String getScreenname() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>blocklyprop.user.email</code>.
	 */
	public void setEmail(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>blocklyprop.user.email</code>.
	 */
	public String getEmail() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>blocklyprop.user.password</code>.
	 */
	public void setPassword(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>blocklyprop.user.password</code>.
	 */
	public String getPassword() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>blocklyprop.user.salt</code>.
	 */
	public void setSalt(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>blocklyprop.user.salt</code>.
	 */
	public String getSalt() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>blocklyprop.user.blocked</code>.
	 */
	public void setBlocked(Byte value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>blocklyprop.user.blocked</code>.
	 */
	public Byte getBlocked() {
		return (Byte) getValue(5);
	}

	/**
	 * Setter for <code>blocklyprop.user.created</code>.
	 */
	public void setCreated(Timestamp value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>blocklyprop.user.created</code>.
	 */
	public Timestamp getCreated() {
		return (Timestamp) getValue(6);
	}

	/**
	 * Setter for <code>blocklyprop.user.modified</code>.
	 */
	public void setModified(Timestamp value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>blocklyprop.user.modified</code>.
	 */
	public Timestamp getModified() {
		return (Timestamp) getValue(7);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, Byte, Timestamp, Timestamp> fieldsRow() {
		return (Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, Byte, Timestamp, Timestamp> valuesRow() {
		return (Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return User.USER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return User.USER.SCREENNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return User.USER.EMAIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return User.USER.PASSWORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return User.USER.SALT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Byte> field6() {
		return User.USER.BLOCKED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field7() {
		return User.USER.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field8() {
		return User.USER.MODIFIED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getScreenname();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getEmail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getPassword();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getSalt();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Byte value6() {
		return getBlocked();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value7() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value8() {
		return getModified();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value2(String value) {
		setScreenname(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value3(String value) {
		setEmail(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value4(String value) {
		setPassword(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value5(String value) {
		setSalt(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value6(Byte value) {
		setBlocked(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value7(Timestamp value) {
		setCreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value8(Timestamp value) {
		setModified(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord values(Integer value1, String value2, String value3, String value4, String value5, Byte value6, Timestamp value7, Timestamp value8) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserRecord
	 */
	public UserRecord() {
		super(User.USER);
	}

	/**
	 * Create a detached, initialised UserRecord
	 */
	public UserRecord(Integer id, String screenname, String email, String password, String salt, Byte blocked, Timestamp created, Timestamp modified) {
		super(User.USER);

		setValue(0, id);
		setValue(1, screenname);
		setValue(2, email);
		setValue(3, password);
		setValue(4, salt);
		setValue(5, blocked);
		setValue(6, created);
		setValue(7, modified);
	}
}
