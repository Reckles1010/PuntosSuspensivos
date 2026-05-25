package com.PuntosSuspensivos.Service;

import com.PuntosSuspensivos.Entity.Empleado;
import com.PuntosSuspensivos.Repository.EmpleadoRepository;
import com.PuntosSuspensivos.Repository.EmpleadoRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class EmpleadoService implements EmpleadoRepository {
    EmpleadoRepositoryImpl empleadoRepositoryImpl = new EmpleadoRepositoryImpl();

    @Override
    public void save(Empleado empleado){
        empleadoRepositoryImpl.save(empleado);
    };

    @Override
    public void update(int id, String nombre, LocalDate fecha_nacimiento, int telefono, String email){
        empleadoRepositoryImpl.update(id, nombre, fecha_nacimiento, telefono, email);
    };

    @Override
    public void deleteEmpleado(int id){
        empleadoRepositoryImpl.deleteEmpleado(id);

    };

    @Override
    public List<Empleado> findAll(){
        return empleadoRepositoryImpl.findAll();
    };

    @Override
    public Empleado findEmpleado(int id){
        return empleadoRepositoryImpl.findEmpleado(id);
    };
}
