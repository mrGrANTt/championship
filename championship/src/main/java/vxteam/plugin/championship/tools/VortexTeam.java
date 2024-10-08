package vxteam.plugin.championship.tools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import vxteam.plugin.championship.Championship;

public class VortexTeam {

    private static Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    private static VortexTeam[] teams = new VortexTeam[8];

    private Team team_;

    private VortexTeam(String name, String prefix, ChatColor color) {
        team_ = scoreboard.registerNewTeam(name);
        team_.setPrefix(color + prefix);
        team_.setSuffix(ChatColor.WHITE.toString());
    }

    public static VortexTeam getTeam(Teams team){
        return teams[team.ordinal()];
    }

    public static void registerTeams(Championship plg) {
        teams[Teams.RED.ordinal()] = new VortexTeam("RED", plg.getConfig().getString("prefixes/red"), ChatColor.RED );
        teams[Teams.ORANGE.ordinal()] = new VortexTeam("ORANGE", plg.getConfig().getString("prefixes/orange"), ChatColor.GOLD );
        teams[Teams.YELLOW.ordinal()] = new VortexTeam("YELLOW", plg.getConfig().getString("prefixes/yellow"), ChatColor.YELLOW );
        teams[Teams.GREEN.ordinal()] = new VortexTeam("GREEN", plg.getConfig().getString("prefixes/green"), ChatColor.DARK_GREEN );
        teams[Teams.SKY.ordinal()] = new VortexTeam("SKY", plg.getConfig().getString("prefixes/sky"), ChatColor.DARK_AQUA );
        teams[Teams.BLUE.ordinal()] = new VortexTeam("BLUE", plg.getConfig().getString("prefixes/blue"), ChatColor.BLUE );
        teams[Teams.PURPLE.ordinal()] = new VortexTeam("PURPLE", plg.getConfig().getString("prefixes/purple"), ChatColor.DARK_PURPLE );
        teams[Teams.PINK.ordinal()] = new VortexTeam("PINK", plg.getConfig().getString("prefixes/pink"), ChatColor.LIGHT_PURPLE );
    }

    public void addPlayer(OfflinePlayer plr){
        team_.addPlayer(plr);
    }

    public void remPlayer(OfflinePlayer plr){
        team_.removePlayer(plr);
    }
    public Team getVanilaTeam() {
        return team_;
    }
}
