package com.cinque.config;

import org.aeonbits.owner.ConfigFactory;

public final class Configfactory {

    private Configfactory(){}

    private static final FrameworkConfig config =
            ConfigFactory.create(FrameworkConfig.class);

    public static FrameworkConfig getConfig(){
        return config;
    }
}
