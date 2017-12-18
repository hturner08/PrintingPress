package gmail.littleeinstein0012.blocks;

import gmail.littleeinstein0012.tileentity.PrintingPressEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
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
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState blockState, EntityPlayer player, EnumFacing direction, float p_180639_6_, float p_180639_7_, float p_180639_8_)
    {
        TileEntity te = world.getTileEntity(pos);

        if (te == null || !(te instanceof PrintingPressEntity))
        {
            return true;
        }

        if (world.isSideSolid(pos.add(0, 1, 0), EnumFacing.DOWN))
        {
            return true;
        }

        if (world.isRemote)
        {
            return super(world, pos, blockState, player, direction,);
        }

        player.openGui(PrintingPress.instance, ((TileEntityIronChest) te).getType().ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
