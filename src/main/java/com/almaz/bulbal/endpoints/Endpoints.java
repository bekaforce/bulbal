package com.almaz.bulbal.endpoints;

public class Endpoints {
    private static final String API = "/api";
    private static final String V1 = "/v1";
    public static final String LOGIN = API + V1 + "/login";
    public static final String SEND_MAIL = API + V1 + "/send-mail";
    public static final String ACCOMMODATION = API + V1 + "/accommodation";
    public final static String ADMIN = API + V1 + "/admin";
    public final static String ADVANTAGE = ADMIN + "/advantage";
    public final static String TYPEOFHOUSE = ADMIN + "/typeOfHouse";
    public final static String TYPEOFROOM = ADMIN + "/typeOfRoom";
    public final static String TYPEOFBED = ADMIN + "/typeOfBed";
    public final static String LOCALITY = API + V1 + "/locality";
    public final static String REGION = API + V1 + "/region";
    public final static String NOTIFICATION = ADMIN + "/notification";
    public final static String IMAGES = API + V1 + "/images";

    public static final String SWAGGER = "swagger-ui.html";
    public static final String SWAGGER_URL = "/" + SWAGGER + "/**";
    public static final String SWAGGER_RESOURCE_URL = "/swagger-resources/**";
    public static final String SWAGGER_WEBJARS_URL = "/webjars/springfox-swagger-ui/**";
    public static final String SWAGGER_API_URL = "/v2/api-docs/**";

}
