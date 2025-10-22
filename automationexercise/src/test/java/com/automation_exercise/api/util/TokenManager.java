package com.automation_exercise.api.util;

import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {
    private static final ConcurrentHashMap<String, String> tokenStore = new ConcurrentHashMap<>();

    // Store token per role
    public static void storeToken(String email, String token) {
        tokenStore.put(email, token);
    }

    // Retrieve token by role
    public static String getToken(String email) {
        if (!tokenStore.containsKey(email)) {
            return null;
        }
        return tokenStore.get(email.toLowerCase());
    }

    // Clear tokens (if needed, for cleanup between tests)
    public static void clearTokens() {
        tokenStore.clear();
    }
}