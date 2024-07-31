package games.fatboychummy.tutorialmod.block;

import games.fatboychummy.tutorialmod.TutorialMod;
import games.fatboychummy.tutorialmod.item.custom.FuelBlockItem;
import games.fatboychummy.tutorialmod.block.custom.SoundBlock;
import games.fatboychummy.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> LEAFIUM_BLOCK = registerFuelBlock("leafium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES)
                    .sound(SoundType.BASALT)
                    .strength(1f, 0.6f)
                    .requiresCorrectToolForDrops()
                    .ignitedByLava()
            ), 1000);

    public static final RegistryObject<Block> LEAFIUM_ORE = registerFuelBlock("leafium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES)
                    .strength(2f, 0.5f).requiresCorrectToolForDrops(),
                    UniformInt.of(1, 5)
            ), 12);

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f, 0.5f).requiresCorrectToolForDrops()
            ));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerFuelBlock(String name, Supplier<T> block, int burnTime) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFuelBlockItem(name, toReturn, burnTime);
        return toReturn;
    }

    // This method registers an item alongside the block.
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // This method registers an item alongside the block, but it is burnable.
    private static <T extends Block>RegistryObject<Item> registerFuelBlockItem(String name, RegistryObject<T> block, int burnTime) {
        return ModItems.ITEMS.register(name, () -> new FuelBlockItem(block.get(), new Item.Properties(), burnTime));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
