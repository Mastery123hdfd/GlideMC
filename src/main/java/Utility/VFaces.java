package Utility;

import org.bukkit.util.Vector;

public enum VFaces {
    North(new Vector(0,0,1)),
    South(new Vector(0,0,-1)),
    UP(new Vector(0,1,0)),
    DOWN(new Vector(0,-1,0)),
    EAST(new Vector(1,0,0)),
    WEST(new Vector(-1,0,0));

    public final Vector v;

    VFaces(Vector v) {
        this.v = v;
    }
}
