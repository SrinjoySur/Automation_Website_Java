package com.automation_exercise.api.model;

import lombok.Data;

@Data
public class SignIn {
    private String email;
    private String password;
    public SignIn(SignInBuilder builder){
        this.email=builder.email;
        this.password=builder.password;
    }
    public static class SignInBuilder {
        private String email;
        private String password;

        public SignInBuilder withEmail(String email) {
            this.email=email;
            return this;
        }
        public SignInBuilder withPassword(String password){
            this.password=password;
            return this;
        }
        public SignIn build(){
            return new SignIn(this);
        }
    }
}
