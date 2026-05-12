package com.PuntosSuspensivos.Controller;

import com.PuntosSuspensivos.Entity.Empleado;
import com.PuntosSuspensivos.Repository.EmpleadoRepository;
import com.PuntosSuspensivos.Service.EmpleadoService;

import java.awt.event.ActionListener;
import java.util.List;

public class EmpleadoController implements EmpleadoRepository{
    EmpleadoService empleadoService=new EmpleadoService();

    @Override
    public void save(Empleado empleado){
        empleadoService.save(empleado);
    };

    @Override
    public void update(Empleado empleado){
        empleadoService.update(empleado);
    };

    @Override
    public void deleteEmpleado(int id){
        empleadoService.deleteEmpleado(id);

    };

    @Override
    public List<Empleado> findAll(){
        return empleadoService.findAll();
    };

    @Override
    public Empleado findEmpleado(int id){
        return empleadoService.findEmpleado(id);
    };
}
