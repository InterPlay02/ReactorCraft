/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2017
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ReactorCraft.Auxiliary;

import net.minecraft.command.ICommandSender;

import Reika.DragonAPI.Command.DragonCommandBase;

public class ClearSteamCommand extends DragonCommandBase {

	private static long lastTime = -1;

	@Override
	public void processCommand(ICommandSender ics, String[] args) {
		lastTime = System.currentTimeMillis();
	}

	@Override
	public String getCommandString() {
		return "clearsteam";
	}

	@Override
	protected boolean isAdminOnly() {
		return true;
	}

	public static boolean clearSteam() {
		return System.currentTimeMillis()-lastTime < 1000;
	}

}
