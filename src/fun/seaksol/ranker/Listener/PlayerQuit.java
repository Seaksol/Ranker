package fun.seaksol.ranker.Listener;

import fun.seaksol.ranker.Main;
import fun.seaksol.ranker.Utils.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    private final Main main;

    @EventHandler
    public boolean onPlayerQuit(PlayerQuitEvent event) {
        FileConfiguration config = main.getConfig();
        Player player = event.getPlayer();
        event.setQuitMessage(Utils.color(config.getString("quit-msg")).replace("%player%", player.getName()));
        return true;
    }
    public PlayerQuit(Main main) {
        this.main = main;
    }
}
