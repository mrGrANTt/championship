package vxteam.plugin.championship.tools;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class CustomConfig {
    private FileConfiguration config;
    private File file;
    private String fileName;

    public void loadYamlFile(String file_name, Plugin plugin) {
        fileName = file_name;
        file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) { //проверка на то есть ли файл, если нет - создаётся папка и сохраняется файл.
            plugin.getDataFolder().mkdirs();
            plugin.saveResource(fileName, true);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void reloadCfg(Plugin plugin) {
        if(!file.exists()) { //проверка на то есть ли файл, если нет - создаётся папка и сохраняется файл.
            plugin.getDataFolder().mkdirs();
            plugin.saveResource(fileName, true);
        }
        try {
            config.load(file);
            Bukkit.getConsoleSender().sendMessage("Конфигурация перезагружена!");
        } catch (IOException | InvalidConfigurationException e) {
            Bukkit.getConsoleSender().sendMessage("Не удалось перезагрузить конфигурацию!");
        }
    }

    public File getFile() { return file; }
}
