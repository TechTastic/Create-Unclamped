package io.github.techtastic.unclamped.forge;

import io.github.techtastic.unclamped.Unclamped;
import net.minecraftforge.fml.common.Mod;

@Mod(Unclamped.MOD_ID)
public final class UnclampedForge {
    public UnclampedForge() {
        // Run our common setup.
        Unclamped.init();
    }
}
