package Craft;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.bukkit.block.data.BlockData;
import Utility.VFaces;
import org.jspecify.annotations.NonNull;
import org.bukkit.Material;

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

    private int height = -1;
    private int width = -1;
    private int length = -1;

    private Queue<Material> Mats = new LinkedList<Material>();


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

    private void setGlass(){
        for(Block b : Blocks){
            Mats.push(b.Material); //Materials will be stored in the correct order;
            b.setType(Material.BLUE_GLASS);
        }
    }

    private void setMaterialBack(){
        for(Block b : Blocks){
            b.setType(Mats.pop); //FIFO
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

    private void MassCalc(){
        
    }
    
    public int getWaterline(){
        ArrayList<Integer> touchWatery = new ArrayList<Integer>();
        this.setGlass();
        for(Block b : Blocks){
            if(isTouching(b, Material.WATER){
                touchWater.add(b.getZ);
            }
        }
        this.setMaterialBack(); #Im so proud I used queues correctly!
        int Waterline = -9999;
        for(int i : touchWatery){
            Waterline = i ? i>Waterline : Waterline;
        }
        return Waterline;
    }
    
    private boolean isTouching(Block b, Material m){
        for(BlockFace bf : BlockFace.values()){
            if(b.getRelative(bf).getType == m){
                return true;
            }
        }
        return false;
    }

    public int getHeight(){
        if(height==-1){
            int hmax = 0;
            int hmin = 0;
            for(Block b : Blocks){
                int z = b.getZ();
                hmax=z ? hmax > z : h=h+0;
                hmin = z ? hmin < z : h=h+0;
            }
            return hmax-hmin;
        }
        else {return height;}
    }
    public int getWidth(){
        if(width==-1){
            int hmax = 0;
            int hmin = 0;
            for(Block b : Blocks){
                int z = b.getY();
                hmax=z ? hmax > z : h=h+0;
                hmin = z ? hmin < z : h=h+0;
            }
            return hmax-hmin;
        }
        else {return height;}
    }
    public int getHeight(){
        if(length==-1){
            int hmax = 0;
            int hmin = 0;
            for(Block b : Blocks){
                int z = b.getX();
                hmax=z ? hmax > z : h=h+0;
                hmin = z ? hmin < z : h=h+0;
            }
            return hmax-hmin;
        }
        else {return height;}
    }
    
    public int 
    
    private void thrustCalc(){
    
    }

    private void sealCalc(){
    
    }

    private Vector ConvertInts(int x, int y, int z){return new Vector(x, y, z);}

    private Block getRelative(Block b, Vector v){return b.getRelative((int)v.getX(),(int)v.getY(),(int)v.getZ());}

}
    
