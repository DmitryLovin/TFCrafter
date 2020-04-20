package my.dmitrylovin.plugin.tfc;

import org.bukkit.plugin.java.JavaPlugin;

import my.dmitrylovin.plugin.tfc.recipes.FishRecipes;
import my.dmitrylovin.plugin.tfc.utils.PatternUtils;

public class TFCrafter extends JavaPlugin{
	
	public static TFCrafter instance;
	
	@Override
	public void onEnable() {
		instance = this;
		this.getLogger().info("adding data to cache...");
		if(PatternUtils.setupPaterns()) {
			this.getLogger().info("...done");
			this.getLogger().info("setup recipes...");
			FishRecipes.setupRecipes();
			this.getLogger().info("...done");
			this.getLogger().info("clear cache...");
			PatternUtils.clearCache();
			this.getLogger().info("...done");
			this.getLogger().info("TropicalFishCrafter enabled");	
		}
		else {
			disable();
		}
		
	}

	@Override
	public void onDisable() {
		this.getLogger().info("TropicalFishCrafter disabled");
	}

	public static void disable() {
		instance.setEnabled(false);
	}
}
