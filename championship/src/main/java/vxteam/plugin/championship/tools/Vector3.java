package vxteam.plugin.championship.tools;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Vector3 {
    public int x;
    public int y;
    public int z;

    public Vector3(Location location) {
        x = location.blockX();
        y = location.blockY();
        z = location.blockZ();
    }

    public Vector3(int X, int Y, int Z) {
        x = X;
        y = Y;
        z = Z;
    }

    public static Location StringToLocation(String str, World world){
        String[] strs = str.split(" ");
        return new Location(world,Integer.parseInt(strs[0]),Integer.parseInt(strs[1]),Integer.parseInt(strs[2]));
    }

    public Location toLocation(World world) {
        return new Location(world, x, y, z);
    }

    public Vector3 sum(Vector3 other) {
        return new Vector3(x+other.x, y+other.y, z+other.z);
    }
}
