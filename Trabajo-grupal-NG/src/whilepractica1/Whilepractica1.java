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
             System.out.println("==================");
             System.out.println("CAJERO AUTOMATICO");
             System.out.println("====================");
             System.out.println("ingrese su tarjeta: ");
             System.out.println("tarjeta detectada");
             System.out.println("ingrese su clave");
             int clave_ingresada = sc.nextInt();
             int opcion;
             
             if (clave_ingresada == clave){
                do {
                 System.out.println("\nBIENBENIDO AL CAJERO ");//mejora de mensaje
                 System.out.println("\n========== MENU ==========");
                 System.out.println("1.consultar tu saldo");
                 System.out.println("2.retirar el dinero");
                 System.out.println("3.depositar dinero");
                 System.out.println("4.salir del sistema");
                 System.out.println("ingrese la opcion deseada: ");
                 System.out.println("''''''''''''''''''''''''''''");
                 
                 // CAMBIO 6: Validamos si lo que ingresó el usuario es realmente un número entero
                 if (sc.hasNextInt()) {
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
                             System.out.println("Cerrando sesion...");
                             System.out.println("gracias por utilizar nuestro cajero");
                             sesionActiva = false; 
                             break;
                         default:
                             // (Cambio 5 realizado: Eliminada variable muerta)
                             System.out.println("opcion incorrecta");
                     }
                 } else {
                     // Si ingresa una letra o símbolo, entra aquí sin romper el programa
                     System.out.println("Error: Por favor, ingrese un numero valido (1-4).");
                     opcion = 0; // Reseteamos la opción para que no se quede en bucle infinito
                     sc.next(); // Limpiamos el buffer consumiendo la letra incorrecta
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
         System.out.printf("Saldo disponible: $%.2f%n", saldo);
         System.out.println(" Consulta realizada.");
     }
     
     // Retirar saldo 
     public static void retirar_saldo (){
         System.out.println("---------RETIRAR SALDO-----------");
         System.out.println("Ingresa la cantidad a retirar: ");
         double cantidadRetirar = sc.nextDouble();
         
         // Validamos que tenga dinero y que no pida numeros negativos
         if (cantidadRetirar >0 && cantidadRetirar <=saldo){
              System.out.println("Confirma el retiro de $" + cantidadRetirar + "?");
              System.out.println("1. Si");
              System.out.println("2. No");

            int confirmar = sc.nextInt();
            if(confirmar == 1){saldo -= cantidadRetirar;

            System.out.println(" Retiro realizado correctamente.");
            System.out.printf("Saldo restante: %.2f%n", saldo);
            }else {

            System.out.println("Operacion cancelada.");
        }
         }else if (cantidadRetirar > saldo ){
             System.out.println("error: saldo insuficiente. tu saldo actual es de :$ "+saldo );
         }else{
             System.out.println("la cantidad ingresada no es valida ");
         }
     }

     // Depositar saldo (Cambio 1 realizado)
     public static void depositar_dinero() {
         System.out.println("---------DEPOSITAR DINERO-----------");
         System.out.println("Ingresa la cantidad a depositar: ");
         double cantidadDepositar = sc.nextDouble();
         
         if (cantidadDepositar > 0) {
             saldo = saldo + cantidadDepositar; // Sumamos al saldo global
             System.out.println("Depósito realizado correctamente.");
             System.out.println("Tu nuevo saldo es de: " + saldo);
         } else {
             System.out.println("Cantidad no válida.");
         }
     }
 
}