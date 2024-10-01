package net.cheetah.xanxiacraft.event;

import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.event.level.ChunkDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "xanxiacraft")
public class ChunkEventHandler {

    @SubscribeEvent
   public static void onChunkSave(ChunkDataEvent.Save event) {
       LevelChunk chunk = (LevelChunk) event.getChunk();

   }

   @SubscribeEvent
   public static void onChunkLoad(ChunkDataEvent.Load event) {
       LevelChunk chunk = (LevelChunk) event.getChunk();

   }
}
