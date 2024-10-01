package net.cheetah.xanxiacraft.item;

import net.cheetah.xanxiacraft.XanxiaCraft;
import net.cheetah.xanxiacraft.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, XanxiaCraft.MOD_ID);

    public static final RegistryObject<Item> SPIRITSTONE = ITEMS.register("spiritstone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SPIRITSTONE = ITEMS.register("raw_spiritstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
