package gmail.littleeinstein0012.blocks;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerPrintingPress extends Container{
	 private EntityPlayer player;
	 private IInventory chest;
	 private int rowCount = 5;
	 private int rowLength=5;
	 
	 public ContainerPrintingPress(IInventory playerInventory, IInventory chestInventory, int xSize, int ySize){
	        chest = chestInventory;
	        player = ((InventoryPlayer) playerInventory).player;
	        chestInventory.openInventory(player);
	        layoutContainer(playerInventory, chestInventory,xSize, ySize);
	    }

	 public boolean canInteractWith(EntityPlayer p){
		return chest.isUsableByPlayer(p);
	 }
	 public void onContainerClosed(EntityPlayer entityplayer)
	    {
	        super.onContainerClosed(entityplayer);
	        chest.closeInventory(entityplayer);
	    }

	    protected void layoutContainer(IInventory playerInventory, IInventory chestInventory, int xSize, int ySize)
	    {
//	        if (type == IronChestType.DIRTCHEST9000) {
//	            addSlotToContainer(type.makeSlot(chestInventory, 0, 12 + 4 * 18, 8 + 2 * 18));
//	        } else {
	            for (int chestRow = 0; chestRow < rowCount; chestRow++)
	            {
	                for (int chestCol = 0; chestCol < rowLength; chestCol++)
	                {
	                    addSlotToContainer(new Slot(chestInventory, chestCol + chestRow * rowLength, 12 + chestCol * 18, 8 + chestRow * 18));
	                }
	            }
//	        }

	        int leftCol = (xSize - 162) / 2 + 1;
	        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++)
	        {
	            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++)
	            {
	                addSlotToContainer(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, ySize - (4 - playerInvRow) * 18
	                        - 10));
	            }

	        }

	        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++)
	        {
	            addSlotToContainer(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, ySize - 24));
	        }
	    }

	    public EntityPlayer getPlayer()
	    {
	        return player;
	    }
	    
	    public int getNumColumns() {
	        return rowLength;
	    }
	}

