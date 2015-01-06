/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 25/11/2013 10:48:28 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.ReactorCraft.Models;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import Reika.DragonAPI.Instantiable.Rendering.LODModelPart;
import Reika.RotaryCraft.Base.RotaryModelBase;

public class ModelExchanger extends RotaryModelBase
{
	//fields
	LODModelPart Shape1;
	LODModelPart Shape2;
	LODModelPart Shape1a;
	LODModelPart Shape2a;
	LODModelPart Shape2b;
	LODModelPart Shape2c;
	LODModelPart Shape1b;
	LODModelPart Shape2d;
	LODModelPart Shape1c;

	public ModelExchanger()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new LODModelPart(this, 0, 37);
		Shape1.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape1.setRotationPoint(-8F, 11F, -8F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new LODModelPart(this, 67, 19);
		Shape2.addBox(0F, 0F, 0F, 12, 2, 12);
		Shape2.setRotationPoint(-6F, 9F, -6F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, 0F);
		Shape1a = new LODModelPart(this, 0, 0);
		Shape1a.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape1a.setRotationPoint(-8F, 8F, -8F);
		Shape1a.setTextureSize(128, 128);
		Shape1a.mirror = true;
		this.setRotation(Shape1a, 0F, 0F, 0F);
		Shape2a = new LODModelPart(this, 67, 19);
		Shape2a.addBox(0F, 0F, 0F, 12, 2, 12);
		Shape2a.setRotationPoint(-6F, 21F, -6F);
		Shape2a.setTextureSize(128, 128);
		Shape2a.mirror = true;
		this.setRotation(Shape2a, 0F, 0F, 0F);
		Shape2b = new LODModelPart(this, 0, 19);
		Shape2b.addBox(0F, 0F, 0F, 14, 2, 14);
		Shape2b.setRotationPoint(-7F, 18F, -7F);
		Shape2b.setTextureSize(128, 128);
		Shape2b.mirror = true;
		this.setRotation(Shape2b, 0F, 0F, 0F);
		Shape2c = new LODModelPart(this, 0, 57);
		Shape2c.addBox(0F, 0F, 0F, 16, 4, 16);
		Shape2c.setRotationPoint(-8F, 14F, -8F);
		Shape2c.setTextureSize(128, 128);
		Shape2c.mirror = true;
		this.setRotation(Shape2c, 0F, 0F, 0F);
		Shape1b = new LODModelPart(this, 0, 37);
		Shape1b.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape1b.setRotationPoint(-8F, 20F, -8F);
		Shape1b.setTextureSize(128, 128);
		Shape1b.mirror = true;
		this.setRotation(Shape1b, 0F, 0F, 0F);
		Shape2d = new LODModelPart(this, 0, 19);
		Shape2d.addBox(0F, 0F, 0F, 14, 2, 14);
		Shape2d.setRotationPoint(-7F, 12F, -7F);
		Shape2d.setTextureSize(128, 128);
		Shape2d.mirror = true;
		this.setRotation(Shape2d, 0F, 0F, 0F);
		Shape1c = new LODModelPart(this, 0, 0);
		Shape1c.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape1c.setRotationPoint(-8F, 23F, -8F);
		Shape1c.setTextureSize(128, 128);
		Shape1c.mirror = true;
		this.setRotation(Shape1c, 0F, 0F, 0F);
	}

	@Override
	public void renderAll(TileEntity te, ArrayList li, float phi, float theta)
	{
		Shape1.render(te, f5);
		Shape2.render(te, f5);
		Shape1a.render(te, f5);
		Shape2a.render(te, f5);
		Shape2b.render(te, f5);
		Shape2c.render(te, f5);
		Shape1b.render(te, f5);
		Shape2d.render(te, f5);
		Shape1c.render(te, f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

}
