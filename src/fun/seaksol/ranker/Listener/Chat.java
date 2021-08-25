package fun.seaksol.ranker.Listener;

import fun.seaksol.ranker.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import fun.seaksol.ranker.Utils.Utils;

public class Chat implements Listener {
    private final Main main;

    @EventHandler
    public boolean onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(main.getRankConfig().getString(player.getName() + "-rank") != null) {
            String rank = Utils.color(main.getRankConfig().getString(player.getName() + "-rank"));
            event.setFormat(rank + Utils.color
                    (" &f" + player.getName() + " : " + event.getMessage()));
        }

        else {
            event.setFormat(Utils.color
                    (" &f" + player.getName() + " : " + event.getMessage()));
        }

        return true;
    }
    public Chat(Main main) {
        this.main = main;
    }
}
