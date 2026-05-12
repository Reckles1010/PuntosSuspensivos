package com.PuntosSuspensivos.Service;

import com.PuntosSuspensivos.Entity.Empleado;
import com.PuntosSuspensivos.Repository.EmpleadoRepository;
import com.PuntosSuspensivos.Repository.EmpleadoRepositoryImpl;

import java.util.List;

public class EmpleadoService implements EmpleadoRepository {
    EmpleadoRepositoryImpl empleadoRepositoryImpl = new EmpleadoRepositoryImpl();

    @Override
    public void save(Empleado empleado){
        empleadoRepositoryImpl.save(empleado);
    };

    @Override
    public void update(Empleado empleado){
        empleadoRepositoryImpl.update(empleado);
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
