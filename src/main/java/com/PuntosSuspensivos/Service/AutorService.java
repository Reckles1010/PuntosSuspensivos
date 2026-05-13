package com.PuntosSuspensivos.Service;

import com.PuntosSuspensivos.Entity.Autor;
import com.PuntosSuspensivos.Entity.Empleado;
import com.PuntosSuspensivos.Repository.AutorRepository;
import com.PuntosSuspensivos.Repository.AutorRepositoryImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AutorService implements AutorRepository {
    AutorRepositoryImpl autorRepository=new AutorRepositoryImpl();

    @Override
    public void save(Autor autor){
        autorRepository.save(autor);
    };

    @Override
    public void update(int id_autor, String nombre, String nacionalidad, LocalDate fecha_nacimiento, String biografia){
        autorRepository.update( id_autor, nombre, nacionalidad, fecha_nacimiento, biografia);
    };

    @Override
    public void deleteAutor(int id){
        autorRepository.deleteAutor(id);

    };

    @Override
    public List<Autor> findAll(){
        return autorRepository.findAll();
    };

    @Override
    public Autor findAutor(int id){
        return autorRepository.findAutor(id);
    };
}
