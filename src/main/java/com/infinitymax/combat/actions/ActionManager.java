package com.infinitymax.combat.actions;

import com.infinitymax.combat.util.LogHelper;

/**
 * アクション管理クラス
 * - 戦闘アクション、FPSシステム、スキルなどの初期化をまとめる
 * - 実ゲームロジックはここから FpsSystems / SkillManager へ委譲する
 */
public class ActionManager {

    private final FpsSystems fpsSystems;
    private final SkillManager skillManager;

    public ActionManager() {
        LogHelper.info("ActionManager 初期化");
        this.fpsSystems = new FpsSystems();
        this.skillManager = new SkillManager();
    }

    /**
     * 初期化処理。MOD起動時に呼ばれる。
     */
    public void initialize() {
        LogHelper.info("ActionManager: アクションシステム初期化開始");
        fpsSystems.initialize();
        skillManager.initialize();
        LogHelper.info("ActionManager: アクションシステム初期化完了");
    }

    public FpsSystems getFpsSystems() {
        return fpsSystems;
    }

    public SkillManager getSkillManager() {
        return skillManager;
    }
}
