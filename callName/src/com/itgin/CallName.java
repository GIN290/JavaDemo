package com.itgin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
    ①创建字符缓冲输入流
    ②对象创建ArrayList集合对象
    ③调用字符缓冲输入流对象的方法读数据
    ④把读取到的字符串数据存储到集合中
    ⑤释放资源
    ⑥使用Random产生一个随机数，随机数的范围在:[0,集合的长度)
    ⑦把第6步产生的随机数作为索引到ArrayList集合中获取值
    ⑧把第7步得到的数据输出在控制台
 */
public class CallName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("callName\\names.txt"));

        ArrayList<String> array = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            array.add(line);
        }

        br.close();

        Random r = new Random();
        int index = r.nextInt(array.size());

        System.out.println("幸运儿是:>" + array.get(index));

    }
}
