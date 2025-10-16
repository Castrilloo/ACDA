package ut2;


import ut2.conection.DBConection;
import ut2.dao.VideojuegoDao;
import ut2.model.Videojuego;

import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {


        VideojuegoDao videojuegoDao=new VideojuegoDao();
        try {
            videojuegoDao.insertar(new Videojuego(
                    0,
                    "Hollow Knight",
                    "Nintendo Switch",
                    2020,
                    19.95,
                    true));
            System.out.println("Videojuego insertado correctamente");
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}