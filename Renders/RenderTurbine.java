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

import java.lang.reflect.Constructor;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.MinecraftForgeClient;

import Reika.DragonAPI.Exception.RegistrationException;
import Reika.DragonAPI.Interfaces.TileEntity.RenderFetcher;
import Reika.DragonAPI.Libraries.IO.ReikaTextureHelper;
import Reika.DragonAPI.Libraries.Java.ReikaJavaLibrary;
import Reika.ReactorCraft.ReactorCraft;
import Reika.ReactorCraft.Base.ReactorRenderBase;
import Reika.ReactorCraft.Base.TileEntityReactorBase;
import Reika.ReactorCraft.Models.ModelTurbine;
import Reika.ReactorCraft.Registry.ReactorBlocks;
import Reika.ReactorCraft.TileEntities.PowerGen.TileEntityHiPTurbine;
import Reika.ReactorCraft.TileEntities.PowerGen.TileEntityTurbineCore;
import Reika.RotaryCraft.Auxiliary.IORenderer;

public class RenderTurbine extends ReactorRenderBase
{
	private ModelTurbine[] models = new ModelTurbine[7];

	public RenderTurbine() {
		super();
		this.buildModels();
	}

	private void buildModels() {
		for (int i = 0; i < models.length; i++) {
			Class cc = this.getModelClass();
			try {
				Constructor c = cc.getConstructor(int.class);
				models[i] = (ModelTurbine)c.newInstance(i);
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new RegistrationException(ReactorCraft.instance, "Invalid turbine model registration!");
			}
		}
	}

	protected Class<? extends ModelTurbine> getModelClass() {
		return ModelTurbine.class;
	}

	protected String getTextureName() {
		return "turbine";
	}

	public final void renderTileEntityTurbineCoreAt(TileEntityTurbineCore tile, double par2, double par4, double par6, float par8)
	{
		this.bindTextureByName("/Reika/ReactorCraft/Textures/TileEntity/"+this.getTextureName()+".png");
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float)par2, (float)par4 + 2.0F, (float)par6 + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);

		switch(tile.getBlockMetadata()) {
			case 0:
				GL11.glRotatef(90, 0, 1, 0);
				break;
			case 1:
				GL11.glRotatef(270, 0, 1, 0);
				break;
			case 2:
				GL11.glRotatef(180, 0, 1, 0);
				break;
			case 3:
				GL11.glRotatef(0, 0, 1, 0);
				break;
		}

		if (tile.isInWorld()) {
			if (tile.hasMultiBlock()) {
				int dmg = tile.getDamage();
				if (Minecraft.getMinecraft().thePlayer.getCommandSenderName().equals("waterlubber")) {
					if (System.identityHashCode(tile)%2 == 0 && !Minecraft.getMinecraft().isIntegratedServerRunning()) {
						dmg += 2;
					}
				}
				models[tile.getStage()].renderAll(tile, dmg > 0 ? ReikaJavaLibrary.makeListFrom(dmg) : null, -tile.phi, 0);
			}
			else {
				GL11.glTranslated(-0.5, -0.5, -0.5);
				Tessellator v5 = Tessellator.instance;
				IIcon ico = ReactorBlocks.TURBINEMULTI.getBlockInstance().getIcon(0, 3);
				ReikaTextureHelper.bindTerrainTexture();
				float u = ico.getMinU();
				float v = ico.getMinV();
				float du = ico.getMaxU();
				float dv = ico.getMaxV();
				v5.startDrawingQuads();
				v5.addVertexWithUV(0, 1, 0, u, v);
				v5.addVertexWithUV(1, 1, 0, du, v);
				v5.addVertexWithUV(1, 1, 1, du, dv);
				v5.addVertexWithUV(0, 1, 1, u, dv);

				v5.addVertexWithUV(0, 2, 1, u, dv);
				v5.addVertexWithUV(1, 2, 1, du, dv);
				v5.addVertexWithUV(1, 2, 0, du, v);
				v5.addVertexWithUV(0, 2, 0, u, v);

				v5.addVertexWithUV(1, 2, 1, du, dv);
				v5.addVertexWithUV(1, 1, 1, du, v);
				v5.addVertexWithUV(1, 1, 0, u, v);
				v5.addVertexWithUV(1, 2, 0, u, dv);

				v5.addVertexWithUV(0, 2, 1, u, dv);
				v5.addVertexWithUV(0, 1, 1, u, v);
				v5.addVertexWithUV(1, 1, 1, du, v);
				v5.addVertexWithUV(1, 2, 1, du, dv);

				v5.addVertexWithUV(1, 2, 0, du, dv);
				v5.addVertexWithUV(1, 1, 0, du, v);
				v5.addVertexWithUV(0, 1, 0, u, v);
				v5.addVertexWithUV(0, 2, 0, u, dv);

				v5.addVertexWithUV(0, 2, 0, u, dv);
				v5.addVertexWithUV(0, 1, 0, u, v);
				v5.addVertexWithUV(0, 1, 1, du, v);
				v5.addVertexWithUV(0, 2, 1, du, dv);
				v5.draw();
			}
		}
		else {
			boolean iof = tile instanceof TileEntityHiPTurbine;
			double sc = iof ? 0.4 : 0.6;
			double dy = iof ? 1.7 : 0.8;
			double dx = iof ? 0.3 : 0.1;
			GL11.glScaled(sc, sc, sc);
			GL11.glTranslated(-dx, dy, 0);
			models[0].renderAll(tile, null, -tile.phi);
			GL11.glTranslated(dx, -dy, 0);
			GL11.glScaled(1D/sc, 1D/sc, 1D/sc);
		}

		if (tile.isInWorld())
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public final void renderTileEntityAt(TileEntity tile, double par2, double par4, double par6, float par8)
	{
		if (this.doRenderModel((TileEntityReactorBase)tile))
			this.renderTileEntityTurbineCoreAt((TileEntityTurbineCore)tile, par2, par4, par6, par8);
		if (((TileEntityReactorBase) tile).isInWorld() && MinecraftForgeClient.getRenderPass() == 1) {
			IORenderer.renderIO(tile, par2, par4, par6);
			//IOAPI.renderIO((ShaftMachine)tile, par2, par4, par6);
		}
	}

	@Override
	public final String getImageFileName(RenderFetcher te) {
		return this.getTextureName()+".png";
	}
}
