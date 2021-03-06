package com.vanhal.progressiveautomation.gui.container;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.vanhal.progressiveautomation.entities.BaseTileEntity;
import com.vanhal.progressiveautomation.entities.chopper.TileChopper;
import com.vanhal.progressiveautomation.gui.slots.SlotSaplings;
import com.vanhal.progressiveautomation.gui.slots.SlotTool;
import com.vanhal.progressiveautomation.gui.slots.SlotUpgrades;
import com.vanhal.progressiveautomation.ref.ToolHelper;

public class ContainerChopper extends BaseContainer {
	protected ItemStack updateType;

	public ContainerChopper(InventoryPlayer inv, TileEntity entity) {
		super((BaseTileEntity)entity, 11, 52);
		TileChopper chopper = (TileChopper) entity;
		
		updateType = ToolHelper.getUpgradeType(chopper.getUpgradeLevel());

		//add slots
		this.addSlotToContainer(new SlotSaplings(chopper, chopper.SLOT_SAPLINGS, 11, 16)); //saplings
		this.addSlotToContainer(new SlotTool(ToolHelper.TYPE_AXE,  chopper.getUpgradeLevel(), chopper, chopper.SLOT_AXE, 49, 52)); //axe
		this.addSlotToContainer(new SlotUpgrades(chopper, chopper.SLOT_UPGRADE, 76, 52)); //upgrades

		//output slots
		addInventory(chopper, chopper.SLOT_INVENTORY_START, 112, 16, 3, 3);

		addPlayerInventory(inv);
	}
}
