package com.infinitymax.combat.item;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

public class WeaponForgeScreen extends AbstractContainerScreen<WeaponForgeContainer> {

    public WeaponForgeScreen(WeaponForgeContainer container, int width, int height, Component title) {
        super(container, container.getPlayerInventory(), title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        // 背景描画
        RenderSystem.setShaderTexture(0, ModResources.WEAPON_FORGE_GUI);
        guiGraphics.blit(0, 0, 0, 0, 176, 166);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
