package ziggy.ziggyscompressedblocks;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Block;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, BootstrapContext<Recipe<?>> recipeContext, BootstrapContext<Advancement> advancementContext) {
		return new RecipeProvider(recipeContext, advancementContext) {
			@Override
			public void buildRecipes() {
				for (int i = 0; i < ModBlocks.SupportedItems.length; i++) {
					Item baseItem = ModBlocks.SupportedItems[i].item;
					Block compressedBlock = ModBlocks.MOD_BLOCKS[i];
					
					shaped(RecipeCategory.BUILDING_BLOCKS, compressedBlock)
						.pattern("iii")
						.pattern("iii")
						.pattern("iii")
						.define('i', baseItem)
						.unlockedBy(getHasName(Items.CRAFTING_TABLE), has(Items.CRAFTING_TABLE))
						.unlockedBy(getHasName(baseItem), has(baseItem))
						.save(output, getConversionRecipeName(compressedBlock, baseItem));

					shapeless(RecipeCategory.MISC, baseItem, 9)
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
