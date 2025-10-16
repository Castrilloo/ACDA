package ut2.model;

public class Videojuego {
    private int id;
    private String titulo;
    private String plataforma;
    private int anioLanzamiento;
    private double precio;
    private boolean disponible;

    public Videojuego(int id,String titulo,String plataforma,int anioLanzamiento,double precio,boolean disponible){
        this.id=id;
        this.titulo=titulo;
        this.plataforma=plataforma;
        this.anioLanzamiento=anioLanzamiento;
        this.precio=precio;
        this.disponible=disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
