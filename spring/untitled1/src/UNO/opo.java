package UNO;

import java.util.*;

public class opo {

        static int adjacentElementsProduct(int[] inputArray){
            int cont = 0;
            int product = 0;
            int largest = Integer.MIN_VALUE;
            while (cont < inputArray.length - 1) {
                product = inputArray[cont] * inputArray[cont + 1];
                cont++;
                if (product > largest)
                    largest = product;
            }
            return largest;






        }
    List groupDishes (String[][] dishes) {
        Map<String, Set> store = new TreeMap<>();
        List grouped = new ArrayList();
        for(String[] dish: dishes) {
            for(int i = 1; i< dish.length;i++) {
//Create a map for ingredient at first
                if(!store.containsKey(dish[i])) store.put(dish[i], new TreeSet());

                Set dishSet = store.get(dish[i]);
                dishSet.add(dish[i]);
            }
        }
        for(Map.Entry<String, Set> entrySet: store.entrySet()) {
            System.out.println(entrySet.getKey() + " -> " + entrySet.getValue());
            if(entrySet.getValue().size() > 1) {
                List l = new ArrayList();
                l.add(entrySet.getKey());
                for(Object o: entrySet.getValue()) l.add(o);
                grouped.add(l);
            }
        }
        return grouped;
    }

    static boolean Palindromeme (String inputString) {
        int i = inputString.length()-1;
        int j = 0;
        while(i!=j && j<i)
        {
            if(inputString.charAt(j++) != inputString.charAt(i--))
                return true;
        }
        return false;
    }
    static public int Consecutive (int[] statues){
        int[] m = new int[2];
        m = minNum(statues);
        int large = m[1] - m[0] + 1;
        return large - statues.length;
    }
    public static int[] minNum(int[] array) {
        int[] m = new int[2];
        m[0] = array[0];
        m[1] = array[0];
        for(int i= 1; i < array.length; i++) {
            if(m[0] > array[i])
                m[0] = array[i];
            if(m[1] < array[i])
                m[1] = array[i];
        }
        return m;
    }
    public static int firstDuplicate(int[] a){
        int returnValue = -1000;
        outerloop:
        for(int i = 1; i < a.length;i++)
        {
            for(int j = i - 1; j >= 0; j++)
            {
                if(a[i] == a[j])
                {
                    returnValue = a[i];
                    break outerloop;
                }
            }
        }
        if(returnValue == -1000)
        {
            returnValue = -1;
        }
        return returnValue;
    }




}

