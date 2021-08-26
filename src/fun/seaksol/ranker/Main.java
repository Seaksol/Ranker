package fun.seaksol.ranker;

import fun.seaksol.ranker.Listener.*;
import fun.seaksol.ranker.Utils.Utils;
import fun.seaksol.ranker.commands.ColorMsg;
import fun.seaksol.ranker.commands.Ranker;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import java.io.File;

public class Main extends JavaPlugin {
    private FileConfiguration rankConfig;
    private FileConfiguration colorConfig;

    @Override
    public void onLoad() {
        getLogger().info(getDescription().getFullName() + " Loaded");
    }

    @Override
    public void onEnable() {
        if(getConfig().getBoolean("join-listener"))
            getServer().getPluginManager().registerEvents(new PlayerJoinMsg(this), this);

        if(getConfig().getBoolean("quit-listener"))
            getServer().getPluginManager().registerEvents(new PlayerQuitMsg(this), this);

        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(this), this);
        getServer().getPluginManager().registerEvents(new Chat(this), this);
        getCommand("colormsg").setExecutor(new ColorMsg(this));
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
        File colorFile = new File(getDataFolder(), "colormsg.yml");
        if(!rankFile.exists()) saveResource("rank.yml", true);
        if(!colorFile.exists()) saveResource("colormsg.yml", true);
        rankConfig = YamlConfiguration.loadConfiguration(rankFile);
        colorConfig = YamlConfiguration.loadConfiguration(colorFile);
    }

    public void registerScoreboard(String player, String ranker, Boolean enable) {
        if(enable) {
            Scoreboard sc = getServer().getScoreboardManager().getMainScoreboard();
            Team rank = sc.registerNewTeam(player);
            rank.allowFriendlyFire();
            rank.setPrefix(Utils.color(ranker + "&f "));
            rank.addEntry(player);
        }
        else {
            Scoreboard sc = getServer().getScoreboardManager().getMainScoreboard();
            Team rank = sc.getTeam(player);
            rank.unregister();
        }
    }

    public boolean isTeam(String team) {
        Scoreboard sc = getServer().getScoreboardManager().getMainScoreboard();
        return sc.getTeam(team) != null;
    }

    public FileConfiguration getRankConfig() {
        return rankConfig;
    }

    public FileConfiguration getColorConfig() {
        return colorConfig;
    }
}
