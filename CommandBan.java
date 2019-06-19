package me.serverproxy.staffhelper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBan implements CommandExecutor {
	
	Main plugin;
	   
    public CommandBan(Main instance){
        plugin = instance;
    }
    
    public String colorize(String str)
    {
        return str.replace('&', '§');
    }


	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		
		
		if(!(sender.hasPermission("staff.ban"))) {
			sender.sendMessage(ChatColor.RED + "You do not have the correct permissions!");
			return true;
		}
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Specify a player.");
			return true;
		}
		OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
				if (target == null) {
					 Bukkit.getOfflinePlayer(args[0]).setBanned(true);
					
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
			String username = target.getName();
			String banreason = reason;
			if(target.isOnline()) {
			    	Player onlineTarget = target.getPlayer();
			    	onlineTarget.kickPlayer("&8&l---------&7&l[&9StaffHelper&7&l]&8&l--------- \n" + "&c&lUsername: " + target.getName() + "\n&c&lReason for Ban: " + "&b&l" + banreason + "&8&l---------&7&l[&9StaffHelper&7&l]&8&l---------");
			    }
				
				
			    
				sender.sendMessage(ChatColor.BLUE + target.getName() + " " + "has been banned.");
				
		
				plugin.getConfig().set(username + ".reason", banreason);
				
		return true;
	}

   
}
