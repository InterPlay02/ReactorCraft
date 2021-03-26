/*******************************************************************************
 * @author Reika Kalseki
 *
 * Copyright 2017
 *
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.ReactorCraft.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import Reika.DragonAPI.Base.EnumOreBlock;
import Reika.DragonAPI.Instantiable.IO.PacketTarget;
import Reika.DragonAPI.Interfaces.Registry.OreEnum;
import Reika.DragonAPI.Libraries.IO.ReikaPacketHelper;
import Reika.DragonAPI.Libraries.Java.ReikaRandomHelper;
import Reika.ReactorCraft.ReactorCraft;
import Reika.ReactorCraft.Auxiliary.RadiationEffects.RadiationIntensity;
import Reika.ReactorCraft.Registry.ReactorAchievements;
import Reika.ReactorCraft.Registry.ReactorBlocks;
import Reika.ReactorCraft.Registry.ReactorOptions;
import Reika.ReactorCraft.Registry.ReactorOres;
import Reika.ReactorCraft.Registry.ReactorPackets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockReactorOre extends EnumOreBlock {

	private IIcon[] icons = new IIcon[ReactorOres.oreList.length];

	private static final Random rand = new Random();

	public BlockReactorOre(Material par2Material) {
		super(par2Material);
		this.setResistance(5);
		this.setHardness(2);
		this.setCreativeTab(ReactorCraft.instance.isLocked() ? null : ReactorCraft.tabRctr);
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (ReactorOptions.RADIOORE.getState()) {
			ReactorOres ore = ReactorOres.getOre(this, world.getBlockMetadata(x, y, z));
			if (ore.isRadioactive() && !RadiationIntensity.LOWLEVEL.hasSufficientShielding(Minecraft.getMinecraft().thePlayer)) {
				ReikaPacketHelper.sendUpdatePacket(ReactorCraft.packetChannel, ReactorPackets.ORERADIATION.ordinal(), x, y, z, PacketTarget.server);
			}
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> li = new ArrayList<ItemStack>();
		//ItemStack is = new ItemStack(ReactorBlocks.ORE.getBlock(), 1, metadata);
		ReactorOres ore = ReactorOres.getOre(this, metadata);
		int n = ore.dropsSelf(world, x, y, z) ? 1 : 1+rand.nextInt(1+fortune);
		for (int i = 0; i < n; i++)
			li.addAll(ore.getOreDrop(metadata));
		return li;
	}

	private int droppedXP(ReactorOres ore) {
		return ReikaRandomHelper.doWithChance(ore.xpDropped) ? 1 : 0;
	}

	@Override
	protected void onHarvested(World world, int x, int y, int z, Block b, int meta, OreEnum ore, EntityPlayer ep) {
		if (!ep.capabilities.isCreativeMode) {
			if (((ReactorOres)ore).isUranium()) {
				ReactorAchievements.MINEURANIUM.triggerAchievement(ep);
			}
			else if (ore == ReactorOres.CADMIUM) {
				ReactorAchievements.MINECADMIUM.triggerAchievement(ep);
			}
		}
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition tgt, World world, int x, int y, int z)
	{
		ReactorOres ore = ReactorOres.getOre(world, x, y, z);
		return new ItemStack(ReactorBlocks.ORE.getBlockInstance(), 1, ore.getBlockMetadata());
	}

	@Override
	public void registerBlockIcons(IIconRegister ico) {
		for (int i = 1; i < ReactorOres.oreList.length; i++) {
			icons[i] = ico.registerIcon(ReactorOres.oreList[i].getTextureName());
		}
		icons[0] = Blocks.stone.getIcon(0, 0);
	}

	@Override
	public IIcon getIcon(int s, int meta) {
		return icons[meta];
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity e)
	{
		return ReactorOres.getOre(world, x, y, z) != ReactorOres.ENDBLENDE || !(e instanceof EntityDragon);
	}

	@Override
	public OreEnum getOre(int meta) {
		return ReactorOres.getOre(this, meta);
	}
}
