package paseosDePerro;

import java.io.*;
import java.util.ArrayList;

public class Paseo {
    public static void main(String[] args) {


        Perro p1 = new Perro("dingo","calle",5,"calle32");
        Perro p2 = new Perro("fido","pastor",3,"calle35");
        Perro p3 = new Perro("venuz","Aleman",13,"ca 25");
        Perro p4 = new Perro("dif","coker",8,"avenida 12");


        ArrayList<Perro> lunes= new ArrayList<>();
        ArrayList<Perro> Martes= new ArrayList<>();
        ArrayList<Perro> Miercoles= new ArrayList<>();
        ArrayList<Perro> Jueves= new ArrayList<>();
        ArrayList<Perro> viernes= new ArrayList<>();

        lunes.add(p1);
        Miercoles.add(p1);
        viernes.add(p1);

        lunes.add(p2);
        Martes.add(p2);
        Miercoles.add(p2);
        Jueves.add(p2);

        Miercoles.add(p3);
        Jueves.add(p3);
        viernes.add(p3);

        lunes.add(p4);
        Martes.add(p4);
        Miercoles.add(p4);
        Jueves.add(p4);
        viernes.add(p4);

        try {
            FileOutputStream file = new FileOutputStream("perros.dat");
            ObjectOutputStream archi = new ObjectOutputStream(file);


            archi.writeObject(lunes);
            archi.writeObject(Martes);
            archi.writeObject(Miercoles);
            archi.writeObject(Jueves);
            archi.writeObject(viernes);

            archi.close();

            FileInputStream filin = new FileInputStream("perros.dat");
            ObjectInputStream archin = new ObjectInputStream(filin);

            ArrayList<Perro> dia;

            for (int i=0; i<5;i++ ){
                System.out.println("Dia: "+i+1);
                System.out.println("================");
                dia = (ArrayList<Perro>) archin.readObject();
                for (Perro p: dia
                     ) {
                    System.out.println(p);
                    
                }
            }
            archin.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }



}
