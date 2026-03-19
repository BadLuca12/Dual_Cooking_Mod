package net.marsstation.cooking.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.marsstation.cooking.CookingMod;

public class ModItems {

    // ═══════════════════════════════════════════════════════════
    // PFERDEFLEISCH (roh - dropp vom Pferd)
    // ═══════════════════════════════════════════════════════════
    public static final Item RAW_HORSE_MEAT = register("raw_horse_meat",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(3)
                .saturationModifier(0.3f)
                .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.4f)
                .build()
        ))
    );

    // ═══════════════════════════════════════════════════════════
    // LANDJÄGER (aus Pferdefleisch)
    // ═══════════════════════════════════════════════════════════
    public static final Item LANDJAEGER = register("landjaeger",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(8)
                .saturationModifier(0.8f)
                .build()
        ))
    );

    // ═══════════════════════════════════════════════════════════
    // GERICHTE - Gekochte Speisen
    // ═══════════════════════════════════════════════════════════

    // Gulasch
    public static final Item GOULASH = register("goulash",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(10)
                .saturationModifier(0.9f)
                .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 0), 0.6f)
                .build()
        ))
    );

    // Gemüsesuppe
    public static final Item VEGETABLE_SOUP = register("vegetable_soup",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(7)
                .saturationModifier(0.7f)
                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 0.5f)
                .build()
        ))
    );

    // Gebackenes Huhn mit Kräutern
    public static final Item HERB_CHICKEN = register("herb_chicken",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(9)
                .saturationModifier(0.85f)
                .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 800, 0), 0.4f)
                .build()
        ))
    );

    // Fischsuppe
    public static final Item FISH_STEW = register("fish_stew",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(8)
                .saturationModifier(0.75f)
                .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200, 0), 0.6f)
                .build()
        ))
    );

    // Festtagsbraten (Prestige-Gericht)
    public static final Item FESTIVE_ROAST = register("festive_roast",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(14)
                .saturationModifier(1.2f)
                .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400, 1), 0.8f)
                .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 0.8f)
                .build()
        ))
    );

    // Pilzrisotto
    public static final Item MUSHROOM_RISOTTO = register("mushroom_risotto",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(9)
                .saturationModifier(0.8f)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 0), 0.5f)
                .build()
        ))
    );

    // Pfannkuchen
    public static final Item PANCAKES = register("pancakes",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(6)
                .saturationModifier(0.6f)
                .alwaysEdible()
                .build()
        ))
    );

    // Teigbrot (selbst gebacken)
    public static final Item HOMEMADE_BREAD = register("homemade_bread",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(6)
                .saturationModifier(0.65f)
                .build()
        ))
    );

    // Schwarzwälder Kuchen (Dessert)
    public static final Item BLACK_FOREST_CAKE = register("black_forest_cake",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(5)
                .saturationModifier(0.5f)
                .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 0), 0.6f)
                .alwaysEdible()
                .build()
        ))
    );

    // Zutaten
    public static final Item DOUGH = register("dough",
        new Item(new Item.Settings())
    );

    public static final Item COOKED_HORSE_MEAT = register("cooked_horse_meat",
        new Item(new Item.Settings().food(
            new FoodComponent.Builder()
                .nutrition(7)
                .saturationModifier(0.7f)
                .build()
        ))
    );

    // ═══════════════════════════════════════════════════════════
    // ITEM GROUP
    // ═══════════════════════════════════════════════════════════
    public static final RegistryKey<ItemGroup> COOKING_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(CookingMod.MOD_ID, "cooking_group")
    );

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CookingMod.MOD_ID, name), item);
    }

    public static void registerItems() {
        // ItemGroup erstellen
        Registry.register(Registries.ITEM_GROUP, COOKING_GROUP_KEY,
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(LANDJAEGER))
                .displayName(Text.translatable("itemGroup.cookingmod.cooking_group"))
                .build()
        );

        // Items zur Gruppe hinzufügen
        ItemGroupEvents.modifyEntriesEvent(COOKING_GROUP_KEY).register(entries -> {
            entries.add(RAW_HORSE_MEAT);
            entries.add(COOKED_HORSE_MEAT);
            entries.add(LANDJAEGER);
            entries.add(DOUGH);
            entries.add(GOULASH);
            entries.add(VEGETABLE_SOUP);
            entries.add(HERB_CHICKEN);
            entries.add(FISH_STEW);
            entries.add(FESTIVE_ROAST);
            entries.add(MUSHROOM_RISOTTO);
            entries.add(PANCAKES);
            entries.add(HOMEMADE_BREAD);
            entries.add(BLACK_FOREST_CAKE);
        });

        CookingMod.LOGGER.info("Items registriert!");
    }
}
