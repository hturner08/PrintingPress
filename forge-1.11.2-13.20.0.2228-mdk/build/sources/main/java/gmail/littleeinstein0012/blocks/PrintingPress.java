package gmail.littleeinstein0012.blocks;

import gmail.littleeinstein0012.tileentity.PrintingPressEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PrintingPress extends BlockContainer{
	
	public PrintingPress(String unlocalizedName){
		super(Material.IRON);
        this.setUnlocalizedName(unlocalizedName);
        this.setHardness(2.0f);
        this.setResistance(6.0f);
        this.setHarvestLevel("pickaxe", 2);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new PrintingPressEntity();
    }
}
