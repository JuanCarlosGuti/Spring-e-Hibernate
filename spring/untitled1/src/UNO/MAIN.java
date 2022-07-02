package UNO;

import java.sql.Array;

public class MAIN {
    public static void main(String[] args) {
       int[] nombre_array = new int[6];
       nombre_array[0]=8;
       nombre_array[1]=6;
       nombre_array[2]=4;
       nombre_array[3]=3;
       nombre_array[4]=3;
       nombre_array[5]=9;
       int[] array= new int[5];
       array[0]=6;
       array[1]=2;
       array[2]=3;
       array[3]=8;

        //System.out.println(opo.adjacentElementsProduct(nombre_array));
        //System.out.println(opo.Palindromeme("estse"));
        System.out.println(opo.firstDuplicate(nombre_array));

    }
    public int Consecutive (int[] statues){
        int[] m = new int[2];
        m = minNum(statues);
        int large = m[1] - m[0] + 1;
        return large - statues.length;
    }
    public int[] minNum(int[] array) {
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


}
