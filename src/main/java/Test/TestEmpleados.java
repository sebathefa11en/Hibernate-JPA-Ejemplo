package Test;

import Modelo.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestEmpleados {
    private static EntityManager manager;

    private static EntityManagerFactory emf;

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        //Crear el gestor de Persistencia (EM)
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();

        List<Empleado> empleados =(List<Empleado>) manager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
        System.out.println("En esta base de datos hay " + empleados.size()+ " empleados");
    }


}
