package fun.seaksol.ranker.Listener;

import fun.seaksol.ranker.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    private final Main main;

    @EventHandler
    public boolean onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if(main.getRankConfig().getString(player.getName() + "-rank") != null) {
            main.registerScoreboard(player.getName(),
                    main.getRankConfig().getString(player.getName() + "-rank"), false);
        }

        return true;
    }
    public PlayerQuit(Main main) {
        this.main = main;
    }
}
