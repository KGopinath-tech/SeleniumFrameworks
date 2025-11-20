package com.cinque.config;

import org.aeonbits.owner.ConfigFactory;

public final class Configfactory {

    private Configfactory(){}


    public static FrameworkConfig getConfig(){
        return ConfigFactory.create(FrameworkConfig.class);
    }
}
