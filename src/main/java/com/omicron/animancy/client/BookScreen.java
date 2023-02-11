package com.omicron.animancy.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.omicron.animancy.Animancy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;

public class BookScreen extends Screen {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Animancy.MODID, "textures/gui/gui.png");
    private static final ResourceLocation MINECRAFT_LOGO = new ResourceLocation("textures/gui/title/minecraft.png");

    public BookScreen() {
        super(Component.translatable("screen.omicronexample.book"));
    }

    @Override
    public void render(PoseStack pMatrixStack, int pMouseX, int pMouseY, float pPartialTicks)
    {
        this.renderBackground(pMatrixStack);
        super.render(pMatrixStack, pMouseX, pMouseY, pPartialTicks);
        drawString(pMatrixStack, Minecraft.getInstance().font, "test", 10, 10, 0xffffff);
        Style style = Component.literal("yes").getStyle();
        Style style1 = style.withFont(new ResourceLocation(Animancy.MODID, "test"));
        pMatrixStack.pushPose();
        pMatrixStack.scale(0.3F, 0.3F, 0.3F);
        Minecraft.getInstance().font.drawShadow(pMatrixStack, Component.literal("yes").setStyle(style1).append(" tak"), 6, 6, 0xffffff);
        this.minecraft.getTextureManager().bindForSetup(TEXTURE);
        blit(pMatrixStack, 200, 200, 0, 0, 0, 0, 955, 638, 955, 638);
        this.minecraft.getTextureManager().bindForSetup(TEXTURE);
        this.blit(pMatrixStack, 100 + 0, 100, 0, 0, 955, 638, 955, 638);
        pMatrixStack.popPose();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        super.mouseClicked(pMouseX, pMouseY, pButton);
        System.out.println(width + " W");
        System.out.println(height + " H");
        System.out.println(Minecraft.getInstance().getWindow().getGuiScale() + " S");
        return true;
    }
}
