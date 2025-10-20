package ut2.conection;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConection {

    private static final Logger logger = Logger.getLogger(DBConection.class.getName());

    private static DBConection instancia;

    private Connection conexion;

    private final String PUERTO = "3308";
    private final String ESQUEMA = "ut2_clase";
    private final String SGBD = "mysql";
    private final String url = "jdbc:"+SGBD +"://localhost:" + PUERTO +"/"+ESQUEMA + "?allowMultiQueries=true";
    private final String usuario = "root";
    private final String contrasena= "root";


    private DBConection(){
        try{
            conexion = DriverManager.getConnection(url,usuario,contrasena);
            logger.info("conexion exitosa a la base de datos");
        }catch (SQLException e){
            logger.severe("Error al conectar a la base de datos: "+ e.getMessage());
        }
    }

    public static DBConection getInstancia(){
        if (instancia==null){
            instancia = new DBConection();
        }
        return instancia;
    }

    public Connection getConexion(){
        return conexion;
    }
}
