package db.service;

import db.dao.PartidaDAO;
import db.model.Partida;

import java.util.List;

public class PartidaService {
    private PartidaDAO partidaDAO;

    public PartidaService() {
        this.partidaDAO = new PartidaDAO();
    }

    public void save(Partida partida) {
        if (partida.getNombre() == null || partida.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la partida no puede estar vacío.");
        }
        if (partida.getFechaInicio() == null || partida.getFechaInicio().isEmpty()) {
            throw new IllegalArgumentException("La fecha de inicio de la partida no puede estar vacia.");
        }
        String[] correctValues= {"EN CURSO","FINALIZADA","EN PAUSA"};
        if (!partida.getEstado().equals(correctValues[0]) && (!partida.getEstado().equals(correctValues[1])) && (!partida.getEstado().equals(correctValues[2]))){
            throw new IllegalArgumentException("La dificultad debe ser BAJA MEDIA o ALTA.");
        }
        if (partida.getNumeroJugadores() < 1) {
            throw new IllegalArgumentException("Una partida debe tener al menos 1 jugador.");
        }
        partidaDAO.save(partida);
    }

    public Partida findById(int id) {
        return partidaDAO.findById(id);
    }

    public List<Partida> findAll() {
        return partidaDAO.findAll();
    }

    public void update(Partida partida) {
        if (partida.getPartidaId() == 0) {
            throw new IllegalArgumentException("La mision debe tener un ID válido para actualizarse.");
        }
        partidaDAO.update(partida);
    }

    public void delete(int id) {
        partidaDAO.delete(id);
    }
}
