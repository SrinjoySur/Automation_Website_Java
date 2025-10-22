package com.automation_exercise.api.manager;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.automation_exercise.constants.ConstantsProvider.BASE_URI;

public class RequestSpecificationManager {
    private static RequestSpecification requestSpec;

    public static RequestSpecification getRequestSpecification() {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(BASE_URI)
                    .setContentType(ContentType.JSON)
                    .build();
        }
        return requestSpec;
    }
    public static RequestSpecification getAuthenticatedRequestSpecification(String token) {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .setBaseUri(BASE_URI)
                    .setContentType(ContentType.JSON)
                    .build();
        }
        return requestSpec;
    }

    public static void resetRequestSpec() {
        requestSpec = null;
    }
}
