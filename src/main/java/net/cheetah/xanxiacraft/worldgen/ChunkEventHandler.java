package net.cheetah.xanxiacraft.worldgen;

import net.cheetah.xanxiacraft.capability.ChunkCapability;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.event.level.ChunkDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class ChunkEventHandler {


    private static final String NBT_KEY = "xanxia_chunk";
    @SubscribeEvent
    public static void onChunkLoad
            (ChunkDataEvent.Load event) {
        LevelChunk chunk = (LevelChunk)
                event.getChunk();
        if (event.getData().contains("xanxia_chunk")) {

        } else {
            handleNewChunk(chunk);
        }
    }
    @SubscribeEvent
    public static void onChunkSave
            (ChunkDataEvent.Save event) {
        LevelChunk chunk = (LevelChunk)
                event.getChunk();
        event.getData().putBoolean(NBT_KEY, true);
    }
    private static void handleNewChunk
            (LevelChunk chunk) {
        int customqi = QIHeightMap.getQiForChunk(chunk.getPos().x, chunk.getPos().z);
        chunk.getCapability(ChunkCapability.CHUNK_QI_CAPABILITY).ifPresent(chunkQI -> {
            chunkQI.setQi(customqi);
        });
    }
}
