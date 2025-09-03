package ru.overwrite.smallcapital;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReplacerExpansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getAuthor() {
        return "OverwriteMC";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "replacer";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        String[] values = params.split(";");
        if (values.length != 3) {
            return null;
        }
        String placeholderValue = PlaceholderAPI.setPlaceholders(player, "%" + values[0] + "%");
        String expectedValue = values[1];
        String replacementValue = values[2];
        if (placeholderValue.equals(expectedValue)) {
            return replacementValue;
        }
        return placeholderValue;
    }
}
