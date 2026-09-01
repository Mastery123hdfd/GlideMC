package Craft;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import Utility.VFaces;
import org.jspecify.annotations.NonNull;

import java.util.*;

public class Craft{
    Set<Block> Blocks= new HashSet<>();
    Set<Block> Exposed = new HashSet<>();
    public Craft(Player p, World w){
        DetectCraft(p, w);
    }
    public Craft(Block sign, World w) {DetectCraft(sign, w);}
    public void DetectCraft(@NonNull Player p, @NonNull World w){
        Queue<Block> scan = new LinkedList<Block>();
        Set<Block> scanned = new HashSet<Block>();
        scan.offer(w.getBlockAt(p.getLocation()));
        Scan(scan, scanned);

    }
    public void DetectCraft(Block sign, World w){
        Queue<Block> scan = new LinkedList<Block>();
        Set<Block> scanned = new HashSet<Block>();
        scan.offer(sign);
        Scan(scan, scanned);
    }

    private void Scan(Queue<Block> scan, Set<Block> scanned) {
        while(!scan.isEmpty()){
            Block b = scan.poll();
            for(BlockFace face : BlockFace.values()){
                if(!scanned.contains(b.getRelative(face))){
                    scan.offer(b.getRelative(face));
                }
            }
            Blocks.add(b);
            scanned.add(b);
        }
    }
    public void setDirSPHERICAL(int theta, int phi, int speed){
        Vector unit = new Vector();
        unit.setZ((int)Math.cos(phi));
        unit.setX((int)(Math.sin(phi)*Math.cos(theta)));
        unit.setY((int)(Math.sin(phi)*Math.sin(theta)));
        unit.multiply(speed);
        Move(unit);
    }
    private void Move(Vector mvec){
        //Use moveAnimate, make the blocks invisible, change coordinates accordingly
    }

    private void moveAnimate(){
        //Use BlockDisplay here : D
    }
    private boolean checkValid(Block b){
        boolean empty = b.isEmpty();
        if (empty){
            return true;
        } //I'll add a config file later but that's not at the top of my agenda rn
        return false;
    }

    public void changeWorld(World w){

    }

    public Vector ConvertInts(int x, int y, int z){return new Vector(x, y, z);}

    public Block getRelative(Block b, Vector v){return b.getRelative((int)v.getX(),(int)v.getY(),(int)v.getZ());}

}
