package fun.seaksol.ranker;

import fun.seaksol.ranker.Listener.PlayerJoin;
import fun.seaksol.ranker.Listener.Chat;
import fun.seaksol.ranker.Listener.PlayerQuit;
import fun.seaksol.ranker.commands.Ranker;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class Main extends JavaPlugin {
    private FileConfiguration rankConfig;

    @Override
    public void onLoad() {
        getLogger().info(getDescription().getFullName() + " Loaded");
    }

    @Override
    public void onEnable() {
        if(getConfig().getBoolean("join-listener"))
            getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);

        if(getConfig().getBoolean("quit-listener"))
            getServer().getPluginManager().registerEvents(new PlayerQuit(this), this);

        getServer().getPluginManager().registerEvents(new Chat(this), this);
        getCommand("ranker").setExecutor(new Ranker(this));
        getLogger().info("------------------");
        getLogger().info(getDescription().getFullName() + " Enabled");
        getLogger().info("------------------");
        registerConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("------------------");
        getLogger().info(getDescription().getFullName() + " Disabled");
        getLogger().info("------------------");
    }

    private void registerConfig() {
        saveDefaultConfig();
        File rankFile = new File(getDataFolder(), "rank.yml");
        if(!rankFile.exists()) saveResource("rank.yml", true);
        rankConfig = YamlConfiguration.loadConfiguration(rankFile);
    }

    public FileConfiguration getRankConfig() {
        return rankConfig;
    }
}
