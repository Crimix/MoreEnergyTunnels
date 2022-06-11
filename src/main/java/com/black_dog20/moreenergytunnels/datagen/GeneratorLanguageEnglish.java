package com.black_dog20.moreenergytunnels.datagen;

import com.black_dog20.moreenergytunnels.ModCompat;
import com.black_dog20.moreenergytunnels.MoreEnergyTunnels;
import net.minecraft.ChatFormatting;
import net.minecraft.data.DataGenerator;
import org.jetbrains.annotations.NotNull;

import static com.black_dog20.moreenergytunnels.utils.Translations.*;

public class GeneratorLanguageEnglish extends BaseModLanguageProvider {

    public GeneratorLanguageEnglish(DataGenerator gen) {
        super(gen, MoreEnergyTunnels.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addPrefixed(MOD_NAME, "More Energy Tunnels", ChatFormatting.BLUE);
        addPrefixed(ADDED_BY,  "Added by %s", ChatFormatting.GRAY);
        addPrefixed(TRANSFER, "Transfers %s", ChatFormatting.GRAY);
        addPrefixed(RATE, "%s FE/t", ChatFormatting.RED);
        addTunnel(ModCompat.ADVANCED_FORGE_ENERGY.get(), "Advanced Energy Tunnel");
        addTunnel(ModCompat.ELITE_FORGE_ENERGY.get(), "Elite Energy Tunnel");
        addTunnel(ModCompat.ULTIMATE_FORGE_ENERGY.get(), "Ultimate Energy Tunnel");
    }

    @Override
    public @NotNull String getName() {
        return String.format("More Energy Tunnels: %s", super.getName());
    }
}
