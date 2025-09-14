package com.infinitymax.combat.item;

import com.infinitymax.api.core.RegistryHandler;
import com.infinitymax.combat.util.LogHelper;

/**
 * 近接武器
 */
public class MeleeItem {

    public final String id;
    public final String name;
    public final String type; // sword, axe, spear etc
    public final int damage;
    public final double attackSpeed;
    public final double reach;

    public MeleeItem(String id, String name, String type, int damage, double attackSpeed, double reach){
        this.id = id;
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.reach = reach;
    }

    public void register(){
        RegistryHandler.registerItem(id, this);
        LogHelper.info("Registered melee weapon: " + id);
    }
}
