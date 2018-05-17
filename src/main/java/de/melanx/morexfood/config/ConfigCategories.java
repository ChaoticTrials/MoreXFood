package de.melanx.morexfood.config;

import java.util.Locale;

public enum ConfigCategories {

    WORLD_GEN("World Gen", "Everything regarding World Generation");

    public final String name;
    public final String comment;

    ConfigCategories(String name, String comment){
        this.name = name.toLowerCase(Locale.ROOT);
        this.comment = comment;
    }

}
