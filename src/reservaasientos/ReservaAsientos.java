
package reservaasientos;

import java.util.Scanner;


public class ReservaAsientos {

    
    public static void main(String[] args) {
        //declaracion variables
        char asientos [][] = new char [10][10]; //usamos una martriz de 10 filas x 10 columnas
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila=0, asiento=0;
        String respuesta;
        String verMapa;
        
        //cargo la matriz de asientos
        for(int f=0;f<10;f++) { //recorro de forma horizontal
            for(int c=0;c<10;c++) { //recorro de forma vertical
                asientos[f][c] = 'L';
            }
        }
        
        
        //bienvenida al sistema
        System.out.println("----------BIENVENIDO AL SISTEMA DE RESERVAS----------");
        
        //reserva de asientos
        while(bandera != true) {
            System.out.println("Desea ver los asientos disponibles? S: Si. Cualquier otra letra: No");
            verMapa = teclado.next();
            
            //visualizacion de mapa
            if(verMapa.equalsIgnoreCase("S")) {
                dibujarMapa(asientos);
            }
            
            dibujarMapa(asientos);
            
            //reserva
            boolean estaOk = false;
            while(estaOk!=true) {
            System.out.println("Ingrese Fila y Asiento a reservar");
            System.out.print("Fila(entre 0 y 9):");
            fila = teclado.nextInt();
            
            System.out.print("Asiento(entre 0 y 9):");
            asiento = teclado.nextInt();
            
            if(fila <=9 && fila >=0) {
                if(asiento<=9 && asiento<=0){
                    estaOk=true;
                }
                else {
                    System.out.println("El numero de fila no es válido.");
                }
            }
            else{
                    System.out.println("El numero de asiento no es válido.");
               }
            }
            
            if(asientos[fila][asiento]=='L') {
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento fue reservado correctamente");
            }else {
                System.out.println("El asiento está ocupado. Por favor, elija otro");
                
            }
            
            System.out.println("Desea finalizar la reserva? S: Si. Cualquier otra letra: No");
            respuesta = teclado.next();
            
            if(respuesta.equalsIgnoreCase("S")) {
                bandera=true;
            }
        }
    }
    
    static void dibujarMapa(char asientos[][]) {
        for(int f=0;f<10;f++) { 
            System.out.print(f + " ");
            for(int c=0;c<10;c++) {
                System.out.print("[" + asientos[f][c] + "]");
            }
            System.out.println("");
        }
    }
    
}
