# Ranker
一个简单的 Minecraft 称号插件, 适用于 1.8.X 的版本

## Command
本插件目前为 **1.0.0** 版本, 使用参数如下:

_add, set, remove, help_

  使用 _add_ 参数时, 会在 *ranker.yml* 下产生新 Path , 即 **%player%-rank : ''** 

***eg. /ranker add Seaksol***

  使用 _set_ 参数时, 会更改 *ranker.yml* 下 **%player%-rank** 的值 

***eg. /ranker set Seaksol &6[Author]***

  使用 _remove_ 参数时, 会删除 *ranker.yml* 下 **%player%-rank** 的 Path 和值 
  
***eg. /ranker remove Seaksol***

### Tips: 

本插件支持颜色参数, 并使用 **&** 替代了 **§**

***由于 _setFormat()_ 方法原因, 本插件暂不能在称号内添加 '$', '%' 字符, 请不要使用, 可能会出现意料外的 Bug***

## Listener
本插件在 **1.0.0** 版本包含了两个对 *PlayerJoin / PlayerQuit* 事件的监听器

你可以在 _config.yml_ 下更改监听器的设置, 下面是 _config.yml_ 中可更改的 Path

*join-msg:* 即玩家加入时对**全局玩家**发送的信息

*quit-msg:* 即玩家退出时对**全局玩家**发送的信息

*join-listener:* 即监听 *PlayerJoin* 事件监听器的开关, 填写 **Boolean** 值 **(True: 开启, False: 关闭)**

*quit-listener:* 即监听 *PlayerQuit* 事件监听器的开关, 填写 **Boolean** 值 **(True: 开启, False: 关闭)**

### Player Variable:
**%player%** 变量内置在 _config.yml_ 中, 其代表触发 *PlayerJoin / PlayerQuit* 事件的玩家名

你可以在 *join-msg*  或 *quit-msg* 中使用它

## Update / Special Thanks
*于 2021.8.25 完成正式版 Ranker 1.0.0 的发布*

本人将会对此插件持续维护及更新, 但由于**学习原因**更新频率可能会**较慢**

*预计下一更新内容:*
  - **彩色可自定义聊天消息**   _2021.8.25 18:00 已开发完成_
  - **Tab 可见的玩家称号**
  - **悬浮于玩家头顶的称号**

非常感谢在插件开发过程中以下开发者对我的帮助 :
  - FaintCloudy
  - 橙纸Fy (ChengZhiFy)
  - Peaksol

这是本人的第一个插件项目, 如有 *Bug* 欢迎在 *Issue* 中指出

***若你无法完成插件编译, 仓库内 Jar 文件夹或 Release 中含有编译完成的插件***
