package com.bilibili40.chapter11;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * @date 2023-03-18
 * 并查集
 * 并查集优化，路径压缩
 */
public class UnionFindClass {
    //泛型，包裹并查集元素
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap; //key 元素 value 对应的包裹类
        public HashMap<Element<V>, Element<V>> fatherMap; //key 元素 value 链头的元素
        public HashMap<Element<V>, Integer> sizeMap; //key 元素 value 这个集合含有多少元素

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value); //包裹类
                elementMap.put(value, element); //记录元素对应的包裹类
                fatherMap.put(element, element); //开始时每个元素都指向自己
                sizeMap.put(element, 1); //开始时每条链长度都为1
            }
        }

        /**
         * 泛型方法
         * 找到根节点，并压缩路径
         *
         * @param element 查找的元素
         * @return 返回头部元素
         */
        private Element<V> findHead(Element<V> element) {
            Queue<Element<V>> path = new ArrayDeque<>();
            while (element != fatherMap.get(element)) { //找到根节点
                path.offer(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.poll(), element); //将路径上的元素都连接到根节点
            }
            return null;
        }

        /**
         * 两个元素是否在一个集合内
         *
         * @param a 元素
         * @param b 元素
         * @return 返回两个元素是否在一个集合内
         */
        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) { //并查集中含有ab元素
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        /**
         * 合并ab所在的两个集合
         *
         * @param a 元素
         * @param b 元素
         */
        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aFather = findHead(elementMap.get(a));
                Element<V> bFather = findHead(elementMap.get(b));
                if (aFather != bFather) {
                    Element<V> big = sizeMap.get(aFather) >= sizeMap.get(bFather) ? aFather : bFather; //比较size，获得含有元素数量更大的根节点
                    Element<V> small = big == aFather ? bFather : aFather;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(aFather) + sizeMap.get(bFather));
                    sizeMap.remove(small);
                }
                //ab在一个集合，不需要合并
            }
            //没有ab两个元素的记录，无法合并
        }
    }

}
