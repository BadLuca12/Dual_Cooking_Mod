package net.marsstation.cooking;

import net.fabricmc.api.ModInitializer;
import net.marsstation.cooking.item.ModItems;
import net.marsstation.cooking.recipe.ModRecipes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookingMod implements ModInitializer {
    public static final String MOD_ID = "cookingmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Mars Station Cooking Mod wird geladen...");
        ModItems.registerItems();
        ModRecipes.registerRecipes();
        LOGGER.info("Mars Station Cooking Mod geladen!");
    }
}
