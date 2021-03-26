/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2017
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ReactorCraft.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;

import Reika.DragonAPI.Base.CoreContainer;
import Reika.ReactorCraft.TileEntities.Processing.TileEntityCentrifuge;

public class ContainerCentrifuge extends CoreContainer {

	private TileEntityCentrifuge proc;

	public ContainerCentrifuge(EntityPlayer player, TileEntityCentrifuge te) {
		super(player, te);

		this.addSlotToContainer(new Slot(te, 0, 44, 62));
		this.addSlotToContainer(new Slot(te, 1, 116, 62));

		this.addPlayerInventoryWithOffset(player, 0, 0);

		proc = te;
	}

	/**
	 * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
	 */
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < crafters.size(); i++)
		{
			ICrafting icrafting = (ICrafting)crafters.get(i);

			icrafting.sendProgressBarUpdate(this, 0, proc.split);
		}
	}

	@Override
	public void updateProgressBar(int par1, int par2)
	{
		switch(par1) {
		case 0: proc.split = par2; break;
		}
	}
}
