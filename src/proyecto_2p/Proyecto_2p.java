/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_2p;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PANDORA
 */
public class Proyecto_2p {

    /**
     * @param args the command line arguments
     */
    public static String nombrearchivo = "habitaciones.txt";
    public static String nombrearchivo2 = "Reservaciones.txt";
    public static String nombrearchivo3 = "Clientes.txt";
    public static String nombrearchivo4 = "Factura.txt";
    public static Scanner scan = new Scanner(System.in).useDelimiter("\n");
    public static ArrayList<Habitaciones> listaHabitaciones = new ArrayList<Habitaciones>();
    public static ArrayList<Reservaciones> listaReservaciones = new ArrayList<Reservaciones>();
    public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    public static ArrayList<Factura> listaFacturas = new ArrayList<Factura>();

    public static void main(String[] args) {
        // TODO code application logic here
        listaHabitaciones = ArchivosHabit.listaHabitaciones(nombrearchivo);
        //  listaReservaciones = ArchivoReservaciones.listaReservaciones(nombrearchivo2);
        listaReservaciones = ArchivoReservaciones.listaReservaciones(nombrearchivo2);
        listaClientes = ArchivoCliente.listaCliente(nombrearchivo3);
        listaFacturas = ArchivoFactura.listarFactura(nombrearchivo4);
        int op;
        do {
            op = menu();
            operaciones(op);
            System.out.print("Desea realizar otra operación SI(1): ");
            op = scan.nextInt();
        } while (op == 1);

    }

    public static int menu() {
        int op;
        do {
            System.out.println("****Hotel Tu descanso****");
            System.out.println("1: Administrar Habitaciones");
            System.out.println("2: Reservar Habitaciones");
            System.out.println("3: Listar Reservaciones");
            System.out.println("4: Listar Clientes");
            System.out.println("5: Facturar");
            System.out.println("6: Listar Facturas");
            System.out.println("Elija la operacion: ");
            op = scan.nextInt();
            scan.nextLine();
        } while (op < 1 || op > 6);
        return op;
    }

    public static void operaciones(int op) {
        int opmenu;
        switch (op) {
            case 1:
                opmenu = menuHotel();
                operacionesHotel(opmenu);
                break;
            case 2:
                fun_Reservaciones();
                break;
            case 3:
                fun_ListarReservaciones();
                break;
            case 4:
                fun_ListarClientes();
                break;
            case 5:
                fun_Facturar();
                break;
            case 6:
                fun_ListarFacturas();
                break;
        }
    }

    public static int menuHotel() {
        int opmenu;
        do {
            System.out.println("1: Ingresar Habitaciones");
            System.out.println("2: Modificar Habitaciones");
            System.out.println("3: Eliminar Habitaciones");
            System.out.println("4: Visualizar Habitaciones");
            System.out.println("Elija la operacion: ");
            opmenu = scan.nextInt();
            scan.nextLine();
        } while (opmenu < 1 || opmenu > 4);
        return opmenu;
    }

    public static void operacionesHotel(int opmenu) {

        switch (opmenu) {
            case 1:
                fun_IngresarHabitaciones();
                break;
            case 2:
                fun_modificarHabitaciones();
                break;
            case 3:
                fun_eliminarHabitacion();
                break;
            case 4:
                fun_Listar();
                break;

        }
    }

    public static void fun_IngresarHabitaciones() {
        int SelecHabitacion, numHabt, vistaAlmar, disponibilidad = 1;
        String descripcionHabt, tipoHabt;
        float precioBaseHabt;

        do {
            System.out.println("Seleccione el tipo de habitacion a registrar");
            System.out.println("1: Sencilla");
            System.out.println("2: Matrimoniales");
            System.out.println("3: Multiples");
            SelecHabitacion = scan.nextInt();

        } while (SelecHabitacion < 1 || SelecHabitacion > 3);

        System.out.println("Ingrese el número de la habitacion: ");
        numHabt = scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese La descripcion de la habitación: ");
        descripcionHabt = scan.nextLine();
        System.out.println("Ingrese el precio Base de la habitación: ");
        precioBaseHabt = scan.nextFloat();
        scan.nextLine();
        do {
            System.out.println("Tiene vista al mar Si(1) No(0)");
            vistaAlmar = scan.nextInt();
        } while (vistaAlmar < 0 || vistaAlmar > 1);
        if (SelecHabitacion == 1) {
            tipoHabt = "Habitacion Sencilla";
            HabitacionSencilla objHabt = new HabitacionSencilla(tipoHabt, numHabt, descripcionHabt, precioBaseHabt, disponibilidad, vistaAlmar);
            ArchivosHabit.grabarArchivo(nombrearchivo, objHabt);
        }
        if (SelecHabitacion == 2) {
            tipoHabt = "Habitacion Matrimonial";
            HabitacionesMatrimoniales objHabt = new HabitacionesMatrimoniales(tipoHabt, numHabt, descripcionHabt, precioBaseHabt, disponibilidad, vistaAlmar);
            ArchivosHabit.grabarArchivo(nombrearchivo, objHabt);

        }
        if (SelecHabitacion == 3) {
            int cantidadCamas;
            tipoHabt = "Habitacion Multiple";
            System.out.println("Ingrese la cantidad de Camas: ");
            cantidadCamas = scan.nextInt();
            HabitacionesMultiples objHabt = new HabitacionesMultiples(tipoHabt, numHabt, descripcionHabt, precioBaseHabt, disponibilidad, vistaAlmar, cantidadCamas);
            ArchivosHabit.grabarArchivo(nombrearchivo, objHabt);

        }
        listaHabitaciones = ArchivosHabit.listaHabitaciones(nombrearchivo);
    }

