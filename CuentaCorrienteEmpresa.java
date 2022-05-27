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
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    private double cantFijaDescubierto;
    private final double comisionFija;
    private double interes;

    public CuentaCorrienteEmpresa(double cantDescubierto, double comisionFija, double interes, String nombre, String apellidos, LocalDate fecNacimiento, String DNI, String numCuenta) {
        super(nombre, apellidos, fecNacimiento, DNI, numCuenta);
        this.cantFijaDescubierto = cantDescubierto;
        this.comisionFija = comisionFija;
        this.interes = interes;
    }
    public double reintegro(double cantidad){
        if(this.getCONT()==10){
            this.setCONT(0);
        }
        double efectivo;
        if(this.getSaldo()<cantidad){
            if(this.cantFijaDescubierto>(cantidad-this.getSaldo())){
                this.cantFijaDescubierto-=(cantidad-this.getSaldo());
                this.setSaldo(0);
                this.anotarOperacion(cantidad, "Movimiento reintegro al descubierto");
                efectivo=cantidad;
            }else{
                System.out.println("Error por falta de saldo");
                return 0;
            }
        }else{
           efectivo=super.reintegro(cantidad);
        }
        return efectivo;
    }

    
    public double getCantFijaDescubierto() {
        return cantFijaDescubierto;
    }

    public double getComisionFija() {
        return comisionFija;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Cantidad Descubierto: "+ this.getCantFijaDescubierto());
        System.out.println("Comision: "+this.comisionFija);
        System.out.println("Interes: "+this.interes);
    }

    

    @Override
    public double balance() {
        return getSaldo() - (this.cantFijaDescubierto * this.comisionFija / 100) - 
                ((this.cantFijaDescubierto - this.cantFijaDescubierto) * this.interes / 100);
    }
    
}
