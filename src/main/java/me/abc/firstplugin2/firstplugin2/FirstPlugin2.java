package me.abc.firstplugin2.firstplugin2;

import org.bukkit.plugin.java.JavaPlugin;

public final class FirstPlugin2 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("Launch").setExecutor(new Fly(this));
        System.out.println("[FirstPlugin2] Hello!");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[FirstPlugin2] Goodbye!");
    }


}