package net.cheetah.xanxiacraft.worldgen;

import net.cheetah.xanxiacraft.XanxiaCraft;
import net.cheetah.xanxiacraft.capability.ChunkCapability;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "xanxiacraft")

public class WorldGenerationHandler {

    @SubscribeEvent
    public static void onChunkGenerate(ChunkEvent.Load event) {
        LevelChunk chunk = (LevelChunk) event.getChunk();


        chunk.getCapability(ChunkCapability.CHUNK_QI_CAPABILITY).ifPresent(cap -> {
            cap.setQI(100);

        });
    }
}
