package vxteam.plugin.championship;

import org.bukkit.plugin.java.JavaPlugin;
import vxteam.plugin.championship.commands.CommandSystem;
import vxteam.plugin.championship.commands.CommandTab;
import vxteam.plugin.championship.events.EventSystem;
import vxteam.plugin.championship.tools.VortexTeam;

public final class Championship extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        new EventSystem(this).registerEvents();
        getServer().getLogger().info("Championship's  EventSystem was loaded!");

        getServer().getPluginCommand("championship").setExecutor(new CommandSystem(this));
        getServer().getLogger().info("Championship's CommandSystem was loaded!");

        getServer().getPluginCommand("championship").setTabCompleter(new CommandTab(this));
        getServer().getLogger().info("Championship's CommandTab was loaded!");

        VortexTeam.registerTeams(this);
        getServer().getLogger().info("Championship's Team was loaded!");

        getServer().getLogger().info("Championship was loaded!");
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("Championship was disable!");
    }
}
