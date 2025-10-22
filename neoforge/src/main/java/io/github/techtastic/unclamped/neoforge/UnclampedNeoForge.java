package io.github.techtastic.unclamped.neoforge;

import io.github.techtastic.unclamped.Unclamped;
import net.neoforged.fml.common.Mod;

@Mod(Unclamped.MOD_ID)
public final class UnclampedNeoForge {
    public UnclampedNeoForge() {
        // Run our common setup.
        Unclamped.init();
    }
}
