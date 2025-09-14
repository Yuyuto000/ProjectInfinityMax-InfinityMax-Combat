package com.infinitymax.combat.item;

import com.infinitymax.api.core.RegistryHandler;
import net.minecraft.world.item.ItemStack;

public class WeaponForgeRecipe {

    private final String id;
    private final ItemStack output;
    private final int energyCost;
    private final int duration; // tick単位

    public WeaponForgeRecipe(String id, ItemStack output, int energyCost, int duration) {
        this.id = id;
        this.output = output;
        this.energyCost = energyCost;
        this.duration = duration;
    }

    public int getEnergyCost() { return energyCost; }
    public int getDuration() { return duration; }

    public void craft(WeaponForgeBlockEntity forge) {
        // APIで直接アイテム登録・生成
        RegistryHandler.registerItem(output.getItem().toString(), output);
    }

    public String getId() { return id; }
}
