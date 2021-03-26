/*******************************************************************************
 * @author Reika Kalseki
 *
 * Copyright 2017
 *
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ReactorCraft.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import Reika.ReactorCraft.Registry.ReactorBlocks;
import Reika.ReactorCraft.Registry.ReactorOres;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockReactorOre extends ItemBlock {

	public ItemBlockReactorOre(Block b) {
		super(b);
		hasSubtypes = true;
		this.setMaxDamage(0);
	}

	/*
	@Override
	public void onUpdate(ItemStack is, World world, Entity e, int slot, boolean flag) {
		if (e instanceof EntityPlayer && ReactorOptions.RADIOORE.getState() && ReactorOres.oreList[is.getItemDamage()].isUranium()) {
			EntityPlayer ep = (EntityPlayer)e;
			if (!ep.capabilities.isCreativeMode) {
				RadiationEffects.instance.applyEffects(ep, RadiationIntensity.LOWLEVEL);
			}
		}
	}
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item ID, CreativeTabs cr, List li) {
		for (int i = 1; i < this.getDataValues(); i++) {
			ItemStack item = new ItemStack(ID, 1, i);
			li.add(item);
		}
	}

	private int getDataValues() {
		return ReactorOres.oreList.length;
	}

	@Override
	public String getUnlocalizedName(ItemStack is) {
		if (this.getDataValues() <= 1)
			return super.getUnlocalizedName(is);
		int d = is.getItemDamage();
		return super.getUnlocalizedName() + "." + d;
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack) {
		return ReactorBlocks.ORE.getMultiValuedName(itemstack.getItemDamage());
	}
}
