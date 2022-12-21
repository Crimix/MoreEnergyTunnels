package com.black_dog20.moreenergytunnels.datagen;

import com.black_dog20.bml.datagen.BaseRecipeProvider;
import com.black_dog20.moreenergytunnels.ModCompat;
import com.black_dog20.moreenergytunnels.MoreEnergyTunnels;
import dev.compactmods.machines.api.tunnels.recipe.TunnelRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class GeneratorRecipes extends BaseRecipeProvider {

    public GeneratorRecipes(DataGenerator generator) {
        super(generator, MoreEnergyTunnels.MOD_ID);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        TunnelRecipeBuilder.tunnel(ModCompat.ADVANCED_FORGE_ENERGY, 2)
                .requires(Blocks.GLOWSTONE)
                .requires(Items.ENDER_PEARL)
                .requires(Items.REDSTONE)
                .requires(Items.OBSERVER)
                .unlockedBy("observer", RecipeProvider.has(Items.OBSERVER))
                .save(consumer);

        TunnelRecipeBuilder.tunnel(ModCompat.ELITE_FORGE_ENERGY, 2)
                .requires(Blocks.DIAMOND_BLOCK)
                .requires(Items.ENDER_PEARL)
                .requires(Items.LAPIS_BLOCK)
                .requires(Items.OBSERVER)
                .unlockedBy("observer", RecipeProvider.has(Items.OBSERVER))
                .save(consumer);

        TunnelRecipeBuilder.tunnel(ModCompat.ULTIMATE_FORGE_ENERGY, 2)
                .requires(Blocks.NETHERITE_BLOCK)
                .requires(Items.ENDER_PEARL)
                .requires(Items.EMERALD_BLOCK)
                .requires(Items.OBSERVER)
                .unlockedBy("observer", RecipeProvider.has(Items.OBSERVER))
                .save(consumer);
    }


    @Override
    public @NotNull String getName() {
        return String.format("More Energy Tunnels: %s", super.getName());
    }
}
