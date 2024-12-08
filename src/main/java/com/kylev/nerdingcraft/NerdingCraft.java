package com.kylev.nerdingcraft;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.kylev.nerdingcraft.block.WoolFurnace;

/**
 * The main mod class for NerdingCraft.
 */
@Mod(NerdingCraft.MOD_ID)
public class NerdingCraft {
    public static final String MOD_ID = "nerdingcraft";
    public static Logger LOGGER = LogUtils.getLogger();

    // Registries
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    // A minimal block and item
    public static final DeferredBlock<Block> SMILING_BLOCK = BLOCKS.register("smiling_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.ICE)));
    public static final DeferredItem<Item> SMILING_BLOCK_ITEM = ITEMS.register("smiling_block",
            () -> new BlockItem(SMILING_BLOCK.get(), new Item.Properties().stacksTo(64)));

    // A customized furnace
    public static final DeferredBlock<Block> WOOL_FURNACE = BLOCKS.register("wool_furnace",
            () -> new WoolFurnace(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL)));
    public static final DeferredItem<Item> WOOL_FURNACE_ITEM = ITEMS.register("wool_furnace",
            () -> new BlockItem(WOOL_FURNACE.get(), new Item.Properties().stacksTo(16)));

    public NerdingCraft(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("NerdingCraft constructor");

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
