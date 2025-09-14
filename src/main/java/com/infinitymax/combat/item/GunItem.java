package com.infinitymax.combat.item;

import com.infinitymax.api.core.RegistryHandler;
import com.infinitymax.combat.util.LogHelper;
import com.infinitymax.combat.actions.FpsSystems;
import com.infinitymax.combat.animation.FpsAnimation;

/**
 * 銃火器の基本クラス
 * - InfinityMaxAPI 経由で登録
 * - FPS操作やアニメーションに対応
 */
public class GunItem {

    public final String id;
    public final String name;
    public final int damage;
    public final int rateOfFire;
    public final int magazineSize;
    public final double reloadTime;

    private final FpsSystems fpsSystems;
    private final FpsAnimation fpsAnimation;

    public GunItem(String id, String name, int damage, int rateOfFire, int magazineSize, double reloadTime,
                   FpsSystems fpsSystems, FpsAnimation fpsAnimation) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.rateOfFire = rateOfFire;
        this.magazineSize = magazineSize;
        this.reloadTime = reloadTime;
        this.fpsSystems = fpsSystems;
        this.fpsAnimation = fpsAnimation;
    }

    /**
     * 射撃
     */
    public void fire(Object player) {
        long now = System.currentTimeMillis();
        if(fpsSystems.tryFireWeapon(id, now)){
            fpsAnimation.playFirstPersonFire(id, player);
            LogHelper.info("Gun fired: " + id);
        }
    }

    /**
     * リロード
     */
    public void reload(Object player){
        fpsAnimation.playFirstPersonReload(id, player);
        LogHelper.info("Reloaded gun: " + id);
    }

    /**
     * InfinityMaxAPI で登録
     */
    public void register() {
        RegistryHandler.registerItem(id, this);
        LogHelper.info("Registered gun: " + id);
    }
}
