package net.cheetah.xanxiacraft.capability;
import net.cheetah.xanxiacraft.XanxiaCraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

@Mod.EventBusSubscriber(modid = "xanxiacraft")
public class ChunkCapability {

    public static final Capability<IChunkQI> CHUNK_QI_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<LevelChunk> event) {
        if (event.getObject() instanceof LevelChunk) {

            event.addCapability(new ResourceLocation("xanxiacraft","chunk_qi"), new ChunkQIProvider());
        }
    }
}
