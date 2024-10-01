package net.cheetah.xanxiacraft.commands;
import net.minecraft.network.chat.Component;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.cheetah.xanxiacraft.capability.ChunkCapability;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
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
        Vec3 positionVec = source.getPosition();
        BlockPos pos = new BlockPos((int) positionVec.x, (int) positionVec.y, (int) positionVec.z);
        LevelChunk chunk = source.getLevel().getChunkAt(pos);


        chunk.getCapability(ChunkCapability.CHUNK_QI_CAPABILITY).ifPresent(chunkQI -> {
            int setQI = chunkQI.getQI();

            source.sendSuccess(() -> Component.literal("Current Chunk QI:" + setQI), false);
        });

    return 1;
    }
}
