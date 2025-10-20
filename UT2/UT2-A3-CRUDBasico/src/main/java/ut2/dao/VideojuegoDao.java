package ut2.dao;

import ut2.conection.DBConection;
import ut2.model.Videojuego;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideojuegoDao  implements GenericDAO<Videojuego, Integer>{
    @Override
    public void insertar(Videojuego entity) throws SQLException {
        DBConection dbConection = DBConection.getInstancia();
        String sql = "INSERT INTO Videojuegos(titulo, plataforma, anio_lanzamiento, precio, disponible) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = dbConection.getConexion().prepareStatement(sql);

        statement.setString(1, entity.getTitulo());
        statement.setString(2, entity.getPlataforma());
        statement.setInt(3, entity.getAnioLanzamiento());
        statement.setDouble(4, entity.getPrecio());
        statement.setBoolean(5, entity.isDisponible());

        statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Videojuego> obtenerTodos() throws SQLException {
        List<Videojuego> videojuegos = new ArrayList<>();
        String sql = "SELECT id, titulo, plataforma, anio_lanzamiento, precio, disponible FROM videojuegos";

        try (Connection conexion = DBConection.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Videojuego videojuego = new Videojuego(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("plataforma"),
                        rs.getInt("anio_lanzamiento"),
                        rs.getDouble("precio"),
                        rs.getBoolean("disponible")
                );
                videojuegos.add(videojuego);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener todos los videojuegos: " + e.getMessage(), e);
        }

        return videojuegos;
    }

    @Override
    public Videojuego obtenerPorID(Integer id) throws SQLException {
        String sql = "SELECT id, titulo, plataforma, anio_lanzamiento, precio, disponible FROM videojuegos WHERE id = ?";

        try (Connection conexion = DBConection.getInstancia().getConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    Videojuego videojuego = new Videojuego(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("plataforma"),
                            rs.getInt("anio_lanzamiento"),
                            rs.getDouble("precio"),
                            rs.getBoolean("disponible")
                    );
                    return videojuego;
                } else {
                    // No se encontró el videojuego con ese ID
                    return null;
                }
            }

        } catch (SQLException e) {
            throw new SQLException("Error al obtener el videojuego con ID " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizar(Videojuego entity) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        DBConection dbConection = DBConection.getInstancia();

        String sql = "DELETE FROM Videojuegos WHERE id = ?";
        PreparedStatement statement = dbConection.getConexion().prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();  // <-- sin argumento aquí
        statement.close();
    }
}
