package com.matatabi.matatabiMod.block.gui.screen;

import com.matatabi.matatabiMod.block.gui.container.Amethyst_Storage_Menu;
import com.matatabi.matatabiMod.block.gui.container.MatatabiModContainerTypes;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class Amethyst_Storage_Screen extends AbstractContainerScreen<Amethyst_Storage_Menu> {

    private static final ResourceLocation AMETHYST_STORGE_TEXTURE = new ResourceLocation(MatatabiMod.MOD_ID,"textures/gui/container/Amethyst_Storage_GUI.png");

    private static final Component INVENTORY_TITLE = Component.translatable("container." + MatatabiMod.MOD_ID + ".inventory").withStyle(ChatFormatting.BLUE);

    public Amethyst_Storage_Screen(Amethyst_Storage_Menu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.titleLabelX = 4;
        this.titleLabelY = 3;
        this.inventoryLabelX = 4;
        this.inventoryLabelY = this.imageHeight - 90;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float f, int w, int h) {
        int setW = (this.width-this.imageWidth)/2;
        int setH = (this.height-this.imageHeight)/2;
        graphics.blit(AMETHYST_STORGE_TEXTURE,setW,setH,0,0,this.imageWidth,this.imageHeight);

    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int w, int h) {
        graphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0xFF0AF6, false);
        graphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0xFF0AF6, false);
    }
}
