package vxteam.plugin.championship.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CommandSystem implements CommandExecutor {
    JavaPlugin  plg_;
    public CommandSystem(JavaPlugin plg) {
        plg_ = plg;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(command.getName().equals("championship")) {
            return true;
        }
        return false;
    }
}
