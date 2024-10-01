package net.cheetah.xanxiacraft.worldgen;

public class NoiseUtil {
    private static final PerlinNoise perlinNoise = new PerlinNoise(1234356);  // Seed for reproducibility

    public static double multiplyWithPerlinNoise(double value, double x, double z) {
        double noiseValue = perlinNoise.noise(x, z);
        double scaledNoiseValue = (noiseValue + 1) / 2;  // Scale noise from [-1, 1] to [0, 1]
        return value * scaledNoiseValue;
    }
}