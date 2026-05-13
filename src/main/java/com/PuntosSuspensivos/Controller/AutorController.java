package com.PuntosSuspensivos.Controller;

import com.PuntosSuspensivos.Entity.Autor;
import com.PuntosSuspensivos.Entity.Empleado;
import com.PuntosSuspensivos.Repository.AutorRepository;
import com.PuntosSuspensivos.Service.AutorService;
import com.PuntosSuspensivos.Service.EmpleadoService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AutorController implements AutorRepository {
    AutorService autorService=new AutorService();

    @Override
    public void save(Autor autor){
        autorService.save(autor);
    };

    @Override
    public void update(int id_autor, String nombre, String nacionalidad, LocalDate fecha_nacimiento, String biografia){
        autorService.update(id_autor, nombre, nacionalidad, fecha_nacimiento, biografia);
    };

    @Override
    public void deleteAutor(int id){
        autorService.deleteAutor(id);

    };

    @Override
    public List<Autor> findAll(){
        return autorService.findAll();
    };

    @Override
    public Autor findAutor(int id){
        return autorService.findAutor(id);
    };
}
