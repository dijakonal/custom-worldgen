package com.example.worldgen;

import com.example.TemplateMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModWorldgen {
    public static void initialize() {
        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                TemplateMod.id("sine_terrain"),
                SineTerrain.CODEC.codec());

        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                TemplateMod.id("sine_surface_height"),
                SineSurfaceHeight.CODEC.codec());

        Registry.register(BuiltInRegistries.DENSITY_FUNCTION_TYPE,
                TemplateMod.id("custom_terrain_gen"),
                CustomTerrainGen.CODEC.codec());
    }
}