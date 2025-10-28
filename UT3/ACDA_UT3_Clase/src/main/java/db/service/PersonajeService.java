package db.service;

import db.dao.MisionDAO;
import db.dao.PersonajeDAO;
import db.model.Mision;
import db.model.Personaje;

import java.util.List;

public class PersonajeService {
    private PersonajeDAO personajeDAO;

    public PersonajeService() {
        this.personajeDAO = new PersonajeDAO();
    }

    //public void save(Personaje personaje) {
    //    if (mision.getTitulo() == null || mision.getTitulo().isEmpty()) {
    //        throw new IllegalArgumentException("El título de la mision no puede estar vacío.");
    //    }
    //    if (mision.getDescripcion() == null || mision.getDescripcion().isEmpty()) {
    //        throw new IllegalArgumentException("La descripcion de la mision no puede estar vacia.");
    //    }
    //    String[] correctValues= {"BAJA","MEDIA","ALTA"};
    //    if (!mision.getDificultad().equals(correctValues[0]) && (!mision.getDificultad().equals(correctValues[1])) && (!mision.getDificultad().equals(correctValues[2]))){
    //        throw new IllegalArgumentException("La dificultad debe ser BAJA MEDIA o ALTA.");
    //    }
    //    if (mision.getRecompensa() == null || mision.getRecompensa().isEmpty()) {
    //        throw new IllegalArgumentException("La recompensa de la mision no puede estar vacia.");
    //    }
    //    personajeDAO.save(personaje);
    //}

    public Personaje findById(int id) {
        return personajeDAO.findById(id);
    }

    public List<Personaje> findAll() {
        return personajeDAO.findAll();
    }

    public void update(Personaje personaje) {
        if (personaje.getPersonajeID() == 0) {
            throw new IllegalArgumentException("La mision debe tener un ID válido para actualizarse.");
        }
        personajeDAO.update(personaje);
    }

    public void delete(int id) {
        personajeDAO.delete(id);
    }
}
