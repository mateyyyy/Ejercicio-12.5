package com.mycompany.ej;
import java.util.Scanner;

public class CasasRurales {
    String poblacion;
    String direccion;
    public int numHabitacion;
    double precio;
    String id;
    public boolean esAlta;
    
    public CasasRurales()
        {
            
            esAlta =  true;
            asigna();
        }
    
    public void asigna()
        {
            Scanner scan =  new Scanner(System.in);
            try 
                {
                    System.out.print("\n Codigo (10 caracteres): ");
                    id = scan.nextLine();
                    System.out.print("\n Población: ");
                    poblacion = scan.nextLine();
                    System.out.print("\n Dirección: ");
                    direccion = scan.nextLine();
                    System.out.print("\n Número de habitaciones: ");
                    numHabitacion = scan.nextInt();
                    System.out.print("\n Precio por día de estancia: ");
                    precio = scan.nextDouble();
                }
            catch (Exception e)
                {
                    System.out.println(" Excepcion en la entrada de datos " +
                    e.getMessage()+ " . No se da de alta");
                    esAlta = false;
                }
        }
    
    public String getId()
    {
        return id;
    }
    
    public void muestra()
    {
        System.out.println("\nCasa Rural : " + id);
        System.out.println("Población : " + poblacion);
        System.out.println("Dirección : " + direccion);
        System.out.println("Precio por día : $" + precio);
    }
   
}
