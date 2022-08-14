package me.Ksever.loot;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public static ItemStack keyIron = ItemStackUtils.getItem(Material.TRIPWIRE_HOOK, "§fKlucz do skrzyni §7zelaznej", "§eTego klucza mozesz uzyc w skrzyni", "§7zelaznej§e, kliknij w skrzynie, a nastepnie", "§ekliknij hak aby otworzyc!");
	public static ItemStack keyGold = ItemStackUtils.getItem(Material.TRIPWIRE_HOOK, "§fKlucz do skrzyni §6zlotej", "§eTego klucza mozesz uzyc w skrzyni", "§6zlotej§e, kliknij w skrzynie, a nastepnie", "§ekliknij hak aby otworzyc!");
	public static ItemStack keyDiamond = ItemStackUtils.getItem(Material.TRIPWIRE_HOOK, "§fKlucz do skrzyni §bdiamentowej", "§eTego klucza mozesz uzyc w skrzyni", "§bdiamentowej§e, kliknij w skrzynie, a nastepnie", "§ekliknij hak aby otworzyc!");

	@Override
	public void onEnable() {
		DropFromChests.init();
		super.onEnable();
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		DropFromChests.clearLoot();
		super.onDisable();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().toLowerCase().equals("key")) {
			if(sender.hasPermission("loot.key")) {
				if(args.length > 1) {
					ArrayList<Player> p = new ArrayList<Player>();
					if(args[1].toLowerCase().equals("@all")) {
						for(Player d : Bukkit.getOnlinePlayers()) {
							p.add(d);
						}
					} else {
						p.add(Bukkit.getPlayerExact(args[1]));
					}
					int i = 0;
					if(args.length > 2) {
						while(i < Integer.parseInt(args[2])) {
							i++;
						}
					} else {
						i = 1;
					}
					ItemStack key = null;
					if(args[0].toLowerCase().equals("iron")) key = keyIron;
					if(args[0].toLowerCase().equals("gold")) key = keyGold;
					if(args[0].toLowerCase().equals("diamond")) key = keyDiamond;
					for(Player d : p) {
						for(int j = 0; j < i; j++) {
							d.getInventory().addItem(key);
						}
						d.sendTitle("§6§lKlucze", "§eOtrzymales " + i + "x " + key.getItemMeta().getDisplayName());
					}
				}
			}
		}
		return super.onCommand(sender, command, label, args);
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void openLootChest(PlayerInteractEvent e) {
		if(e.getAction() == e.getAction().RIGHT_CLICK_BLOCK || e.getAction() == e.getAction().LEFT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType().equals(Material.CHEST)) {
				Block b = e.getClickedBlock().getRelative(BlockFace.DOWN);
				Block b2 = b.getRelative(BlockFace.DOWN);
				if(b.getType().equals(Material.IRON_BLOCK) && b2.getType().equals(Material.BARRIER)) {
					e.setCancelled(true);
					GUI.iron(e.getPlayer());
				} if(b.getType().equals(Material.GOLD_BLOCK) && b2.getType().equals(Material.BARRIER)) {
					e.setCancelled(true);
					GUI.gold(e.getPlayer());
				} if(b.getType().equals(Material.DIAMOND_BLOCK) && b2.getType().equals(Material.BARRIER)) {
					e.setCancelled(true);
					GUI.diamond(e.getPlayer());
				}
			}
		}
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getView().getTitle().contains("§fSkrzynia zelazna -")) {
			e.setCancelled(true);
			if(e.getView().getTitle().contains("Menu")) {
				if(e.getRawSlot() == 11) {
					GUI.ironloot((Player) e.getWhoClicked());
				} if(e.getRawSlot() == 15) {
					DropFromChests.roll(DropFromChests.lootI, (Player) e.getWhoClicked());
				}
			}
		} if(e.getView().getTitle().contains("§eSkrzynia zlota -")) {
			e.setCancelled(true);
			if(e.getView().getTitle().contains("Menu")) {
				if(e.getRawSlot() == 11) {
					GUI.goldloot((Player) e.getWhoClicked());
				} if(e.getRawSlot() == 15) {
					DropFromChests.roll(DropFromChests.lootG, (Player) e.getWhoClicked());
				}
			}
		} if(e.getView().getTitle().contains("§bSkrzynia diamentowa -")) {
			e.setCancelled(true);
			if(e.getView().getTitle().contains("Menu")) {
				if(e.getRawSlot() == 11) {
					GUI.diamondloot((Player) e.getWhoClicked());
				} if(e.getRawSlot() == 15) {
					DropFromChests.roll(DropFromChests.lootD, (Player) e.getWhoClicked());
				}
			}
		}
	}

}
