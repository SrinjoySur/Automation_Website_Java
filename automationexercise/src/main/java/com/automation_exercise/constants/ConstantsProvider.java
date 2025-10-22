package com.automation_exercise.constants;

import com.contact_list.utils.ConfigReader;
import io.github.cdimascio.dotenv.Dotenv;

public class ConstantsProvider {
    public static final String configPath = "src/main/resources/config/config.properties";
    public static final String screenshotsDirPath = System.getProperty("user.dir") + "/screenshots";
    public static final String jsonSchemasDir =ConfigReader.getInstance().getProperty("josnschemas.dir") ;
    public static final String BASE_URI = ConfigReader.getInstance().getProperty("base.uri");
    public static final String LOG_IN_ENDPOINT = BASE_URI + "login";
    public static final String SIGN_IN_ENDPOINT = BASE_URI+"users/login";
    public static final String SIGN_UP_ENDPOINT = BASE_URI + "addUser";
    public static final String CONTACT_LIST_ENDPOINT = BASE_URI +"contactList";
    public static final String API_REGISTER_ENDPOINT = BASE_URI +"users";
    public static final String DELETE_USER_ENDPOINT = BASE_URI +"users/me";
    public static final String SIGN_UP_SCHEMA = ConfigReader.getInstance().getProperty("signUp.schema");
    public static final String SIGN_IN_SCHEMA = ConfigReader.getInstance().getProperty("signIn.schema");
    public static final String LT_USERNAME = Dotenv.load().get("LT_USERNAME");
    public static final String LT_ACCESS_KEY=Dotenv.load().get("LT_ACCESS_KEY");
}
