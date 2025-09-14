package com.infinitymax.combat.animation;

import com.infinitymax.combat.util.LogHelper;

/**
 * 一人称用アニメーション（武器のスライド、リロード、射撃の一人称表示）
 * - BlockBench で作った一人称モデルに適用する際のラッパー
 */
public class FpsAnimation {

    public FpsAnimation() {
        LogHelper.info("FpsAnimation 初期化");
    }

    public void playFirstPersonFire(String weaponId, Object player) {
        LogHelper.info("Play FP fire anim for " + weaponId + " on player " + player);
    }

    public void playFirstPersonReload(String weaponId, Object player) {
        LogHelper.info("Play FP reload anim for " + weaponId + " on player " + player);
    }
}
