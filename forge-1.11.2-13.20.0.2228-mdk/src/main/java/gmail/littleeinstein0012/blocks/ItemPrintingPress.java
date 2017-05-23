package gmail.littleeinstein0012.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPrintingPress extends ItemBlock{
	 public ItemPrintingPress(Block block)
	    {
	        super(block);
	        
	        this.setMaxDamage(0);
	        this.setHasSubtypes(true);
	    }

	    @Override
	    public int getMetadata(int meta)
	    {
//	        return PrintingPress.validateMeta(meta);
	    	return 0;
	    }

	    @Override
	    public String getUnlocalizedName(ItemStack itemstack)
	    {
	        return "tile.PrintingPress" ;
	    }
}
