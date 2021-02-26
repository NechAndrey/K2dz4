package K2dz4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        StartApp();
    }

    public static void StartApp() {
        String str = "swq";

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(-2);
        list.add(5);
        list.add(4);

        List<String> stringList = new ArrayList<>();
        stringList.add("yea");
        stringList.add("adv");
        stringList.add("no");

        //перевернуть строку
        ServiceString s = x -> new StringBuilder(x).reverse().toString();
        str = s.reverse(str);

        //найти строки которые начинаются на "а"
        ServiceStringList ser = x ->{
            List<String> result = new ArrayList<>();
            for (String z : x){
               if(z.indexOf("a") == 0){
                  result.add(z);
               }
            }
            return result;
        };

        //максимальное число в листе
        List<String> a = ser.search(stringList);
        ServiceInt iMax  = x -> { int max = 0;
            if(list.size()>0) {
                for (Integer i : list) {
                    max = Math.max(i,max);
                }
            }
            return max;};
        int max = iMax.ListApp(list);

        //найти среднее в листе
        ServiceInt iAverage = x ->{
            Collections.sort(list);
            return list.get(list.size()/2);};
        int average = iAverage.ListApp(list);

        //найти индекс в листе по объекту
        ServiceIntList inList = (x,listInt) ->{return listInt.indexOf(x);};
        int searchList = inList.search(5,list);
    }
    @FunctionalInterface
    interface ServiceString {
        String reverse(String s);
    }
    @FunctionalInterface
    interface ServiceInt{
        int ListApp(List<Integer> list);
    }

    @FunctionalInterface
    interface ServiceIntList{
        int search(int x,List<Integer> list);
    }

    @FunctionalInterface
    interface ServiceStringList{
        List<String> search(List<String> list);
    }
}
