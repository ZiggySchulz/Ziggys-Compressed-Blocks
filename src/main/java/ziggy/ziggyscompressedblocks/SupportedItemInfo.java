package ziggy.ziggyscompressedblocks;

import java.util.List;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

public class SupportedItemInfo {
    public Item item;
    public BlockBehaviour.Properties properties;
    public List<TagKey<Block>> tags;

    public SupportedItemInfo(Item item, Block block, List<TagKey<Block>> tags) {
        this.item = item;
        this.tags = tags;
        
        properties = BlockBehaviour.Properties.ofFullCopy(block);
        properties.strength(block.defaultDestroyTime() * 1.09f, block.getExplosionResistance() * 1.09f);
        properties.pushReaction(PushReaction.NORMAL);
    }

    public SupportedItemInfo(Item item, float strength, SoundType soundType, List<TagKey<Block>> tags) {
        this.item = item;
        this.tags = tags;
        properties = BlockBehaviour.Properties.of();
        properties.strength(strength);
        properties.sound(soundType);
    }

    public SupportedItemInfo(Item item, BlockBehaviour.Properties properties, List<TagKey<Block>> tags) {
        this.item = item;
        this.properties = properties;
        this.tags = tags;
    }
}