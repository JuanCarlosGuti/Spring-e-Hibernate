package consultorio.com.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO <T>{
 T registrar(T t);
 List<T> listar() throws SQLException;
}
