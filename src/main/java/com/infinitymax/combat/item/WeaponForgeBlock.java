package com.infinitymax.combat.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WeaponForgeBlock extends Block {

    public WeaponForgeBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL)
                .strength(5.0f, 10.0f));
    }

    @Override
    public boolean hasBlockEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WeaponForgeBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(BlockState state, BlockEntityType<T> type) {
        return (level, pos, s, be) -> {
            if (be instanceof WeaponForgeBlockEntity forge) {
                forge.tick();
            }
        };
    }
}
