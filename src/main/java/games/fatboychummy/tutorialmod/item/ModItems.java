package games.fatboychummy.tutorialmod.item;

import games.fatboychummy.tutorialmod.TutorialMod;
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
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAFIUM_BUNDLE = ITEMS.register("leafium_bundle",
            () -> new Item(new Item.Properties()));

    // The method which actually registers things
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
