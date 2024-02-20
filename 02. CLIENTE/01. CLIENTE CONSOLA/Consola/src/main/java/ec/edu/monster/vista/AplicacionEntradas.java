/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.monster.vista;

import ec.edu.monster.controlador.TicketController;

import ec.edu.monster.ws.Factura;
import ec.edu.monster.ws.Localidad;
import ec.edu.monster.ws.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class AplicacionEntradas {

    public static void main(String[] args) {
        boolean flag;
        do {
            flag = menu();
        } while (!flag);

        limpiarConsola();
        int opcion;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=================================================================");
            System.out.println("||\tBienvenido a la Aplicación de Compra de Entradas\t||");
            System.out.println("===================================================================");
            System.out.println("|| 1. Comprar Entradas                                          ||");
            System.out.println("|| 2. Ver Reporte                                               ||");
            System.out.println("|| 0. Salir                                                     ||");
            System.out.println("=================================================================");
            System.out.print(" Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    comprarEntradas();
                    opcion = 0;
                    break;
                case 2:
                    verReporte();
                    opcion = 0;
                    break;
                case 0:
                    System.out.println("¡Gracias por utilizar la aplicación!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
            scanner.close();
            System.out.println();
        } while (opcion != 0);

    }

    public static boolean menu() {
        boolean paso = false;
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String username, password, nombre, apellido, cedula, direccion;
        TicketController controller = new TicketController();
        System.out.println("**********************************************");
        System.out.println("||\t\tBienvenido a TicketPremium Ecuador\t\t||");
        System.out.println("||\t\tGrupo #3 ANDRANGO - CANTUÑA - ROMERO\t\t||");
        System.out.println("**********************************************");
        System.out.println("|| 1. Iniciar Sesión                                     ||");
        System.out.println("|| 0. Sali                                               ||");
        System.out.println("**********************************************");
        System.out.println("Ingrese una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter de nueva línea

        switch (opcion) {
            case 0:
                System.out.println("Gracias por preferirnos !.");
                System.exit(0);
                
            case 1:
                System.out.println("|| Ingrese su Usuario: ");
                username = scanner.nextLine();
                System.out.println("|| Ingrese su Contraseña: ");
                password = scanner.nextLine();

                paso = controller.comprobarUsuario(username, password);
                if (paso) {
                    System.out.println("");
                    System.out.println("||    Inicio de Sesión exitoso     ||");
                    System.out.println("");
                } else {
                    System.out.println("\u001B[36m" +"**********************************************************");
                    System.out.println("\u001B[36m" +"||  Usuario o contraseña incorrectos, intente de nuevo  ||");
                    System.out.println("\u001B[36m" +"**********************************************************");
                    
                }
                break;
            case 2:
                System.out.println("Usuario: ");
                username = scanner.nextLine();
                System.out.println("Contraseña: ");
                password = scanner.nextLine();
                System.out.println("Nombre: ");
                nombre = scanner.nextLine();
                System.out.println("Apellido: ");
                apellido = scanner.nextLine();
                System.out.println("Cedula: ");
                cedula = scanner.nextLine();
                System.out.println("Direccion: ");
                direccion = scanner.nextLine();
                controller.registrarUsuario(username, password, nombre, apellido, cedula, direccion);
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    return paso;
}

    public static void comprarEntradas() {
        Scanner scanner = new Scanner(System.in);
        int partido;
        int palco = 0, tribuna = 0, general = 0, generalVisitante = 0;

        TicketController controller = new TicketController();
        List<Ticket> lista = controller.traerPartidos();

        // Mostrar lista de partidos y solicitar selección
        System.out.println("Partidos Disponibles:");
        System.out.println("*");
        for (Ticket tk : lista) {
            String fechaFormateada = tk.getFechaPartido().toString().substring(0, 10);
            System.out.println(tk.getCodigoPartido() + ". " + tk.getEquipoLocal() + " vs " + tk.getEquipoVisita() + "  " + fechaFormateada + "  " + tk.getHoraPartido());
        }
        System.out.println("*");
         do {
            System.out.print("Seleccione el partido para su compra: ");
            partido = scanner.nextInt();

            // Verifica que el índice seleccionado esté dentro del rango válido
            if (partido < 1 || partido > lista.size()) {
                System.out.println("Índice de partido inválido. Por favor, seleccione un partido válido.");
            }
        } while (partido < 1 || partido > lista.size());
        //System.out.print("Seleccione el partido deseado: ");
        //partido = scanner.nextInt();

        // Solicitar cantidad de localidades deseadas
        System.out.print("¿Cuantos tickets desea en Palco?(máximo 4): ");
        palco = scanner.nextInt();
        System.out.print("¿Cuantos tickets desea en Tribuna? (máximo 4): ");
        tribuna = scanner.nextInt();
        System.out.print("¿Cuantos tickets desea en General? (máximo 4): ");
        general = scanner.nextInt();
        System.out.print("¿Cuantos tickets desea en General Visitante? (máximo 4): ");
        generalVisitante = scanner.nextInt();

        // Calcular subtotal, IVA y total
        double subtotal = calcularSubtotal(palco, tribuna, general, generalVisitante, partido);
        double iva = subtotal * 0.12;
        double total = subtotal + iva;

        // Mostrar resumen de la compra
        System.out.println("________________________________________________________________________________");
        System.out.println("|\t\t\t\tResumen de su Compra\t\t\t\t|");
        System.out.println("|\tLocalidad\t\t\t|\tCantidad\t\t\t|");
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("|\tPalco\t\t\t\t\t " + palco);
        System.out.println("|\tTribuna\t\t\t\t\t " + tribuna);
        System.out.println("|\tGeneral\t\t\t\t\t " + general);
        System.out.println("|\tGeneral Visitante\t\t\t " + generalVisitante);
        System.out.println();
        System.out.println("_________________________________________________________________________________");
        System.out.println("|Subtotal: \t\t\t\t\t $" + subtotal+"                   " );
        System.out.println("|IVA (12%): \t\t\t\t\t $" + iva+"                       ");
        System.out.println("|Total: \t\t\t\t\t $" + total+"                         ");
        System.out.println("_________________________________________________________________________________");

        // Solicitar tipo de factura
        System.out.print("¿Desea factura? (Sí / No): ");
        String facturaOption = scanner.next();
        Ticket tk = lista.get(partido - 1);

        if (facturaOption.equalsIgnoreCase("sí") || facturaOption.equalsIgnoreCase("si")) {
            generarFactura(palco, tribuna, general, generalVisitante, total, tk.getCodigoPartido());
             
        } else {
            generarConsumidorFinal(palco, tribuna, general, generalVisitante, total, tk.getCodigoPartido());
        }

        scanner.close();
    }

    public static void generarFactura(int palco, int tribuna, int general, int generalVisitante, double total, int codigoPartido) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los siguientes datos para la factura:");
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Cédula o RUC: ");
        String cedula = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        // Guardar datos en la base de datos
        // Aquí debes implementar el código para guardar los datos en la base de datos
        TicketController controller = new TicketController();
        controller.registroCompra(nombres, cedula, direccion, palco, tribuna, general, generalVisitante, total, codigoPartido);
        System.out.println("Factura generada correctamente.");
        System.out.println("Gracias por su compra.");

        scanner.close();
    }

    public static void generarConsumidorFinal(int palco, int tribuna, int general, int generalVisitante, double total, int codigoPartido) {
        // Guardar datos en la base de datos con cédula, nombres y dirección "-"
        // Aquí debes implementar el código para guardar los datos en la base de datos
        TicketController controller = new TicketController();
        //controller.registroCompra("-", "-", "-", palco, tribuna, general, generalVisitante, total, codigoPartido);
        //System.out.println("Venta realizada como Consumidor Final.");
        System.out.println("Gracias por su compra.");
    }

    public static double calcularSubtotal(int palco, int tribuna, int general, int generalVisitante, int partido) {
        TicketController controller = new TicketController();
        List<Ticket> lista = controller.traerPartidos();
        Ticket tk = lista.get(partido - 1);
        List<Localidad> localidad = controller.traerLocalidades(tk.getCodigoPartido());
        List<Double> precios = new ArrayList<>();
        for (Localidad lc : localidad) {
            precios.add(lc.getPrecioLocalidad());
        }
        double precioTribuna = precios.get(0);
        double precioPalco = precios.get(1);
        double precioGeneral = precios.get(2);
        double precioGeneralVisitante = precios.get(3);

        double subtotalPalco = palco * precioPalco;
        double subtotalTribuna = tribuna * precioTribuna;
        double subtotalGeneral = general * precioGeneral;
        double subtotalGeneralVisitante = generalVisitante * precioGeneralVisitante;

        return subtotalPalco + subtotalTribuna + subtotalGeneral + subtotalGeneralVisitante;
    }

    public static void verReporte() {
        Scanner scanner = new Scanner(System.in);
        int partido;
        TicketController controller = new TicketController();
        List<Ticket> lista = controller.traerPartidos();

        // Mostrar lista de partidos y solicitar selección
        System.out.println("Partidos Disponibles:");
        for (Ticket tk : lista) {
            String fechaFormateada = tk.getFechaPartido().toString().substring(0, 10);
            System.out.println(tk.getCodigoPartido() + ". " + tk.getEquipoLocal() + " vs " + tk.getEquipoVisita() + "  " + fechaFormateada + "  " + tk.getHoraPartido());
        }
        System.out.print("Seleccione el partido deseado: ");
        partido = scanner.nextInt();
        Ticket tk = lista.get(partido - 1);
        List<Localidad> localidad = controller.traerLocalidades(tk.getCodigoPartido());
        List<Factura> reporte = controller.traerReporte(tk.getCodigoPartido());
        int cantPalco = 0;
        int cantTribuna = 0;
        int cantGeneral = 0;
        int cantGeneralV = 0;
        for (Factura fc : reporte) {
            cantPalco = cantPalco + fc.getCantPalco();
            cantTribuna = cantTribuna + fc.getCantTribuna();
            cantGeneral = cantGeneral + fc.getCantGeneral();
            cantGeneralV = cantGeneralV + fc.getCantGeneralVisita();
        }
        List<Integer> totales = new ArrayList<>();
        totales.add(cantTribuna);
        totales.add(cantPalco);
        totales.add(cantGeneral);
        totales.add(cantGeneralV);
        // Mostrar reporte de localidades vendidas
        System.out.println("Reporte de Localidades Vendidas:");
        System.out.println("Localidad\t\tVendido\tRecaudado");
        System.out.println("---------\t\t-------\t----------");
        // Aquí debes implementar el código para obtener los datos de la base de datos y mostrarlos en la tabla
        for (int i = 0; i < localidad.size(); i++) {
            Localidad lc = localidad.get(i);
            int total = totales.get(i);
            System.out.println(lc.getNombreLocalidad() + "\t\t\t" + total + "\t" + (lc.getPrecioLocalidad() * total));
        }

        scanner.close();
    }
    
    public static void limpiarConsola() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}