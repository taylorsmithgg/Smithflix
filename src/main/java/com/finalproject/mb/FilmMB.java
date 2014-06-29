package com.finalproject.mb;

import com.finalproject.model.Film;
import com.finalproject.service.FilmService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "filmMB")
@RequestScoped
public class FilmMB implements Serializable {
    List<Film> films;

    @ManagedProperty(value = "#{FilmService}")
    FilmService filmService;

    public List<Film> getFilms() {
        films = new ArrayList<Film>();
        films.addAll(getFilmService().getFilms());
        return films;
    }

    public FilmService getFilmService() {
        return filmService;
    }

    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }
}
