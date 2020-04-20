package my.dmitrylovin.plugin.tfc.utils;

import java.util.HashMap;

import org.bukkit.Material;

public class PatternUtils {

	public static HashMap<Material,Integer> patterns = new HashMap<Material,Integer>();
	public static HashMap<Material,Integer> mcolors = new HashMap<Material,Integer>();
	public static HashMap<Material,Integer> pcolors = new HashMap<Material,Integer>();
	
	private static void setPaterns() {
		patterns.put(Material.STICK, 0);
		patterns.put(Material.BONE, 256);
		patterns.put(Material.GOLD_NUGGET, 512);
		patterns.put(Material.IRON_NUGGET, 768);
		patterns.put(Material.QUARTZ, 1024);
		patterns.put(Material.GUNPOWDER, 1280);
		patterns.put(Material.FEATHER, 1);
		patterns.put(Material.STRING, 257);
		patterns.put(Material.GLOWSTONE_DUST, 513);
		patterns.put(Material.INK_SAC, 769);
		patterns.put(Material.SUGAR, 1025);
		patterns.put(Material.SLIME_BALL, 1281);
	}
	
	private static void setColors() {
		mcolors.put(Material.WHITE_DYE,0);
		mcolors.put(Material.ORANGE_DYE,65536);
		mcolors.put(Material.MAGENTA_DYE,131072);
		mcolors.put(Material.LIGHT_BLUE_DYE,196608);
		mcolors.put(Material.YELLOW_DYE,262144);
		mcolors.put(Material.LIME_DYE,327680);
		mcolors.put(Material.PINK_DYE,393216);
		mcolors.put(Material.GRAY_DYE,458752);
		mcolors.put(Material.LIGHT_GRAY_DYE,524288);
		mcolors.put(Material.CYAN_DYE,589824);
		mcolors.put(Material.PURPLE_DYE,655360);
		mcolors.put(Material.BLUE_DYE,720896);
		mcolors.put(Material.BROWN_DYE,786432);
		mcolors.put(Material.GREEN_DYE,851968);
		mcolors.put(Material.RED_DYE,917504);
	}
	
	private static void setPColors() {
		pcolors.put(Material.WHITE_DYE,0);
		pcolors.put(Material.ORANGE_DYE,16777216);
		pcolors.put(Material.MAGENTA_DYE,33554432);
		pcolors.put(Material.LIGHT_BLUE_DYE,50331648);
		pcolors.put(Material.YELLOW_DYE,67108864);
		pcolors.put(Material.LIME_DYE,83886080);
		pcolors.put(Material.PINK_DYE,100663296);
		pcolors.put(Material.GRAY_DYE,117440512);
		pcolors.put(Material.LIGHT_GRAY_DYE,134217728);
		pcolors.put(Material.CYAN_DYE,150994944);
		pcolors.put(Material.PURPLE_DYE,167772160);
		pcolors.put(Material.BLUE_DYE,184549376);
		pcolors.put(Material.BROWN_DYE,201326592);
		pcolors.put(Material.GREEN_DYE,218103808);
		pcolors.put(Material.RED_DYE,234881024);
	}
	
	
	public static void setupPaterns() {
		setPaterns();
		setColors();
		setPColors();
	}
	
	public static Integer getColor(Material material) {
		return mcolors.get(material);
	}
	
	public static Integer getPColor(Material material) {
		return pcolors.get(material);
	}
	
	public static Integer getPattern(Material material) {
		return patterns.get(material);
	}
	
	public static void clearCache() {
		patterns.clear();
		mcolors.clear();
		pcolors.clear();
	}

	public static int getVariant(Material key, Material key2, Material key3) {

		int result = patterns.get(key);
		result += mcolors.get(key2);
		result += pcolors.get(key3);
		
		return result;
	}
}
