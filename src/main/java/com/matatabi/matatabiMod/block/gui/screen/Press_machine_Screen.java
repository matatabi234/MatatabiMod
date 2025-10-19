package com.matatabi.matatabiMod.block.gui.screen;


import com.matatabi.matatabiMod.block.gui.container.Press_Machine_Menu;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class Press_machine_Screen extends AbstractContainerScreen<Press_Machine_Menu> {

    private static final ResourceLocation PRESS_MACHINE_TEXTURE = MatatabiMod.makeId("textures/gui/container/press_machine_gui.png");


    private static final Component INVENTORY_TITLE = Component.translatable("container." + MatatabiMod.MOD_ID + ".inventory").withStyle(ChatFormatting.DARK_PURPLE);

    public Press_machine_Screen(Press_Machine_Menu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.titleLabelX = 4;
        this.titleLabelY = 3;
        this.inventoryLabelX = 4;
        this.inventoryLabelY = this.imageHeight - 92;
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float tick, int mouseX, int mouseY) {
        guiGraphics.blit(PRESS_MACHINE_TEXTURE, this.leftPos, this.topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int w, int h) {

        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0x000000, true);

        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0x4B0082, true);
    }

}
