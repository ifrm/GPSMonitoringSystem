package com.gps.persistence.util;

/**
 * @author radu.miron
 * @since 10/8/13
 */
public class PersistenceConstants {
    //Position Table
    public static final String POSITION_TABLE = "Position";
    public static final String USER_ID = "userId";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String DATE = "date";
    public static final String ID = "ID";

    //User Table
    public static final String USER_TABLE="user";
    public static final String NAME="name";
    public static final String EMAIL="email";
    public static final String PASSWORD="password";
    public static final String ROLE="role";

    //Mysql-DB Specific
    public static final String MYSQL_TIMESTAMP_MAX_VALUE = "2147483647000";
    public static final String MYSQL_TIMESTAMP_MIN_VALUE = "0";

}
