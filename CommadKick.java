package me.serverproxy.staffhelper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKick implements CommandExecutor {
	
	 
	  public String colorize(String str)
	    {
	        return str.replace('&', '§');
	    }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(!(sender.hasPermission("staff.kick"))) {
			sender.sendMessage(ChatColor.RED + "You do not have the correct permissions!");
			return true;
		}
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Specify a player.");
			return true;
		}
		Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage(ChatColor.RED + "Player not found.");
				    return true;
				}
			if(args.length == 1) {
				sender.sendMessage(ChatColor.RED + "Specify a reason.");
				return true;
			}
			
			String s = "";
			for (int i = 1; i < args.length; i++) {
			s += args[i] + " ";
			}
			String reason = s.trim();
			String kickreason = reason;
				target.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&8&l---------&7&l[&9StaffHelper&7&l]&8&l--------- \n" + "&c&lUsername: " + target.getName() + "\n&c&lReason for Kick: " + "&b&l" + kickreason + "\n&8&l---------&7&l [&9StaffHelper&7&l]&8&l---------"));
				sender.sendMessage(ChatColor.BLUE + target.getName() + " " + "has been kicked.");
				
		
		
	
		return true;
	}

}
