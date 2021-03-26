/*******************************************************************************
 * @author Reika Kalseki
 *
 * Copyright 2017
 *
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ReactorCraft.GUIs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;

import Reika.DragonAPI.Libraries.IO.ReikaTextureHelper;
import Reika.DragonAPI.Libraries.Rendering.ReikaGuiAPI;
import Reika.DragonAPI.Libraries.Rendering.ReikaLiquidRenderer;
import Reika.ReactorCraft.ReactorCraft;
import Reika.ReactorCraft.Base.ReactorGuiBase;
import Reika.ReactorCraft.Container.ContainerCentrifuge;
import Reika.ReactorCraft.TileEntities.Processing.TileEntityCentrifuge;

public class GuiCentrifuge extends ReactorGuiBase {

	private TileEntityCentrifuge tile;

	public GuiCentrifuge(EntityPlayer player, TileEntityCentrifuge proc) {
		super(new ContainerCentrifuge(player, proc), player, proc);
		ySize = 166;
		tile = proc;
	}

	@Override
	public String getGuiTexture() {
		return "centrifuge";
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		super.drawGuiContainerForegroundLayer(par1, par2);
		ReikaTextureHelper.bindFontTexture();

		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;

		ReikaGuiAPI.instance.drawCenteredStringNoShadow(fontRendererObj, tile.getName(), xSize/2, 5, 4210752);
	}

	@Override
	protected boolean showInventoryLabel() {
		return false;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);
		int i4 = tile.getFluidScaled(60);

		Fluid f = tile.getFluid();
		if (f != null) {
			IIcon ico = ReikaLiquidRenderer.getFluidIconSafe(f);
			ReikaTextureHelper.bindTerrainTexture();
			ReikaGuiAPI.instance.drawTexturedModelRectFromIcon(j+80, k+78-i4, ico, 16, i4);
		}
		String i = "/Reika/ReactorCraft/Textures/GUI/"+this.getGuiTexture()+".png";
		ReikaTextureHelper.bindTexture(ReactorCraft.class, i);
		ReikaGuiAPI.instance.drawTexturedModalRect(j+80, k+18, 223, 83, 16, 60);

		int i5 = tile.getProcessingScaled(48);
		this.drawTexturedModalRect(j+104, k+18, 216, 84, 4, i5);
	}

}
