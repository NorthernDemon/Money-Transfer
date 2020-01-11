package com.moneytransfer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.moneytransfer.resources.RestAPI;

import static spark.Spark.after;

public class Main {

    public static void main(String[] args) {
        after(((request, response) -> response.type("application/json")));

        Injector injector = Guice.createInjector(new GuiceConfiguration());
        injector.getInstance(RestAPI.class).run();
    }

}
