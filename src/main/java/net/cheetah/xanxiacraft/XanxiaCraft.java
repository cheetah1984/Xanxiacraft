package net.cheetah.xanxiacraft;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import net.cheetah.xanxiacraft.block.ModBlocks;
import net.cheetah.xanxiacraft.capability.ChunkCapability;
import net.cheetah.xanxiacraft.commands.QiCommand;
import net.cheetah.xanxiacraft.event.ForgeCommandRegisterEvent;
import net.cheetah.xanxiacraft.item.ModCreativeModeTabs;
import net.cheetah.xanxiacraft.item.ModItems;
import net.cheetah.xanxiacraft.worldgen.QIHeightMap;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.event.RegisterCommandsEvent;

import static com.mojang.text2speech.Narrator.LOGGER;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(XanxiaCraft.MOD_ID)
public class XanxiaCraft {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "xanxiacraft";
    // Directly reference a slf4j logger

    public XanxiaCraft()  {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);


        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::loadComplete);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    @SubscribeEvent
    public static void onChunkLoad(ChunkEvent.Load event) {

        ChunkAccess chunkAccess = event.getChunk();

        if (chunkAccess instanceof LevelChunk chunk) {
            BlockPos chunkPos = chunk.getPos().getWorldPosition();

            int chunkx = chunkPos.getX();
            int chunkz = chunkPos.getZ();

            int customqi = QIHeightMap.getQiForChunk(chunkx, chunkz);

            chunk.getCapability(ChunkCapability.CHUNK_QI_CAPABILITY).ifPresent(chunkQI -> {
                chunkQI.setQi(customqi);
            });
        }
    }


    private void loadComplete(FMLLoadCompleteEvent event) {
        MinecraftForge.EVENT_BUS.register(new ForgeCommandRegisterEvent());
    }



    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SPIRITSTONE);
            event.accept(ModItems.RAW_SPIRITSTONE);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        QiCommand.register(event.getDispatcher());  // Register your command here
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
        public static void RegisterClientCommandsEvent(RegisterCommandsEvent event) {
            CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

            QiCommand.register(dispatcher);
        }
    }
}
