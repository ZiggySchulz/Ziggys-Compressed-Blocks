package ziggy.ziggyscompressedblocks;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

public class TagProvider extends FabricTagsProvider.BlockTagsProvider {
	public TagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
        for (int i = 0; i < ModBlocks.SupportedItems.length; i++) {
            SupportedItemInfo info = ModBlocks.SupportedItems[i];
            Block block = ModBlocks.MOD_BLOCKS[i];
            for (TagKey<Block> tag : info.tags) {
                getOrCreateRawBuilder(tag).addOptionalElement(BuiltInRegistries.BLOCK.getKey(block));
            }
            
        }

    }
}
