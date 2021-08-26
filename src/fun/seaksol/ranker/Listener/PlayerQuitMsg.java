package fun.seaksol.ranker.Listener;

import fun.seaksol.ranker.Main;
import fun.seaksol.ranker.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitMsg implements Listener {
    private final Main main;

    @EventHandler
    public boolean onPlayerQuitMsg(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(Utils.color
                (main.getConfig().getString("join-msg")).replace("%player%", player.getName()));
        return true;
    }

    public PlayerQuitMsg(Main main) {
        this.main = main;
    }
}
