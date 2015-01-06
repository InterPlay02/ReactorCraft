/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 19/04/2014 1:13:25 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.ReactorCraft.Models;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import Reika.DragonAPI.Instantiable.Rendering.LODModelPart;
import Reika.RotaryCraft.Base.RotaryModelBase;

public class ModelGenerator extends RotaryModelBase
{
	//fields
	LODModelPart Shape1;
	LODModelPart Shape2;
	LODModelPart Shape2a;
	LODModelPart Shape2b;
	LODModelPart Shape2c;
	LODModelPart Shape2d;
	LODModelPart Shape2e;
	LODModelPart Shape2f;
	LODModelPart Shape2g;
	LODModelPart Shape1b;
	LODModelPart Shape1c;
	LODModelPart Shape3;
	LODModelPart Shape1d;
	LODModelPart Shape3a;
	LODModelPart Shape3b;
	LODModelPart Shape3c;
	LODModelPart Shape4;
	LODModelPart Shape5;
	LODModelPart Shape7;
	LODModelPart Shape7a;
	LODModelPart Shape7b;
	LODModelPart Shape7c;

	public ModelGenerator()
	{
		textureWidth = 512;
		textureHeight = 512;

		Shape1 = new LODModelPart(this, 0, 0);
		Shape1.addBox(-8F, -8F, 0F, 16, 16, 127);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(512, 512);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 1.178097F);
		Shape2 = new LODModelPart(this, 0, 155);
		Shape2.addBox(-17F, 32F, 0F, 34, 8, 128);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(512, 512);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, -0.7853982F);
		Shape2a = new LODModelPart(this, 0, 155);
		Shape2a.addBox(-17F, 32F, 0F, 34, 8, 128);
		Shape2a.setRotationPoint(0F, 0F, 0F);
		Shape2a.setTextureSize(512, 512);
		Shape2a.mirror = true;
		this.setRotation(Shape2a, 0F, 0F, -2.356194F);
		Shape2b = new LODModelPart(this, 0, 155);
		Shape2b.addBox(-17F, 32F, 0F, 34, 8, 128);
		Shape2b.setRotationPoint(0F, 0F, 0F);
		Shape2b.setTextureSize(512, 512);
		Shape2b.mirror = true;
		this.setRotation(Shape2b, 0F, 0F, 0.7853982F);
		Shape2c = new LODModelPart(this, 0, 155);
		Shape2c.addBox(-17F, 32F, 0F, 34, 8, 128);
		Shape2c.setRotationPoint(0F, 0F, 0F);
		Shape2c.setTextureSize(512, 512);
		Shape2c.mirror = true;
		this.setRotation(Shape2c, 0F, 0F, 0F);
		Shape2d = new LODModelPart(this, 0, 155);
		Shape2d.addBox(-17F, 32F, 0F, 34, 8, 128);
		Shape2d.setRotationPoint(0F, 0F, 0F);
		Shape2d.setTextureSize(512, 512);
		Shape2d.mirror = true;
		this.setRotation(Shape2d, 0F, 0F, 1.570796F);
		Shape2e = new LODModelPart(this, 0, 155);
		Shape2e.addBox(-17F, 32F, 0F, 34, 8, 128);
		Shape2e.setRotationPoint(0F, 0F, 0F);
		Shape2e.setTextureSize(512, 512);
		Shape2e.mirror = true;
		this.setRotation(Shape2e, 0F, 0F, -1.570796F);
		Shape2f = new LODModelPart(this, 0, 155);
		Shape2f.addBox(-17F, 32F, 0F, 34, 8, 128);
		Shape2f.setRotationPoint(0F, 0F, 0F);
		Shape2f.setTextureSize(512, 512);
		Shape2f.mirror = true;
		this.setRotation(Shape2f, 0F, 0F, 3.170681F);
		Shape2g = new LODModelPart(this, 0, 155);
		Shape2g.addBox(-17F, 32F, 0F, 34, 8, 128);
		Shape2g.setRotationPoint(0F, 0F, 0F);
		Shape2g.setTextureSize(512, 512);
		Shape2g.mirror = true;
		this.setRotation(Shape2g, 0F, 0F, 2.373648F);
		Shape1b = new LODModelPart(this, 0, 0);
		Shape1b.addBox(-8F, -8F, 0F, 16, 16, 127);
		Shape1b.setRotationPoint(0F, 0F, 0F);
		Shape1b.setTextureSize(512, 512);
		Shape1b.mirror = true;
		this.setRotation(Shape1b, 0F, 0F, 0.7853982F);
		Shape1c = new LODModelPart(this, 0, 0);
		Shape1c.addBox(-8F, -8F, 0F, 16, 16, 127);
		Shape1c.setRotationPoint(0F, 0F, 0F);
		Shape1c.setTextureSize(512, 512);
		Shape1c.mirror = true;
		this.setRotation(Shape1c, 0F, 0F, 0.3926991F);
		Shape3 = new LODModelPart(this, 0, 293);
		Shape3.addBox(-20F, -20F, 0F, 40, 40, 116);
		Shape3.setRotationPoint(0F, 0F, 4F);
		Shape3.setTextureSize(512, 512);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0F, 0F, 1.178097F);
		Shape1d = new LODModelPart(this, 0, 0);
		Shape1d.addBox(-8F, -8F, 0F, 16, 16, 127);
		Shape1d.setRotationPoint(0F, 0F, 0F);
		Shape1d.setTextureSize(512, 512);
		Shape1d.mirror = true;
		this.setRotation(Shape1d, 0F, 0F, 0F);
		Shape3a = new LODModelPart(this, 0, 293);
		Shape3a.addBox(-20F, -20F, 0F, 40, 40, 116);
		Shape3a.setRotationPoint(0F, 0F, 4F);
		Shape3a.setTextureSize(512, 512);
		Shape3a.mirror = true;
		this.setRotation(Shape3a, 0F, 0F, 0F);
		Shape3b = new LODModelPart(this, 0, 293);
		Shape3b.addBox(-20F, -20F, 0F, 40, 40, 116);
		Shape3b.setRotationPoint(0F, 0F, 4F);
		Shape3b.setTextureSize(512, 512);
		Shape3b.mirror = true;
		this.setRotation(Shape3b, 0F, 0F, 0.7853982F);
		Shape3c = new LODModelPart(this, 0, 293);
		Shape3c.addBox(-20F, -20F, 0F, 40, 40, 116);
		Shape3c.setRotationPoint(0F, 0F, 4F);
		Shape3c.setTextureSize(512, 512);
		Shape3c.mirror = true;
		this.setRotation(Shape3c, 0F, 0F, 0.3926991F);
		Shape4 = new LODModelPart(this, 0, 0);
		Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape4.setRotationPoint(0F, 0F, 0F);
		Shape4.setTextureSize(512, 512);
		Shape4.mirror = true;
		this.setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new LODModelPart(this, 288, 0);
		Shape5.addBox(-40F, -40F, 0F, 80, 80, 32);
		Shape5.setRotationPoint(0F, 0F, -32F);
		Shape5.setTextureSize(512, 512);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0F);
		Shape7 = new LODModelPart(this, 0, 461);
		Shape7.addBox(-36F, -4F, 0F, 72, 8, 1);
		Shape7.setRotationPoint(0F, 0F, 126.7F);
		Shape7.setTextureSize(512, 512);
		Shape7.mirror = true;
		this.setRotation(Shape7, 0F, 0F, -0.7853982F);
		Shape7a = new LODModelPart(this, 0, 461);
		Shape7a.addBox(-36F, -4F, 0F, 72, 8, 1);
		Shape7a.setRotationPoint(0F, 0F, 126.8F);
		Shape7a.setTextureSize(512, 512);
		Shape7a.mirror = true;
		this.setRotation(Shape7a, 0F, 0F, 0F);
		Shape7b = new LODModelPart(this, 0, 461);
		Shape7b.addBox(-36F, -4F, 0F, 72, 8, 1);
		Shape7b.setRotationPoint(0F, 0F, 126.9F);
		Shape7b.setTextureSize(512, 512);
		Shape7b.mirror = true;
		this.setRotation(Shape7b, 0F, 0F, 1.570796F);
		Shape7c = new LODModelPart(this, 0, 461);
		Shape7c.addBox(-36F, -4F, 0F, 72, 8, 1);
		Shape7c.setRotationPoint(0F, 0F, 126.7F);
		Shape7c.setTextureSize(512, 512);
		Shape7c.mirror = true;
		this.setRotation(Shape7c, 0F, 0F, 0.7853982F);
	}

	@Override
	public void renderAll(TileEntity te, ArrayList li, float phi, float theta) {
		double a = 0;
		double b = 1;
		double c = -7.5;
		double d = 1;
		GL11.glTranslated(a, b, c);
		GL11.glRotated(phi, 0, 0, 1);
		Shape1.render(te, f5);
		Shape1b.render(te, f5);
		Shape1c.render(te, f5);
		Shape3.render(te, f5);
		Shape1d.render(te, f5);
		Shape3a.render(te, f5);
		Shape3b.render(te, f5);
		Shape3c.render(te, f5);
		GL11.glRotated(-phi, 0, 0, 1);

		Shape2.render(te, f5);
		Shape2a.render(te, f5);
		Shape2b.render(te, f5);
		Shape2c.render(te, f5);
		Shape2d.render(te, f5);
		Shape2e.render(te, f5);
		Shape2f.render(te, f5);
		Shape2g.render(te, f5);
		Shape4.render(te, f5);
		Shape5.render(te, f5);
		Shape7.render(te, f5);
		Shape7a.render(te, f5);
		Shape7b.render(te, f5);
		Shape7c.render(te, f5);
		GL11.glTranslated(-a, -b, -c);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

}
