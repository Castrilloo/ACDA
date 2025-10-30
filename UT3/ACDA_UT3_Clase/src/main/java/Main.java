import db.connection.HibernateUtil;
import db.model.Mision;
import db.model.Partida;
import db.model.Personaje;
import db.service.MisionService;
import db.service.PartidaService;
import db.service.PersonajeService;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        PersonajeService personajeService = new PersonajeService();
        MisionService misionService = new MisionService();
        PartidaService partidaService = new PartidaService();

        // 1. Crear un personaje
        Personaje p = new Personaje();
        p.setNombre("Ayla la Hechicera");
        p.setClase("Maga");
        p.setNivel(5);
        p.setPuntosVida(80);
        p.setArmaPrincipal("Bastón del Alba");
        personajeService.save(p);

        // 2. Crear una misión
        Mision m = new Mision();
        m.setTitulo("El Bosque de las Sombras");
        m.setDescripcion("Explora las ruinas antiguas y vence a la Sombra del Olvido.");
        m.setDificultad("Alta");
        m.setRecompensa("500");
        m.setActiva(true);
        misionService.save(m);

        // 3. Crear una partida
        Partida partida = new Partida();
        partida.setNombre("La leyenda de Ayla");
        partida.setNumeroJugadores(4);
        partida.setEstado("En curso");
        partidaService.save(partida);

        System.out.println("Datos iniciales añadidos correctamente.");
    }
}
