package com.black_dog20.moreenergytunnels.tunnels;

import com.black_dog20.moreenergytunnels.tunnels.EliteForgeEnergyTunnel.EliteForgeEnergyTunnelInstance;
import com.black_dog20.moreenergytunnels.tunnels.instance.AbstractForgeEnergyTunnelInstance;
import com.black_dog20.moreenergytunnels.tunnels.utils.TierForgeEnergyTunnel;
import com.black_dog20.moreenergytunnels.tunnels.utils.Tiers;
import com.google.common.collect.ImmutableSet;
import dev.compactmods.machines.api.tunnels.TunnelDefinition;
import dev.compactmods.machines.api.tunnels.capability.CapabilityTunnel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.FastColor;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;

public class EliteForgeEnergyTunnel implements TunnelDefinition, CapabilityTunnel<EliteForgeEnergyTunnelInstance>, TierForgeEnergyTunnel {

    @Override
    public int ringColor() {
        return FastColor.ARGB32.color(255, 0, 33, 166);
    }

    @Override
    public ImmutableSet<Capability<?>> getSupportedCapabilities() {
        return ImmutableSet.of(ForgeCapabilities.ENERGY);
    }

    @Override
    public <CapType> LazyOptional<CapType> getCapability(Capability<CapType> type, EliteForgeEnergyTunnelInstance instance) {
        if (type == ForgeCapabilities.ENERGY) {
            return instance.lazy().cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public EliteForgeEnergyTunnelInstance newInstance(BlockPos position, Direction side) {
        return new EliteForgeEnergyTunnelInstance();
    }

    @Override
    public Tiers getTier() {
        return Tiers.ELITE;
    }

    public static final class EliteForgeEnergyTunnelInstance extends AbstractForgeEnergyTunnelInstance {

        @Override
        protected Tiers getTier() {
            return Tiers.ELITE;
        }
    }

}
