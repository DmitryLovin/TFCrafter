package my.dmitrylovin.plugin.tfc.recipes;

import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import my.dmitrylovin.plugin.tfc.TFCrafter;
import my.dmitrylovin.plugin.tfc.utils.PatternUtils;
import net.minecraft.server.v1_15_R1.NBTTagCompound;

public class FishRecipes {
	public static void setupRecipes() {
		
		for (Entry<Material, Integer> pEntry : PatternUtils.patterns.entrySet()) {
			for (Entry<Material, Integer> mEntry : PatternUtils.mcolors.entrySet()) {
				for (Entry<Material, Integer> cEntry : PatternUtils.pcolors.entrySet()) {
					ItemStack bukket = new ItemStack(Material.TROPICAL_FISH_BUCKET);
					net.minecraft.server.v1_15_R1.ItemStack stack = CraftItemStack.asNMSCopy(bukket);
					NBTTagCompound tag = stack.getOrCreateTag();
					
					int variant = PatternUtils.getVariant(pEntry.getKey(),mEntry.getKey(),cEntry.getKey());
					
					tag.setInt("BucketVariantTag", variant);
					stack.setTag(tag);

					bukket = CraftItemStack.asBukkitCopy(stack);
					
					ShapedRecipe tFish = new ShapedRecipe(new NamespacedKey(TFCrafter.instance,"tfc-"+variant),bukket);
					tFish.shape(" % ","BF#"," $ ");
					tFish.setIngredient('%', mEntry.getKey());
					tFish.setIngredient('B', Material.WATER_BUCKET);
					tFish.setIngredient('F', Material.TROPICAL_FISH);
					tFish.setIngredient('$', cEntry.getKey());
					tFish.setIngredient('#', pEntry.getKey());
					TFCrafter.instance.getServer().addRecipe(tFish);
				}
			}
		}		
	}
	
}
