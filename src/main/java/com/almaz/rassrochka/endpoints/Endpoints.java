package com.almaz.rassrochka.endpoints;

public class Endpoints {
    private static final String API = "/api";
    private static final String V1 = "/v1";
    public static final String LOGIN = API + V1 + "/login";

    public static final String USER = API + V1 + "/user";

    public static final String PROFILES = API + V1 + "/profiles";
    public static final String BROTHER = API + V1 + "/brother";
    public static final String DEVICE = API + V1 + "/device";
    public static final String CREDIT = API + V1 + "/credit";
    public static final String MONTH =  CREDIT + "/month";
    public static final String REPORT =  CREDIT + "/reporting";
    public static final String OWNER = API + V1 + "/owner";
}
