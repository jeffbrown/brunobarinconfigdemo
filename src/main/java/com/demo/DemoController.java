package com.demo;

import io.micronaut.http.annotation.*;

@Controller("/demo")
public class DemoController {

    private final Helper helper;

    public DemoController(Helper helper) {
        this.helper = helper;
    }

    @Get(uri="/", produces="text/plain")
    public String index() {
        return helper.getMessage();
    }
}