package Test;

import Modelo.Empleado;
import sun.util.calendar.Gregorian;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;
import java.util.List;

public class TestEmpleados {
    private static EntityManager manager;

    private static EntityManagerFactory emf;

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        //Crear el gestor de Persistencia (EM)
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();

        //List<Empleado> empleados =(List<Empleado>) manager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
        //System.out.println("En esta base de datos hay " + empleados.size()+ " empleados");

        Empleado e = new Empleado(10L, "Perez", "Pepito", new GregorianCalendar(1000, 6,6).getTime());
        Empleado e2 = new Empleado(25L, "Martinez", "José", new GregorianCalendar(1996, 7,22).getTime());


        manager.getTransaction().begin();
        manager.persist(e);
        manager.persist(e2);
        manager.getTransaction().commit();

        imprimitTodo();
    }

    @SuppressWarnings("unchecked")
    private static void imprimitTodo(){
        List<Empleado> emps = (List<Empleado>) manager.createQuery("SELECT e FROM Empleado e").getResultList();
        System.out.println("Hay "+emps.size() + " empleados en el sistema.");
        for (Empleado emp : emps){
            System.out.println(emp.toString());
        }
    }
}
