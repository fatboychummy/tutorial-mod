package games.fatboychummy.tutorialmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            if (player != null) {
                for (int i = 0; i < positionClicked.getY() + 64; i++) {
                    BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                    if (isValuableBlock(state)) {
                        outputValuableCoordinates(positionClicked.below(i), player, i);
                        foundBlock = true;

                        break;
                    }
                }

                if (!foundBlock) {
                    player.sendSystemMessage(Component.literal("Nothing found."));
                }
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, int distance) {
        player.sendSystemMessage(Component.literal("Found something " + distance + " blocks below the targeted block."));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE)
                || state.is(Blocks.DIAMOND_ORE)
                || state.is(Blocks.GOLD_ORE)
                || state.is(Blocks.COAL_ORE)
                || state.is(Blocks.LAPIS_ORE);
    }
}
