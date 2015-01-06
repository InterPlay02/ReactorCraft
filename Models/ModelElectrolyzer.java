/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 25/01/2014 3:08:49 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.ReactorCraft.Models;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import Reika.DragonAPI.Instantiable.Rendering.LODModelPart;
import Reika.RotaryCraft.Base.RotaryModelBase;

public class ModelElectrolyzer extends RotaryModelBase
{
	//fields
	LODModelPart Shape1;
	LODModelPart Shape2;
	LODModelPart Shape2a;
	LODModelPart Shape3;
	LODModelPart Shape3a;
	LODModelPart Shape4;
	LODModelPart Shape5;
	LODModelPart Shape5a;
	LODModelPart Shape6;
	LODModelPart Shape6a;
	LODModelPart Shape7;
	LODModelPart Shape7a;
	LODModelPart Shape8;
	LODModelPart Shape8a;

	public ModelElectrolyzer()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new LODModelPart(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 12, 13, 12);
		Shape1.setRotationPoint(-6F, 11F, -6F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new LODModelPart(this, 0, 25);
		Shape2.addBox(0F, 0F, 0F, 14, 3, 1);
		Shape2.setRotationPoint(-7F, 11F, -7F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, 0F);
		Shape2a = new LODModelPart(this, 0, 25);
		Shape2a.addBox(0F, 0F, 0F, 14, 3, 1);
		Shape2a.setRotationPoint(-7F, 11F, 6F);
		Shape2a.setTextureSize(128, 128);
		Shape2a.mirror = true;
		this.setRotation(Shape2a, 0F, 0F, 0F);
		Shape3 = new LODModelPart(this, 50, 0);
		Shape3.addBox(0F, 0F, 0F, 1, 3, 12);
		Shape3.setRotationPoint(6F, 11F, -6F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0F, 0F, 0F);
		Shape3a = new LODModelPart(this, 50, 0);
		Shape3a.addBox(0F, 0F, 0F, 1, 3, 12);
		Shape3a.setRotationPoint(-7F, 11F, -6F);
		Shape3a.setTextureSize(128, 128);
		Shape3a.mirror = true;
		this.setRotation(Shape3a, 0F, 0F, 0F);
		Shape4 = new LODModelPart(this, 78, 0);
		Shape4.addBox(0F, 0F, 0F, 4, 3, 4);
		Shape4.setRotationPoint(-2F, 8F, -2F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		this.setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new LODModelPart(this, 0, 30);
		Shape5.addBox(0F, 0F, 0F, 4, 4, 2);
		Shape5.setRotationPoint(-2F, 15F, -8F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0F);
		Shape5a = new LODModelPart(this, 0, 30);
		Shape5a.addBox(0F, 0F, 0F, 4, 4, 2);
		Shape5a.setRotationPoint(-2F, 15F, 6F);
		Shape5a.setTextureSize(128, 128);
		Shape5a.mirror = true;
		this.setRotation(Shape5a, 0F, 0F, 0F);
		Shape6 = new LODModelPart(this, 0, 37);
		Shape6.addBox(0F, 0F, 0F, 2, 4, 4);
		Shape6.setRotationPoint(-8F, 15F, -2F);
		Shape6.setTextureSize(128, 128);
		Shape6.mirror = true;
		this.setRotation(Shape6, 0F, 0F, 0F);
		Shape6a = new LODModelPart(this, 0, 37);
		Shape6a.addBox(0F, 0F, 0F, 2, 4, 4);
		Shape6a.setRotationPoint(6F, 15F, -2F);
		Shape6a.setTextureSize(128, 128);
		Shape6a.mirror = true;
		this.setRotation(Shape6a, 0F, 0F, 0F);
		Shape7 = new LODModelPart(this, 0, 52);
		Shape7.addBox(0F, 0F, 0F, 8, 2, 1);
		Shape7.setRotationPoint(-4F, 9F, -4F);
		Shape7.setTextureSize(128, 128);
		Shape7.mirror = true;
		this.setRotation(Shape7, 0F, 0F, 0F);
		Shape7a = new LODModelPart(this, 0, 47);
		Shape7a.addBox(0F, 0F, 0F, 8, 2, 1);
		Shape7a.setRotationPoint(-4F, 9F, 3F);
		Shape7a.setTextureSize(128, 128);
		Shape7a.mirror = true;
		this.setRotation(Shape7a, 0F, 0F, 0F);
		Shape8 = new LODModelPart(this, 29, 30);
		Shape8.addBox(0F, 0F, 0F, 1, 2, 6);
		Shape8.setRotationPoint(3F, 9F, -3F);
		Shape8.setTextureSize(128, 128);
		Shape8.mirror = true;
		this.setRotation(Shape8, 0F, 0F, 0F);
		Shape8a = new LODModelPart(this, 13, 30);
		Shape8a.addBox(0F, 0F, 0F, 1, 2, 6);
		Shape8a.setRotationPoint(-4F, 9F, -3F);
		Shape8a.setTextureSize(128, 128);
		Shape8a.mirror = true;
		this.setRotation(Shape8a, 0F, 0F, 0F);
	}

	public void renderAll(TileEntity te, ArrayList li, float phi, float theta)
	{
		Shape1.render(te, f5);
		Shape2.render(te, f5);
		Shape2a.render(te, f5);
		Shape3.render(te, f5);
		Shape3a.render(te, f5);
		Shape4.render(te, f5);
		Shape5.render(te, f5);
		Shape5a.render(te, f5);
		Shape6.render(te, f5);
		Shape6a.render(te, f5);
		Shape7.render(te, f5);
		Shape7a.render(te, f5);
		Shape8.render(te, f5);
		Shape8a.render(te, f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

}
