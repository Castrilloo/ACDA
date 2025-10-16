package ut2.dao;

import ut2.conection.DBConection;
import ut2.model.Videojuego;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VideojuegoDao  implements GenericDAO<Videojuego, Integer>{
    @Override
    public void insertar(Videojuego entity) throws SQLException {
        DBConection dbConection=DBConection.getInstancia();

        Statement statement = dbConection.getConexion().createStatement();
        statement.execute("INSERT INTO Videojuegos(titulo,plataforma,anio_lanzamiento,precio,deisponible) VALUES("
                +"'"+entity.getTitulo()+"',"
                +"'"+entity.getPlataforma()+"',"
                + entity.getAnioLanzamiento()+","
                + entity.getPrecio() + ","
                + entity.isDisponible()+");");
        statement.close();
    }

    @Override
    public List<Videojuego> obtenerTodos() throws SQLException {
        return List.of();
    }

    @Override
    public Videojuego obtenerPorID(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void actualizar(Videojuego entity) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }
}
