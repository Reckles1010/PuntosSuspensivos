package com.PuntosSuspensivos.Controller;

import com.PuntosSuspensivos.Entity.Categoria;
import com.PuntosSuspensivos.Repository.CategoriaRepository;
import com.PuntosSuspensivos.Service.CategoriaService;

import java.awt.event.ActionListener;
import java.util.List;

public class CategoriaController implements CategoriaRepository{
    CategoriaService categoriaService = new CategoriaService();

    @Override
    public void save(Categoria categoria){
        categoriaService.save(categoria);
    };

    @Override
    public void update(int id, String nombre){
        categoriaService.update(id, nombre);
    };

    @Override
    public void deleteCategoria(int id){
        categoriaService.deleteCategoria(id);
    }

    @Override
    public List<Categoria> findAll(){
        return categoriaService.findAll();
    }

    @Override
    public Categoria findCategoria(int id){
        return categoriaService.findCategoria(id);
    }
}
