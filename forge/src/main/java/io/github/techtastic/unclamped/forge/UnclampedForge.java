package io.github.techtastic.unclamped.forge;

import io.github.techtastic.unclamped.Unclamped;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Unclamped.MOD_ID)
public final class UnclampedForge {
    public UnclampedForge(FMLJavaModLoadingContext context) {
        // Run our common setup.
        Unclamped.init();
    }
}
