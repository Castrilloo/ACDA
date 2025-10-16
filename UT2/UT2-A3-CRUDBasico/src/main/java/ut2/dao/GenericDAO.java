package ut2.dao;

import java.lang.classfile.Interfaces;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T,K>{
    void insertar(T entity) throws SQLException;
    List<T> obtenerTodos() throws SQLException;
    T obtenerPorID(K id) throws SQLException;
    void actualizar(T entity) throws SQLException;
    void eliminar(K id) throws SQLException;

}
