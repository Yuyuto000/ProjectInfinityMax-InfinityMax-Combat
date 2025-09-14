package com.infinitymax.combat.actions;

import com.infinitymax.combat.util.LogHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * スキル管理（雛形）
 * - プレイヤーが習得可能な戦闘スキルやアクティブスキルを管理する
 * - 実装ではデータベース（NBT, capability, データパック）と連携する想定
 */
public class SkillManager {

    // スキルID -> スキル定義（雛形）
    private final Map<String, SkillDefinition> skills = new HashMap<>();

    public SkillManager() {
        LogHelper.info("SkillManager 初期化");
    }

    public void initialize() {
        LogHelper.info("SkillManager: デフォルトスキル登録");
        // サンプルスキルを登録
        registerSkill(new SkillDefinition("quick_reload", "Quick Reload", "リロード速度が上がる"));
        registerSkill(new SkillDefinition("steady_aim", "Steady Aim", "エイムの反動が減る"));
    }

    public void registerSkill(SkillDefinition def) {
        skills.put(def.id, def);
        LogHelper.info("スキル登録: " + def.id);
    }

    public SkillDefinition getSkill(String id) {
        return skills.get(id);
    }

    public static class SkillDefinition {
        public final String id;
        public final String name;
        public final String description;

        public SkillDefinition(String id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }
}
