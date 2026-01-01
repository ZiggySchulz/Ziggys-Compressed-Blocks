package ziggy.ziggyscompressedblocks;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider.TranslationBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class EnglishLangProvider extends FabricLanguageProvider {
    protected EnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		// Specifying en_us is optional, as it's the default language code
		super(dataOutput, "en_us", registryLookup);
	}

	@Override
	public void generateTranslations(HolderLookup.Provider wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.ziggys_compressed_blocks", "Ziggy's Compressed Blocks");
        for (SupportedItemInfo info : ModBlocks.SupportedItems) {
            String itemName = BuiltInRegistries.ITEM.getKey(info.item).getPath();
            itemName = "Compressed " + toTitleCase(itemName.replace('_', ' '));
            translationBuilder.add(
                    "block.ziggys-compressed-blocks.compressed_" + BuiltInRegistries.ITEM.getKey(info.item).getPath(),
                    itemName);
        }
	}


    private String toTitleCase(String input) {
        return Arrays.stream(input.toLowerCase().split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}
