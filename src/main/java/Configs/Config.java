import org.bukkit.Material;
import java.util.ArrayList;

public class Config{
    private int BlocksBelowWaterlinePercentageMax;
    private int BlocksBelowWaterlinePercentageMin;
    private boolean RecycleBuckets;
    private boolean UseBurnchest;
    private ArrayList<String> STRINGHealthBlocks = new ArrayList<String>();
    private ArrayList<Material> HealthBlocks = new ArrayList<Material>();
    public ArrayList<Material> getMaterials(){ return HealthBlocks == 0 ? reloadMaterials() : HealthBlocks; }
    public ArrayList<Material> reloadMaterials(){
    ArrayList<Material> mats = new ArrayList<Material>();
        for (String s : HealthBlocks){
            Material m = Material.matchMaterial(s);
            if(m != null){
                mats.add(m);
            }
        }
    }
    public int getBlocksBelowWaterlinePercentageMax() {return BlocksBelowWaterlinePercentageMax;}
    public int getBlocksBelowWaterlinePercentageMin() {return BlocksBelowWaterlinePercentageMin;}
    public boolean getRecycleBuckets() {return RecycleBuckets;}
    public boolean getUseBurnchest() {return UseBurnchest;}
}