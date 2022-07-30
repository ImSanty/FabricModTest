package com.santiaguero.test.registry;

import com.santiaguero.test.TestMod;
import com.santiaguero.test.items.PaintBrushItem;
import com.santiaguero.test.items.RubyItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

  //Items
  public static final PaintBrushItem PAINT_BRUSH = new PaintBrushItem();
  public static final RubyItem RUBY = new RubyItem();

  //BLock Items
  public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new FabricItemSettings().group(TestMod.ITEM_GROUP));

  //is:ruby
  public static void registerItems() {
    Registry.register(Registry.ITEM, new Identifier(TestMod.MOD_ID, "ruby"), RUBY);
    Registry.register(Registry.ITEM, new Identifier(TestMod.MOD_ID, "paint_brush"), PAINT_BRUSH);
    Registry.register(Registry.ITEM, new Identifier(TestMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
  }
}
