# JavaDemo
* 一个用来存放初学Java的仓库:smile:
* 存放了一些有意思的Java小项目:gift:
* :exclamation: 本仓库里所有代码除非特别说明，均为[B站黑马Java教程](https://www.bilibili.com/video/BV18J411W7cE)中的演示代码，只是用作练习。
* 还会持续更新……:relaxed: 
## 项目一
### 模拟斗地主:black_joker:
实现的功能：
  * 牌盒装牌
  * 洗牌
  * 抓牌
  * 看牌
目前是两个版本：
* 1.0 牌盒用ArrayList集合实现，洗牌用Collections.shuffle方法实现，抓牌普通for循环（带索引）实现，玩家和底牌一共用了4个ArrayList集合实现，看牌写了一个静态方法遍历ArrayList集合
* 2.0（:star2:同1.0的不同） 想要增加抓到手里的牌有序的功能，所以将牌盒改为HashMap数组来实现并将牌与索引相匹配，在发牌时改为发索引，在看牌时通过玩家手里的索引来到HashMap中寻找对应的牌
* 后续版本：还应该增加叫地主、出牌、记牌器、判定出牌是否符合游戏规则、判定输赢……等功能💕💕💕。
