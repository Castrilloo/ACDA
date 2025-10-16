package ut2;


import ut2.conection.DBConection;
import ut2.dao.VideojuegoDao;
import ut2.model.Videojuego;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static VideojuegoDao videojuegoDao=new VideojuegoDao();
    public static Videojuego videojuego=new Videojuego(
            0,
            "Hollow Knight",
            "Nintendo Switch",
            2020,
            19.95,
            true);

    public static void main(String[] args) throws SQLException {



        //insertar(videojuego);
        //mostrarTodos();
        //mostrarPorId(2);
        eliminar(2);

    }
    public static void insertar(Videojuego videojuego){
        VideojuegoDao videojuegoDao=new VideojuegoDao();
        try {
            videojuegoDao.insertar(new Videojuego(
                    videojuego.getId(),
                    videojuego.getTitulo(),
                    videojuego.getPlataforma(),
                    videojuego.getAnioLanzamiento(),
                    videojuego.getPrecio(),
                    videojuego.isDisponible()));
            System.out.println("Videojuego insertado correctamente");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void mostrarTodos() throws SQLException {
        List<Videojuego> videojuegos= videojuegoDao.obtenerTodos();
        for (int i = 0; i < videojuegos.size(); i++) {
            System.out.println(videojuegos.get(i).getTitulo());
        }
    }
    public static void mostrarPorId(int id) throws SQLException {
        Videojuego videojuego= videojuegoDao.obtenerPorID(id);
        System.out.println(videojuego.getTitulo());
    }
    public static void eliminar(int id){
        try{
            videojuegoDao.eliminar(id);
            System.out.println("Videojuego eliminado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}