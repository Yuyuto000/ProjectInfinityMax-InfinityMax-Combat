package com.infinitymax.combat.item;

import com.infinitymax.api.core.RegistryHandler;
import com.infinitymax.combat.util.LogHelper;

/**
 * 弾丸アイテム
 */
public class AmmoItem {

    public final String id;
    public final String name;
    public final int damage;
    public final double speed;

    public AmmoItem(String id, String name, int damage, double speed){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.speed = speed;
    }

    public void register() {
        RegistryHandler.registerItem(id, this);
        LogHelper.info("Registered ammo: " + id);
    }
}
