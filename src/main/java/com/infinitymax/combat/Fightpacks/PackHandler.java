package com.infinitymax.combat.Fightpacks;

import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 読み込んだパックのハンドラ
 * - パック内に読み込まれた銃・近接武器の定義を保持する
 */
public class PackHandler {

    private final String packName;
    private final Path packRoot;

    private final Map<String, PackLoader.GunDefinition> guns = new HashMap<>();
    private final Map<String, PackLoader.WeaponDefinition> weapons = new HashMap<>();

    public PackHandler(String packName) {
        this.packName = packName;
        this.packRoot = null;
    }

    public PackHandler(String packName, Path packRoot) {
        this.packName = packName;
        this.packRoot = packRoot;
    }

    public String getPackName() {
        return packName;
    }

    public void addLoadedGun(String id, PackLoader.GunDefinition def) {
        guns.put(id, def);
    }

    public void addLoadedWeapon(String id, PackLoader.WeaponDefinition def) {
        weapons.put(id, def);
    }

    public Map<String, PackLoader.GunDefinition> getLoadedGuns() {
        return Collections.unmodifiableMap(guns);
    }

    public Map<String, PackLoader.WeaponDefinition> getLoadedWeapons() {
        return Collections.unmodifiableMap(weapons);
    }
}
