     //------------------------------------------ //
    // Plugin libre d'utilisation crée par nxyo. //
   //  Si vous utilisez PlaceholderAPI, merci   //
  //  de l'importer dans votre projet pour     //
 //           ne pas avoir de bug!            //
//------------------------------------------ //
package org.nxyo.chatformat;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin implements Listener {

    File newConfig;
    FileConfiguration newConfigz;
    @Override
    public void onEnable(){
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "ChatFormatter by nxyo");
        getServer().getPluginManager().registerEvents(this, this);
        newConfig = new File(getDataFolder(), "config.yml");
        newConfigz = YamlConfiguration.loadConfiguration(newConfig);
        saveNewConfig();
    }

    public void saveNewConfig(){
        try{
            newConfigz.save(newConfig);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setFormat(PlaceholderAPI.setPlaceholders(player,getConfig().getString("prefix") + " " + player.getDisplayName() + " " + getConfig().getString("suffix") + " " + getConfig().getString("separator") + " " + event.getMessage()));
    }

// Si vous utiliser un system de grade avec permission normal (non luckperms, ect..) vous pouvez utiliser cela :
//    @EventHandler
//    public void chatFormat(AsyncPlayerChatEvent event) {
//        Player player = event.getPlayer();
//        if(player.hasPermission("admin") {
//          event.setFormat("§cAdmin §f" + p.getDisplayName() + "§8> §f" + event.getMessage());
//        }
//        else if(player.hasPermission("player") {
//          event.setFormat("§7Joueur §f" + p.getDisplayName() + "§8> §f" + event.getMessage());
//        }
//    }

}
