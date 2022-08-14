package me.Ksever.loot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class GUI {

	public static InventoryView iron(Player p) {
		ItemStack hook = ItemStackUtils.getItem(Material.TRIPWIRE_HOOK, "§7Otworz skrzynke", "§cUWAGA! Musisz miec w ekwipunku klucz!", "§fKliknij aby otworzyc");
		hook.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		Inventory inventory = Bukkit.createInventory((InventoryHolder)p, 27, "§fSkrzynia zelazna - Menu");
		inventory.setItem(11, ItemStackUtils.getItem(Material.CHEST, "§7Zobacz drop ze skrzynki", "§fKliknij aby zobaczyc"));
		inventory.setItem(13, ItemStackUtils.getItem(Material.PAPER, "§c§lINFORMACJA", "§fObecnie przegladasz skrzynie §7zelazna§f!",
				"§f", "§fZe skrzyni mozesz otrzymac najrozniejsze przedmioty,",
				"§fpelna liste znajdziesz klikajac w skrzynie!",
				"§fJezeli natomiast chcialbys otworzyc ta",
				"§fskrzynie, kliknij w hak!"));
		inventory.setItem(15, hook);
		return p.openInventory(inventory);
	}
	
	public static InventoryView gold(Player p) {
		ItemStack hook = ItemStackUtils.getItem(Material.TRIPWIRE_HOOK, "§6Otworz skrzynke", "§cUWAGA! Musisz miec w ekwipunku klucz!", "§eKliknij aby otworzyc");
		hook.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		Inventory inventory = Bukkit.createInventory((InventoryHolder)p, 27, "§eSkrzynia zlota - Menu");
		inventory.setItem(11, ItemStackUtils.getItem(Material.CHEST, "§6Zobacz drop ze skrzynki", "§eKliknij aby zobaczyc"));
		inventory.setItem(13, ItemStackUtils.getItem(Material.PAPER, "§c§lINFORMACJA", "§eObecnie przegladasz skrzynie §6zlota§e!",
				"§e", "§eZe skrzyni mozesz otrzymac najrozniejsze przedmioty,",
				"§epelna liste znajdziesz klikajac w skrzynie!",
				"§eJezeli natomiast chcialbys otworzyc ta",
				"§eskrzynie, kliknij w hak!"));
		inventory.setItem(15, hook);
		return p.openInventory(inventory);
	}
	
	public static InventoryView diamond(Player p) {
		ItemStack hook = ItemStackUtils.getItem(Material.TRIPWIRE_HOOK, "§9Otworz skrzynke", "§cUWAGA! Musisz miec w ekwipunku klucz!", "§bKliknij aby otworzyc");
		hook.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		Inventory inventory = Bukkit.createInventory((InventoryHolder)p, 27, "§bSkrzynia diamentowa - Menu");
		inventory.setItem(11, ItemStackUtils.getItem(Material.CHEST, "§9Zobacz drop ze skrzynki", "§bKliknij aby zobaczyc"));
		inventory.setItem(13, ItemStackUtils.getItem(Material.PAPER, "§c§lINFORMACJA", "§9Obecnie przegladasz skrzynie §bdiamentowa§9!",
				"§9", "§9Ze skrzyni mozesz otrzymac najrozniejsze przedmioty,",
				"§9pelna liste znajdziesz klikajac w skrzynie!",
				"§9Jezeli natomiast chcialbys otworzyc ta",
				"§9skrzynie, kliknij w hak!"));
		inventory.setItem(15, hook);
		return p.openInventory(inventory);
	}

	public static InventoryView ironloot(Player p) {
		Inventory inventory = Bukkit.createInventory((InventoryHolder)p, 27, "§fSkrzynia zelazna - Drop");
		int slot = 0;
		for(ItemStack i : DropFromChests.lootI) {
			inventory.setItem(slot, i);
			slot++;
		}
		return p.openInventory(inventory);
	}
	
	public static InventoryView goldloot(Player p) {
		Inventory inventory = Bukkit.createInventory((InventoryHolder)p, 27, "§eSkrzynia zlota - Drop");
		int slot = 0;
		for(ItemStack i : DropFromChests.lootG) {
			inventory.setItem(slot, i);
			slot++;
		}
		return p.openInventory(inventory);
	}
	
	public static InventoryView diamondloot(Player p) {
		Inventory inventory = Bukkit.createInventory((InventoryHolder)p, 27, "§bSkrzynia diamentowa - Drop");
		int slot = 0;
		for(ItemStack i : DropFromChests.lootD) {
			inventory.setItem(slot, i);
			slot++;
		}
		return p.openInventory(inventory);
	}

}
