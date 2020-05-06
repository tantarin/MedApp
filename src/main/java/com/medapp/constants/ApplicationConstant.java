package com.medapp.constants;

public class ApplicationConstant {
    //for database
    public static final String PROPERTY_SOURCE = "classpath:db.properties";
    public static final String HIBERNATE_DIALECT = "hibernate.dialect";
    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String HIBERNATE_FORMAT = "hibernate.format_sql";
    public static final String HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
    //for sservice layer
    public static final String STATUS_DISHARGED = "discharged";
    public static final String EVENT_STATUS_SHEDULED = "Scheduled";
    public static final String EVENT_STATUS_CANCELLED = "Cancelled";
    public static final String DEFAULT_COMMENTS = "";
    public static final String DISCHARGED_COMMENTS = "Patient discharged";
    public static final String NO_FILTER = "no filter";

}
