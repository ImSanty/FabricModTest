package com.santiaguero.test.items;

import com.santiaguero.test.TestMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PaintBrushItem extends Item {

  public PaintBrushItem() {
    super(new FabricItemSettings().group(TestMod.ITEM_GROUP));
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    World world = context.getWorld();
    Block block = world.getBlockState(context.getBlockPos()).getBlock();
    if (block == Blocks.GRASS_BLOCK) {
      if (!world.isClient()) {
        //Update the block and item on server side
        world.setBlockState(context.getBlockPos(), Blocks.LIME_CONCRETE.getDefaultState());
      }else {
        //Play sound on client side
        context.getPlayer().playSound(SoundEvents.BLOCK_SLIME_BLOCK_PLACE, 1.0f, 1.0f);
      }
    }
    return super.useOnBlock(context);
  }

  @Override
  public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
    if (!user.getWorld().isClient() && hand == Hand.MAIN_HAND) {
      //Runs on server side only
      if (entity.getType() == EntityType.SHEEP) {
        //Set sheep color
        SheepEntity sheep = (SheepEntity) entity;
        sheep.setColor(DyeColor.LIME);
        if (!user.isCreative()) {
          user.getStackInHand(hand).decrement(1);
        }
      } else {
        user.sendMessage(Text.literal("Solo funciona en ovejas"));
      }
    }
    return super.useOnEntity(stack, user, entity, hand);
  }
}
