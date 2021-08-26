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

        if(main.getRankConfig().getString(player.getName() + "-rank") != null &&
                main.getColorConfig().getString(player.getName() + "-msg") != null) {
            String rank = Utils.color(main.getRankConfig().getString(player.getName() + "-rank"));
            String color = main.getColorConfig().getString(player.getName() + "-msg");
            event.setFormat(rank + Utils.color
                    (" &f" + player.getName() + " : " + color +
                            event.getMessage()));
            event.getPlayer().setPlayerListName(Utils.color(rank + "&f " + event.getPlayer().getName()));
            main.registerScoreboard(player.getName(),
                    main.getRankConfig().getString(player.getName() + "-rank"), true);
        }

        else if(main.getRankConfig().getString(player.getName() + "-rank") != null) {
            String rank = Utils.color(main.getRankConfig().getString(player.getName() + "-rank"));
            event.setFormat(rank + Utils.color(" &f" + player.getName() + " : " + event.getMessage()));
            event.getPlayer().setPlayerListName(Utils.color(rank + "&f " + event.getPlayer().getName()));
            main.registerScoreboard(player.getName(),
                    main.getRankConfig().getString(player.getName() + "-rank"), true);
        }

        else if(main.getColorConfig().getString(player.getName() + "-msg") != null) {
            String color = main.getColorConfig().getString(player.getName() + "-msg");
            event.setFormat(Utils.color(" &f" + player.getName() + " : " + color + event.getMessage()));
        }

        else {
            event.setFormat(Utils.color
                    (" &f" + player.getName() + " : " + event.getMessage()));
            event.getPlayer().setPlayerListName(event.getPlayer().getName());
        }

        return true;
    }

    public Chat(Main main) {
        this.main = main;
    }
}
