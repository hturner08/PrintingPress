package gmail.littleeinstein0012.com;

import gmail.littleeinstein0012.blocks.*;
import gmail.littleeinstein0012.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid="YourModsID", version="YourModsVersion")
public class main
{
	public static String MODID = "YourModID";
	public static String VERSION = "YourModVersion";

	public static CreativeTabs tabName = new CreativeTabs("OurMods")
	{
	public ItemStack getTabIconItem()
	{
		return getIconItemStack();
	}
	};
	//Blocks (This is called a comment, they're optional)
	public static Block yourBlock;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{

	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
	yourBlock = new PrintingPress("YourBlock").setCreativeTab(tabName);
	yourBlock.setRegistryName("Printing Press");
	GameRegistry.registerTileEntity(PrintingPressEntity.class, "tutorial_tile_entity");
	GameRegistry.register(yourBlock);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{

	}
}