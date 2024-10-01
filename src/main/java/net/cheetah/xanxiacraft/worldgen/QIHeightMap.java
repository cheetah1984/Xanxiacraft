package net.cheetah.xanxiacraft.worldgen;
import net.minecraft.util.Mth;
import net.minecraftforge.event.level.ChunkDataEvent;

import static net.cheetah.xanxiacraft.worldgen.NoiseUtil.multiplyWithPerlinNoise;

public class QIHeightMap {

    private static final int BASE_QI = 10;

    public static int getQiForChunk(int chunkx, int chunkz) {


        int baseQiValue = BASE_QI + (int) (Math.sin(chunkx) * 3);

        int increment = 2 + (int) (Math.cos(chunkz) * 2);

        int setQi = baseQiValue + (chunkx * increment) * (int) multiplyWithPerlinNoise(BASE_QI,chunkx,chunkz) ;

        return Mth.clamp(setQi,0,2560000);

    }
}
