package com.gungun.projects.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LamdaTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "a");
        map.put("price",500);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "a");
        map2.put("price",1500);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "b");
        map3.put("price",300);

        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        list.add(map);
        list.add(map2);
        list.add(map3);
        Map<String, List<Map<String, Object>>> user_id = list.stream().collect(Collectors.groupingBy(e -> e.get("name").toString()));
        System.out.println(user_id.toString());

    }
}
