/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej;

/**
 *
 * @author matia
 */
public class TablaDispersa {
    CasasRurales[] Tabla;
    static int numElementos = 0;
    static double factorCarga;
    
    public TablaDispersa()
    {
        Tabla = new CasasRurales[101];
    }
    
    public int direccion(String id)
    {
        int i = 0, p;
        long d;
        d = transformaCadena(id);
        // aplica aritmética modular para obtener dirección base
        p = (int)(d % 101);
        // bucle de exploración
            while (Tabla[p]!= null && !Tabla[p].getId().equals(id))
        {
        i++;
        p = p + i*i;
        p = p % 101; // considera el array como circular
        }
        return p;
    }
    
    long transformaCadena(String c)
    {
        long d;
        d = 0;
        for (int j = 0; j < Math.min(10,c.length()); j++)
        {
            d = d * 27 + (int)c.charAt(j);
        }
        if (d < 0)
        {
            d = -d;
        }
        return d;
    }
    
    public void insertar(CasasRurales r)
    {
        int posicion;
        posicion = direccion(r.getId());
        Tabla[posicion] = r;
        numElementos++;
        factorCarga = (double)(numElementos)/101;
        if (factorCarga > 0.5)
        {
            System.out.println("\n!! Factor de carga supera el 50%.!!" +  " Conviene aumentar el tamaño." );
        }
    }
    
    public int buscar(String id)
    {
        return direccion(id);
    }
    
    public void bajar(String id)
    {
        int posicion = direccion(id);
        Tabla[posicion].esAlta = false;
    }
    
}
