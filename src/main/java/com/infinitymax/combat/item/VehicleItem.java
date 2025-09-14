package com.infinitymax.combat.item;

import com.infinitymax.api.core.RegistryHandler;
import com.infinitymax.combat.util.LogHelper;

/**
 * 戦闘機・戦車・砲台
 */
public class VehicleItem {

    public final String id;
    public final String name;
    public final String type; // tank, fighter, helicopter
    public final int health;
    public final int firepower;

    public VehicleItem(String id, String name, String type, int health, int firepower){
        this.id = id;
        this.name = name;
        this.type = type;
        this.health = health;
        this.firepower = firepower;
    }

    public void register(){
        RegistryHandler.registerItem(id, this);
        LogHelper.info("Registered vehicle: " + id);
    }
}
