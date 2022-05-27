/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplicacionBanco;

import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author usuario
 */
public abstract class CuentaBancaria implements Operacionable, Comparable{
    private final Persona titular;
    private int saldo;
    private final String numCuenta;
    private Movimiento[] movimientos;
    private static int CONT=0;
    private final static int IND=10;

    @Override
    public int compareTo(Object o){
        CuentaBancaria c1=(CuentaBancaria) o;
        return this.getOficina().compareTo(c1.getOficina());
    }

    public CuentaBancaria(String nombre, String apellidos, LocalDate fecNacimiento, String DNI, String numCuenta) {
        this.titular = new Persona(nombre, apellidos, fecNacimiento, DNI);
        this.numCuenta = numCuenta;
        this.movimientos=new Movimiento[IND];
    }
    /*public CuentaBancaria(String nombre, String apellidos, LocalDate fecNacimiento, String DNI, String numCuenta, int saldo) {
        this.titular = new Persona(nombre, apellidos, fecNacimiento, DNI);
        this.numCuenta = numCuenta;
        this.saldo=saldo;
    }*/
    @Override
    public void ingreso(double cantidad){
        if(CONT==10){
            CONT=0;
        }
        this.movimientos[CONT]=new Movimiento(cantidad, "Movimiento ingreso");
        CONT++;
        this.saldo+=cantidad;
    }

    public int getCONT() {
        return CONT;
    }

    public void setCONT(int CONT) {
        CuentaBancaria.CONT = CONT;
    }
    
    @Override
    public double reintegro(double cantidad){
        if(this.getCONT()==10){
            this.setCONT(0);
        }
        if(this.saldo>=cantidad){
            this.movimientos[CONT]=new Movimiento(cantidad, "Movimiento reintegro satisfactorio");
            CONT++;
            this.saldo-=cantidad;
        }else{
            System.out.println("No se han podido reintegrar "+(cantidad-this.getSaldo())+"$");
            cantidad=saldo;
            this.movimientos[CONT]=new Movimiento(cantidad, "Movimiento reintegro insuficiente");
            CONT++;
            this.saldo=0;
        }
        return cantidad;
    }
    public void anotarOperacion(double cantidad, String descripcion){
        this.movimientos[CONT]=new Movimiento(cantidad, descripcion);
        CONT++;
    }
    public Persona getTitular() {
        return titular;
    }

    public int getSaldo() {
        return saldo;
    }
    public String getIBAN(){
        return numCuenta.substring(0, 4);
    }
    public String getEntidad(){
        return numCuenta.substring(4, 8);
    }
    public String getOficina(){
        return numCuenta.substring(8, 12);
    }
    public String getDC(){
        return numCuenta.substring(12, 14);
    }
    public String getNumeroCuentaFinal(){
        return numCuenta.substring(14, 24);
    }
    public String getNumCuenta() {
        return this.getIBAN()+"-"+this.getEntidad()+"-"+this.getOficina()+"-"+this.getDC()+"-"+this.getNumeroCuentaFinal();
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
   static class OrdenarXSaldo implements Comparator<CuentaBancaria>{

        @Override
        public int compare(CuentaBancaria o1, CuentaBancaria o2) {
           if(o1.getSaldo()>o2.getSaldo()){
               return 1;
           }else{
               if(o1.getSaldo()<o2.getSaldo()){
                   return -1;
               }else{
                   return 0;
               }
           }
        }

    }
           public String getNNombre(){
            return this.titular.getNombre();
        }
private class Persona{
    private String nombre;
    private String apellidos;
    private LocalDate fecNacimiento;
    private String DNI;

        public Persona(String nombre, String apellidos, LocalDate fecNacimiento, String DNI) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fecNacimiento = fecNacimiento;
            this.DNI = DNI;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public LocalDate getFecNacimiento() {
            return fecNacimiento;
        }

        public String getDNI() {
            return DNI;
        }
        
}
private class Movimiento{
    private double cantidad;
    private String descripcion;

        public Movimiento(double cantidad, String descripcion) {
            this.cantidad = cantidad;
            this.descripcion = descripcion;
        }

        public double getCantidad() {
            return cantidad;
        }

        public String getDescripcion() {
            return descripcion;
        }

}

    @Override
    public void imprimir(){
        System.out.println(this.titular.nombre+" "+this.titular.apellidos+"\n"+this.titular.DNI+" "+this.titular.fecNacimiento
        +"\n"+this.numCuenta+"\nSaldo:"+this.saldo);
        for(Movimiento m: movimientos){
            if(m!=null){
                System.out.println(m.getCantidad()+" "+m.getDescripcion());
            }
        }
    }


}
