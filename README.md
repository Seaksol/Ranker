# Ranker
一个简单的 Minecraft 称号插件, 适用于 1.8.X 的版本

## Command
本插件目前最新正式版本为 `1.1.0` 版本

### _/ranker_

使用参数如下:

_add, set, remove, help_

  使用 `add` 参数时, 会在 *ranker.yml* 下产生新 Path , 即 **%player%-rank : ''** 

***eg. /ranker add Seaksol***

  使用 `set` 参数时, 会更改 *ranker.yml* 下 **%player%-rank** 的值 

***eg. /ranker set Seaksol &6[Author]***

  使用 `remove` 参数时, 会删除 *ranker.yml* 下 **%player%-rank** 的 Path 和值
  
***eg. /ranker remove Seaksol***

  使用 `help` 参数时, 会弹出帮助菜单
  
***eg. /ranker help***

### _/colormsg_

在 **1.1.0** 版本中, 增加了彩色聊天文本的支持, _/colormsg_ 命令使用参数如下:

_set, remove, help_

  使用 `set` 参数时, 会在 *colormsg.yml* 下产生新 Path , 并设置你所输入的值, 即 **%player%-msg : '<Value>'**
  
***eg. /colormsg set Seaksol &6***
  
  使用 `remove` 参数时, 会删除 *colormsg.yml* 下 **%player%-msg** 的 Path 和值
  
***eg. /colormsg remove Seaksol***
  
  使用 `help` 参数时, 会弹出帮助菜单
  
***eg. /colormsg help***
  

### Tips: 

本插件支持颜色参数, 并使用 `&` 替代了 `§`

***<s>由于 _setFormat()_ 方法原因, 本插件暂不能在称号内添加 `$`, `%` 字符, 请不要使用, 可能会出现意料外的 Bug</s>***
  
  ↑ *已于 1.1.0 更新中设置了对 `$` 和 `%` 字符的过滤*
  
***在使用 `/colormsg` 时, 设置的参数只能是颜色, 且必须包含 `&`, 已做过滤处理***

## Listener
本插件在 **1.1.0** 版本包含了四个对 *PlayerJoin / PlayerQuit* 事件的监听器

你可以在 _config.yml_ 下更改 `PlayerJoinMsg` 和 `PlayerQuitMsg` 监听器的设置, 下面是 _config.yml_ 中可更改的 Path

`join-msg` 即玩家加入时对**全局玩家**发送的信息

`quit-msg` 即玩家退出时对**全局玩家**发送的信息

`join-listener` 即 `PlayerJoinMsg` 监听器的开关, 填写 **Boolean** 值 **(True: 开启, False: 关闭)**

`quit-listener` 即 `PlayerQuitMsg` 监听器的开关, 填写 **Boolean** 值 **(True: 开启, False: 关闭)**

### Player Variable:
`%player%` 变量内置在 _config.yml_ 中, 其代表触发 *PlayerJoin / PlayerQuit* 事件的玩家名

你可以在 `join-msg`  或 `quit-msg` 中使用它

## Update
**以下为在 2021.8.26 23:00 已完成的 1.0.0 -> 1.1.0 的更新, 耗时两天**
  
<s>*预计下一更新内容:*</s>
  - **彩色可自定义聊天消息**   _2021.8.25 18:00 已开发完成(pre-Release 1.0.1)_
  - **Tab 可见的玩家称号**   _2021.8.26 16:40 已开发完成_
  - **悬浮于玩家头顶的称号** <s>**(暂搁置)**</s> _2021.8.26 22:40 已开发完成_
  - **临时 Rank** ***(将在下一版本添加)***
  
---------------------------
  
*预计下一更新内容:*
  - **支持对参数进行 Tab 补全**
  - **临时 Rank**

## Special Thanks
*于 2021.8.25 完成正式版 Ranker 1.0.0 的发布*

本人将会对此插件持续维护及更新, 但由于**学习原因**更新频率可能会**较慢**
  
非常感谢在插件开发过程中以下开发者对我的帮助 :
  - `FaintCloudy`
  - `橙纸Fy (ChengZhiFy)`
  - `Peaksol`

这是本人的第一个插件项目, 如有 *Bug* 欢迎在 *Issue* 中指出

***若你无法完成插件编译, Release 中含有编译完成的插件***
