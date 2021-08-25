package fun.seaksol.ranker.Listener;

import fun.seaksol.ranker.Utils.Utils;
import fun.seaksol.ranker.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    private final Main main;

    @EventHandler
    public boolean onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = main.getConfig();
        Player player = event.getPlayer();
        event.setJoinMessage(Utils.color(config.getString("join-msg")).replace("%player%", player.getName()));
        return true;
    }

    public PlayerJoin(Main main) {
        this.main = main;
    }
}