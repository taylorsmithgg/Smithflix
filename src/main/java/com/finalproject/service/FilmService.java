package com.finalproject.service;

import com.finalproject.dao.FilmDAO;
import com.finalproject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("FilmService")
@Transactional
public class FilmService {
    @Autowired
    FilmDAO filmDAO;

    public List<Film> getFilms() {
        return filmDAO.getFilms();
    }

    public FilmDAO getFilmDAO() {
        return filmDAO;
    }

}
