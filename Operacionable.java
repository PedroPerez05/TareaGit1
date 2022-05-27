/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplicacionBanco;

/**
 *
 * @author usuario
 */
public interface Operacionable {
    void ingreso(double cantidad);
    double reintegro(double cantidad);
    void imprimir();
    double balance();
}
