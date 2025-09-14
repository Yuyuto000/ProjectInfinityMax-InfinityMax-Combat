package com.infinitymax.combat.animation;

import com.infinitymax.combat.util.LogHelper;

/**
 * 戦闘アクション用アニメーションの抽象/ユーティリティ
 * - BlockBenchで生成されたアニメーションがあれば、ここでそれを再生するためのラッパーを用意する
 * - 実際のアニメーション再生は GeckoLib などを想定
 */
public class ActionAnimation {

    public ActionAnimation() {
        LogHelper.info("ActionAnimation 初期化");
    }

    /**
     * 攻撃時アニメーション再生のダミー
     */
    public void playAttackAnimation(String animationId, Object entity) {
        // 実装では GeckoLib の AnimationController 等に繋ぐ
        LogHelper.info("Play attack animation: " + animationId + " on entity: " + entity);
    }

    /**
     * リロードアニメーション
     */
    public void playReloadAnimation(String animationId, Object entity) {
        LogHelper.info("Play reload animation: " + animationId + " on entity: " + entity);
    }
}
