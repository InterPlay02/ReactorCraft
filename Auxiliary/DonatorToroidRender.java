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

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.player.EntityPlayer;

import Reika.DragonAPI.Auxiliary.Trackers.PlayerSpecificRenderer.PlayerRotationData;
import Reika.DragonAPI.Interfaces.PlayerRenderObj;
import Reika.ReactorCraft.Registry.ReactorTiles;
import Reika.ReactorCraft.TileEntities.Fusion.TileEntityToroidMagnet;

public class DonatorToroidRender implements PlayerRenderObj {

	public static final DonatorToroidRender instance = new DonatorToroidRender();

	private DonatorToroidRender() {

	}

	@Override
	public void render(EntityPlayer ep, float ptick, PlayerRotationData dat) {
		GL11.glPushMatrix();
		double d = 0.1875;
		GL11.glTranslated(-d, 2.0625, -d);
		double angle = (System.currentTimeMillis()/10)%360;
		GL11.glTranslated(-d, d, 0);
		GL11.glTranslated(d, 0, d);
		GL11.glTranslated(d, d, 0);
		GL11.glRotated(90, 0, 0, 1);
		GL11.glRotated(angle, 1, 0, 0);
		GL11.glTranslated(-d, -d, 0);
		GL11.glTranslated(-d, 0, -d);
		//GL11.glRotated(-dat.getRenderYaw(), 0, 1, 0);
		//GL11.glRotated(45, 1, 0, 0);
		//GL11.glRotated(dat.getRenderPitch(), 1, 0, 0);
		//GL11.glRotated(-45, 0, 1, 0);
		double s = 0.375;
		GL11.glScaled(s, s, s);
		//GL11.glRotated(45-ep.rotationPitch+90, 1, 0, 0);
		//GL11.glRotated(RenderManager.instance.playerViewY-ep.rotationYawHead-45, 0, 1, 0);
		TileEntityToroidMagnet te = (TileEntityToroidMagnet)ReactorTiles.MAGNET.createTEInstanceForRender();
		TileEntityRendererDispatcher.instance.renderTileEntityAt(te, 0, 0, 0, ptick);
		GL11.glPopMatrix();
	}

	@Override
	public int getRenderPriority() {
		return 0;
	}

}
