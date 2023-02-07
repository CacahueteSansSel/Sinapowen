package dev.cacahuete.sinapowen;

import dev.cacahuete.sinapowen.block.MetalLadderBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mod.ID);

    public static final RegistryObject<Block> CRAB_BLOCK = registerBlock("crab_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f)
                    .requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> SHEET_METAL_BLOCK = registerBlock("sheet_metal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
                    .requiresCorrectToolForDrops().strength(4.5F, 5.5F).sound(SoundType.METAL))
            , ModTabs.MOD_MAIN_TAB);

    public static final RegistryObject<Block> SHEET_METAL_TILES_BLOCK = registerBlock("sheet_metal_tiles_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
                    .requiresCorrectToolForDrops().strength(4.5F, 5.5F).sound(SoundType.METAL))
            , ModTabs.MOD_MAIN_TAB);

    public static final RegistryObject<Block> SHEET_METAL_CHECKERBOARD_BLOCK = registerBlock("sheet_metal_checkerboard_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
                    .requiresCorrectToolForDrops().strength(4.5F, 5.5F).sound(SoundType.METAL))
            , ModTabs.MOD_MAIN_TAB);

    public static final RegistryObject<Block> SHEET_METAL_CHECKERWALL_BLOCK = registerBlock("sheet_metal_checkerwall_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
                    .requiresCorrectToolForDrops().strength(4.5F, 5.5F).sound(SoundType.METAL))
            , ModTabs.MOD_MAIN_TAB);

    public static final RegistryObject<Block> GENERATOR_BLOCK = registerBlock("generator_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
                    .requiresCorrectToolForDrops().strength(4.5F, 5.5F).sound(SoundType.METAL))
            , ModTabs.MOD_MAIN_TAB);

    public static final RegistryObject<Block> MONITOR_BLOCK = registerBlock("monitor_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
                    .requiresCorrectToolForDrops().strength(4.5F, 5.5F).sound(SoundType.METAL))
            , ModTabs.MOD_MAIN_TAB);

    public static final RegistryObject<Block> METAL_LADDER = registerBlock("metal_ladder",
            () -> new MetalLadderBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
                    .requiresCorrectToolForDrops().strength(4.5F, 5.5F).sound(SoundType.METAL).noOcclusion())
            , ModTabs.MOD_MAIN_TAB);

    public static final RegistryObject<Block> EMERGENCY_RED_LIGHT = registerBlock("emergency_red_light",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
                    .requiresCorrectToolForDrops().lightLevel((v) -> 7).strength(4.5F, 5.5F).sound(SoundType.METAL))
            , ModTabs.MOD_MAIN_TAB);

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                    CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
}
