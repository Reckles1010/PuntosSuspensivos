package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.Categoria;

public interface CategoriaRepository {
    public void save(Categoria categoria);

    public void update(Categoria categoria);

    public Categoria deleteCategoria(int id);

    public void findAll(int id);

    public Categoria findCategoria(int id);
}
