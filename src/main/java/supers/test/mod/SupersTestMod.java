package supers.test.mod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SupersTestMod implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("superstestmod");

    public static final Item CHEESE_MAKER = new CheeseMakerItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1));
    public static final Item CHEESE = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(6).build()));
    public static final Block CHEESE_BLOCK = new CheeseBlock(FabricBlockSettings.copyOf(Blocks.DIRT));
    public static final Item LEMON = new LemonItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(69));
    public static final Item DYNAMITE = new DynamiteItem(new FabricItemSettings().group(ItemGroup.MISC).maxCount(69));
    public static final EntityType<DynamiteEntity> DYNAMITE_ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE, new Identifier("superstestmod", "dynamite_entity"), FabricEntityTypeBuilder.<DynamiteEntity>create(SpawnGroup.MISC, DynamiteEntity::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).trackRangeBlocks(4).trackedUpdateRate(10).build());

    public static final Identifier PACKET_ID = new Identifier("superstestmod", "spawn_packet");

	@Override
	public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("superstestmod", "cheese_maker"), CHEESE_MAKER);
        Registry.register(Registry.ITEM, new Identifier("superstestmod", "cheese"), CHEESE);
        Registry.register(Registry.ITEM, new Identifier("superstestmod", "cheese_block"), new BlockItem(CHEESE_BLOCK, new FabricItemSettings().group(ItemGroup.FOOD)));
        Registry.register(Registry.BLOCK, new Identifier("superstestmod", "cheese_block"), CHEESE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("superstestmod", "lemon"), LEMON);
        Registry.register(Registry.ITEM, new Identifier("superstestmod", "dynamite"), DYNAMITE);

    }

}
