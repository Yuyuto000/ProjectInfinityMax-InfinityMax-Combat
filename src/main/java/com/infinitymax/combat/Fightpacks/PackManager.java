package com.infinitymax.combat.Fightpacks;

import com.infinitymax.combat.util.LogHelper;
import com.infinitymax.combat.item.ItemRegister;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * FightPack 管理クラス
 * - mods/infinitymax_combat/fightpacks/ 以下を探索してパックを見つける
 * - 見つけたパックごとに PackLoader を呼び出して登録する
 *
 * ※Jar内組み込みのデフォルトパックはリソースルートからの読み込みを行う想定だが、
 *    ここでは外部modsフォルダ優先の挙動にしている（ユーザーが追加しやすくするため）。
 */
public class PackManager {

    // デフォルトの探索パス (mod が稼働している環境の mods フォルダ直下)
    private static final String DEFAULT_PACKS_DIR = "mods/infinitymax_combat/fightpacks";

    private final ItemRegister itemRegister;
    private final Map<String, PackHandler> loadedPacks = new HashMap<>();

    public PackManager(ItemRegister itemRegister) {
        this.itemRegister = itemRegister;
        LogHelper.info("PackManager 初期化");
    }

    /**
     * 外部フォルダを探索してパックを発見し、読み込む。
     */
    public void discoverAndLoadPacks() {
        LogHelper.info("FightPack の探索を開始します: " + DEFAULT_PACKS_DIR);

        Path packsRoot = Paths.get(DEFAULT_PACKS_DIR);
        if (!Files.exists(packsRoot)) {
            LogHelper.warn("パックルートが存在しません。作成します: " + packsRoot.toAbsolutePath());
            try {
                Files.createDirectories(packsRoot);
            } catch (IOException e) {
                LogHelper.error("パックルート作成に失敗しました", e);
                return;
            }
        }

        // パックフォルダを列挙
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(packsRoot)) {
            for (Path p : dirStream) {
                if (Files.isDirectory(p)) {
                    String packName = p.getFileName().toString();
                    LogHelper.info("FightPack 発見: " + packName + " -> " + p.toAbsolutePath());
                    PackLoader loader = new PackLoader(p, itemRegister);
                    PackHandler handler = loader.loadPack();
                    if (handler != null) {
                        loadedPacks.put(packName, handler);
                        LogHelper.info("パックをロードしました: " + packName);
                    } else {
                        LogHelper.warn("パック読み込み失敗: " + packName);
                    }
                }
            }
        } catch (IOException ex) {
            LogHelper.error("pack フォルダ探索中に例外", ex);
        }

        // TODO: Jar 内組み込みのデフォルトパックを resources から読み込む処理を追加しても良い
    }

    public Optional<PackHandler> getPack(String name) {
        return Optional.ofNullable(loadedPacks.get(name));
    }

    public Collection<String> listLoadedPacks() {
        return Collections.unmodifiableSet(loadedPacks.keySet());
    }
}
