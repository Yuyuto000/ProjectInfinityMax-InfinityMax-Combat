package com.infinitymax.combat;

import com.infinitymax.combat.util.LogHelper;
import com.infinitymax.combat.item.ItemRegister;
import com.infinitymax.combat.Fightpacks.PackManager;
import com.infinitymax.combat.actions.ActionManager;

/**
 * メインMODクラス（エントリポイント）
 * NeoForge / Fabric 双対応のため、実際のプラットフォーム初期化は compat.* に委ねる。
 */
public class InfinityMaxCombat {

    public static final String MODID = "infinitymax_combat";
    public static final String DOMAIN = "com.infinitymax.combat";

    private static InfinityMaxCombat INSTANCE;

    private final PackManager packManager;
    private final ItemRegister itemRegister;
    private final ActionManager actionManager;

    public InfinityMaxCombat() {
        INSTANCE = this;
        LogHelper.info("InfinityMaxCombat コンストラクタ呼び出し");
        this.itemRegister = new ItemRegister();
        this.packManager = new PackManager(this.itemRegister);
        this.actionManager = new ActionManager();
    }

    /**
     * 起動時に呼ぶ初期化処理（compat側から呼び出す想定）
     */
    public void init() {
        LogHelper.info("InfinityMaxCombat 初期化開始");
        // 1) デフォルトアイテム・レシピ登録（API 経由）
        itemRegister.registerBuiltinItems();

        // 2) FightPack 読み込み（modsフォルダ/リソース内を探索）
        packManager.discoverAndLoadPacks();

        // 3) アクション／スキル登録
        actionManager.initialize();

        LogHelper.info("InfinityMaxCombat 初期化完了");
    }

    public static InfinityMaxCombat getInstance() {
        return INSTANCE;
    }

    public PackManager getPackManager() {
        return this.packManager;
    }

    public ItemRegister getItemRegister() {
        return this.itemRegister;
    }

    public ActionManager getActionManager() {
        return this.actionManager;
    }
}
