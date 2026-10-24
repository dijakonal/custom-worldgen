package com.example.worldgen;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.DensityFunction;

public class SineTerrain implements DensityFunction.SimpleFunction {
    public static final SineTerrain INSTANCE = new SineTerrain();
    public static final KeyDispatchDataCodec<SineTerrain> CODEC = KeyDispatchDataCodec.of(MapCodec.unit(INSTANCE));

    // ---- Settings you can play with ----
    public static final double BASE_HEIGHT = 64;  // average ground level
    public static final double AMPLITUDE   = 24;  // how far the hills go up/down
    public static final double WAVELENGTH  = 40;  // how wide the hills are

    // The wave formula: ground height at a given x/z
    public static double groundHeight(double x, double z) {
        return BASE_HEIGHT + AMPLITUDE * Math.sin(x / WAVELENGTH) * Math.sin(z / WAVELENGTH);
    }

    @Override
    public double compute(FunctionContext pos) {
        // Below the ground = positive (solid), above = negative (air)
        return (groundHeight(pos.blockX(), pos.blockZ()) - pos.blockY()) / 16.0;
    }

    @Override public double minValue() { return -100; }
    @Override public double maxValue() { return 100; }

    @Override
    public KeyDispatchDataCodec<? extends DensityFunction> codec() {
        return CODEC;
    }
}