package com.black_dog20.moreenergytunnels.datagen;

import com.black_dog20.bml.datagen.BaseLanguageProvider;
import dev.compactmods.machines.api.tunnels.TunnelDefinition;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;

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

    protected void addTunnel(RegistryObject<TunnelDefinition> tunnel, String name) {
        ResourceLocation id = tunnel.getId();
        add("item." + id.getNamespace() + ".tunnels." + id.getPath().replace('/', '.'), name);
    }
}
