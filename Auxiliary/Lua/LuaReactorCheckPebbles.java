/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2017
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ReactorCraft.Auxiliary.Lua;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import Reika.DragonAPI.ModInteract.Lua.LuaMethod;
import Reika.ReactorCraft.Registry.ReactorItems;
import Reika.ReactorCraft.TileEntities.HTGR.TileEntityPebbleBed;

public class LuaReactorCheckPebbles extends LuaMethod {

	public LuaReactorCheckPebbles() {
		super("checkPebbleLevel", TileEntityPebbleBed.class);
	}

	@Override
	protected Object[] invoke(TileEntity te, Object[] args) throws LuaMethodException, InterruptedException {
		TileEntityPebbleBed tile = (TileEntityPebbleBed)te;
		int fuel = 0;
		int maxfuel = tile.getSizeInventory()*ReactorItems.PELLET.getNumberMetadatas();
		for (int i = 0; i < tile.getSizeInventory(); i++) {
			ItemStack is = tile.getStackInSlot(i);
			if (is != null) {
				if (is.getItem() == ReactorItems.PELLET.getItemInstance()) {
					fuel += ReactorItems.PELLET.getNumberMetadatas()-1-is.getItemDamage();
				}
			}
		}
		return new Object[]{String.format("%.3f%s", fuel/(float)maxfuel, "%")};
	}

	@Override
	public String getDocumentation() {
		return "Returns the fuel level of a pebble bed reactor.";
	}

	@Override
	public String getArgsAsString() {
		return "";
	}

	@Override
	public ReturnType getReturnType() {
		return ReturnType.STRING;
	}

}
