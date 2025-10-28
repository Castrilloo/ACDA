package db.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Videojuego")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videojuegoID;

    @Column(name = "Titulo", nullable = false, length = 100, unique = true)
    private String titulo;

    @Column(name = "Plataforma", nullable = false, length = 20)
    private String plataforma;

    @Column(name = "Anio_Lanzamiento", nullable = false)
    private int anioLanzamiento;

    @Column(name = "Precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Actualizacion")
    private Date fechaActualizacion;

    @Column(name = "Disponible", nullable = false)
    private boolean disponible;

    public Videojuego() {}

    public int getVideojuegoID() {
        return videojuegoID;
    }

    public void setVideojuegoID(int videojuegoID) {
        this.videojuegoID = videojuegoID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
