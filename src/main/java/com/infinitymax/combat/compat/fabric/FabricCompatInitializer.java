package com.infinitymax.combat.compat.fabric;

import com.infinitymax.combat.InfinityMaxCombat;
import com.infinitymax.combat.util.LogHelper;

/**
 * Fabric 環境向け初期化クラス
 * - Fabric の ModInitializer から呼び出す想定
 *
 * 実際に Fabric のライフサイクルに登録するコード（implements ModInitializer）はビルド時に追加してください。
 */
public class FabricCompatInitializer {

    private static InfinityMaxCombat INSTANCE;

    public static void onInitialize() {
        LogHelper.info("FabricCompatInitializer: onInitialize");
        INSTANCE = new InfinityMaxCombat();
        INSTANCE.init();
        // Fabric のイベントや packet 登録等はここで行う
    }

    public static InfinityMaxCombat getInstance() {
        return INSTANCE;
    }
}
