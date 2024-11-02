package mains;

import java.util.List;

import models.Empleado;
import repositories.EmpleadosRepoSingleton;
import repositories.interfaces.EmpleadoRepo;

public class MainPruebaRepo {

	public static void main(String[] args) {
		
		EmpleadoRepo repo = EmpleadosRepoSingleton.getInstance();
		
		
		Empleado nuevo = new Empleado("Ernesto", 26, 345000);
		
		repo.insert(nuevo);
		List<Empleado> listado = repo.getAll();
		
		Empleado emple = repo.findById(1);
		emple.setSueldo(87512);
		
		
		//por ahora no hace nada
		repo.update(emple);
		
		repo.delete(4);
		listado.forEach(System.out::println);
		
		
		System.out.println("-----------");
		
		List<Empleado> listado2 = repo.getAll();
		listado2.forEach(System.out::println);
		

	}

}
