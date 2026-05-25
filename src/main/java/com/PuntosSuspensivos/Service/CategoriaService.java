package com.PuntosSuspensivos.Service;

import com.PuntosSuspensivos.Entity.Categoria;
import com.PuntosSuspensivos.Repository.CategoriaRepository;
import com.PuntosSuspensivos.Repository.CategoriaRepositoryImpl;

import java.util.List;

public class CategoriaService implements CategoriaRepository{
    CategoriaRepository categoriaRepository = new CategoriaRepositoryImpl();

    @Override
    public void save(Categoria categoria){
        categoriaRepository.save(categoria);
    };

    @Override
    public void update(int id, String nombre){
        categoriaRepository.update(id,nombre);
    };

    @Override
    public void deleteCategoria(int id){
        categoriaRepository.deleteCategoria(id);
    };

    @Override
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    };

    @Override
    public Categoria findCategoria(int id){
        return categoriaRepository.findCategoria(id);
    };
}
