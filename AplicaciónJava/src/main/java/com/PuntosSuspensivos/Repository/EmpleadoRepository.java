package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.Empleado;

import java.time.LocalDate;
import java.util.List;

public interface EmpleadoRepository {
    public void save(Empleado empleado);

    public void update(int id, String nombre, LocalDate fecha_nacimiento, int telefono, String email);

    public void deleteEmpleado(int id);

    public List<Empleado> findAll();

    public Empleado findEmpleado(int id);
}
