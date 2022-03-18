package com.itgin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/*
    模拟斗地主2.0
    1.0中看牌，牌型是无序的，不便于看牌，所以升级版斗地主来了（发到手里的牌可以有序了）
    只是为了更多地用上这些集合的知识，还有很多其他方法可以实现
 */
public class PokerDemo02 {
    public static void main(String[] args) {
        //这次采用HashMap集合来存储牌和索引
        HashMap<Integer, String> hm = new HashMap<>();

        //ArrayList用来存储索引
        ArrayList<Integer> array = new ArrayList<>();

        //花色数组
        String[] colors = {"♦", "♣", "♥", "♠"};

        //点数数组（这里是按照斗地主中的牌大小排序的）
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //装牌
        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                hm.put(index, color + number);
                array.add(index);
                index++;
            }
        }
        hm.put(index, "小王");
        array.add(index);
        index++;
        hm.put(index, "大王");
        array.add(index);
        //洗牌
        Collections.shuffle(array);

        //为了保证发到玩家手里的牌是有序的，采用TreeSet集合收牌(发到手里的是索引)
        TreeSet<Integer> player_1 = new TreeSet<>();
        TreeSet<Integer> player_2 = new TreeSet<>();
        TreeSet<Integer> player_3 = new TreeSet<>();
        TreeSet<Integer> dyPoker = new TreeSet<>();

        //发牌
        for (int i = 0; i < array.size(); i++) {
            int x = array.get(i);
            if (i >= array.size() - 3) {
                dyPoker.add(x);
            } else if (i % 3 == 0) {
                player_1.add(x);
            } else if (i % 3 == 1) {
                player_2.add(x);
            } else if (i % 3 == 2) {
                player_3.add(x);
            }
        }

        //看牌
        lookPoker("Boss Gao", player_1, hm);
        lookPoker("Miss Ma", player_2, hm);
        lookPoker("Lee Hua", player_3, hm);
        lookPoker("dyPoker", dyPoker, hm);
    }

    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.print(name + "的牌是：");
        for (Integer key : ts) {
            String poker = hm.get(key);
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
