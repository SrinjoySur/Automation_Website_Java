package com.automation_exercise.api.util;

import com.automation_exercise.api.model.SignIn;
import com.automation_exercise.constants.ConstantsProvider;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CommonUtils {

    public static String sessionClientId;

    public static String generateAuthToken(String email, String password) {
        SignIn auth = new SignIn.SignInBuilder().withEmail(email).withPassword(password).build();

        Response response = given()
                .contentType("application/json")
                .body(auth)
                .when()
                .post(ConstantsProvider.SIGN_IN_ENDPOINT)
                .then()
                .extract().response();

        if (response.statusCode() == 200) {
            sessionClientId = response.jsonPath().getString("user.id");
            return response.jsonPath().getString("token");
        } else {
            throw new RuntimeException("Failed to generate token for user: " + email);
        }
    }
}
