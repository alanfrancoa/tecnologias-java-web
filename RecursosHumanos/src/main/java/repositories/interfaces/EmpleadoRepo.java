package repositories.interfaces;

import java.util.List;

import models.Empleado;

public interface EmpleadoRepo {
	// metodos basicos que vamos a tener en el empleado

	// listar
	public List<Empleado> getAll();

	// buscar por id
	public Empleado findById(int id);

	// Acciones
	// insertar
	public void insert(Empleado empleado);

	// actualizar
	public void update(Empleado empleado);

	// eliminar
	public void delete(int id);

}
