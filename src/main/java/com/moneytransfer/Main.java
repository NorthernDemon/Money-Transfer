package com.moneytransfer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.moneytransfer.resources.AccountResource;
import com.moneytransfer.resources.TransactionResource;

import static spark.Spark.after;

public class Main {

    public static void main(String[] args) {
        after(((request, response) -> response.type("application/json")));

        System.setProperty("norm.jdbcUrl", "jdbc:h2:mem:moneytransfer;INIT=runscript from './src/main/resources/schema.sql';database_to_upper=false");
        System.setProperty("norm.user", "");
        System.setProperty("norm.password", "");

        Injector injector = Guice.createInjector(new GuiceConfiguration());
        injector.getInstance(AccountResource.class).run();
        injector.getInstance(TransactionResource.class).run();
    }

}
