package net.cheetah.xanxiacraft.worldgen;

import java.util.Random;

import static org.joml.Math.lerp;

public class PerlinNoise {
    private final int[] permutationTable;

    public PerlinNoise(long seed) {
        permutationTable = new int[512];
        int[] tempTable = new int[256];

        // Initialize the permutation table
        for (int i = 0; i < 256; i++) {
            tempTable[i] = i;
        }

        // Shuffle the table using the seed
        Random random = new Random(seed);
        for (int i = 255; i > 0; i--) {
            int swapIndex = random.nextInt(i + 1);
            int temp = tempTable[i];
            tempTable[i] = tempTable[swapIndex];
            tempTable[swapIndex] = temp;
        }

        // Duplicate the table to avoid overflow
        for (int i = 0; i < 512; i++) {
            permutationTable[i] = tempTable[i % 256];
        }
    }

    public double noise(double x, double z) {
        int X = (int) Math.floor(x) & 255;
        int Z = (int) Math.floor(z) & 255;

        x -= Math.floor(x);
        z -= Math.floor(z);

        double u = fade(x);
        double w = fade(z);

        int A = permutationTable[X] + Z;
        int AA = permutationTable[A];
        int AB = permutationTable[A + 1];
        int B = permutationTable[X + 1] + Z;
        int BA = permutationTable[B];
        int BB = permutationTable[B + 1];

        return lerp(w, lerp(u, grad(permutationTable[AA], x, z),
                        grad(permutationTable[BA], x - 1, z)),
                lerp(u, grad(permutationTable[AB], x, z - 1),
                        grad(permutationTable[BB], x - 1, z - 1)));
    }

    private double fade(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private double lerp(double t, double a, double b) {
        return a + t * (b - a);
    }

    private double grad(int hash, double x, double z) {
        int h = hash & 15;
        double u = h < 8 ? x : z;
        return (h & 1) == 0 ? u : -u;
    }
}
