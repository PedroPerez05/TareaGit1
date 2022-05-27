/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplicacionBanco;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public abstract class CuentaCorriente extends CuentaBancaria{
    private ArrayList<String> entidades;
     public CuentaCorriente(String nombre, String apellidos, LocalDate fecNacimiento, String DNI, String numCuenta) {
        super(nombre, apellidos, fecNacimiento, DNI, numCuenta);
        this.entidades=new ArrayList<String>();
    }
    public void add(String entidad){
        this.entidades.add(entidad);
    }
    public void eliminar(String entidad){
        if(this.entidades.contains(entidad)){
            this.entidades.remove(entidad);
        }
    }
    public void mostrar(){
        for(String s: entidades){
            System.out.println(s);
        }
    }

    @Override
    public void imprimir() {
        super.imprimir();
        this.mostrar();
    }
    
}
