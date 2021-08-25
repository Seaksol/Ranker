package fun.seaksol.ranker.commands;

import fun.seaksol.ranker.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import fun.seaksol.ranker.Utils.Utils;
import org.bukkit.configuration.InvalidConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ranker implements CommandExecutor {
    private final Main main;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 0) {
            commandSender.sendMessage(Utils.color("&6------------------"));
            commandSender.sendMessage(Utils.color("&4&l你没有输入参数"));
            senderHelp(commandSender);
        }

        else if(strings.length == 1) {
            if("help".equals(strings[0])) {
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color("&eRanker 帮助菜单"));
                commandSender.sendMessage(Utils.color("&b作者: 坠星"));
                senderHelp(commandSender);
            }

            else
                senderName(commandSender);
        }

        else if("add".equals(strings[0])) {

            if(main.getRankConfig().isString(strings[1] + "-rank")) {
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color
                        ("&4&l%player% 已经被添加过了").replace("%player%", strings[1]));
                commandSender.sendMessage(Utils.color("&6------------------"));
            }

            else {
                main.getRankConfig().set(strings[1] + "-rank","");
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color
                        ("&2&l成功添加了 %player%").replace("%player%", strings[1]));
                commandSender.sendMessage(Utils.color("&6------------------"));
            }

        }
        else if("set".equals(strings[0])) {

            if(!main.getRankConfig().isString(strings[1] + "-rank")) {
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color
                        ("&4&l%player% 还没有被添加").replace("%player%", strings[1]));
                commandSender.sendMessage(Utils.color("&6------------------"));
            }

            else {
                if(strings.length == 2) {
                    commandSender.sendMessage(Utils.color("&6------------------"));
                    commandSender.sendMessage(Utils.color("&4&l你没有输入称号名"));
                    commandSender.sendMessage(Utils.color("&6------------------"));
                }
                else {
                    if(strings[2].contains("$") || strings[2].contains("%")) {
                        commandSender.sendMessage(Utils.color("&6------------------"));
                        commandSender.sendMessage(Utils.color("&4&l称号名内含有非法字符"));
                        commandSender.sendMessage(Utils.color("&6------------------"));
                    }
                    else {
                        main.getRankConfig().set(strings[1] + "-rank", strings[2]);
                        commandSender.sendMessage(Utils.color("&6------------------"));
                        commandSender.sendMessage(Utils.color
                                ("&2&l%player% 的 Rank 设置被成功地更改了").replace("%player%", strings[1]));
                        commandSender.sendMessage(Utils.color("&6------------------"));
                    }
                }
            }

        }
        else if("remove".equals(strings[0])) {

            if(!main.getRankConfig().isString(strings[1] + "-rank")) {
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color
                        ("&4&l%player% 还没有被添加").replace("%player%", strings[1]));
                commandSender.sendMessage(Utils.color("&6------------------"));
            }

            else {
                main.getRankConfig().set(strings[1] + "-rank", null);
                commandSender.sendMessage(Utils.color("&6------------------"));
                commandSender.sendMessage(Utils.color
                        ("&2&l%player% 被成功地删除了").replace("%player%", strings[1]));
                commandSender.sendMessage(Utils.color("&6------------------"));
            }
        }

        else {
            commandSender.sendMessage(Utils.color("&6------------------"));
            commandSender.sendMessage(Utils.color("&4&l你输入了错误的参数"));
            senderHelp(commandSender);
        }
        try {
            main.getRankConfig().save(new File(main.getDataFolder(), "rank.yml"));
            main.getRankConfig().load(new File(main.getDataFolder(), "rank.yml"));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void senderHelp(CommandSender commandSender) {
        commandSender.sendMessage(Utils.color("&8可用参数如下:"));
        commandSender.sendMessage(Utils.color("&b[add, set, remove, help]"));
        commandSender.sendMessage(Utils.color("&7eg: /ranker set Seaksol &6[Author]"));
        commandSender.sendMessage(Utils.color("&fTips: 本插件支持颜色代码, 使用 '&'"));
        commandSender.sendMessage(Utils.color("&e请不要在称号里添加 '%', '$' 符号"));
        commandSender.sendMessage(Utils.color("&6------------------"));
    }
    private void senderName(CommandSender commandSender) {
        commandSender.sendMessage(Utils.color("&6------------------"));
        commandSender.sendMessage(Utils.color("&4&l你没有输入玩家名"));
        commandSender.sendMessage(Utils.color("&7eg: /ranker set Seaksol &6[Author]"));
        commandSender.sendMessage(Utils.color("&fTips: 本插件支持颜色代码, 使用 '&'"));
        commandSender.sendMessage(Utils.color("&e请不要在称号里添加 '%', '$' 符号"));
        commandSender.sendMessage(Utils.color("&6------------------"));
    }

    public Ranker(Main main) {
        this.main = main;
    }
}
