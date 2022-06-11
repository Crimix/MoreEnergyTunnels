package com.black_dog20.moreenergytunnels.utils;

import com.black_dog20.bml.utils.translate.ITranslation;
import com.black_dog20.moreenergytunnels.MoreEnergyTunnels;

public enum Translations implements ITranslation {
    MOD_NAME("tooltip.mod_name"),
    ADDED_BY("tooltip.added_by"),
    TRANSFER("tooltip.transfer"),
    RATE("tooltip.rate");

    private final String modId;
    private final String key;

    Translations(String key) {
        this.modId = MoreEnergyTunnels.MOD_ID;
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getModId() {
        return modId;
    }
}
