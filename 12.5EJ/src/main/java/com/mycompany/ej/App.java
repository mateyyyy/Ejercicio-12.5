package com.mycompany.ej;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int op=0,num=0,posicion;
        String buscaId, bajaId;
        Scanner scan =  new Scanner(System.in);
        
        TablaDispersa tablita = new TablaDispersa();
        CasasRurales casa[];
        casa = new CasasRurales[5];
        while(op!=4){
            System.out.print("\033[H\033[2J");
            System.out.flush(); 
            menu();
            op = scan.nextInt();
            switch(op)
            {
                case 1 -> {
                    /* Agrega una casa */
                    casa[num] = new CasasRurales();
                    tablita.insertar(casa[num]);
                    casa[num].muestra();
                    num ++;
                }

                case 2 -> {
                    System.out.println("Ingrese el id de la casa : ");
                    scan.nextLine();
                    buscaId = scan.nextLine();
                    
                    try
                    {
                        posicion = tablita.buscar(buscaId);
                        System.out.println("Datos de la casa:");
                        tablita.Tabla[posicion].muestra();
                    }
                    catch(Exception e)
                    {    
                        System.out.println("No se encontro la casa...");
                    }
                    System.out.println("Press Any Key To Continue...");
                    scan.nextLine();
                }
                
                case 3 -> 
                {
                    System.out.println("Ingrese el id de la casa a dar de baja :");
                    scan.nextLine();
                    bajaId = scan.nextLine();
                    try{
                        tablita.bajar(bajaId);
                        System.out.println("Se dio de baja la casa");
                    }
                    catch(Exception e)
                    {
                        System.out.println("No se encontro esa casa...");
                    }
                }
            }
        }
    }
    
    public static void menu()
    {
        System.out.println("1) Agregar una casa rural");
        System.out.println("2) Buscar una casa rural");
        System.out.println("3) Eliminar una casa rural");
        System.out.println("4) Salir");
        System.out.println("INGRESE OPCION : "); 
    }
}
