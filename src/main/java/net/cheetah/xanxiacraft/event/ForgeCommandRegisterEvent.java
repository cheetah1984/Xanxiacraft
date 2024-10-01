package net.cheetah.xanxiacraft.event;

import net.cheetah.xanxiacraft.commands.QiCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ForgeCommandRegisterEvent {
    public ForgeCommandRegisterEvent() {
    }
    public void registercommands (RegisterCommandsEvent e) {
        QiCommand.register(e.getDispatcher());
    }
}
