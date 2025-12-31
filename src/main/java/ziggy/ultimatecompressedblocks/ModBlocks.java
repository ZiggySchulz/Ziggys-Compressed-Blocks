package ziggy.ultimatecompressedblocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    public static void initialize() {
        // Register the group.
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            for (Block block : BLOCKS) {
                itemGroup.accept(block);
            }
        });

    }

    private static Block register(Item item) {
        String name = BuiltInRegistries.ITEM.getKey(item).getPath();
        name = "compressed_" + name;

		// Create a registry key for the block
		ResourceKey<Block> blockKey = keyOfBlock(name);

        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of();
		// Create the block instance
		Block block = new Block(settings.setId(blockKey));

        // Items need to be registered with a different type of registry key, but the ID
        // can be the same.
        ResourceKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(UltimateCompressedBlocks.MOD_ID, name));
	}

	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(UltimateCompressedBlocks.MOD_ID, name));
	}

    public static final Item[] SupportedItems = {
        Items.DIRT,
        Items.STONE_AXE
    };

    public static final Block[] BLOCKS = new Block[SupportedItems.length];
    static {
        for (int i = 0; i < SupportedItems.length; i++) {
            BLOCKS[i] = register(SupportedItems[i]);
        }
    }

    // Creative mode tab
    public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(UltimateCompressedBlocks.MOD_ID, "item_group"));
    public static final CreativeModeTab CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BLOCKS[0]))
            .title(Component.translatable("itemGroup.ultimate_compressed_blocks"))
            .build();


}
