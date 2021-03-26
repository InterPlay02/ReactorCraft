/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2017
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ReactorCraft.Base;

import java.util.ArrayList;
import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import Reika.ChromatiCraft.API.Interfaces.UnCopyableBlock;
import Reika.DragonAPI.Libraries.ReikaEntityHelper;
import Reika.ReactorCraft.ReactorCraft;
import Reika.RotaryCraft.API.Interfaces.Transducerable;

public abstract class BlockMultiBlock extends Block implements Transducerable, UnCopyableBlock {

	private final IIcon[] icons = new IIcon[this.getNumberTextures()];
	protected static final ForgeDirection[] dirs = ForgeDirection.values();

	public BlockMultiBlock(Material par2Material) {
		super(par2Material);
		this.setResistance(10);
		this.setHardness(2);
		this.setCreativeTab(ReactorCraft.instance.isLocked() ? null : ReactorCraft.tabRctrMultis);
	}

	public abstract int getNumberTextures();

	public abstract boolean checkForFullMultiBlock(World world, int x, int y, int z, ForgeDirection dir);

	@Override
	public final void onNeighborBlockChange(World world, int x, int y, int z, Block idn) {

	}

	@Override
	public final float getBlockHardness(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		float ret = super.getBlockHardness(world, x, y, z);
		if (meta >= 8)
			ret *= 4;
		return ret;
	}

	@Override
	public final boolean canSilkHarvest() {
		return false;
	}

	public abstract void breakMultiBlock(World world, int x, int y, int z);

	@Override
	public final void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase e, ItemStack is) {
		if (!world.isRemote && this.canTriggerMultiBlockCheck(world, x, y, z, world.getBlockMetadata(x, y, z))) {
			if (e instanceof EntityPlayer)
				if (this.checkForFullMultiBlock(world, x, y, z, ReikaEntityHelper.getDirectionFromEntityLook(e, false)))
					this.onCreateFullMultiBlock(world, x, y, z);
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block oldid, int oldmeta) {
		for (int i = 0; i < 6; i++) {
			ForgeDirection dir = dirs[i];
			int dx = x+dir.offsetX;
			int dy = y+dir.offsetY;
			int dz = z+dir.offsetZ;
			if (!world.isRemote) {
				this.breakMultiBlock(world, dx, dy, dz);
			}
		}

		super.breakBlock(world, x, y, z, oldid, oldmeta);
	}

	protected abstract void onCreateFullMultiBlock(World world, int x, int y, int z);

	public abstract int getNumberVariants();

	@Override
	public final IIcon getIcon(int s, int meta) {
		return icons[this.getItemTextureIndex(meta, s)];
	}

	protected abstract String getIconBaseName();

	@Override
	public final void registerBlockIcons(IIconRegister ico) {
		for (int i = 0; i < this.getNumberTextures(); i++) {
			String name = this.getIconBaseName()+"_"+i;
			icons[i] = ico.registerIcon("reactorcraft:multi/"+name);
		}
	}

	@Override
	public final IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		int index = this.getTextureIndex(world, x, y, z, side, world.getBlockMetadata(x, y, z));
		index = Math.max(0, Math.min(this.getNumberTextures()-1, index)); //safety net
		return icons[index];
		//return Blocks.blocksList[1+world.getBlockMetadata(x, y, z)*2].getIcon(0, 0);
	}

	public abstract int getTextureIndex(IBlockAccess world, int x, int y, int z, int side, int meta);

	@Override
	public final int damageDropped(int meta) {
		return meta&7;
	}

	public final String getName(int meta) {
		return StatCollector.translateToLocal("multiblock."+this.getIconBaseName().toLowerCase(Locale.ENGLISH)+"."+(meta&7));
	}

	public abstract int getItemTextureIndex(int meta, int side);

	@Override
	public final ItemStack getPickBlock(MovingObjectPosition mov, World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z)&7;
		return new ItemStack(this, 1, meta);
	}

	public abstract boolean canTriggerMultiBlockCheck(World world, int x, int y, int z, int meta);

	protected abstract TileEntity getTileEntityForPosition(World world, int x, int y, int z);

	@Override
	public final ArrayList<String> getMessages(World world, int x, int y, int z, int side) {
		TileEntity te = this.getTileEntityForPosition(world, x, y, z);
		return te instanceof TileEntityReactorBase ? ((TileEntityReactorBase)te).getMessages(world, x, y, z, side) : new ArrayList();
	}

	@Override
	public final boolean disallowCopy(int meta) {
		return true;
	}

}
