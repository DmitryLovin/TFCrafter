package my.dmitrylovin.plugin.tfc.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import my.dmitrylovin.plugin.tfc.TFCrafter;

public class PatternUtils {

	public static HashMap<Material,Integer> patterns = new HashMap<Material,Integer>();
	public static HashMap<Material,Integer> mcolors = new HashMap<Material,Integer>();
	public static HashMap<Material,Integer> pcolors = new HashMap<Material,Integer>();
	
	private static boolean setPaterns() {
		
		File patternFile = new File(TFCrafter.instance.getDataFolder(), "patterns.yml");
		
        if(!patternFile.exists()) {
        	createNewFile(patternFile);	
        }
        YamlConfiguration patternConfig = YamlConfiguration.loadConfiguration(patternFile);
        patternConfig.options().copyDefaults(true);
		
        Material Kob = Material.getMaterial(patternConfig.getString("kob"));
        if(Kob==null) {
        	MissOption("kob");
        	return false;
        }  
        Material Snooper = Material.getMaterial(patternConfig.getString("snooper"));
        if(Snooper==null) {
        	MissOption("snooper");
        	return false;
        }
        Material Brinely = Material.getMaterial(patternConfig.getString("brinely"));
        if(Brinely==null) {
        	MissOption("brinely");
        	return false;
        }
        Material Sunstreak = Material.getMaterial(patternConfig.getString("sunstreak"));
        if(Sunstreak==null) {
        	MissOption("sunstreak");
        	return false;
        }
        Material Dasher = Material.getMaterial(patternConfig.getString("dasher"));
        if(Dasher==null) {
        	MissOption("dasher");
        	return false;
        }
        Material Spotty = Material.getMaterial(patternConfig.getString("spotty"));
        if(Spotty==null) {
        	MissOption("spotty");
        	return false;
        }
        Material Flopper = Material.getMaterial(patternConfig.getString("flopper"));
        if(Flopper==null) {
        	MissOption("flopper");
        	return false;
        }
        Material Glitter = Material.getMaterial(patternConfig.getString("glitter"));
        if(Glitter==null) {
        	MissOption("glitter");
        	return false;
        }
        Material Betty = Material.getMaterial(patternConfig.getString("betty"));
        if(Betty==null) {
        	MissOption("betty");
        	return false;
        }
        Material Stripey = Material.getMaterial(patternConfig.getString("stripey"));
        if(Stripey==null) {
        	MissOption("stripey");
        	return false;
        }
        Material Blockfish = Material.getMaterial(patternConfig.getString("blockfish"));
        if(Blockfish==null) {
        	MissOption("blockfish");
        	return false;
        }
        Material Clayfish = Material.getMaterial(patternConfig.getString("clayfish"));
        if(Clayfish==null) {
        	MissOption("clayfish");
        	return false;
        }

		patterns.put(Kob, 0);
		patterns.put(Sunstreak, 256);
		patterns.put(Snooper, 512);
		patterns.put(Dasher, 768);
		patterns.put(Brinely, 1024);
		patterns.put(Spotty, 1280);
		patterns.put(Flopper, 1);
		patterns.put(Stripey, 257);
		patterns.put(Glitter, 513);
		patterns.put(Blockfish, 769);
		patterns.put(Betty, 1025);
		patterns.put(Clayfish, 1281);
		return true;
	}
	
	private static void MissOption(String st) {
		TFCrafter.instance.getLogger().warning("Missing '"+st+"' in 'patterns.yml'\nTry to remove 'patterns.yml' or add/fix '"+st+"' option in file");
		TFCrafter.disable();
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
	
	
	public static boolean setupPaterns() {
		if(setPaterns()) {
			setColors();
			setPColors();
			return true;
		}
		else {
			return false;
		}
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
	
	private static void createNewFile(File file) {
    	final InputStream link = TFCrafter.instance.getResource("patterns.yml");
        try {
            Files.copy(link, file.getAbsoluteFile().toPath(), new CopyOption[0]);
        }
        catch (IOException e) {
            System.out.print("TFCrafter: Unable to make patterns file! Plugin will not enable.");
            TFCrafter.disable();
        }
    }
}
