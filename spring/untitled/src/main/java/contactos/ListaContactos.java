package contactos;

import java.io.*;
import java.util.ArrayList;

public class ListaContactos {
    public static void main(String[] args) {

        Contacto c1 = new Contacto("juan","juan@gmail.com", 35699897);
        Contacto c2 = new Contacto("carlo","jucarlo@gmail.com", 3564567);
        Contacto c3 = new Contacto("uanj","jcagh@gmail.com", 35542171);


        ArrayList<Contacto> lista2 = new ArrayList<>();



        lista2.add(c1);
        lista2.add(c2);
        lista2.add(c3);


        try {
            FileOutputStream fil = new FileOutputStream("contactos.txt");
            ObjectOutputStream archi = new ObjectOutputStream(fil);


            archi.writeObject(lista2);

            archi.close();

            FileInputStream file = new FileInputStream("contactos.txt");
            ObjectInputStream archin = new ObjectInputStream(file);

            ArrayList<Contacto> lista;

                lista = (ArrayList<Contacto>) archin.readObject();
            System.out.println("Listado de contactos");
            System.out.println("=======================");
                for (Contacto c: lista
                ) {
                    System.out.println(c);
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
