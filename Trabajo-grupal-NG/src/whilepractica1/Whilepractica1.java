/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package whilepractica1;

import java.util.Scanner;

/**
 * @author Estudiante
 */
public class Whilepractica1 {
     // Ponemos el saldo aquí afuera para que todos los métodos los visualicen 
     // y se actualicen de verdad 
     public static double saldo = 500;
     public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       cajero_automatico();
    }
    
     public static void cajero_automatico(){
         // Algoritmo para simular cajero automatico
         int clave = 1234;
         int intentos = 3;
         boolean sesionActiva = true; // Control de salida del cajero
         
         while (intentos > 0 && sesionActiva){
             System.out.println("cajero automatico");
             System.out.println("------------------");
             System.out.println("ingrese su tarjeta: ");
             System.out.println("tarjeta detectada");
             System.out.println("ingrese su clave");
             int clave_ingresada = sc.nextInt();
             int opcion;
             
             if (clave_ingresada == clave){
                do {
                 System.out.println("\nbienvenido al cajero");
                 System.out.println("seleccione una opcion: ");
                 System.out.println("1.consultar saldo");
                 System.out.println("2.retirar dinero");
                 System.out.println("3.depositar dinero");
                 System.out.println("4.salir");
                 System.out.println("ingrese la opcion deseada");
                 
                 opcion = sc.nextInt();
                  
                 switch (opcion){
                     case 1: // Opcion consultar
                         consultar_saldo();   
                         break;
                     case 2: // Opcion retirar
                         retirar_saldo();
                         break;
                     case 3: // Opcion depositar (Cambio 1 realizado)
                         depositar_dinero();
                         break;
                     case 4: // Opcion salir (Cambio 2 realizado)
                         System.out.println("gracias por preferirnos");
                         sesionActiva = false; 
                         break;
                     default:
                         // CAMBIO 5: Se eliminó la variable muerta intentos2 para optimizar el código
                         System.out.println("opcion incorrecta");
                 }
                 
                 // Bloque de pausa activa (Cambio 4 realizado)
                 if (opcion != 4) {
                     System.out.println("\nPresione ENTER para continuar...");
                     sc.nextLine(); 
                     sc.nextLine(); 
                 }
                 
                } while (opcion != 4); // Condición corregida (Cambio 3 realizado)
                    break;
                     
                 }else{
                 System.out.println("clave incorrecta");
                 intentos --;
                 System.out.println("te quedan "+ intentos);
             } 
         }
         if (intentos == 0){
             System.out.println("tarjeta bloqueada, haz superado los 3 intentos");
         }
     }
     
     // Consultar saldo
     public static void consultar_saldo(){
         System.out.println("--------CONSULTAR SALDO --------");
         System.out.println("el saldo disponible es de "+ saldo);
     }
     
     // Retirar saldo 
     public static void retirar_saldo (){
         System.out.println("---------RETIRAR SALDO-----------");
         System.out.println("Ingresa la cantidad a retirar: ");
         double cantidadRetirar = sc.nextDouble();
         
         // Validamos que tenga dinero y que no pida numeros negativos
         if (cantidadRetirar >0 && cantidadRetirar <=saldo){
             saldo = saldo - cantidadRetirar; // Restamos al saldo global 
             System.out.println("Retiro exitoso");
             System.out.println("Saldo restante :" + saldo);
         }else if (cantidadRetirar > saldo ){
             System.out.println("error: saldo insuficiente. tu saldo actual es de : "+saldo );
         }else{
             System.out.println("cantidad no valida ");
         }
     }

     // Depositar saldo (Cambio 1 realizado)
     public static void depositar_dinero() {
         System.out.println("---------DEPOSITAR DINERO-----------");
         System.out.println("Ingresa la cantidad a depositar: ");
         double cantidadDepositar = sc.nextDouble();
         
         if (cantidadDepositar > 0) {
             saldo = saldo + cantidadDepositar; // Sumamos al saldo global
             System.out.println("Depósito exitoso.");
             System.out.println("Tu nuevo saldo es de: " + saldo);
         } else {
             System.out.println("Cantidad no válida.");
         }
     }
}