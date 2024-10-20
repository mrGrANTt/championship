package vxteam.plugin.championship.events;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import vxteam.plugin.championship.ViolentWinds.ViolentWindsEvents;

public class EventSystem {

    public void registerEvents(){
        plg_.getServer().getPluginManager().registerEvents(new ViolentWindsEvents(), plg_);
    }
    JavaPlugin plg_;
    public EventSystem(JavaPlugin plg) {
        plg_ = plg;
    }
}
