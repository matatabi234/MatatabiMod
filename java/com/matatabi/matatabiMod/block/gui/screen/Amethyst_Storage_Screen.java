package com.matatabi.matatabiMod.block.gui.screen;

import com.matatabi.matatabiMod.block.gui.container.Amethyst_Storage_Menu;
import com.matatabi.matatabiMod.mine.MatatabiMod;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.gui.Font;

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

        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0x000000, true);

        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0x4B0082, true);
    }

// Amethyst_Storage_Screen.java のクラス内に追記

    // 💡 ステップ 1: 数値フォーマットヘルパーメソッド (以前のもの)
    private String formatCount(int count) {
        if (count < 1000) {
            return String.valueOf(count);
        } else if (count < 1000000) {
            double k = count / 1000.0;
            return String.format("%.1fk", k);
        } else if (count < 1000000000) {
            double m = count / 1000000.0;
            return String.format("%.1fM", m);
        }
        double g = count / 1000000000.0;
        return String.format("%.1fG", g);
    }


    // 💡 ステップ 2: 全スロットに対するカスタム描画を実行するメソッド
// Amethyst_Storage_Screen.java のクラス内に追記/上書き

// Amethyst_Storage_Screen.java のクラス内に追記/上書き

    private void drawCustomItemCount(GuiGraphics graphics) {
        // 描画サイズを調整するためのスケール値
        final float scale = 0.5f;

        // GUIメニューに存在する全スロットをループ
        for (Slot slot : this.menu.slots) {
            ItemStack stack = slot.getItem();

            // 以下の条件: スロットが空でなく、スタック数が64を超えている、かつカスタムコンテナのスロットである
            if (!stack.isEmpty() && stack.getCount() > 64 && slot.container.getContainerSize() > slot.getSlotIndex()) {

                // 1. スロットの左上座標を取得
                int x = slot.x + this.leftPos;
                int y = slot.y + this.topPos;

                // 2. 表示するテキストを取得
                String countText = formatCount(stack.getCount());

                // 3. テキストの色を設定（明るいシアン）
                int color = 0xFF42E5F4;

                // 4. フォントと文字幅を取得 (スケール前のサイズ)
                Font font = this.font;
                int textWidth = font.width(countText);

                // 5. 描画位置の計算（スロットの右下隅に配置）
                // 縮小後の描画位置を計算する
                int unscaledX = (int)((x + 16 - textWidth * scale - 1.0f) / scale); // 1.0fを引いて枠から1ピクセル内側に寄せる
                int unscaledY = (int)((y + 16 - (font.lineHeight * scale)) / scale);

                // 描画設定をプッシュ (保存)
                graphics.pose().pushPose(); // <--- ここを修正

                // 描画をスケールダウン (例: 50%に縮小)
                graphics.pose().scale(scale, scale, scale);

                // スケールされた座標に影付きで描画
                // 影として黒を描画
                graphics.drawString(font, countText, unscaledX + 1, unscaledY + 1, 0x000000, false);
                // その上にカスタムカラーの文字を描画
                graphics.drawString(font, countText, unscaledX, unscaledY, color, false);

                // 描画設定をポップ (元に戻す)
                graphics.pose().popPose(); // <--- ここを修正
            }
        }
    }


// Amethyst_Storage_Screen.java の render メソッドをオーバーライド

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // 1. 最初に背景の描画（画面の暗転）を呼び出す
        this.renderBackground(graphics);

        // 2. 標準のGUI描画処理を呼び出す (アイテムアイコン、スロットの枠線など)
        super.render(graphics, mouseX, mouseY, partialTicks);

        // 3. カスタム描画を呼び出す (ここが重要)
        // マウステキスト（ツールチップ）が表示される前に描画する
        this.drawCustomItemCount(graphics);

        // 4. ツールチップ（カーソルを合わせたときのアイテム名）の描画
        this.renderTooltip(graphics, mouseX, mouseY);
    }
}
