package ziggy.ziggyscompressedblocks;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TagProvider extends FabricTagProvider.BlockTagProvider {
	public TagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
        for (int i = 0; i < ModBlocks.SupportedItems.length; i++) {
            SupportedItemInfo info = ModBlocks.SupportedItems[i];
            Block block = ModBlocks.MOD_BLOCKS[i];
            for (TagKey<Block> tag : info.tags) {
                valueLookupBuilder(tag).add(block);
            }
            
        }

    }
}
