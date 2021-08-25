package fun.seaksol.ranker.commands;

import fun.seaksol.ranker.Main;
import fun.seaksol.ranker.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import java.io.File;
import java.io.IOException;

public class ColorMsg implements CommandExecutor {
    private final Main main;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 0)
            senderColor(commandSender);

        else if(strings[0].equals("help"))
            senderColor(commandSender);

        else if(strings[0].equals("set")) {
            if(strings.length == 1) {
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color("&4&l你没有输入玩家名及需要设置的颜色!"));
                commandSender.sendMessage(Utils.color("&6------------------"));
                }

            else if(strings.length == 2) {
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color("&4&l你没有输入需要设置的颜色!"));
                commandSender.sendMessage(Utils.color("&6------------------"));
            }

            else {
                if(!strings[2].contains("&")) {
                    commandSender.sendMessage(Utils.color("&6------------------"));
                    commandSender.sendMessage(Utils.color("&4&l输入的颜色值内不包含 '&' "));
                    commandSender.sendMessage(Utils.color("&6------------------"));
                }
                else {
                    main.getColorConfig().set(commandSender.getName() + "-msg", strings[2]);
                    commandSender.sendMessage(Utils.color("&6------------------"));
                    commandSender.sendMessage(Utils.color
                            ("&2&l成功地添加了玩家 %player%").replace("%player%", commandSender.getName()));
                    commandSender.sendMessage(Utils.color("&6------------------"));
                }
            }
        }
        else if(strings[0].equals("remove")) {
            if(main.getColorConfig().getString(commandSender.getName() + "-msg") != null) {
                main.getColorConfig().set(commandSender.getName() + "-msg", null);
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color
                        ("&2&l成功地删除了玩家 %player%").replace("%player%", commandSender.getName()));
            }
            else if(strings.length == 1) {
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color("&4&l你没有输入玩家名!"));
            }
            else {
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color("&4&l此玩家还没有被设置!"));
            }
            commandSender.sendMessage(Utils.color("&6------------------"));
        }
        else {
            senderColor(commandSender);
        }
        try {
            main.getColorConfig().save(new File(main.getDataFolder(), "colormsg.yml"));
            main.getRankConfig().load(new File(main.getDataFolder(), "colormsg.yml"));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return true;

    }

    private void senderColor(CommandSender commandSender) {
        commandSender.sendMessage(Utils.color("&6------------------"));
        commandSender.sendMessage(Utils.color("&eRanker-ColorMsg 帮助菜单"));
        commandSender.sendMessage(Utils.color("&b作者: 坠星"));
        commandSender.sendMessage(Utils.color("&8可用参数如下:"));
        commandSender.sendMessage(Utils.color("&b[set, remove, help]"));
        commandSender.sendMessage(Utils.color("&4彩色聊天文本设置时只能设置彩色字体!"));
        commandSender.sendMessage(Utils.color("&7eg: /colormsg set Seaksol [颜色]"));
        commandSender.sendMessage(Utils.color("请使用 '&' 来作为彩色符号"));
        commandSender.sendMessage(Utils.color("&6------------------"));
    }
    public ColorMsg(Main main) {
        this.main = main;
    }
}
