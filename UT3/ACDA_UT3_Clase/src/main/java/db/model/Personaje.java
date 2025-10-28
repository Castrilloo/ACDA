package db.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "Personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personajeID;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "clase", nullable = false)
    @Check(constraints = "clase IN ('GUERRERO', 'MAGO', 'ARQUERO')")
    private String clase;

    @Column(name = "nivel", nullable = false)
    private int nivel;

    @Column(name = "puntosVida", nullable = false)
    private int puntosVida;

    @Column(name = "armaPrincipal", nullable = false, length = 100)
    private String armaPrincipal;


    public Personaje(){}

    public int getPersonajeID() {
        return personajeID;
    }

    public void setPersonajeID(int personajeID) {
        this.personajeID = personajeID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public String getArmaPrincipal() {
        return armaPrincipal;
    }

    public void setArmaPrincipal(String armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }
}
