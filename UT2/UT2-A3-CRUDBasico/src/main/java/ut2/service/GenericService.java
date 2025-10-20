package ut2.service;

import java.util.List;

public interface GenericService<T,K> {

    int insertar(T entity);

    List<T> obtenerTodos();

    T obtenerPorId(K id);

    int actualizar(T entity);

    int eliminar(K id);
}
