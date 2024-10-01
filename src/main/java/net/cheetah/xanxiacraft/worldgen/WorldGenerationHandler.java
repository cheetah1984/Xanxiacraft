package net.cheetah.xanxiacraft.worldgen;

import net.cheetah.xanxiacraft.XanxiaCraft;
import net.cheetah.xanxiacraft.capability.ChunkCapability;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.cheetah.xanxiacraft.worldgen.QIHeightMap;

@Mod.EventBusSubscriber(modid = "xanxiacraft")

public class WorldGenerationHandler {

    @SubscribeEvent
    public static void onChunkGenerate(ChunkEvent.Load event) {
        LevelChunk chunk = (LevelChunk) event.getChunk();

        int customqi = QIHeightMap.getQiForChunk((int) chunk.getPos().x, (int) chunk.getPos().z);

        chunk.getCapability(ChunkCapability.CHUNK_QI_CAPABILITY).ifPresent(chunkQI -> {chunkQI.setQi(customqi);
        });
    }
}
