package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.Autor;

public interface AutorRepository {
    public void save(Autor autor);

    public void update(Autor autor);

    public Autor deleteAutor(int id);

    public void findAll(int id);

    public Autor findAutor(int id);
}
