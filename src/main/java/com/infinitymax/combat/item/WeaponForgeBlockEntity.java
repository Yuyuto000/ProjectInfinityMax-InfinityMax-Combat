package com.infinitymax.combat.item;

import com.infinitymax.api.energy.adapter.EnergyAdapter;
import com.infinitymax.api.energy.IEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WeaponForgeBlockEntity extends BlockEntity {

    private IEnergyStorage energyStorage;
    private int progress;
    private int maxProgress = 200; // デフォルト制作時間
    private WeaponForgeRecipe currentRecipe;

    public WeaponForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WEAPON_FORGE.get(), pos, state);
        energyStorage = EnergyAdapter.wrap(this); // InfinityMaxAPI Energy
    }

    public void tick() {
        if (currentRecipe == null) return;

        if (energyStorage != null && energyStorage.extractEnergy(currentRecipe.getEnergyCost(), true) >= currentRecipe.getEnergyCost()) {
            // 実際に消費
            energyStorage.extractEnergy(currentRecipe.getEnergyCost(), false);
            progress++;

            if (progress >= maxProgress) {
                finishCrafting();
            }
        }
    }

    private void finishCrafting() {
        // 完成アイテムを登録・ドロップ
        currentRecipe.craft(this);
        progress = 0;
        currentRecipe = null;
    }

    public void setRecipe(WeaponForgeRecipe recipe) {
        this.currentRecipe = recipe;
        this.progress = 0;
        this.maxProgress = recipe.getDuration();
    }
}
