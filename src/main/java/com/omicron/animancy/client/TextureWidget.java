package com.omicron.animancy.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Widget;

public class TextureWidget implements Widget {

    private Texture texture;

    private int x;

    private int y;

    private int renderToX;

    private int renderToY;

    private float scaleX;

    private float scaleY;


    public TextureWidget(Texture texture, int x, int y, int renderToX, int renderToY, float scaleX, float scaleY) {
        this.texture = texture;
        this.x = x;
        this.y = y;

        this.renderToX = renderToX;
        this.renderToY = renderToY;

        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public TextureWidget(Texture texture, int x, int y, int renderToX, int renderToY)
    {
        this(texture, x, y, renderToX, renderToY, 1, 1);
    }

    public TextureWidget(Texture texture, int x, int y, float scaleX, float scaleY)
    {
        this(texture, x, y, texture.textureEndX - texture.textureStartX, texture.textureEndY - texture.textureStartY, scaleX, scaleY);
    }

    public TextureWidget(Texture texture, int x, int y)
    {
        this(texture, x, y, texture.textureEndX - texture.textureStartX, texture.textureEndY - texture.textureStartY, 1, 1);
    }

    @Override
    public void render(PoseStack stack, int pMouseX, int pMouseY, float pPartialTicks) {
        RenderSystem.setShaderTexture(0, texture.textureLocation);
        int differenceX = texture.textureEndX - texture.textureStartX;
        int differenceY = texture.textureEndY - texture.textureStartY;
        int tempX = this.renderToX;

        for(int i = 0; tempX > 0; i++)
        {
            int tempY = this.renderToY;
            int currentX = tempX < differenceX ? tempX : differenceX;
            for(int j = 0; tempY > 0; j++)
            {
                int currentY = tempY < differenceY ? tempY : differenceY;
                GuiComponent.blit(stack, (int) (x + Math.floor(differenceX * scaleX * i)), (int) (y + Math.floor(differenceY * scaleY * j)), (int) (currentX * scaleX), (int) (currentY * scaleY), texture.textureStartX, texture.textureStartY, currentX, currentY, texture.textureWidth, texture.textureHeight);
                tempY -= differenceY;
            }
            tempX -= differenceX;
        }
    }

    /*private void innerRender(PoseStack stack, int x, int y)
    {
        GuiComponent.blit(stack, x, y, (int) ((texture.textureEndX - texture.textureStartX) * scaleX), (int) ((texture.textureEndY - texture.textureStartY) * scaleY), texture.textureStartX, texture.textureStartY, currentX, currentY, texture.textureWidth, texture.textureHeight);
    }*/
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRenderToX(int renderToX) {
        this.renderToX = renderToX;
    }

    public void setRenderToY(int renderToY) {
        this.renderToY = renderToY;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRenderToX() {
        return renderToX;
    }

    public int getRenderToY() {
        return renderToY;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }
}
