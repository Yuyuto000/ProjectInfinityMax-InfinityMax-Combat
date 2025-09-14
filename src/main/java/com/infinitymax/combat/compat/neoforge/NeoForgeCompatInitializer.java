package com.infinitymax.combat.compat.neoforge;

import com.infinitymax.combat.InfinityMaxCombat;
import com.infinitymax.combat.util.LogHelper;

/**
 * NeoForge 環境向け初期化クラス
 * - NeoForge の mod 入力点から呼ぶ想定（@Mod などでエントリポイントを指定）
 *
 * 実際の NeoForge のアノテーション (@Mod) はビルド環境に合わせて追加してください。
 */
public class NeoForgeCompatInitializer {

    private static InfinityMaxCombat INSTANCE;

    public static void onInitialize() {
        // NeoForge 用初期化処理をここに書く（イベントバス登録など）
        LogHelper.info("NeoForgeCompatInitializer: onInitialize");
        INSTANCE = new InfinityMaxCombat();
        INSTANCE.init();
        // Forge/NeoForge のイベントバスやプロキシ登録はここで行う
    }

    public static InfinityMaxCombat getInstance() {
        return INSTANCE;
    }
}
