package org._Shane.Utils.Other;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Misc
{
    /**
     * @param input Regular message turned into a clickable message; When players click this message, they will perform the command desired.
     * @return the new link message.
    */
    public static String toMCLink(String input, boolean messageUnderlined, String commandToRun)
    {
        input = "{text:\"" + colourize(input) + "\", underlined:" + messageUnderlined + ", clickEvent:{ action:run_command, value:\"" + commandToRun + "\" }}";        
        return input;
    }
    
    /**
     *
     * @param input Regular message containing char '&' will be turned into a Minecraft ColorCode EX: &7 -> (§7 / ChatColor.GRAY).
     * @return input after color codes correctly added.
     */
    public static String colourize(String input)
    {
        input = ChatColor.translateAlternateColorCodes('&', input);
        return input;
    }

    /**
     *
     * @param input Regular message containing ColorCode chars '§' to be stripped out of the message.
     * @return input after removing color codes. (Left with blank message.)
     */
    public static String stripColour(String input)
    {
        input = ChatColor.stripColor(input);
        return input;
    }

    /**
     *
     * @param player The player to gather all of his/her drops.
     * @return new List of Type ItemStack from the players inventory.
     */
    public static List<ItemStack> getDrops(Player player)
    {
        List<ItemStack> drops = new ArrayList<ItemStack>();
        //Loops through the default 36 main inventory slots and gathers what they contain.
        for (ItemStack is : player.getInventory())
        {
            if (is == null)
                continue;
            drops.add(is);
        }
        return drops;
    }
}
