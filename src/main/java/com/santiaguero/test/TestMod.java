package com.santiaguero.test;

import com.santiaguero.test.registry.ModBlocks;
import com.santiaguero.test.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TestMod implements ModInitializer {

  public static final String MOD_ID = "is";

  public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"), () -> new ItemStack(ModItems.RUBY));

  @Override
  public void onInitialize() {
    ModItems.registerItems();
    ModBlocks.registerBlocks();
  }
}
