package net.marsstation.cooking.mixin;

// Pferde-Drops werden über die Loot-Table in
// data/minecraft/loot_tables/entities/horse.json gesteuert.
// Diese Datei ist ein Platzhalter - die Loot Table Methode ist sauberer
// und benötigt keinen Mixin für einfache Drop-Änderungen.

// Falls du trotzdem den Mixin brauchst (z.B. für besondere Logik),
// kannst du ihn hier wieder aktivieren.

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.entity.passive.HorseEntity;

@Mixin(HorseEntity.class)
public class HorseMixin {
    // Leer - Drops via Loot Table geregelt
}
