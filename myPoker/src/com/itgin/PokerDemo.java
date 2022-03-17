package com.itgin;

import java.util.ArrayList;
import java.util.Collections;

/*
    需求：
        通过程序实现斗地主过程的洗牌，发牌和看牌

    思路：
        1.创建一个牌盒，也就是定义一个集合对象，用ArrayList集合实现
        2.在牌盒里装牌
        3.洗牌，也就是把牌打散，用Collections的shuffle()方法实现
        4.发牌，也就是遍历集合，给三个玩家发牌
        5.看牌，也就是三个玩家分别遍历自己的牌
 */
public class PokerDemo {
    public static void main(String[] args) {
//        1.创建一个牌盒，也就是定义一个集合对象，用ArrayList集合实现
        ArrayList<String> array = new ArrayList<>();

//        2.在牌盒里装牌
        /*
        ♦2，……
        ♣2，……
        ♠2，……
        ♥2，……
        🃏，🃏
        小王，大王
         */
        //定义两个数组
        //花色数组
        String[] colors = {"♦", "♣", "♠", "♥"};
        //点数数组
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String color : colors) {
            for (String number : numbers) {
                array.add(color + number);
            }
        }
        array.add("大王");
        array.add("小王");

        //洗牌
        Collections.shuffle(array);
//        System.out.println(array);

        //发牌
        ArrayList<String> player_1 = new ArrayList<>();
        ArrayList<String> player_2 = new ArrayList<>();
        ArrayList<String> player_3 = new ArrayList<>();
        ArrayList<String> dpArray = new ArrayList<>();//底牌

        for (int i = 0; i < array.size(); i++) {
            String poker = array.get(i);
            if (i >= array.size() - 3) {
                dpArray.add(poker);
            } else if (i % 3 == 0) {
                player_1.add(poker);
            } else if (i % 3 == 1) {
                player_2.add(poker);
            } else if (i % 3 == 2) {
                player_3.add(poker);
            }
        }
        //看牌
        lookPoker("高老板",player_1);
        lookPoker("小麻",player_2);
        lookPoker("绝绝子",player_3);
        lookPoker("dpArray",dpArray);

    }

    public static void lookPoker(String name, ArrayList<String> array) {
        System.out.print(name + "牌是：");

        for (String poker : array) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
