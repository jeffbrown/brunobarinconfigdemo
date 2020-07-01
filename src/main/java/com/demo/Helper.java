package com.demo;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.inject.Singleton;

@Singleton
@ConfigurationProperties("bruno.demo")
public class Helper {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}