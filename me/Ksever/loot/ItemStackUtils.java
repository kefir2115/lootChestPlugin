package me.Ksever.loot;

import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackUtils {
	public static ItemStack getItem(Material m, String name, String... lore) {
		ItemStack item = new ItemStack(m);
		ItemMeta im = item.getItemMeta();
		if(name != "") {
			im.setDisplayName(name);
		}
		im.setLore(Arrays.asList(lore));
		item.setItemMeta(im);
		return item;
	}
	public static ItemStack getItem(Material m, int count) {
		ItemStack item = new ItemStack(m);
		item.setAmount(count);
		return item;
	}
	public static ItemStack getItem(Material m, int count, HashMap<Enchantment, Integer> e) {
		ItemStack item = new ItemStack(m);
		item.addUnsafeEnchantments(e);
		return item;
	}
	public static ItemStack getItem(Material m, Enchantment e, int level) {
		ItemStack item = new ItemStack(m);
		EnchantmentStorageMeta esm = (EnchantmentStorageMeta) item.getItemMeta();
		esm.addStoredEnchant(e, level, true);
		item.setItemMeta(esm);
		return item;
	}
}