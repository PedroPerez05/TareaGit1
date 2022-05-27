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
public class CuentaCorrientePersonal extends CuentaCorriente{
    private double comision;

    public CuentaCorrientePersonal(double comision, String nombre, String apellidos, LocalDate fecNacimiento, String DNI, String numCuenta) {
        super(nombre, apellidos, fecNacimiento, DNI, numCuenta);
        this.comision = comision;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Comision: "+this.comision);
    }

    public double getComision() {
        return comision;
    }




    @Override
    public double balance() {
       return this.getSaldo()* (1 - this.comision/100);
    }
    
}
