package com.infinitymax.combat.Fightpacks;

import com.infinitymax.combat.util.LogHelper;
import com.infinitymax.combat.item.ItemRegister;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.util.*;

/**
 * PackLoader
 * - 指定ディレクトリ（fightpack/*）を解析し、guns/gun.json、weapon/weapon.json を読み込む
 * - GunDefinition / WeaponDefinition の最小スキーマでパースして ItemRegister に登録を依頼する
 *
 * データ例に対応：
 * guns/gun.json
 * [
 *   {
 *     "id":"smr01",
 *     "name":"SMR-01",
 *     "category":"Snipping_machine_rifle",
 *     "Initial_parameter": { "damage": 30, "rateOfFire":600, "magazineSize":30, "reloadTime":2.5 }
 *   }
 * ]
 */
public class PackLoader {

    private final Path packRoot;
    private final ItemRegister itemRegister;
    private final Gson gson = new Gson();

    public PackLoader(Path packRoot, ItemRegister itemRegister) {
        this.packRoot = packRoot;
        this.itemRegister = itemRegister;
    }

    /**
     * 実際のパック読み込み処理
     */
    public PackHandler loadPack() {
        LogHelper.info("PackLoader: loading pack at " + packRoot.toAbsolutePath());
        PackHandler handler = new PackHandler(packRoot.getFileName().toString());

        // 1) guns/gun.json の読み込み
        Path gunsJson = packRoot.resolve("guns").resolve("gun.json");
        if (Files.exists(gunsJson)) {
            try (Reader r = Files.newBufferedReader(gunsJson)) {
                JsonElement el = JsonParser.parseReader(r);
                if (el.isJsonArray()) {
                    for (JsonElement e : el.getAsJsonArray()) {
                        if (e.isJsonObject()) {
                            GunDefinition def = gson.fromJson(e, GunDefinition.class);
                            if (def != null && def.id != null) {
                                LogHelper.info("GunDefinition 読み込み: " + def.id);
                                itemRegister.registerGunFromDefinition(def.id, def);
                                handler.addLoadedGun(def.id, def);
                            } else {
                                LogHelper.warn("無効なGunDefinitionをスキップ");
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                LogHelper.error("guns/gun.json の読み込みに失敗", ex);
            }
        } else {
            LogHelper.warn("guns/gun.json が見つかりません: " + gunsJson.toAbsolutePath());
        }

        // 2) weapon/weapon.json の読み込み
        Path weaponJson = packRoot.resolve("weapon").resolve("weapon.json");
        if (Files.exists(weaponJson)) {
            try (Reader r = Files.newBufferedReader(weaponJson)) {
                JsonElement el = JsonParser.parseReader(r);
                if (el.isJsonArray()) {
                    for (JsonElement e : el.getAsJsonArray()) {
                        if (e.isJsonObject()) {
                            WeaponDefinition def = gson.fromJson(e, WeaponDefinition.class);
                            if (def != null && def.id != null) {
                                LogHelper.info("WeaponDefinition 読み込み: " + def.id);
                                itemRegister.registerMeleeFromDefinition(def.id, def);
                                handler.addLoadedWeapon(def.id, def);
                            } else {
                                LogHelper.warn("無効なWeaponDefinitionをスキップ");
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                LogHelper.error("weapon/weapon.json の読み込みに失敗", ex);
            }
        } else {
            LogHelper.warn("weapon/weapon.json が見つかりません: " + weaponJson.toAbsolutePath());
        }

        // TODO: resource/texture, sound, lang の取り込み・コピー処理を追加可能

        return handler;
    }

    // ---------------------------
    // 内部定義：Gun / Weapon の POJO
    // ---------------------------

    public static class GunDefinition {
        public String id;
        public String name;
        public String category;
        public InitialParameter Initial_parameter;

        public static class InitialParameter {
            public int damage;
            public int rateOfFire;
            public int magazineSize;
            public double reloadTime;
        }
    }

    public static class WeaponDefinition {
        public String id;
        public String name;
        public String type;
        public InitialParameter Initial_parameter;

        public static class InitialParameter {
            public int damage;
            public double attackSpeed;
            public double reach;
        }
    }
}
