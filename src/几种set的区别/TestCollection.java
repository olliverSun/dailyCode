package 几种set的区别;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestCollection {
    public static void main(String[] args) {
        HashMap dictionary = new HashMap();
        dictionary.put("1","一");
        dictionary.put("2","二");


    }

    /**
     * linkedHashSet：插入顺序 且无重复的集
     */
    @Test
    public  void linkedHashSet(){
        LinkedHashSet<Integer> numberSet = new LinkedHashSet<>();
        numberSet.add(55);
        numberSet.add(2);
        numberSet.add(66);
        System.out.println(numberSet);
    }

//    插入无序，也是不重复
    @Test
    public void HashSet(){
        HashSet<Integer>numberSet = new HashSet();
        numberSet.add(55);
        numberSet.add(2);
        numberSet.add(66);
        System.out.println(numberSet);
    }

//    大小顺序且不重复
    @Test
    public void TreeSet(){
        TreeSet<Integer> numberSet = new TreeSet();
        numberSet.add(55);
        numberSet.add(2);
        numberSet.add(66);
        System.out.println(numberSet);
    }
}
