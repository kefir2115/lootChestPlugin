package me.Ksever.loot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DropFromChests {
	
	static Main l;
	
	public static ArrayList<ItemStack> lootI = new ArrayList<ItemStack>();
	public static ArrayList<ItemStack> lootG = new ArrayList<ItemStack>();
	public static ArrayList<ItemStack> lootD = new ArrayList<ItemStack>();
	
	public static void init() {
		loadLoot();
	}

	private static void loadLoot() {
		HashMap<Enchantment, Integer> e = new HashMap<Enchantment, Integer>();
		lootI.add(ItemStackUtils.getItem(Material.COCOA_BEANS, 32));
		lootI.add(ItemStackUtils.getItem(Material.SUGAR_CANE, 32));
		lootI.add(ItemStackUtils.getItem(Material.BAMBOO, 16));
		lootI.add(ItemStackUtils.getItem(Material.BROWN_MUSHROOM, 32));
		lootI.add(ItemStackUtils.getItem(Material.WARPED_ROOTS, 48));
		lootI.add(ItemStackUtils.getItem(Material.TUBE_CORAL, 32));
		lootI.add(ItemStackUtils.getItem(Material.IRON_BLOCK, 4));
		lootI.add(ItemStackUtils.getItem(Material.GOLD_BLOCK, 2));
		lootI.add(ItemStackUtils.getItem(Material.DIAMOND_BLOCK, 1));
		lootI.add(ItemStackUtils.getItem(Material.GOLDEN_APPLE, 4));
		lootI.add(ItemStackUtils.getItem(Material.BEETROOT_SEEDS, 32));
		
		
		
		lootG.add(ItemStackUtils.getItem(Material.EMERALD_BLOCK, 8));
		lootG.add(ItemStackUtils.getItem(Material.DIAMOND_BLOCK, 2));
		lootG.add(ItemStackUtils.getItem(Material.IRON_BLOCK, 8));
		lootG.add(ItemStackUtils.getItem(Material.GOLD_BLOCK, 4));
		lootG.add(ItemStackUtils.getItem(Material.NETHERITE_INGOT, 1));
		e.put(Enchantment.DIG_SPEED, 5);
		lootG.add(ItemStackUtils.getItem(Material.IRON_PICKAXE, 8, e));
		e.clear();
		e.put(Enchantment.LOOT_BONUS_BLOCKS, 2);
		lootG.add(ItemStackUtils.getItem(Material.IRON_PICKAXE, 8, e));
		e.clear();
		e.put(Enchantment.MENDING, 1);
		lootG.add(ItemStackUtils.getItem(Material.IRON_PICKAXE, 8, e));
		e.clear();
		e.put(Enchantment.LOOT_BONUS_BLOCKS, 2);
		lootG.add(ItemStackUtils.getItem(Material.DIAMOND_PICKAXE, 8, e));
		lootG.add(ItemStackUtils.getItem(Material.GOLDEN_PICKAXE, 8, e));
		e.clear();
		lootG.add(ItemStackUtils.getItem(Material.NAME_TAG, 1));
		lootG.add(ItemStackUtils.getItem(Material.GLOBE_BANNER_PATTERN, 1));
		lootG.add(ItemStackUtils.getItem(Material.GOLDEN_APPLE, 6));
		lootG.add(ItemStackUtils.getItem(Material.EXPERIENCE_BOTTLE, 32));
		
		
		
		lootD.add(ItemStackUtils.getItem(Material.GOLD_BLOCK, 4));
		lootD.add(ItemStackUtils.getItem(Material.DIAMOND_BLOCK, 2));
		lootD.add(ItemStackUtils.getItem(Material.EMERALD_BLOCK, 16));
		lootD.add(ItemStackUtils.getItem(Material.IRON_BLOCK, 16));
		lootD.add(ItemStackUtils.getItem(Material.NETHERITE_INGOT, 3));
		lootD.add(ItemStackUtils.getItem(Material.ELYTRA, 1));
		lootD.add(ItemStackUtils.getItem(Material.BEACON, 1));
		lootD.add(ItemStackUtils.getItem(Material.ENCHANTED_BOOK, Enchantment.DIG_SPEED, 6));
		lootD.add(ItemStackUtils.getItem(Material.CONDUIT, 1));
		lootD.add(ItemStackUtils.getItem(Material.TOTEM_OF_UNDYING, 1));
		lootD.add(ItemStackUtils.getItem(Material.PARROT_SPAWN_EGG, 1));
		lootD.add(ItemStackUtils.getItem(Material.PANDA_SPAWN_EGG, 1));
		lootD.add(ItemStackUtils.getItem(Material.COW_SPAWN_EGG, 1));
		lootD.add(ItemStackUtils.getItem(Material.CHICKEN_SPAWN_EGG, 1));
		lootD.add(ItemStackUtils.getItem(Material.ZOMBIE_SPAWN_EGG, 1));
		lootD.add(ItemStackUtils.getItem(Material.HORSE_SPAWN_EGG, 1));
		lootD.add(ItemStackUtils.getItem(Material.SPAWNER, 1));
		e.put(Enchantment.LUCK, 3);
		e.put(Enchantment.LURE, 3);
		e.put(Enchantment.MENDING, 1);
		e.put(Enchantment.DURABILITY, 3);
		lootD.add(ItemStackUtils.getItem(Material.FISHING_ROD, 1, e));
		e.clear();
		lootD.add(ItemStackUtils.getItem(Material.SHULKER_BOX, 1));
	}

	public static void clearLoot() {
		lootI.clear();
		lootG.clear();
		lootD.clear();
	}

	@SuppressWarnings("deprecation")
	public static void roll(ArrayList<ItemStack> a, Player p) {
		ItemStack key = null;
		if(a == lootI) key = Main.keyIron;
		if(a == lootG) key = Main.keyGold;
		if(a == lootD) key = Main.keyDiamond;
		if(p.getInventory().containsAtLeast(key, 1)) {
			int inv = 0;
			for (ItemStack item: p.getInventory().getStorageContents()) {
				if(item == null) {
					inv++;
				}
			}
			if(inv > 0) {
				ItemStack i = a.get(ThreadLocalRandom.current().nextInt(0, a.size() - 1));
				p.getInventory().removeItem(key);
				p.getInventory().addItem(i);
			} else {
				p.closeInventory();
				p.sendTitle("§cBlad!", "§cNie masz juz miejsca w EQ!");
				Utils.pushPlayer(-p.getLocation().getDirection().getX(), 1, -p.getLocation().getDirection().getZ(), 10, p);
				p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 1);
			}
		} else {
			p.closeInventory();
			p.sendTitle("§cBlad!", "§cNie posiadasz klucza!");
			Utils.pushPlayer(-p.getLocation().getDirection().getX(), 1, -p.getLocation().getDirection().getZ(), 10, p);
			p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 1);
		}
		
	}

}
