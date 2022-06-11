package com.black_dog20.moreenergytunnels.tunnels.instance;

import com.black_dog20.moreenergytunnels.tunnels.utils.Tiers;
import dev.compactmods.machines.api.tunnels.lifecycle.TunnelInstance;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;

public abstract class AbstractForgeEnergyTunnelInstance implements TunnelInstance, INBTSerializable<CompoundTag> {

    private EnergyStorage storage;
    private final LazyOptional<IEnergyStorage> lazy;

    public AbstractForgeEnergyTunnelInstance() {
        this.storage = new EnergyStorage(getTier().getCapacity());
        this.lazy = LazyOptional.of(this::getStorage);
    }

    protected abstract Tiers getTier();

    @Nonnull
    public EnergyStorage getStorage() {
        return this.storage;
    }

    public LazyOptional<IEnergyStorage> lazy() {
        return lazy;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag data = new CompoundTag();
        data.put("storage", storage.serializeNBT());
        return data;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if(!nbt.contains("storage")) {
            this.storage = new EnergyStorage(getTier().getCapacity());
            return;
        }

        final Tag nbtStorage = nbt.get("storage");
        storage.deserializeNBT(nbtStorage);
    }
}