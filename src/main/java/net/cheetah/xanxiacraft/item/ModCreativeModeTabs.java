package net.cheetah.xanxiacraft.item;

import net.cheetah.xanxiacraft.XanxiaCraft;
import net.cheetah.xanxiacraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, XanxiaCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> XANXIACRAFT_TAB = CREATIVE_MODE_TABS.register("xanxiacraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SPIRITSTONE.get()))
                    .title(Component.translatable("creativetab.xanxiacraft_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SPIRITSTONE.get());
                        output.accept(ModItems.RAW_SPIRITSTONE.get());
                        output.accept(ModBlocks.SPIRITSTONE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
