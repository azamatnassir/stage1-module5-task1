package com.epam.mjc;

import java.util.*;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                if (!Character.isUpperCase(s.charAt(0)))
                    return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int length = x.size();
            for (int i = 0; i < length; i++) {
                if (x.get(i) % 2 == 0) {
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String str : values) {
                int length = Arrays.stream(str.split("[. ]")).filter(e -> !e.trim().isEmpty()).toArray(String[]::new).length;
                if (Character.isUpperCase(str.charAt(0)) && str.charAt(str.length() - 1) == '.' && length > 3) {
                    list.add(str);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : x) {
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>(list1);
            list.addAll(list2);
            return list;
        };
    }
}
