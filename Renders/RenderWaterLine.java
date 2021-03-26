/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2017
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ReactorCraft.Renders;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

import Reika.DragonAPI.Interfaces.TileEntity.RenderFetcher;
import Reika.DragonAPI.Libraries.IO.ReikaTextureHelper;
import Reika.ReactorCraft.Base.ReactorRenderBase;
import Reika.ReactorCraft.Base.TileEntityLine;
import Reika.ReactorCraft.TileEntities.TileEntityHeatPipe;
import Reika.ReactorCraft.TileEntities.PowerGen.TileEntitySteamLine;

public class RenderWaterLine extends ReactorRenderBase {

	/**
	 * Renders the TileEntity for the position.
	 */
	@Deprecated
	private void renderTileEntityWaterLineAt(TileEntitySteamLine tile, double par2, double par4, double par6, float par8)
	{
		this.bindTextureByName("/Reika/ReactorCraft/Textures/TileEntity/waterline.png");

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		int var11 = 0;
		float var13;

		for (int i = 0; i < 6; i++) {
			//this.renderFace(tile, par2, par4, par6, dirs[i]);
		}

		if (tile.isInWorld())
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double par2, double par4, double par6, float par8)
	{
		//if (this.isValidMachineRenderpass((TileEntityReactorBase)tile))
		//	this.renderTileEntityWaterLineAt((TileEntitySteamLine)tile, par2, par4, par6, par8);
		TileEntityLine te = (TileEntityLine)tile;
		if (!tile.hasWorldObj()) {
			ReikaTextureHelper.bindTerrainTexture();
			this.renderBlock(te, par2, par4, par6);
		}
	}

	private void renderBlock(TileEntityLine te, double par2, double par4, double par6) {
		IIcon ico = te.getTexture();
		float u = ico.getMinU();
		float v = ico.getMinV();
		float du = ico.getMaxU();
		float dv = ico.getMaxV();
		GL11.glTranslated(par2, par4, par6);
		Tessellator v5 = Tessellator.instance;

		float f = 1F;//0.15F;
		double s = 0.375;
		float r = 1;
		float g = 1;
		float b = 1;
		if (te instanceof TileEntityHeatPipe) {
			g = 0.65F;
			b = 0.3F;
		}
		GL11.glColor4f(r, g, b, 1);
		GL11.glScaled(s, s, s);
		for (int i = 0; i < 7; i++) {
			double d1 = 0;
			double d2 = 0;
			double d3 = 0;
			if (i == 1)
				d1 = 1;
			else if (i == 2) {
				d2 = 1;
			}
			else if (i == 3) {
				d3 = 1;
			}
			else if (i == 4) {
				d1 = -1;
			}
			else if (i == 5) {
				d2 = -1;
			}
			else if (i == 6) {
				d3 = -1;
			}
			GL11.glTranslated(d1, d2, d3);
			v5.startDrawingQuads();
			v5.setNormal(0, 1, 0);
			v5.addVertexWithUV(0, 0, 1, u, v);
			v5.addVertexWithUV(1, 0, 1, du, v);
			v5.addVertexWithUV(1, 1, 1, du, dv);
			v5.addVertexWithUV(0, 1, 1, u, dv);
			v5.draw();

			v5.startDrawingQuads();
			v5.setNormal(0, 1, 0);
			v5.addVertexWithUV(0, 1, 0, u, dv);
			v5.addVertexWithUV(1, 1, 0, du, dv);
			v5.addVertexWithUV(1, 0, 0, du, v);
			v5.addVertexWithUV(0, 0, 0, u, v);
			v5.draw();

			f = 0.375F;
			GL11.glColor4f(f*r, f*g, f*b, 1);
			v5.startDrawingQuads();
			v5.setNormal(0, 1, 0);
			v5.addVertexWithUV(1, 1, 0, u, dv);
			v5.addVertexWithUV(1, 1, 1, du, dv);
			v5.addVertexWithUV(1, 0, 1, du, v);
			v5.addVertexWithUV(1, 0, 0, u, v);
			v5.draw();

			v5.startDrawingQuads();
			v5.setNormal(0, 1, 0);
			v5.addVertexWithUV(0, 0, 0, u, v);
			v5.addVertexWithUV(0, 0, 1, du, v);
			v5.addVertexWithUV(0, 1, 1, du, dv);
			v5.addVertexWithUV(0, 1, 0, u, dv);
			v5.draw();

			f = 0.625F;
			GL11.glColor4f(f*r, f*g, f*b, 1);
			v5.startDrawingQuads();
			v5.setNormal(0, 1, 0);
			v5.addVertexWithUV(0, 1, 1, u, dv);
			v5.addVertexWithUV(1, 1, 1, du, dv);
			v5.addVertexWithUV(1, 1, 0, du, v);
			v5.addVertexWithUV(0, 1, 0, u, v);
			v5.draw();

			v5.startDrawingQuads();
			v5.setNormal(0, 1, 0);
			v5.addVertexWithUV(0, 0, 0, u, v);
			v5.addVertexWithUV(1, 0, 0, du, v);
			v5.addVertexWithUV(1, 0, 1, du, dv);
			v5.addVertexWithUV(0, 0, 1, u, dv);
			v5.draw();
			GL11.glTranslated(-d1, -d2, -d3);
		}
		GL11.glScaled(1/s, 1/s, 1/s);
		GL11.glTranslated(-par2, -par4, -par6);
		v5.setColorOpaque(255, 255, 255);
	}

	@Override
	public String getImageFileName(RenderFetcher te) {
		return "waterline.png";
	}
}
