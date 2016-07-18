/**
 * This class is generated by jOOQ
 */
package com.parallax.server.blocklyprop.db.generated;

import com.parallax.server.blocklyprop.db.generated.tables.Admin;
import com.parallax.server.blocklyprop.db.generated.tables.Project;
import com.parallax.server.blocklyprop.db.generated.tables.ProjectSharing;
import com.parallax.server.blocklyprop.db.generated.tables.ProjectTag;
import com.parallax.server.blocklyprop.db.generated.tables.SecRole;
import com.parallax.server.blocklyprop.db.generated.tables.SecUserRole;
import com.parallax.server.blocklyprop.db.generated.tables.Session;
import com.parallax.server.blocklyprop.db.generated.tables.Tag;
import com.parallax.server.blocklyprop.db.generated.tables.User;
import javax.annotation.Generated;

/**
 * Convenience access to all tables in blocklyprop
 */
@Generated(
        value = {
            "http://www.jooq.org",
            "jOOQ version:3.6.1"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Tables {

    /**
     * The table blocklyprop.admin
     */
    public static final Admin ADMIN = com.parallax.server.blocklyprop.db.generated.tables.Admin.ADMIN;

    /**
     * The table blocklyprop.project_sharing
     */
    public static final Project PROJECT = com.parallax.server.blocklyprop.db.generated.tables.Project.PROJECT;

    /**
     * The table blocklyprop.project_sharing
     */
    public static final ProjectSharing PROJECT_SHARING = com.parallax.server.blocklyprop.db.generated.tables.ProjectSharing.PROJECT_SHARING;

    /**
     * The table blocklyprop.project_tag
     */
    public static final ProjectTag PROJECT_TAG = com.parallax.server.blocklyprop.db.generated.tables.ProjectTag.PROJECT_TAG;

    /**
     * The table blocklyprop.sec_role
     */
    public static final SecRole SEC_ROLE = com.parallax.server.blocklyprop.db.generated.tables.SecRole.SEC_ROLE;

    /**
     * The table blocklyprop.sec_user_role
     */
    public static final SecUserRole SEC_USER_ROLE = com.parallax.server.blocklyprop.db.generated.tables.SecUserRole.SEC_USER_ROLE;

    /**
     * The table blocklyprop.session
     */
    public static final Session SESSION = com.parallax.server.blocklyprop.db.generated.tables.Session.SESSION;

    /**
     * The table blocklyprop.tag
     */
    public static final Tag TAG = com.parallax.server.blocklyprop.db.generated.tables.Tag.TAG;

    /**
     * The table blocklyprop.user
     */
    public static final User USER = com.parallax.server.blocklyprop.db.generated.tables.User.USER;
}
