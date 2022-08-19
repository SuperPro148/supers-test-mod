package net.supers.test.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupersTestMod implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("superstestmod");
    public static final Item CHEESE_MAKER = new CheeseMaker(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1));
    public static final Item CHEESE = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(6).build()));

	@Override
	public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier("superstestmod", "cheese_maker"), CHEESE_MAKER);
        Registry.register(Registry.ITEM, new Identifier("superstestmod", "cheese"), CHEESE);

    }
}
