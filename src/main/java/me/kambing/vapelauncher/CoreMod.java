package me.kambing.vapelauncher;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.lwjgl.Sys;

import java.io.File;
import java.util.Objects;

@Mod(modid = CoreMod.MOD_ID, name = CoreMod.MOD_NAME, version = CoreMod.MOD_VERSION, clientSideOnly = true)
public class CoreMod {

    public static final String MOD_NAME = "autoV4Launcher";
    public static final String MOD_ID = "autov4launcher";
    public static final String MOD_VERSION = "1.0";

    @Mod.Instance(CoreMod.MOD_ID)
    private static CoreMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        File v4 = null;
        File folder = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/v4");
        File[] listOfFiles = folder.listFiles();
        for (File file : Objects.requireNonNull(listOfFiles)) {
            System.out.println(file.getName());
            if (file.getName().endsWith(".exe")) {
                v4 = file;
            }
        }
        if (v4 != null) {
            ExecutorUtil.executeCommand("cmd /c start " + System.getProperty("user.home") + "/AppData/Roaming/.minecraft/v4/" + v4.getName());
            System.out.println("V4 launched");
        }
    }

    public static CoreMod getInstance() {
        return instance;
    }

}
