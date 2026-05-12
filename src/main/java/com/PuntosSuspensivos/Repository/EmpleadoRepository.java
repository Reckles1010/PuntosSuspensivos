package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.Empleado;

import java.util.List;

public interface EmpleadoRepository {
    public void save(Empleado empleado);

    public void update(Empleado empleado);

    public void deleteEmpleado(int id);

    public List<Empleado> findAll();

    public Empleado findEmpleado(int id);
}
