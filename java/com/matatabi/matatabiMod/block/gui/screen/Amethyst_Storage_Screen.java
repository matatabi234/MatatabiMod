package com.matatabi.matatabiMod.block.gui.screen;

import com.matatabi.matatabiMod.block.gui.container.Amethyst_Storage_Menu;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class Amethyst_Storage_Screen extends AbstractContainerScreen<Amethyst_Storage_Menu> {

    private static final ResourceLocation AMETHYST_STORAGE_TEXTURE = MatatabiMod.makeId("textures/gui/container/amethyst_storage_gui.png");


    private static final Component INVENTORY_TITLE = Component.translatable("container." + MatatabiMod.MOD_ID + ".inventory").withStyle(ChatFormatting.DARK_PURPLE);

    public Amethyst_Storage_Screen(Amethyst_Storage_Menu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = 277;
        this.imageHeight = 224;
        this.titleLabelX = 4;
        this.titleLabelY = 6;
        this.inventoryLabelX = 4;
        this.inventoryLabelY = this.imageHeight - 80;
    }

//    @Override
//    protected void renderBg(GuiGraphics graphics, float f, int w, int h) {
//        int setW = (this.width-this.imageWidth)/2;
//        int setH = (this.height-this.imageHeight)/2;
//        graphics.blit(AMETHYST_STORAGE_TEXTURE, this.leftPos, this.topPos, 8, 8, imageWidth, imageHeight, imageWidth, imageHeight);
//
//    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float tick, int mouseX, int mouseY) {
        guiGraphics.blit(AMETHYST_STORAGE_TEXTURE, this.leftPos, this.topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int w, int h) {

        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0xFF8A2BE2, false);

        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0xFF4B0082, false);
    }
}
