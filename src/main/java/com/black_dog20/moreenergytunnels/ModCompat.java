package com.black_dog20.moreenergytunnels;

import com.black_dog20.bml.utils.math.MathUtil;
import com.black_dog20.moreenergytunnels.tunnels.AdvancedForgeEnergyTunnel;
import com.black_dog20.moreenergytunnels.tunnels.EliteForgeEnergyTunnel;
import com.black_dog20.moreenergytunnels.tunnels.UltimateForgeEnergyTunnel;
import com.black_dog20.moreenergytunnels.tunnels.utils.TierForgeEnergyTunnel;
import dev.compactmods.machines.api.tunnels.TunnelDefinition;
import dev.compactmods.machines.tunnel.TunnelItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

import static com.black_dog20.moreenergytunnels.utils.Translations.*;
import static dev.compactmods.machines.core.Tunnels.DEFINITIONS;

public class ModCompat {

    public static final RegistryObject<TunnelDefinition> ADVANCED_FORGE_ENERGY = DEFINITIONS.register("advanced_energy", AdvancedForgeEnergyTunnel::new);
    public static final RegistryObject<TunnelDefinition> ELITE_FORGE_ENERGY = DEFINITIONS.register("elite_energy", EliteForgeEnergyTunnel::new);
    public static final RegistryObject<TunnelDefinition> ULTIMATE_FORGE_ENERGY = DEFINITIONS.register("ultimate_energy", UltimateForgeEnergyTunnel::new);

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void itemTooltip(ItemTooltipEvent event) {
        TunnelItem.getDefinition(event.getItemStack())
                .filter(TierForgeEnergyTunnel.class::isInstance)
                .map(TierForgeEnergyTunnel.class::cast)
                .ifPresent(tunnelDef -> {
            if (Screen.hasShiftDown()) {
                String rate = MathUtil.formatThousands(tunnelDef.getTier().getCapacity());

                event.getToolTip().add(ADDED_BY.get(ChatFormatting.ITALIC, MOD_NAME.get(ChatFormatting.ITALIC)));
                event.getToolTip().add(TRANSFER.get(ChatFormatting.ITALIC, RATE.get(ChatFormatting.ITALIC, rate)));
            }
        });
    }

}
