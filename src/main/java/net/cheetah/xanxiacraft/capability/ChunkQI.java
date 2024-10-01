package net.cheetah.xanxiacraft.capability;
import net.cheetah.xanxiacraft.worldgen.QIHeightMap;

public abstract class ChunkQI implements IChunkQI {
    private int qi;

    public ChunkQI() {
        this.qi = 0; // Initialize Qi value to 0 or any default value
    }

    public int getQi() {
        return this.qi;
    }
    public void setQi(int qi) {
        this.qi = qi;
    }


}
