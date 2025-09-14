package com.infinitymax.combat.item;

import com.infinitymax.api.core.RegistryHandler; // Provided API
import com.infinitymax.combat.util.LogHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * アイテム登録管理クラス
 * - InfinityMaxAPI の RegistryHandler を利用して Item を登録する
 * - JSONから生成された定義を受け取り、アイテムオブジェクトを生成して登録する（Objectで受け渡す）
 *
 * 注意：ここでは汎用性のため具体の Minecraft Item クラスを直接使わず、
 * API 経由で Object を登録する実装にしてある。実際は Project:InfinityMaxAPI が返す Item クラスに合わせて変更すること。
 */
public class ItemRegister {

    // 登録済みアイテムのローカルキャッシュ（id -> アイテムオブジェクト）
    private final Map<String, Object> registeredItems = new HashMap<>();

    public ItemRegister() {
        LogHelper.info("ItemRegister 初期化");
    }

    /**
     * Mod内であらかじめ用意しておく「初期アイテム」を登録する処理。
     * ここに「スターター銃」や「近接武器」などをハードコーディングして登録しておく。
     */
    public void registerBuiltinItems() {
        LogHelper.info("組み込みアイテムを登録します");

        // サンプル：簡易プレースホルダ表現のアイテムオブジェクトを登録
        // 実際は Project:InfinityMaxAPI の Item オブジェクトを生成して渡す
        Object samplePistol = createPlaceholderItem("Pistol (placeholder)");
        registerItem("pistol_builtin", samplePistol);

        Object sampleKatana = createPlaceholderItem("Katana (placeholder)");
        registerItem("katana_builtin", sampleKatana);

        // 必要に応じて初期弾丸やアタッチメントなども登録
        Object sampleAmmo = createPlaceholderItem("Ammo_9mm (placeholder)");
        registerItem("ammo_9mm_builtin", sampleAmmo);
    }

    /**
     * JSONからの定義に基づいて銃アイテムを生成し登録する。
     * @param id 定義ID
     * @param definition GunDefinition（PackLoader 側で定義）
     */
    public void registerGunFromDefinition(String id, com.infinitymax.combat.Fightpacks.PackLoader.GunDefinition definition) {
        // ここで実際の Item 実体 (例えば独自 GunItem クラス) を生成する。
        // まずは placeholder オブジェクトで登録する。
        String display = String.format("Gun[%s] name=%s dmg=%s rof=%s mag=%s reload=%s",
                id,
                definition.name,
                definition.Initial_parameter.damage,
                definition.Initial_parameter.rateOfFire,
                definition.Initial_parameter.magazineSize,
                definition.Initial_parameter.reloadTime
        );
        Object gunItem = createPlaceholderItem(display);
        registerItem(id, gunItem);
    }

    /**
     * JSONからの定義に基づいて近接武器を生成し登録する。
     */
    public void registerMeleeFromDefinition(String id, com.infinitymax.combat.Fightpacks.PackLoader.WeaponDefinition definition) {
        String display = String.format("Melee[%s] name=%s dmg=%s atkspd=%s reach=%s",
                id,
                definition.name,
                definition.Initial_parameter.damage,
                definition.Initial_parameter.attackSpeed,
                definition.Initial_parameter.reach
        );
        Object meleeItem = createPlaceholderItem(display);
        registerItem(id, meleeItem);
    }

    /**
     * 実際に API に登録を委譲するラッパー。
     */
    private void registerItem(String name, Object item) {
        if (registeredItems.containsKey(name)) {
            LogHelper.warn("アイテム " + name + " は既にローカル登録済みです。スキップします");
            return;
        }
        // Project:InfinityMaxAPI の RegistryHandler を使ってグローバル登録
        try {
            RegistryHandler.registerItem(name, item);
            registeredItems.put(name, item);
            LogHelper.info("Registered item: " + name);
        } catch (Exception e) {
            LogHelper.error("アイテム登録に失敗しました: " + name, e);
        }
    }

    /**
     * プレースホルダのアイテムオブジェクトを作るユーティリティ（実際は Item クラスを生成する）
     */
    private Object createPlaceholderItem(String desc) {
        // 単純な Map を返してデバッグしやすくしている。
        Map<String, String> placeholder = new HashMap<>();
        placeholder.put("placeholder", "true");
        placeholder.put("desc", desc);
        return placeholder;
    }

    /**
     * 登録済みアイテムの参照を取得
     */
    public Object getRegisteredItem(String id) {
        return registeredItems.get(id);
    }
}
