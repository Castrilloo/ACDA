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

    public void save(Personaje personaje) {
        if (personaje.getNombre() == null || personaje.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del personaje no puede estar vacío.");
        }
        if (personaje.getArmaPrincipal() == null || personaje.getArmaPrincipal().isEmpty()) {
            throw new IllegalArgumentException("El arma principal del personaje no puede estar vacia.");
        }
        String[] correctValues= {"GUERRERO","MAGO","ARQUERO"};
        if (!personaje.getClase().equals(correctValues[0]) && (!personaje.getClase().equals(correctValues[1])) && (!personaje.getClase().equals(correctValues[2]))){
            throw new IllegalArgumentException("La clase debe ser GUERRERO,MAGO o ARQUERO.");
        }
        if (personaje.getPuntosVida() <=0 ) {
            throw new IllegalArgumentException("Los puntos de vida deben ser mas que 0.");
        }
        personajeDAO.save(personaje);
    }

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
