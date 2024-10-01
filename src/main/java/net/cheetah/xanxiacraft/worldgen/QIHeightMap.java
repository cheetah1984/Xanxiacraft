package net.cheetah.xanxiacraft.worldgen;

import net.minecraft.util.Mth;

public class QIHeightMap {
    private static final int BASE_QI = 10;

    public static int getQiForChunk(int chunkx, int chunkz) {

        int baseQiValue = BASE_QI + (int) (Math.sin(chunkx * 0.1) * 20);

        int increment = 2 + (int) (Math.cos(chunkz * 0.1) * 3);

        int qiValue = baseQiValue + (chunkx * increment);

        return Mth.clamp(qiValue,0,256);
    }
}
