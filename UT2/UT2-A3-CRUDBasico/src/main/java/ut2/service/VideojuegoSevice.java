package ut2.service;

import ut2.dao.GenericDAO;
import ut2.dao.VideojuegoDao;
import ut2.model.Videojuego;

import java.util.List;

public class VideojuegoSevice  extends GenericServiceImpl<Videojuego,Integer>{


    public VideojuegoSevice(VideojuegoDao videojuegoDao) {
        super(videojuegoDao);
    }

}
