package ziggy.ziggyscompressedblocks;

import java.util.List;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    // Supported blocks. Add new supported blocks here
    public static final SupportedItemInfo[] SupportedItems = {
        // World generation blocks
        new SupportedItemInfo(
            Items.DIRT, 
            Blocks.DIRT, 
            List.of(BlockTags.MINEABLE_WITH_SHOVEL)
        ),
        new SupportedItemInfo(
            Items.COBBLESTONE, 
            Blocks.COBBLESTONE, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        new SupportedItemInfo(
            Items.STONE, 
            Blocks.STONE, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        new SupportedItemInfo(
            Items.SAND, 
            Blocks.SAND, 
            List.of(BlockTags.MINEABLE_WITH_SHOVEL)
        ),
        new SupportedItemInfo(
            Items.GRAVEL, 
            Blocks.GRAVEL, 
            List.of(BlockTags.MINEABLE_WITH_SHOVEL)
        ),
        new SupportedItemInfo(
            Items.GRASS_BLOCK, 
            Blocks.GRASS_BLOCK, 
            List.of(BlockTags.MINEABLE_WITH_SHOVEL)
        ),
        new SupportedItemInfo(
            Items.NETHERRACK, 
            Blocks.NETHERRACK,
            List.of(
                BlockTags.MINEABLE_WITH_PICKAXE, 
                BlockTags.INFINIBURN_OVERWORLD,
                BlockTags.INFINIBURN_NETHER, 
                BlockTags.INFINIBURN_END
            )
        ),
        new SupportedItemInfo(
            Items.END_STONE, 
            Blocks.END_STONE, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        new SupportedItemInfo(
            Items.OBSIDIAN, 
            Blocks.OBSIDIAN, 
            List.of(
                BlockTags.MINEABLE_WITH_PICKAXE, 
                BlockTags.NEEDS_DIAMOND_TOOL
            )
        ),
        new SupportedItemInfo(
            Items.COBBLED_DEEPSLATE, 
            Blocks.COBBLED_DEEPSLATE, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        new SupportedItemInfo(
            Items.DEEPSLATE, 
            Blocks.DEEPSLATE, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        new SupportedItemInfo(
            Items.BLACKSTONE, 
            Blocks.BLACKSTONE, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        new SupportedItemInfo(
            Items.BASALT, 
            Blocks.BASALT, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        new SupportedItemInfo(
            Items.MOSS_BLOCK, 
            Blocks.MOSS_BLOCK, 
            List.of(BlockTags.MINEABLE_WITH_HOE)
        ),

        // Crops
        new SupportedItemInfo(
            Items.CARROT, 
            0.3f, 
            SoundType.CROP, 
            List.of(BlockTags.MINEABLE_WITH_HOE)
        ),
        new SupportedItemInfo(
            Items.POTATO, 
            0.3f, 
            SoundType.CROP, 
            List.of(BlockTags.MINEABLE_WITH_HOE)
        ),
        new SupportedItemInfo(
            Items.BEETROOT, 
            0.3f, 
            SoundType.CROP, 
            List.of(BlockTags.MINEABLE_WITH_HOE)
        ),
        new SupportedItemInfo(
            Items.SUGAR_CANE, 
            0.25f, 
            SoundType.BAMBOO, 
            List.of(BlockTags.MINEABLE_WITH_HOE)
        ),
        new SupportedItemInfo(
            Items.MELON, 
            Blocks.MELON, 
            List.of(BlockTags.MINEABLE_WITH_AXE)
        ),
        new SupportedItemInfo(
            Items.PUMPKIN, 
            Blocks.PUMPKIN, 
            List.of(BlockTags.MINEABLE_WITH_AXE)
        ),
        new SupportedItemInfo(
            Items.CACTUS, 
            Blocks.CACTUS, 
            List.of(BlockTags.MINEABLE_WITH_SHOVEL)
        ),

        // Mobs
        new SupportedItemInfo(
            Items.FEATHER, 
            0.1f, 
            SoundType.WOOL, 
            List.of(BlockTags.SWORD_EFFICIENT)
        ),
        new SupportedItemInfo(
            Items.EGG, 
            0.1f, 
            SoundType.MUD_BRICKS, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        new SupportedItemInfo(
            Items.LEATHER, 
            0.2f, 
            SoundType.WOOL, 
            List.of(BlockTags.SWORD_EFFICIENT)
        ),
        new SupportedItemInfo(
            Items.ARROW, 
            0.1f, 
            SoundType.WOOD, 
            List.of(BlockTags.MINEABLE_WITH_AXE)
        ),
        new SupportedItemInfo(
            Items.SPIDER_EYE, 
            0.1f, 
            SoundType.NETHER_WART, 
            List.of(BlockTags.SWORD_EFFICIENT)
        ),
        new SupportedItemInfo(
            Items.GUNPOWDER, 
            0.1f, 
            SoundType.SAND, 
            List.of(BlockTags.MINEABLE_WITH_SHOVEL)
        ),
        new SupportedItemInfo(
            Items.ROTTEN_FLESH, 
            0.1f, 
            SoundType.NETHER_WART, 
            List.of(BlockTags.SWORD_EFFICIENT)
        ),
        new SupportedItemInfo(
            Items.GHAST_TEAR, 
            0.3f, 
            SoundType.DRIED_GHAST, 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)
        ),
        
        new SupportedItemInfo(
            Items.ENDER_PEARL,
            BlockBehaviour.Properties.of()
                .strength(0.5f)
                .sound(SoundType.AMETHYST)
                .lightLevel(blockstate -> 5),
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)),
        
        new SupportedItemInfo(
            Items.BLAZE_ROD, 
            BlockBehaviour.Properties.of()
                .strength(0.3f)
                .sound(SoundType.WOOD)
                .lightLevel(blockstate -> 15), 
            List.of(BlockTags.MINEABLE_WITH_PICKAXE)),
    };

    public static void initialize() {
        // Register the creative mode tab.
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            for (Block block : MOD_BLOCKS) {
                itemGroup.accept(block);
            }
        });

    }

    private static Block register(SupportedItemInfo info) {
        String name = BuiltInRegistries.ITEM.getKey(info.item).getPath();
        name = "compressed_" + name;

		// Create a registry key for the block
		ResourceKey<Block> blockKey = keyOfBlock(name);

		// Create the block instance
        BlockBehaviour.Properties settings = info.properties;
		Block block = new Block(settings.setId(blockKey));

        // Items need to be registered with a different type of registry key, but the ID
        // can be the same.
        ResourceKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ZiggysCompressedBlocks.MOD_ID, name));
	}

	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ZiggysCompressedBlocks.MOD_ID, name));
	}

    public static final Block[] MOD_BLOCKS = new Block[SupportedItems.length];
    static {
        for (int i = 0; i < SupportedItems.length; i++) {
            MOD_BLOCKS[i] = register(SupportedItems[i]);
        }
    }

    // Creative mode tab
    public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(ZiggysCompressedBlocks.MOD_ID, "item_group"));
    public static final CreativeModeTab CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MOD_BLOCKS[0]))
            .title(Component.translatable("itemGroup.ziggys_compressed_blocks"))
            .build();


}
