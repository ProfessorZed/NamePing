package me.zed.nameping;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NamePing extends JavaPlugin implements Listener{

	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onchat(PlayerChatEvent e) {
		String msg = e.getMessage();
		String name = e.getPlayer().getName();
		for(Player player : Bukkit.getOnlinePlayers()){
			if(msg.contains(player.getName())){
				e.setMessage(msg.replace(player.getName(), ChatColor.YELLOW + player.getName() + ChatColor.WHITE));
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
			}
		}
	}
}
