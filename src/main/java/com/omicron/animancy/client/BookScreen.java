package com.omicron.animancy.client;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.omicron.animancy.Animancy;
import com.omicron.animancy.util.RenderUtils;
import com.omicron.animancy.util.math.EPointF;
import com.omicron.animancy.util.math.PolyBezierPathUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class BookScreen extends Screen {


    private static DynamicTexture texture = null;

    @Override
    protected void init() {
        //System.out.println("izi");
        //CriteriaTriggers.BAD_OMEN;
        int x = 30;
        int y = 20;
        ResourceLocation gui = new ResourceLocation(Animancy.MODID, "textures/gui/sprite.png");
        ResourceLocation galaxy = new ResourceLocation(Animancy.MODID, "textures/gui/galaxy.png");
        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 18, 27, 59, 68), x, y));
        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 63, 27, 104, 68), this.width - 41 - x, y));
        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 18, 73, 59, 114), x, this.height - 41 - y));
        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 63, 73, 104, 114), this.width - 41 - x, this.height - 41 - y));

        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 18, 121, 21, 135), x + 3,  y + 41, 4, this.height - (y + 41) * 2));
        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 24, 121, 27, 135), this.width - x - 7,  y + 41, 4, this.height - (y + 41) * 2));
        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 33, 121, 44, 124),  x + 41, y + 8 - 4, this.width - (x + 41) * 2, 4));
        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 33, 129, 44, 132), x + 41, this.height - y - 8, this.width - (x + 41) * 2, 4));


        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 50, 121, 63, 126), this.width / 2 - 7,  y + 3));
        addRenderableOnly(new TextureWidget(new Texture(gui, 256, 256, 50, 129, 63, 134), this.width / 2 - 7, this.height - y - 7));

        addRenderableOnly(new TextureWidget(new Texture(galaxy, 1024, 1024), x + 7, y + 8, this.width - x - 43, this.height - y - 35));
        //addRenderableWidget()

    }

    private static void updateTexture()
    {


        ArrayList<EPointF> list = new ArrayList<>();
        list.add(new EPointF(89F, 54F));
        list.add(new EPointF(27F, 178F));

        list.add(new EPointF(181F, 37F));
        list.add(new EPointF(168F, 137F));
        list.add(new EPointF(123F, 92F));
        Path2D path = PolyBezierPathUtil.computePathThroughKnots(list);
        int width = 200;
        int height = 200;

        // create a new BufferedImage object
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);//new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = image.createGraphics();
      //  g2d.setColor(Color.CYAN);
       // g2d.fillRect(0, 0, width, height);
/*        BufferedImage textureImage = new BufferedImage(1024, 1024, BufferedImage.TYPE_INT_RGB);
        Optional<Resource> optional = Minecraft.getInstance().getResourceManager().getResource(new ResourceLocation(Animancy.MODID, "textures/gui/gui_res.png"));
        if(optional.isPresent())
        {
            try {
                image = ImageIO.read(optional.get().open());
                System.out.println(image.getHeight());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
       // Graphics2D textureGraphics = textureImage.createGraphics();

        textureGraphics.setColor(Color.BLUE);
        textureGraphics.fillRect(0, 0, 10, 10);
        textureGraphics.fillRect(10, 10, 10, 10);
        textureGraphics.dispose();
           g2d.setColor(Color.BLACK);*/

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(path);
        g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(path);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
        g2d.setColor(new Color(0, 0, 0, 0));
        g2d.setStroke(new BasicStroke(8));
        //g2d.drawLine(0, 0, image.getWidth(), image.getHeight());
        g2d.draw(path);
        g2d.dispose();
