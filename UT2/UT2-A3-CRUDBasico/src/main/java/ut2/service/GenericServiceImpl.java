package ut2.service;

import ut2.dao.GenericDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class GenericServiceImpl <T,K> implements GenericService<T,K>{

    private final GenericDAO<T,K> genericDAO;
    private static final Logger logger = LogManager.getLogger(GenericServiceImpl.class);

    public GenericServiceImpl(GenericDAO<T, K> genericDAO) {
        this.genericDAO = genericDAO;
    }

    @Override
    public int insertar(T entity) {
        try {
            genericDAO.insertar(entity);
            logger.info("Insercion correcta de {}", entity.getClass().getName());
        }catch (SQLException e){
            logger.error("Error al insertar {} en la BD: ", entity.getClass().getName(), e.fillInStackTrace());
            return -1;
        }
        return 0;
    }

    @Override
    public List<T> obtenerTodos() {
        List<T> resultado = new ArrayList<T>();
        try{
            genericDAO.obtenerTodos();
        }catch (SQLException e){
            logger.error("Error al obtener todos los registros en la BD", e.fillInStackTrace());
        }
        return resultado;
    }

    @Override
    public T obtenerPorId(K id) {
        T resultado= null;
        try {
            resultado = genericDAO.obtenerPorID(id);
        }catch (SQLException e){
            logger.error("Error al obtener el registro '{}' en la BD", id, e.fillInStackTrace());
        }
        return resultado;
    }

    @Override
    public int actualizar(T entity) {
        return 0;
    }

    @Override
    public int eliminar(K id) {
        try{
            genericDAO.eliminar(id);
            logger.info("Eliminacion correcta de id {}",id);
        }catch (SQLException e){
            logger.error("Error al eliminar id {} en la BD: ", id, e.fillInStackTrace());
            return -1;
        }



        return 0;
    }
}
