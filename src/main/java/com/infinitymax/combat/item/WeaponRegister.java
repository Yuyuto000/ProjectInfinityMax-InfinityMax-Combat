package com.infinitymax.combat.item;

import com.infinitymax.combat.animation.FpsAnimation;
import com.infinitymax.combat.actions.FpsSystems;

/**
 * 初期武器・兵器の大量登録
 */
public class WeaponRegister {

    private final FpsSystems fpsSys;
    private final FpsAnimation fpsAnim;

    public WeaponRegister(FpsSystems fpsSys) {
        this.fpsSys = fpsSys;
        this.fpsAnim = new FpsAnimation();
    }

    public void registerAll() {

        // ================================
        // 🔫 銃火器 (25種)
        // ================================

        // --- SMG ---
        new GunItem("smg01", "Raptor-9 SMG", 9, 750, 30, 2.1, fpsSys, fpsAnim).register();
        new GunItem("smg02", "Viper-X", 8, 800, 32, 2.0, fpsSys, fpsAnim).register();
        new GunItem("smg03", "Specter-11", 10, 720, 28, 2.3, fpsSys, fpsAnim).register();
        new GunItem("smg04", "Hornet-45", 11, 680, 25, 2.5, fpsSys, fpsAnim).register();
        new GunItem("smg05", "Falcon-Micro", 7, 900, 20, 1.9, fpsSys, fpsAnim).register();

        // --- Handgun ---
        new GunItem("hg01", "Cobra .45", 12, 300, 12, 1.6, fpsSys, fpsAnim).register();
        new GunItem("hg02", "Sidewinder-9", 10, 280, 15, 1.4, fpsSys, fpsAnim).register();
        new GunItem("hg03", "IronFist", 14, 260, 10, 1.8, fpsSys, fpsAnim).register();
        new GunItem("hg04", "Python-X", 13, 250, 8, 2.0, fpsSys, fpsAnim).register();
        new GunItem("hg05", "Valkyrie-17", 11, 320, 16, 1.5, fpsSys, fpsAnim).register();

        // --- Assault Rifle ---
        new GunItem("ar01", "Hydra-21", 15, 650, 30, 2.5, fpsSys, fpsAnim).register();
        new GunItem("ar02", "Cerberus Mk2", 16, 620, 32, 2.6, fpsSys, fpsAnim).register();
        new GunItem("ar03", "Cyclone-47", 17, 600, 35, 2.7, fpsSys, fpsAnim).register();
        new GunItem("ar04", "Griffin-94", 18, 580, 40, 3.0, fpsSys, fpsAnim).register();
        new GunItem("ar05", "Phantom-56", 15, 700, 28, 2.4, fpsSys, fpsAnim).register();

        // --- Shotgun ---
        new GunItem("sg01", "Thunderstrike-12", 40, 80, 6, 3.0, fpsSys, fpsAnim).register();
        new GunItem("sg02", "Cerberus Pump", 45, 70, 8, 3.2, fpsSys, fpsAnim).register();
        new GunItem("sg03", "DragonBreath-X", 50, 60, 5, 3.5, fpsSys, fpsAnim).register();
        new GunItem("sg04", "Breaker-10", 38, 90, 10, 2.8, fpsSys, fpsAnim).register();
        new GunItem("sg05", "Howl-16", 42, 75, 7, 3.1, fpsSys, fpsAnim).register();

        // --- Sniper Rifle ---
        new GunItem("sr01", "ShadowLance", 80, 50, 5, 3.8, fpsSys, fpsAnim).register();
        new GunItem("sr02", "Longclaw-98", 90, 45, 4, 4.0, fpsSys, fpsAnim).register();
        new GunItem("sr03", "Basilisk Mk3", 95, 40, 3, 4.2, fpsSys, fpsAnim).register();
        new GunItem("sr04", "Oblivion-7", 85, 55, 6, 3.7, fpsSys, fpsAnim).register();
        new GunItem("sr05", "Hellpiercer", 100, 35, 2, 4.5, fpsSys, fpsAnim).register();


        // ================================
        // ⚔️ 近接武器 (32種)
        // ================================

        // --- Sword (5) ---
        new MeleeItem("sword01", "Eternal Fang", "sword", 14, 1.6, 3.0).register();
        new MeleeItem("sword02", "Duskreaver", "sword", 16, 1.5, 3.2).register();
        new MeleeItem("sword03", "Bloodsong", "sword", 18, 1.4, 3.0).register();
        new MeleeItem("sword04", "Stormfang", "sword", 15, 1.7, 3.1).register();
        new MeleeItem("sword05", "Soulrender", "sword", 20, 1.3, 3.4).register();

        // --- Axe (5) ---
        new MeleeItem("axe01", "Crusher of Dawn", "axe", 22, 1.2, 2.7).register();
        new MeleeItem("axe02", "Frostcleaver", "axe", 25, 1.0, 2.8).register();
        new MeleeItem("axe03", "Demon Splitter", "axe", 28, 0.9, 2.6).register();
        new MeleeItem("axe04", "Warhowl", "axe", 24, 1.1, 2.9).register();
        new MeleeItem("axe05", "Ironjaw", "axe", 26, 1.0, 2.5).register();

        // --- Spear (5) ---
        new MeleeItem("spear01", "Moonlance", "spear", 15, 1.4, 4.0).register();
        new MeleeItem("spear02", "Skyrender", "spear", 18, 1.3, 4.2).register();
        new MeleeItem("spear03", "Serpent Fang", "spear", 20, 1.2, 4.1).register();
        new MeleeItem("spear04", "Thunderpike", "spear", 22, 1.1, 4.3).register();
        new MeleeItem("spear05", "Dawnbreaker", "spear", 19, 1.4, 4.0).register();

        // --- Dagger (5) ---
        new MeleeItem("dagger01", "Venomfang", "dagger", 10, 2.0, 2.0).register();
        new MeleeItem("dagger02", "Silent Fang", "dagger", 12, 1.9, 2.2).register();
        new MeleeItem("dagger03", "Shadowfang", "dagger", 14, 1.8, 2.1).register();
        new MeleeItem("dagger04", "Gloomfang", "dagger", 13, 1.9, 2.0).register();
        new MeleeItem("dagger05", "Nightfang", "dagger", 15, 1.7, 2.3).register();

        // --- Greatsword (5) ---
        new MeleeItem("gs01", "Titanfall Blade", "greatsword", 28, 0.9, 3.8).register();
        new MeleeItem("gs02", "Worldbreaker", "greatsword", 30, 0.8, 4.0).register();
        new MeleeItem("gs03", "Dragoncleaver", "greatsword", 32, 0.7, 4.2).register();
        new MeleeItem("gs04", "Nightfall Blade", "greatsword", 29, 0.9, 3.9).register();
        new MeleeItem("gs05", "Oblivion Edge", "greatsword", 35, 0.6, 4.5).register();

        // --- Katana (7, 実在名) ---
        new MeleeItem("katana01", "村正", "katana", 22, 1.4, 3.1).register();
        new MeleeItem("katana02", "正宗", "katana", 24, 1.3, 3.2).register();
        new MeleeItem("katana03", "長曾祢虎徹", "katana", 26, 1.2, 3.3).register();
        new MeleeItem("katana04", "童子切安綱", "katana", 28, 1.1, 3.4).register();
        new MeleeItem("katana05", "三日月宗近", "katana", 30, 1.0, 3.5).register();
        new MeleeItem("katana06", "大典太光世", "katana", 27, 1.2, 3.3).register();
        new MeleeItem("katana07", "数珠丸恒次", "katana", 25, 1.3, 3.2).register();


        // ================================
        // 🚀 戦闘機 (6) & 戦車 (6)
        // ================================

        // --- Fighter ---
        new VehicleItem("fighter01", "F-22 Raptor", "fighter", 300, 80).register();
        new VehicleItem("fighter02", "F-35 Lightning II", "fighter", 280, 75).register();
        new VehicleItem("fighter03", "Su-57 Felon", "fighter", 310, 82).register();
        new VehicleItem("fighter04", "J-20 Mighty Dragon", "fighter", 320, 78).register();
        new VehicleItem("fighter05", "Eurofighter Typhoon", "fighter", 290, 70).register();
        new VehicleItem("fighter06", "Rafale M", "fighter", 285, 72).register();

        // --- Tank ---
        new VehicleItem("tank01", "M1A2 Abrams", "tank", 600, 120).register();
        new VehicleItem("tank02", "Leopard 2A7", "tank", 580, 115).register();
        new VehicleItem("tank03", "Challenger 2", "tank", 620, 118).register();
        new VehicleItem("tank04", "T-14 Armata", "tank", 590, 122).register();
        new VehicleItem("tank05", "K2 Black Panther", "tank", 570, 110).register();
        new VehicleItem("tank06", "Type 10", "tank", 560, 108).register();
    }
}
