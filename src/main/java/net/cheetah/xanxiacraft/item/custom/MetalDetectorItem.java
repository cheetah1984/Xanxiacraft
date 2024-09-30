package net.cheetah.xanxiacraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
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
            boolean foundblock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++)
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

            if (isValuableBlock(state)) {

                }
        }



        return InteractionResult.SUCCESS;
    }
}

