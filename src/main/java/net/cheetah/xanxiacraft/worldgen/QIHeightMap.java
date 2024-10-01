package net.cheetah.xanxiacraft.worldgen;

import net.minecraft.util.Mth;

public class QIHeightMap {
    private static final int BASE_QI = 100;

    public static int getQiForChunk(int chunkx, int chunkz) {

        int baseQiValue = BASE_QI + (int) (Math.sin(chunkx * 0.1) * 200);

        int increment = 2 + (int) (Math.cos(chunkz * 0.1) * 30);

        int setQI = baseQiValue + (chunkx * increment);

        return Mth.clamp(setQI,0,2560);
    }
}