    public static void fun_Listar() {
        listaHabitaciones = ArchivosHabit.listaHabitaciones(nombrearchivo);
        for (Habitaciones objHabitaciones : listaHabitaciones) {
            objHabitaciones.mostrarHabitaciones();
            if (objHabitaciones instanceof HabitacionesMultiples) {
                ((HabitacionesMultiples) objHabitaciones).mostarHabitacionMulti();
            }
            System.out.println("");
        }

    }

    public static void fun_eliminarHabitacion() {
        int num_Habitacion;
        System.out.println("Ingrese el número de la habitacion a eliminar: ");
        num_Habitacion = scan.nextInt();
        ArchivosHabit.eliminarHabitacion(nombrearchivo, num_Habitacion);
        System.out.println("La habitación Con el número " + num_Habitacion + " Ha sido eliminado Correctamente");
    }

    public static void fun_modificarHabitaciones() {
        int num_Habitacion;
        System.out.println("Ingrese el número de la habitacion a Modificar: ");
        num_Habitacion = scan.nextInt();
        ArchivosHabit.ModificarHabitacion(nombrearchivo, num_Habitacion);
    }

    public static void fun_Reservaciones() {
        int num_Habitacion;
        Habitaciones dirHabitaciones;
        Cliente nuevocliente;
        LocalDate fechaInicio, fechaSalida;
        String nombre, apellido, cedula, telefono, email;
        int tipoTemporada;
        System.out.println("Ingrese el número de la habitacion Para Reservar: ");
        num_Habitacion = scan.nextInt();
        scan.nextLine();
        dirHabitaciones = fun_buscarHabitaciones(num_Habitacion);
        if (dirHabitaciones != null) {
            if (dirHabitaciones.getDisponibilidad() == 1) {
                // Solicitar la información del cliente
                System.out.println("Ingrese el nombre del cliente: ");
                nombre = scan.nextLine();
                System.out.println("Ingrese el apellido");
                apellido = scan.nextLine();
                System.out.println("Ingrese la cédula/RUC del cliente: ");
                cedula = scan.nextLine();
                System.out.println("Ingrese el teléfono del cliente: ");
                telefono = scan.nextLine();
                System.out.println("Ingrese el email del cliente: ");
                email = scan.nextLine();
                nuevocliente = new Cliente(nombre, apellido, cedula, telefono, email);
                ArchivoCliente.grabarArchivoCli(nombrearchivo3, nuevocliente);
                // Solicitar las fechas de inicio y salida
                System.out.println("Ingrese la fecha de inicio de la reservación (en formato AAAA-MM-DD): ");
                fechaInicio = LocalDate.parse(scan.next());
                System.out.println("Ingrese la fecha de salida de la reservación (en formato AAAA-MM-DD): ");
                fechaSalida = LocalDate.parse(scan.next());

                // Solicitar el tipo de temporada
                System.out.println("Ingrese el tipo de temporada (1: alta, 2: media, 3: baja): ");
                tipoTemporada = scan.nextInt();

                // Crear un nuevo objeto Reservacion con los datos proporcionados
                Reservaciones reservacion = new Reservaciones(num_Habitacion, fechaInicio, fechaSalida, cedula, tipoTemporada);
                ArchivoReservaciones.grabarArchivo(nombrearchivo2, reservacion);
                ArchivosHabit.ModificarHabitacionDisponibilidad(nombrearchivo, num_Habitacion);
            } else {
                System.out.println("La habitacion se encuentra Ocupada");
            }

        } else {
            System.out.println("La habitación no existe.");
        }
        listaReservaciones = ArchivoReservaciones.listaReservaciones(nombrearchivo2);
        listaClientes = ArchivoCliente.listaCliente(nombrearchivo3);
    }

    public static Habitaciones fun_buscarHabitaciones(int num_Habitacion) {
        Habitaciones dirHabitaciones = null;
        for (Habitaciones habitacion : listaHabitaciones) {
            if (habitacion.getNumHabt() == num_Habitacion) {
                dirHabitaciones = habitacion;
                break;
            }
        }

        return dirHabitaciones;
    }

