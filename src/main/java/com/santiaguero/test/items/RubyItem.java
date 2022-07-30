package com.santiaguero.test.items;

import com.santiaguero.test.TestMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class RubyItem extends Item {

  public RubyItem() {
    super(new FabricItemSettings().group(TestMod.ITEM_GROUP).rarity(Rarity.EPIC).maxCount(64));
  }
}
