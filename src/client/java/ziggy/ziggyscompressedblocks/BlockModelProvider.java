package ziggy.ziggyscompressedblocks;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Block;

public class BlockModelProvider extends FabricModelProvider {
    public BlockModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        for (Block block : ModBlocks.MOD_BLOCKS) {
            blockStateModelGenerator.createTrivialCube(block);
        }
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
	}

	@Override
	public String getName() {
		return "BlockModelProvider";
	}
}
