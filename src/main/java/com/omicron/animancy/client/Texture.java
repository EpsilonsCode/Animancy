package com.omicron.animancy.client;

import net.minecraft.resources.ResourceLocation;

public class Texture {

    public ResourceLocation textureLocation;

    public int textureWidth;

    public int textureHeight;

    public int textureStartX;

    public int textureStartY;

    public int textureEndX;

    public int textureEndY;

    public Texture(ResourceLocation textureLocation, int textureWidth, int textureHeight, int textureStartX, int textureStartY, int textureEndX, int textureEndY) {
        this.textureLocation = textureLocation;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.textureStartX = textureStartX;
        this.textureStartY = textureStartY;
        this.textureEndX = textureEndX;
        this.textureEndY = textureEndY;
    }

    public Texture(ResourceLocation textureLocation, int textureWidth, int textureHeight) {
        this(textureLocation, textureWidth, textureHeight, 0, 0, textureWidth, textureHeight);
    }

}