/*
        g2d.setPaint(new TexturePaint(textureImage, new Rectangle(0, 0, 1024, 1024)));

        // draw the path
        g2d.draw(path);
        g2d.setColor(new Color(102, 2, 99));

        g2d.setStroke(new BasicStroke(9));
        g2d.draw(path);
        g2d.setColor(new Color(135, 26, 131));
        g2d.setStroke(new BasicStroke(1f * 3));



        Color color1 = Color.RED;
        Color color2 = Color.BLUE;
        GradientPaint gradient = new GradientPaint(0, 0, color1, 50, 50, color2, true);
        g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, null, 0.0f));
        g2d.setPaint(gradient);
        float centerX = 50;
        float centerY = 50;
        float radius = 50;
        Color innerColor = Color.WHITE;
        Color outerColor = Color.BLACK;
        RadialGradientPaint gradient = new RadialGradientPaint(centerX, centerY, radius, new float[] {0f, 1f}, new Color[] {innerColor, outerColor});
        g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, null, 0.0f));
        g2d.setPaint(gradient);

        int x1 = 50;
        int y1 = 50;
        int x2 = 250;
        int y2 = 250;
        Color startColor = Color.RED;
        Color endColor = Color.YELLOW;

        GradientPaint gradient = new GradientPaint(x1, y1, startColor, x2, y2, endColor);
        g2d.setPaint(gradient);

        // Set rendering hints to smooth out the line
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        g2d.setStroke(new GradientStroke(10f, 10f, new float[] { 0f, 1f }, new Color[] { startColor, endColor }));

*/


        String string = RenderUtils.encodeToString(image, "png");
        try {
            texture = new DynamicTexture(NativeImage.fromBase64(string));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static
    {

    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(Animancy.MODID, "textures/gui/gui.png");
    private static final ResourceLocation MINECRAFT_LOGO = new ResourceLocation("textures/gui/title/minecraft.png");

    public BookScreen() {
        super(Component.translatable("screen.omicronexample.book"));
    }

    @Override
    public void render(PoseStack pMatrixStack, int pMouseX, int pMouseY, float pPartialTicks)
    {
        renderBackground(pMatrixStack);
        super.render(pMatrixStack, pMouseX, pMouseY, pPartialTicks);

        if(texture != null)
        {
            //System.out.println(this.width + "   " + this.height);
            ResourceLocation location = new ResourceLocation(Animancy.MODID, "essunia");
          /*  GlStateManager._enableDepthTest();
            GlStateManager._disableCull();
            Minecraft.getInstance().getMainRenderTarget().enableStencil();
            RenderSystem.clearStencil(0);
            RenderSystem.clear(GL11.GL_STENCIL_BUFFER_BIT, false);
            RenderSystem.stencilFunc(GL11.GL_ALWAYS, 1, 0xFF);
            RenderSystem.stencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE);
*/
            this.minecraft.getTextureManager().register(location, texture);
 /*           GlStateManager._colorMask(true, true, true, true);
            GlStateManager._depthMask(true);
            GlStateManager._stencilMask(0xFF);
            //texture.getPixels().fillRect(0, 0, 32, 32, 0xFFFF00FF);
            // RenderSystem.disableBlend();*/
           // Screen.blit(pMatrixStack, 50, 50, 0, 0, 0, 200, 200, 200, 200);

            RenderSystem.enableTexture();
            texture.upload();
            texture.bind();
            //System.out.println(texture.getPixels().getWidth());
            RenderSystem.setShaderTexture(0, location);
            //Screen.blit(pMatrixStack, 50, 50, 0, 0, 0, 200, 200, 200, 200);


       /*     GlStateManager._colorMask(true, true, true, true);
            GlStateManager._depthMask(true);
            RenderSystem.stencilFunc(GL11.GL_EQUAL, 1, 0xFF);
            RenderSystem.stencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_KEEP);
*/


          //  pMatrixStack.pushPose();
           // pMatrixStack.scale(1.1F, 1.0F, 1);

            //RenderSystem.setShaderTexture(0, gui);
            //Screen.blit(pMatrixStack, 0, 0, 0, 500, 500, 1024, 1024, 1024, 1024);

            //System.out.println(this.width/2);
            //renderable.render(pMatrixStack, pMouseX, pMouseY, pPartialTicks);
           // blit(pMatrixStack, (int) (this.width/2.0), this.height/2,  18, 27,  59 - 18, 68 - 27, 256, 256);
           // pMatrixStack.popPose();

        }
        else {
            updateTexture();
        }

/*
                //super.render(pMatrixStack, pMouseX, pMouseY, pPartialTicks);
        int color = 0xFFFF00;
        //Screen.fill(pMatrixStack, 0,0,1000,1000, color);
        RenderSystem.enableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        // Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.LINES);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder buffer = tesselator.getBuilder();
        float red = 1.0F;
        float green = 0.0F;
        float blue = 0.0F;
        float alpha = 1.0F;
       // System.out.println("ez");
        Camera camera = this.minecraft.gameRenderer.getMainCamera();
        PoseStack posestack = RenderSystem.getModelViewStack();
        posestack.pushPose();
        posestack.translate((double)(this.width / 2), (double)(this.height / 2), (double)this.getBlitOffset());
        posestack.mulPose(Vector3f.XN.rotationDegrees(camera.getXRot()));
        posestack.mulPose(Vector3f.YP.rotationDegrees(camera.getYRot()));
        posestack.scale(-1.0F, -1.0F, -1.0F);
        RenderSystem.applyModelViewMatrix();
//        RenderSystem.renderCrosshair(10);
        RenderSystem.assertOnRenderThread();
        GlStateManager._disableTexture();
        GlStateManager._depthMask(false);
        GlStateManager._disableCull();
        RenderSystem.setShader(GameRenderer::getRendertypeLinesShader);
        //Tesselator tesselator = RenderSystem.renderThreadTesselator();
        RenderSystem.lineWidth(40.0F);
        posestack.popPose();
        RenderSystem.applyModelViewMatrix();
        //RenderSystem.lineWidth(4.0F);
        //RenderSystem.renderCrosshair(20);
        buffer.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);
        buffer.vertex(10, 10, 0).color(red, green, blue, alpha).normal(0.0F, 1.0F, 0.0F).endVertex();
        buffer.vertex(50, 50, 0).color(red, green, blue, alpha).normal(0.0F, 1.0F, 0.0F).endVertex();

        // Add the second line
        buffer.vertex(50, 50, 0).color(red, green, blue, alpha).normal(0.0F, 1.0F, 0.0F).endVertex();
        buffer.vertex(90, 10, 0).color(red, green, blue, alpha).normal(0.0F, 1.0F, 0.0F).endVertex();

        tesselator.end();
        buffer.endOrDiscardIfEmpty();
        ScreenUtils.drawGradientRect();

        this.renderBackground(pMatrixStack);

        VertexConsumer consumer = Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.LINES);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(0, 0, 0);

        drawString(pMatrixStack, Minecraft.getInstance().font, "test", 10, 10, 0xffffff);
        Style style = Component.literal("yes").getStyle();
        Style style1 = style.withFont(new ResourceLocation(Animancy.MODID, "test"));
        pMatrixStack.pushPose();
        Matrix4f matrix4f =pMatrixStack.last().pose();
        //blueLine(consumer, matrix4f, pos, 0, 0, 0, 50, 50, 50);


        pMatrixStack.scale(0.3F, 0.3F, 0.3F);
        Minecraft.getInstance().font.drawShadow(pMatrixStack, Component.literal("yes").setStyle(style1).append(" tak"), 6, 6, 0xffffff);
        this.minecraft.getTextureManager().bindForSetup(TEXTURE);
        blit(pMatrixStack, 200, 200, 0, 0, 0, 0, 955, 638, 955, 638);
        this.minecraft.getTextureManager().bindForSetup(TEXTURE);
        this.blit(pMatrixStack, 100 + 0, 100, 0, 0, 955, 638, 955, 638);

        pMatrixStack.popPose();
*/


    }




    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        super.mouseClicked(pMouseX, pMouseY, pButton);

        updateTexture();
        return true;
    }
}