    public static void fun_ListarReservaciones() {
        listaReservaciones = ArchivoReservaciones.listaReservaciones(nombrearchivo2);
        for (Reservaciones objReservaciones : listaReservaciones) {
            objReservaciones.mostrarReservaciones();

        }

    }

    public static void fun_ListarClientes() {
        listaClientes = ArchivoCliente.listaCliente(nombrearchivo3);
        for (Cliente objCliente : listaClientes) {
            objCliente.mostrarCliente();
            System.out.println("");
        }

    }

    public static Cliente fun_buscarClientes(String cedula) {
        Cliente dirCliente = null;
        for (Cliente ObjCliente : listaClientes) {
            if (ObjCliente.getCedulaRuc().equals(cedula)) {
                dirCliente = ObjCliente;
                break;
            }
        }

        return dirCliente;
    }

    public static Reservaciones fun_buscarReservaciones(String cedula) {
        Reservaciones dirReservaciones = null;
        for (Reservaciones ObjRe : listaReservaciones) {
            if (ObjRe.getCedula().equals(cedula)) {
                dirReservaciones = ObjRe;
                break;
            }
        }

        return dirReservaciones;
    }

    public static void fun_Facturar() {
        Reservaciones dirReservacion;
        Habitaciones dirHabitaciones;
        Factura dirFactura;
        String cedula, temporada;
        long auxDias;
        int num_Factura, num_Dias;
        float precioPordias, tasaTemporada, subtotal, precioConIva, totalApagar;
        System.out.println("Ingrese el número de la Factura");
        num_Factura = scan.nextInt();
        scan.nextLine();
        // dirFactura = fun_buscarFacturas(num_Factura);

        // if (dirFactura != null) {
        //     System.out.println("El número de la Factura " + num_Factura + " ya esta registrado");
        //} else {
        System.out.println("Ingrese el Numero de Cedula del Cliente");
        cedula = scan.nextLine();

        dirReservacion = fun_buscarReservaciones(cedula);
        if (dirReservacion != null) {
            dirReservacion.mostrarReservaciones();
            auxDias = ChronoUnit.DAYS.between(dirReservacion.getFechaInicio(), dirReservacion.getFechaSalida());
            num_Dias = (int) auxDias;

            dirHabitaciones = fun_buscarHabitaciones(dirReservacion.getNum_habitacion());
            precioPordias = num_Dias * dirHabitaciones.getPrecioBaseHabt();
            float precioTasa;
            switch (dirReservacion.getTipoTemporada()) {
                case 1:
                    precioTasa = 0.15f;
                    tasaTemporada = Math.round(precioPordias * precioTasa * 1000) / 1000.0f;
                    temporada = "ALTA";
                    break;
                case 2:
                    precioTasa = 0.10f;
                    tasaTemporada = Math.round(precioPordias * precioTasa * 1000) / 1000.0f;
                    temporada = "MEDIA";
                    break;
                default:
                    precioTasa = 0;
                    tasaTemporada = Math.round(precioPordias * precioTasa * 1000) / 1000.0f;
                    temporada = "BAJA";
                    break;
            }
            subtotal = precioPordias + tasaTemporada;
            precioConIva = Math.round(subtotal * 0.12f * 1000)/1000.0f;
            
            totalApagar = subtotal + precioConIva;
            System.out.println("");
            System.out.println("");
            System.out.println("---Facturacion---");
            System.out.println("Numero de dias Hospedados: " + num_Dias);
            System.out.println("Precio Por dias: " + precioPordias);
            System.out.println("Tasa por temporada " + temporada + ": " + tasaTemporada);
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Precio del iva del 12%: " + precioConIva);
            System.out.println("Total a pagar: " + totalApagar);

            Factura ObjFa = new Factura(num_Factura, cedula, num_Dias, precioPordias, tasaTemporada, subtotal, precioConIva, totalApagar);
            ArchivoFactura.grabarFactura(nombrearchivo4, ObjFa);
        } else {
            System.out.println("El cliente no existe");
        }
        //}
        listaFacturas = ArchivoFactura.listarFactura(nombrearchivo4);

    }

    public static Factura fun_buscarFacturas(int num_Factura) {
        listaFacturas = ArchivoFactura.listarFactura(nombrearchivo4);
        Factura dirFactura = null;
        for (Factura objFactura : listaFacturas) {
            if (objFactura.getNum_Fatura() == num_Factura) {
                dirFactura = objFactura;
                break;
            }
        }

        return dirFactura;
    }

    public static void fun_ListarFacturas() {
        listaFacturas = ArchivoFactura.listarFactura(nombrearchivo4);
        System.out.println("---Facturas---");
        for (Factura objFactura : listaFacturas) {
            objFactura.mostrarFactura();
            System.out.println("");
        }

    }
}//fin de la clase
