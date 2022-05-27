/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplicacionBanco;

import java.time.LocalDate;

/**
 *
 * @author usuario
 */
public class CuentaAhorro extends CuentaBancaria{
    private double tipoInteres;

    public CuentaAhorro(String nombre, String apellidos, LocalDate fecNacimiento, String DNI, String numCuenta, double tipoInteres) {
        super(nombre, apellidos, fecNacimiento, DNI, numCuenta);
        this.tipoInteres = tipoInteres;
    }

    
    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Tipo interes: "+this.getTipoInteres());
    }

    

    @Override
    public double balance() {
        return this.getSaldo()*(1+tipoInteres/100);
    }
    
}
