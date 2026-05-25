package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.Categoria;

import java.util.List;

public interface CategoriaRepository {
    public void save(Categoria categoria);

    public void update(int id, String nombre);

    public void deleteCategoria(int id);

    public List<Categoria> findAll();

    public Categoria findCategoria(int id);
}
