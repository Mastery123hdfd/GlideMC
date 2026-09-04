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
<<<<<<< HEAD
    ArrayList<Block> Blocks= new ArrayList<Block>();
    //Constructor given the coordinates of the player entity
    public Craft(Player p){
        DetectCraft(p);
=======
    Set<Block> Blocks= new HashSet<>();
    Set<Block> Exposed = new HashSet<>();
    public Craft(Player p, World w){
        DetectCraft(p, w);
>>>>>>> a043dfafaab874d477c1d898c92f4c1045f560e6
    }
    private Boolean sealed;
    private Boolean canFly;
    private Boolean sinkable;
    private Boolean canFloat;

    private int health;
    private int weight;
    private int thrust;



    public Craft(Block sign, World w) {DetectCraft(sign, w);}
    public void DetectCraft(@NonNull Player p, @NonNull World w){
        Queue<Block> scan = new LinkedList<Block>();
        Set<Block> scanned = new HashSet<Block>();
        scan.offer(w.getBlockAt(p.getLocation()));
        Scan(scan, scanned);
        buoyancyCalc();
        thrustCalc();
        sealCalc();
    }
    private void DetectCraft(Block sign, World w){
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
    private void setDirSPHERICAL(int theta, int phi, int speed){
        Vector unit = new Vector();
        unit.setZ((int)Math.cos(phi));
        unit.setX((int)(Math.sin(phi)*Math.cos(theta)));
        unit.setY((int)(Math.sin(phi)*Math.sin(theta)));
        unit.multiply(speed);
        Move(unit);
    }
    private void Move(Vector mvec){
        for(Block b:Blocks){
            Block ghost = b.getRelative(mvec.getX(), mvec.getY(), mvec.getZ());
            if(!ghost.isEmpty()){
            }
        }
    }

    /*private void moveAnimate(){
       //Use BlockDisplay here : D
    }*/
    private boolean checkValid(Block b){
        boolean empty = b.isEmpty();
        if (empty){
            return true;
        } //I'll add a config file later but that's not at the top of my agenda rn
        return false;
    }

    private void changeWorld(World w){

    }

    private void buoyancyCalc(){
        
    }
    
    public int Waterline(){
        for(Block b : Blocks){
            
        }
    }
    
    private void thrustCalc(){
    
    }

    private void sealCalc(){
    
    }

    private Vector ConvertInts(int x, int y, int z){return new Vector(x, y, z);}

    private Block getRelative(Block b, Vector v){return b.getRelative((int)v.getX(),(int)v.getY(),(int)v.getZ());}

}
    
