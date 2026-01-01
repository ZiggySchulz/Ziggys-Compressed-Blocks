package ziggy.ziggyscompressedblocks;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
		return new RecipeProvider(registryLookup, exporter) {
			@Override
			public void buildRecipes() {
				for (int i = 0; i < ModBlocks.SupportedItems.length; i++) {
					Item baseItem = ModBlocks.SupportedItems[i];
					Block compressedBlock = ModBlocks.BLOCKS[i];
					
					shaped(RecipeCategory.BUILDING_BLOCKS, compressedBlock)
						.pattern("iii")
						.pattern("iii")
						.pattern("iii")
						.define('i', baseItem)
						.unlockedBy(getHasName(Items.CRAFTING_TABLE), has(Items.CRAFTING_TABLE))
						.unlockedBy(getHasName(baseItem), has(baseItem))
						.save(output);

					
					shapeless(RecipeCategory.BUILDING_BLOCKS, baseItem, 9)
							.requires(compressedBlock)
							.unlockedBy(getHasName(compressedBlock), has(compressedBlock))
							.save(output, getConversionRecipeName(baseItem, compressedBlock));
				}
		
			}
		};
	}

	@Override
	public String getName() {
		return "ModRecipeProvider";
	}
}
