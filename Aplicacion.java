/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplicacionBanco;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author usuario
 */
public class Aplicacion {
    public static void main(String[] args) {
        LocalDate d1=LocalDate.of(2003, Month.MARCH, 25);
        CuentaBancaria [] lista=new CuentaBancaria[5];
        lista[0]=new CuentaAhorro("1", "Perez", d1 , "41231313M", "111111642343211114567890", 32);
        lista[0].ingreso(432);
        lista[1]=new CuentaAhorro("2", "Perez", d1 , "41231313M", "111111111143211634567890", 32);
        lista[1].ingreso(712);
        lista[2]=new CuentaAhorro("3", "Perez", d1 , "41231313M", "111111183443291234567890", 32);
        lista[2].ingreso(132);
        lista[3]=new CuentaAhorro("4", "Perez", d1 , "41231313M", "111111193443241234567890", 32);
        lista[3].ingreso(4332);
        lista[4]=new CuentaAhorro("5", "Perez", d1 , "41231313M", "111111123443261234567890", 32);
        lista[4].ingreso(532);
    /* for(int i=0;i<lista.length; i++){
        System.out.println(i+". "+lista[i].getSaldo());   
     }
        Arrays.sort(lista, new CuentaBancaria.OrdenarXSaldo());
     for(int i=0;i<lista.length; i++){
        System.out.println(lista[i].getSaldo());   
     }*/
    for(int i=0;i<lista.length; i++){
        System.out.println(lista[i].getNumeroCuentaFinal());
    }
    Arrays.sort(lista, new Comparator<CuentaBancaria>(){
            @Override
            public int compare(CuentaBancaria o1, CuentaBancaria o2) {
                return o1.getNumeroCuentaFinal().compareTo(o2.getNumeroCuentaFinal());
            }
       
    });
    for(int i=0;i<lista.length; i++){
        System.out.println("Ordenador "+lista[i].getNumeroCuentaFinal());
        System.out.println(lista[i].getNNombre());
    }
    }
}
