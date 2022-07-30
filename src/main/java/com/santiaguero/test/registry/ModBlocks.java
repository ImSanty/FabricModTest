package com.santiaguero.test.registry;

import com.santiaguero.test.TestMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
  public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.RED).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.METAL));

  public static void registerBlocks() {
    Registry.register(Registry.BLOCK, new Identifier(TestMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
  }
}
