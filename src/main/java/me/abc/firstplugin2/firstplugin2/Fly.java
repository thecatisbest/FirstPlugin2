package me.abc.firstplugin2.firstplugin2;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor  {

    private FirstPlugin2 plugin;

    public Fly(FirstPlugin2 plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("launch") || label.equalsIgnoreCase("lch")) {
            if (!(sender instanceof Player)) {
            sender.sendMessage("*console goes flying*");
                return true;
            }
            Player player = (Player) sender;

            if (args.length == 0) {
                // /launch
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("message")));
                player.setVelocity(player.getLocation().getDirection().setY(1));

                return true;
            }

            // /launch <number>
            if (isNum(args[0])) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("message")));
                player.setVelocity(player.getLocation().getDirection().setY(Integer.parseInt(args[0])));
            }
            else {
                player.sendMessage(ChatColor.RED + "Usage: /launch <number-vaule>");
            }
            return true;
        }
        return false;
    }

    public boolean isNum(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

