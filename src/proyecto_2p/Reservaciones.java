/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2p;

import java.time.LocalDate;
import static proyecto_2p.Proyecto_2p.fun_buscarClientes;
import static proyecto_2p.Proyecto_2p.fun_buscarHabitaciones;

/**
 *
 * @author PANDORA
 */
public class Reservaciones {
    private int num_habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaSalida;
    private String cedula;
    private int tipoTemporada;

    public Reservaciones(int num_habitacion, LocalDate fechaInicio, LocalDate fechaSalida, String cedula, int tipoTemporada) {
        this.num_habitacion = num_habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
        this.cedula = cedula;
        this.tipoTemporada = tipoTemporada;
    }

    public int getNum_habitacion() {
        return num_habitacion;
    }

    public void setNum_habitacion(int num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(int tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }




    public void mostrarReservaciones(){
        System.out.println("---Datos De la Reserva---");
        System.out.println("**Datos Habitaciones**");
        Habitaciones dirHabitaciones;
        dirHabitaciones = fun_buscarHabitaciones(num_habitacion);
        dirHabitaciones.mostrarHabitacionesReserva();
        if (dirHabitaciones instanceof HabitacionesMultiples) {
                ((HabitacionesMultiples) dirHabitaciones).mostarHabitacionMulti();
            }

        System.out.println("Fecha de inicio"+fechaInicio);
        System.out.println("Fecha de Salida"+ fechaSalida);
        System.out.println("**Datos Del Cliente**");
        Cliente dirCliente;
        dirCliente = fun_buscarClientes(cedula);
        dirCliente.mostrarCliente();
        String temporada;
        switch (tipoTemporada) {
            case 1:
                temporada = "ALTA";
                break;
            case 2:
                temporada = "MEDIA";
                break;
            default:
                temporada  = "BAJA";
                break;
        }
        System.out.println("El tipo de temporada es:  "+temporada);
        System.out.println("");
    }
}