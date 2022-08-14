package me.Ksever.loot;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Utils {
	
	public static void pushPlayer(double x, double y, double z, double multiply, Player p) {
		Vector v = new Vector(0, 0, 0);
		v.normalize();
		v.multiply(multiply);
		v.setX(x);
		v.setY(y);
		v.setZ(z);
		p.setVelocity(v);
	}

}
