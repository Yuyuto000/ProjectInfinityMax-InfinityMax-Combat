package com.infinitymax.combat.animation;

import com.infinitymax.combat.util.LogHelper;

/**
 * Entity（武器を持つエンティティや弾丸、兵器など）用アニメーション管理
 * - BlockBench で生成されたモデル/アニメーションをここに配置して制御する
 * - 「ここにJava化されたBlockBench出力を投入する」想定の場所
 */
public class EntityAnimation {

    public EntityAnimation() {
        LogHelper.info("EntityAnimation 初期化");
    }

    /**
     * 汎用アニメーション再生
     */
    public void playEntityAnimation(String animId, Object entity) {
        LogHelper.info("Play entity animation " + animId + " on " + entity);
    }

    // BlockBench で生成した Java 版のアニメーションがある場合はそれらをここに統合する
}
