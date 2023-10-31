package games.fatboychummy.tutorialmod.item;

import games.fatboychummy.tutorialmod.TutorialMod;
import games.fatboychummy.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("leafium_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEAFIUM.get()))
                    .title(Component.translatable("creativetab.leafium_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.LEAFIUM.get());
                        pOutput.accept(ModItems.LEAFIUM_BUNDLE.get());

                        pOutput.accept(ModBlocks.LEAFIUM_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
