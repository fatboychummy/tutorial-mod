package games.fatboychummy.tutorialmod.item;

import games.fatboychummy.tutorialmod.TutorialMod;
import games.fatboychummy.tutorialmod.item.custom.FuelItem;
import games.fatboychummy.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Thing that holds all the items to be registered when needed.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    // Our items
    public static final RegistryObject<Item> LEAFIUM = ITEMS.register("leafium",
            () -> new FuelItem(new Item.Properties(), 10));
    public static final RegistryObject<Item> LEAFIUM_BUNDLE = ITEMS.register("leafium_bundle",
            () -> new FuelItem(new Item.Properties(), 100));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    // The method which actually registers things
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
