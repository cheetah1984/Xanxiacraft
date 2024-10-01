package net.cheetah.xanxiacraft.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

public class ChunkQIProvider implements ICapabilitySerializable<CompoundTag> {

    private final ChunkQI chunkQI = new ChunkQI() {


        public int getQI() {
            return 0;
        }


        public void setQI(int qi) {

        }
    };
    private final LazyOptional<IChunkQI> qiOptional = LazyOptional.of(() -> chunkQI);
    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
        return cap == ChunkCapability.CHUNK_QI_CAPABILITY ? qiOptional.cast() : LazyOptional.empty();
    }
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("qi", chunkQI.getQi());
        return tag;
    }

    public void deserializeNBT(CompoundTag nbt) {
        chunkQI.setQi(nbt.getInt("qi"));
    }

}
