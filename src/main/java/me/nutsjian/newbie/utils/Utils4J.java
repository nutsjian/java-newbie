package me.nutsjian.newbie.utils;

import java.util.*;

public class Utils4J {
    /**
     *
     *@Title:  ListToArray
     *@Description: list列表转换成二维数组
     *@Author: Administrator
     *@Since: 2018年1月7日下午2:01:25
     *@param: @param list
     *@param: @param KeyLenght每行的列数，按最长的计算
     *@param: @return
     *@return: Object[][]
     */
    public static Object[][] listMapToArray(List<Map<String, Object>> list, int keyLength) {
        if (null == list || list.isEmpty()) {
            return new Object[0][];
        }
        int size = list.size();
        Object[][] array = new Object[size][keyLength];
        for (int i = 0; i < size; i++) {
            //循环遍历所有行
            array[i] = list.get(i).values().toArray();  //每行的列数
        }
        return array;
    }


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("shanghai", Arrays.asList(1,2,3,4,5,6));
        map.put("beijing", Arrays.asList("a", "b", "c", "d", "e", "f"));

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);
        Object[][] result = listMapToArray(list, map.keySet().size());

        System.out.println(Arrays.toString(result[0]));

    }

}
