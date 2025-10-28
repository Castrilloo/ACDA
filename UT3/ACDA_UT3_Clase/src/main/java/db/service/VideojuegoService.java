package db.service;

import db.model.Videojuego;
import db.dao.VideojuegoDAO;

import java.util.List;

public class VideojuegoService {
    private VideojuegoDAO videojuegoDAO;

    public VideojuegoService() {
        this.videojuegoDAO = new VideojuegoDAO();
    }

    public void save(Videojuego videojuego) {
        if (videojuego.getTitulo() == null || videojuego.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del videojuego no puede estar vacío.");
        }
        if (videojuego.getPrecio() == null || videojuego.getPrecio().doubleValue() < 0) {
            throw new IllegalArgumentException("El precio debe ser mayor o igual a 0.");
        }
        videojuegoDAO.save(videojuego);
    }

    public Videojuego findById(int id) {
        return videojuegoDAO.findById(id);
    }

    public List<Videojuego> findAll() {
        return videojuegoDAO.findAll();
    }

    public void update(Videojuego videojuego) {
        if (videojuego.getVideojuegoID() == 0) {
            throw new IllegalArgumentException("El videojuego debe tener un ID válido para actualizarse.");
        }
        videojuegoDAO.update(videojuego);
    }

    public void delete(int id) {
        videojuegoDAO.delete(id);
    }

}
