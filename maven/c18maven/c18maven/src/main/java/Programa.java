import com.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Programa {
    public static void main(String[] args) {
        Connection connection= null;
        try{
            Conexion conexion = new Conexion();

            Class.forName("org.h2.Driver");
            connection= DriverManager.getConnection("jdbc:h2:~/" +
                    "bd_Clinica_Dental;INIT=RUNSCRIPT FROM 'create.sql'","root","");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
