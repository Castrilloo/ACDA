package db.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "Mision")
public class Mision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int misionId;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "dificultad", nullable = false)
    @Check(constraints = "dificultad IN ('BAJA', 'MEDIA', 'ALTA')")
    private String dificultad;

    @Column(name = "recompensa", nullable = false, length = 100)
    private String recompensa;

    @Column (name = "activa", nullable = false)
    private boolean activa;

    public Mision(){}

    public int getMisionId() {
        return misionId;
    }

    public void setMisionId(int misionId) {
        this.misionId = misionId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
