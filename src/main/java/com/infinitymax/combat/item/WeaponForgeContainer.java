package com.infinitymax.combat.item;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

public class WeaponForgeContainer extends AbstractContainerMenu {

    private final WeaponForgeBlockEntity forge;
    private final ContainerData data;

    public WeaponForgeContainer(int windowId, Inventory playerInventory, WeaponForgeBlockEntity forge) {
        super(ModContainers.WEAPON_FORGE.get(), windowId);
        this.forge = forge;
        this.data = new ContainerData() {
            private int progress = 0;
            @Override public int get(int index) { return progress; }
            @Override public void set(int index, int value) { progress = value; }
            @Override public int getCount() { return 1; }
        };
    }

    @Override
    public boolean stillValid(Player player) { return true; }
}
