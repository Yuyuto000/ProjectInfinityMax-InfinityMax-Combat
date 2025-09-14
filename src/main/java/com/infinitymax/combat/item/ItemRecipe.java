package com.infinitymax.combat.item;

import com.infinitymax.combat.util.LogHelper;

import java.util.*;

/**
 * レシピ管理クラス（雛形）
 * - JSON から読み込んだアイテムに対応するレシピを自動生成する等を想定
 * - 実際のMinecraftレシピシステムへの登録は環境に合わせて拡張すること
 */
public class ItemRecipe {

    // シンプルにレシピをキャッシュする Map
    private final Map<String, Map<String, Object>> recipes = new HashMap<>();

    public ItemRecipe() {
        LogHelper.info("ItemRecipe 初期化");
    }

    /**
     * アイテムIDに対応する簡易レシピを生成して登録する
     */
    public void createSimpleRecipe(String itemId, Map<String, Integer> requiredMaterials) {
        Map<String, Object> recipe = new HashMap<>();
        recipe.put("materials", requiredMaterials);
        recipe.put("result", itemId);
        recipes.put(itemId, recipe);
        LogHelper.info("レシピ生成: " + itemId + " -> " + requiredMaterials.toString());
        // 実運用ではここでMinecraftのレシピ登録処理を呼ぶ
    }

    public Optional<Map<String, Object>> getRecipe(String itemId) {
        return Optional.ofNullable(recipes.get(itemId));
    }

    public Collection<String> listAllRecipes() {
        return recipes.keySet();
    }
}
