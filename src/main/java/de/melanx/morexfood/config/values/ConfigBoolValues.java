package de.melanx.morexfood.config.values;

import de.melanx.morexfood.config.ConfigCategories;

public enum ConfigBoolValues {

    SALT_ORE_SPAWNING("Salt Ore spawning",ConfigCategories.WORLD_GEN, true, "Should Salt Ore be generated? [DEFAULT: true]");

    public final String name;
    public final String category;
    public final boolean defaultValue;
    public final String desc;

    public boolean currentValue;

    ConfigBoolValues(String name, ConfigCategories category, boolean defaultValue, String desc){
        this.name = name;
        this.category = category.name;
        this.defaultValue = defaultValue;
        this.desc = desc;
    }

    public boolean isEnabled(){
        return this.currentValue;
    }

}
