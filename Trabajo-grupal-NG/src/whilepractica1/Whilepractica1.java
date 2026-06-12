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
     public static double saldo = 500;
     public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       cajero_automatico();
    }
    
     public static void cajero_automatico(){
         int clave = 1234;
         int intentos = 3;
         boolean sesionActiva = true; 
         
         while (intentos > 0 && sesionActiva){
             System.out.println("cajero automatico");
             System.out.println("------------------");
             System.out.println("ingrese su tarjeta: ");
             System.out.println("tarjeta detectada");
             System.out.println("ingrese su clave");
             int clave_ingresada = sc.nextInt();
             int opcion;
             int intentos2 = 3;
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
                     case 1:
                         System.out.println("consultar saldo");
                         consultar_saldo();   
                         break;
                     case 2:
                         retirar_saldo();
                         break;
                     case 3:
                         depositar_dinero();
                         break;
                     case 4:
                         System.out.println("gracias por preferirnos");
                         sesionActiva = false; 
                         break;
                     default:
                         System.out.println("opcion incorrecta");
                         intentos2 --;
                 }
                 
                 // CAMBIO 4: Si no elige salir, hace una pausa antes de volver a mostrar el menú
                 if (opcion != 4) {
                     System.out.println("\nPresione ENTER para continuar...");
                     sc.nextLine(); // Limpia buffer
                     sc.nextLine(); // Espera el Enter del estudiante
                 }
                 
                } while (opcion != 4); 
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
     
     public static void consultar_saldo(){
         System.out.println("--------CONSULTAR SALDO --------");
         System.out.println("el saldo disponible es de "+ saldo);
     }
     
     public static void retirar_saldo (){
         System.out.println("---------RETIRAR SALDO-----------");
         System.out.println("Ingresa la cantidad a retirar: ");
         double cantidadRetirar = sc.nextDouble();
         if (cantidadRetirar >0 && cantidadRetirar <=saldo){
             saldo = saldo - cantidadRetirar;
             System.out.println("Retiro exitoso");
             System.out.println("Saldo restante :" + saldo);
         }else if (cantidadRetirar > saldo ){
             System.out.println("error: saldo insuficiente. tu saldo actual es de : "+saldo );
         }else{
             System.out.println("cantidad no valida ");
         }
     }

     public static void depositar_dinero() {
         System.out.println("---------DEPOSITAR DINERO-----------");
         System.out.println("Ingresa la cantidad a depositar: ");
         double cantidadDepositar = sc.nextDouble();
         if (cantidadDepositar > 0) {
             saldo = saldo + cantidadDepositar;
             System.out.println("Depósito exitoso.");
             System.out.println("Tu nuevo saldo es de: " + saldo);
         } else {
             System.out.println("Cantidad no válida.");
         }
     }
}