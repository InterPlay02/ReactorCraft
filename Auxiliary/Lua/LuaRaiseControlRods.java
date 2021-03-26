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

import net.minecraft.tileentity.TileEntity;

import Reika.DragonAPI.ModInteract.Lua.LuaMethod;
import Reika.ReactorCraft.TileEntities.Fission.TileEntityCPU;

public class LuaRaiseControlRods extends LuaMethod {

	public LuaRaiseControlRods() {
		super("raiseRods", TileEntityCPU.class);
	}

	@Override
	protected Object[] invoke(TileEntity te, Object[] args) throws LuaMethodException, InterruptedException {
		((TileEntityCPU)te).raiseAllRods();
		return null;
	}

	@Override
	public String getDocumentation() {
		return "Raises all the reactor control rods.";
	}

	@Override
	public String getArgsAsString() {
		return "";
	}

	@Override
	public ReturnType getReturnType() {
		return ReturnType.VOID;
	}

}
