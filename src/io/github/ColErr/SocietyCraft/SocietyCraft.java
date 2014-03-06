package io.github.ColErr.SocietyCraft;

import java.util.logging.Logger;
import javax.persistence.PersistenceException;

import net.milkbowl.vault.permission.Permission;

import io.github.ColErr.SocietyCraft.Database.*;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class SocietyCraft extends JavaPlugin {
	
	private final Logger log = this.getLogger();
    public static Permission perms = null;
	
	@Override
	public void onEnable(){
		
		if((getServer().getPluginManager().getPlugin("Vault") == null) && !setupVault()) {
			log.severe("Failed to hook Vault");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		if(!this.getDescription().isDatabaseEnabled()){
			log.severe("Database is not enabled in bukkit.yml");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		setupDatabase();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private boolean setupVault(){
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
	}
	
	private void setupDatabase(){
		try {
            getDatabase().find(Town.class).findRowCount();
            getDatabase().find(Chunk.class).findRowCount();
        } catch (PersistenceException ex) {
            System.out.println("Installing database for " + getDescription().getName() + " due to first time usage");
            installDDL();
        }
	}
}
