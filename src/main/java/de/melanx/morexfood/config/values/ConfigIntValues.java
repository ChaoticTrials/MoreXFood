package de.melanx.morexfood.config.values;

import de.melanx.morexfood.config.ConfigCategories;

public enum ConfigIntValues {

    PEAS_SEED_DROPPING("Pea Seeds Dropping: Amount", ConfigCategories.WORLD_GEN, 10, 1, 100, "The Amount of Pea Seeds dropping out of grass [DEFAULT: 10, MIN: 1, MAX: 100]"),
    ASPARAGUS_SEED_DROPPING("Asparagus Seeds Dropping: Amount", ConfigCategories.WORLD_GEN, 10, 1, 100, "The Amount of Asparagus Seeds dropping out of grass [DEFAULT: 10, MIN: 1, MAX: 100]"),
    AGARICUS_SEED_DROPPING("Agaricus Seeds Dropping: Amount", ConfigCategories.WORLD_GEN, 10, 1, 100, "The Amount of Agaricus Seeds dropping out of grass [DEFAULT: 10, MIN: 1, MAX: 100]"),
    RICE_SEED_DROPPING("Rice Seeds Dropping: Amount", ConfigCategories.WORLD_GEN, 10, 1, 100, "The Amount of Rice Seeds dropping out of grass [DEFAULT: 10, MIN: 1, MAX: 100]");

    public final String name;
    public final String category;
    public final int defaultValue;
    public final int min;
    public final int max;
    public final String desc;

    public int currentValue;

    ConfigIntValues(String name, ConfigCategories category, int defaultValue, int min, int max, String desc){
        this.name = name;
        this.category = category.name;
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
        this.desc = desc;
    }

    public int getValue(){
        return this.currentValue;
    }

}
