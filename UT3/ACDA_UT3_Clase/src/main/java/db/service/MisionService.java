package db.service;

import db.dao.MisionDAO;
import db.dao.VideojuegoDAO;
import db.model.Mision;
import db.model.Videojuego;

import java.util.List;

public class MisionService {
    private MisionDAO misionDAO;

    public MisionService() {
        this.misionDAO = new MisionDAO();
    }

    public void save(Mision mision) {
        if (mision.getTitulo() == null || mision.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título de la mision no puede estar vacío.");
        }
        if (mision.getDescripcion() == null || mision.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripcion de la mision no puede estar vacia.");
        }
        String[] correctValues= {"BAJA","MEDIA","ALTA"};
        if (!mision.getDificultad().equals(correctValues[0]) && (!mision.getDificultad().equals(correctValues[1])) && (!mision.getDificultad().equals(correctValues[2]))){
            throw new IllegalArgumentException("La dificultad debe ser BAJA MEDIA o ALTA.");
        }
        if (mision.getRecompensa() == null || mision.getRecompensa().isEmpty()) {
            throw new IllegalArgumentException("La recompensa de la mision no puede estar vacia.");
        }
        misionDAO.save(mision);
    }

    public Mision findById(int id) {
        return misionDAO.findById(id);
    }

    public List<Mision> findAll() {
        return misionDAO.findAll();
    }

    public void update(Mision mision) {
        if (mision.getMisionId() == 0) {
            throw new IllegalArgumentException("La mision debe tener un ID válido para actualizarse.");
        }
        misionDAO.update(mision);
    }

    public void delete(int id) {
        misionDAO.delete(id);
    }
}
