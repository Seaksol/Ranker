package fun.seaksol.ranker.Listener;

import fun.seaksol.ranker.Utils.Utils;
import fun.seaksol.ranker.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    private final Main main;

    @EventHandler
    public boolean onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(main.getRankConfig().getString(player.getName() + "-rank") != null) {
            String rank = Utils.color(main.getRankConfig().getString(player.getName() + "-rank"));
            player.setPlayerListName(Utils.color(rank + "&f " + player.getName()));
            main.registerScoreboard(player.getName(),
                    main.getRankConfig().getString(player.getName() + "-rank"), true);

        }

        else
            player.setPlayerListName(player.getName());

        return true;
    }

    public PlayerJoin(Main main) {
        this.main = main;
    }
}