package net.cheetah.xanxiacraft.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ChunkQIStorage implements INBTSerializable<CompoundTag> {
    private int qi;

    // Method to serialize the data to NBT
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("qi", qi);  // Serialize Qi value
        return nbt;
    }

    // Method to deserialize the data from NBT
    public void deserializeNBT(CompoundTag nbt) {
        this.qi = nbt.getInt("qi");  // Deserialize Qi value
    }

    // Getter and setter for Qi
    public int getQi() {
        return qi;
    }

    public void setQi(int qi) {
        this.qi = qi;
    }
}