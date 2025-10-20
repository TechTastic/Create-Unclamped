package io.github.techtastic.unclamped.util;

import com.simibubi.create.infrastructure.config.AllConfigs;

public class ConfigHelper {
    public static int getMaxRotationSpeed() {
        try {
            Class<AllConfigs> config = AllConfigs.class;

            Object server = config.getDeclaredMethod("server").invoke(null);
            Object kinetics = server.getClass().getDeclaredField("kinetics").get(server);
            Object speed = getCValueClass().cast(kinetics.getClass().getDeclaredField("maxRotationSpeed").get(kinetics));
            return (int) speed.getClass().getMethod("get").invoke(speed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 256;
    }

    private static Class<?> getCValueClass() throws ClassNotFoundException {
        try {
            return Class.forName("net.createmod.catnip.config.ConfigBase$CValue");
        } catch (Exception ignored) {}
        return Class.forName("com.simibubi.create.foundation.config.ConfigBase$CValue");
    }
}
