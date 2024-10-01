package net.cheetah.xanxiacraft.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.cheetah.xanxiacraft.capability.ChunkCapability;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;

import java.awt.*;

public class QiCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("checkqi")
                .executes(context -> executeCheckQi(context.getSource()))
        );
    }
    private static int executeCheckQi(CommandSourceStack source) {
        BlockPos pos = source.getPosition();
        LevelChunk chunk = source.getLevel().getChunkAt(pos);


        chunk.getCapability(ChunkCapability.CHUNK_QI_CAPABILITY).ifPresent(chunkQI -> {
            int qiValue = chunkQI.getQI();

            source.sendSuccess(Component.literal("Current Chunk QI:" + qiValue), false);
        });

        return 1;

    }
}
