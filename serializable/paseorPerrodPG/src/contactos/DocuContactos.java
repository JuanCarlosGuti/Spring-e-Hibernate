package contactos;

import paseosDePerro.Perro;

import java.io.*;
import java.util.ArrayList;

public class DocuContactos {
    public static void main(String[] args) {
        Contacto c1 = new Contacto("juan","juan@gmail.com", 35699897);
        Contacto c2 = new Contacto("carlo","jucarlo@gmail.com", 3564567);
        Contacto c3 = new Contacto("uanj","jcagh@gmail.com", 35542171);

        ArrayList<Contacto> lista1 = new ArrayList<>();
        ArrayList<Contacto> lista2 = new ArrayList<>();

        lista1.add(c1);
        lista1.add(c3);

        lista2.add(c1);
        lista2.add(c2);
        lista2.add(c3);


        try {
            FileOutputStream fil = new FileOutputStream("contactos.txt");
            ObjectOutputStream archi = new ObjectOutputStream(fil);

            archi.writeObject(lista1);
            archi.writeObject(lista2);

            archi.close();

            FileInputStream file = new FileInputStream("contactos.txt");
            ObjectInputStream archin = new ObjectInputStream(file);

            ArrayList<Contacto> lista;
            for (int i = 0; i<2; i++){
                System.out.println("Lista "+(i+1));
                System.out.println("===========");
                lista = (ArrayList<Contacto>) archin.readObject();
                for (Contacto c: lista
                     ) {
                    System.out.println(c);
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
