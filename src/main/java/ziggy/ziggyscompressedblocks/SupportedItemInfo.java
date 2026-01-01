package ziggy.ziggyscompressedblocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SupportedItemInfo {
    public Item item;
    BlockBehaviour.Properties properties;

    public SupportedItemInfo(Item item, Block block) {
        this.item = item;
        properties = BlockBehaviour.Properties.ofFullCopy(block);
        properties.strength(block.defaultDestroyTime() * 1.09f, block.getExplosionResistance() * 1.09f);
    }

    public SupportedItemInfo(Item item, float strength, SoundType soundType) {
        this.item = item;
        properties = BlockBehaviour.Properties.of();
        properties.strength(strength);
        properties.sound(soundType);
    }
}