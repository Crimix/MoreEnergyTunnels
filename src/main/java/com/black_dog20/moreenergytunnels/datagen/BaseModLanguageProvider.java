package com.black_dog20.moreenergytunnels.datagen;

import com.black_dog20.bml.datagen.BaseLanguageProvider;
import dev.compactmods.machines.api.tunnels.TunnelDefinition;
import dev.compactmods.machines.i18n.TranslationUtil;
import net.minecraft.data.DataGenerator;

public abstract class BaseModLanguageProvider extends BaseLanguageProvider {

    /**
     * The constructor for the provider.
     *
     * @param gen    the data generator.
     * @param modid  the mod id.
     * @param locale the locale.
     */
    public BaseModLanguageProvider(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    protected void addTunnel(TunnelDefinition tunnel, String name) {
        add(TranslationUtil.tunnelId(tunnel.getRegistryName()), name);
    }
}
