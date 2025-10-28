package ut2;


import ut2.conection.DBConection;
import ut2.dao.VideojuegoDao;
import ut2.model.Videojuego;
import ut2.service.VideojuegoSevice;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static VideojuegoDao videojuegoDao=new VideojuegoDao();

    public static void main(String[] args) throws SQLException {

        boolean acabado=false;
        Scanner sc= new Scanner(System.in);
        VideojuegoSevice videojuegoSevice = new VideojuegoSevice(new VideojuegoDao());
        while (!acabado){
            System.out.println("""
                    Que quieres hacer?
                        1. Añadir juego
                        2. Actualizar juego
                        3. Listar un juego
                        4. Listar todos los juegos
                        5. Eliminar un juego
                        6. Salir
                    """);
            int accion= sc.nextInt();
            sc.nextLine();
            switch (accion){
                case 1:{
                    System.out.println("Como se llama el juego? ");
                    String titulo= sc.nextLine();
                    System.out.println("En que plataformas esta disponible?");
                    String plataforma= sc.nextLine();
                    System.out.println("En que año salio?");
                    int anio= sc.nextInt();
                    System.out.println("Cuanto vale?");
                    double precio= sc.nextDouble();
                    System.out.println("Esta disponible?");
                    boolean disp= sc.nextBoolean();
                    Videojuego v=new Videojuego(0,titulo,plataforma,anio,precio,disp);
                    int result = videojuegoSevice.insertar(v);
                    if (result==0){
                        System.out.println("El videojuego se a insertado correctamente");
                    }else {
                        System.out.println("No se ha podido insertar");
                    }
                }
                break;
                case 2:{
                    System.out.println("Ingrese el ID del videojuego que desea actualizar:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el nuevo título:");
                    String nuevoTitulo = sc.nextLine();
                    Videojuego v = new Videojuego(id, nuevoTitulo, null, 0, 0, false);
                    int result = videojuegoSevice.actualizar(v);
                    if (result == 0) {
                        System.out.println("Título actualizado correctamente.");
                    } else {
                        System.out.println("No se pudo actualizar el título.");
                    }
                };break;
                case 3:{
                    System.out.println("Que videojuego quieres listar?");
                    int id=sc.nextInt();
                    sc.nextLine();
                    Videojuego v = videojuegoSevice.obtenerPorId(id);
                    System.out.println("TITULO: "+v.getTitulo()+"\nPLATAFORMA: "+v.getPlataforma()+"\nAÑO LANZAMIENTO: "+v.getAnioLanzamiento()+"\nPRECIIO: "+v.getPrecio()+"\nDISPONIBLE: "+v.isDisponible());

                };break;
                case 4:{
                    List<Videojuego> videojuegos= videojuegoSevice.obtenerTodos();
                    for (Videojuego v : videojuegos) {
                        System.out.println("TITULO: "+v.getTitulo()+"\nPLATAFORMA: "+v.getPlataforma()+"\nAÑO LANZAMIENTO: "+v.getAnioLanzamiento()+"\nPRECIIO: "+v.getPrecio()+"\nDISPONIBLE: "+v.isDisponible());
                        System.out.println();
                        System.out.println();
                    }
                };break;
                case 5:{
                    System.out.println("Que videojuego quieres eliminar?");
                    int id=sc.nextInt();
                    sc.nextLine();
                    int result= videojuegoSevice.eliminar(id);
                    if (result==0){
                        System.out.println("Eliminado correctamente");
                    }
                };break;
                case 6: acabado=true;break;
                default:;
            }
        }

    }
}