package com.example.worldgen;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.DensityFunction;

public class SineSurfaceHeight implements DensityFunction.SimpleFunction {
    public static final SineSurfaceHeight INSTANCE = new SineSurfaceHeight();
    public static final KeyDispatchDataCodec<SineSurfaceHeight> CODEC = KeyDispatchDataCodec.of(MapCodec.unit(INSTANCE));

    @Override
    public double compute(FunctionContext pos) {

        return SineTerrain.groundHeight(pos.blockX(), pos.blockZ());
    }

    @Override public double minValue() { return -64; }
    @Override public double maxValue() { return 600000; }

    @Override
    public KeyDispatchDataCodec<? extends DensityFunction> codec() {
        return CODEC;
    }
}