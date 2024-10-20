package vxteam.plugin.championship.ViolentWinds;

import com.sun.tools.javac.jvm.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemType;
import org.bukkit.scheduler.BukkitTask;
import vxteam.plugin.championship.Championship;
import vxteam.plugin.championship.tools.PointCounter;
import vxteam.plugin.championship.tools.Vector3;
import vxteam.plugin.championship.tools.VortexMiniGame;
import vxteam.plugin.championship.tools.VortexTeam;

public class ViolentWindsMiniGame extends VortexMiniGame {
    private PointCounter counter;
    private Championship plg_;

    public ViolentWindsMiniGame(Championship plg, String configName) {
        super(plg, configName);
        plg_ = plg;
        counter = new PointCounter();
    }

    @Override
    public void Start() {

        setBlockInMiniGameSpawnLoc(Material.GLASS);

        time = 0;
        for (VortexTeam team : VortexTeam.getTeams()) {
            team.tpTeam(Vector3.StringToLocation(getConfig().getConfig().getStringList("start-locations").get(time++), plg_.getServer().getWorld("world")));

            team.getVanilaTeam().getPlayers().forEach(
                    (p) -> p.getPlayer().getInventory().clear()
            );
        }

        time = 20;
        Bukkit.getScheduler().runTaskTimer(plg_, (task) -> {
            if(time <= 5)
                Bukkit.broadcastMessage(getConfig().getConfig().getString("time-message")
                    .replace('&', ChatColor.COLOR_CHAR)
                    .replace('i', (char)time));
            if(time == 0) {
                Game();
                task.cancel();
            }
            time--;
            },
            0, 20
        );
    }
    private int time;
    private void Game() {
        setBlockInMiniGameSpawnLoc(Material.AIR);
        for (VortexTeam team : VortexTeam.getTeams()) {
            team.getVanilaTeam().getPlayers().forEach(
                    (p) -> p.getPlayer().getInventory().addItem(ItemType.WIND_CHARGE.createItemStack(3))
            );
        }
    }

    private void setBlockInMiniGameSpawnLoc(Material material) {
        getConfig().getConfig().getStringList("start-locations")
                .stream().map((s) -> Vector3.StringToLocation(s, plg_.getServer().getWorld("world")))
                .forEach((loc) -> {
                    loc.add(0,-1,0).getBlock().setType(material);
                    loc.add(1,1,0).getBlock().setType(material);
                    loc.add(-1,0,1).getBlock().setType(material);
                    loc.add(-1,0,-1).getBlock().setType(material);
                    loc.add(1,0,-1).getBlock().setType(material);
                    loc.add(0,1,0).getBlock().setType(material);
                    loc.add(1,0,1).getBlock().setType(material);
                    loc.add(-1,0,1).getBlock().setType(material);
                    loc.add(-1,0,-1).getBlock().setType(material);
                    loc.add(1,1,0).getBlock().setType(material);
                });
    }
}
