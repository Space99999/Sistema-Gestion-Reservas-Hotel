/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2p;

/**
 *
 * @author PANDORA
 */
public abstract class Habitaciones {

/*public static Habitaciones fromString(String habitacion) {
    if (habitacion.equalsIgnoreCase("Habitacion Sencilla")) {
        return new HabitacionSencilla();
    } else if (habitacion.equalsIgnoreCase("Habitacion Matrimonial")) {
        return new HabitacionesMatrimoniales();
    } else if (habitacion.equalsIgnoreCase("Habitacion Multiple")) {
        return new HabitacionesMultiples();
    
    } else {
        throw new IllegalArgumentException("Tipo de habitación inválido");
    }
}*/
    private String tipoHabt;
    private int numHabt;
    private String descripcionHabt;
    private float precioBaseHabt;
    private int disponibilidad;
    private int vistaAlmar;

    public Habitaciones(String tipoHabt, int numHabt, String descripcionHabt, float precioBaseHabt, int disponibilidad, int vistaAlmar) {
        this.tipoHabt = tipoHabt;
        this.numHabt = numHabt;
        this.descripcionHabt = descripcionHabt;
        this.precioBaseHabt = precioBaseHabt;
        this.disponibilidad = disponibilidad;
        this.vistaAlmar = vistaAlmar;
    }

    public String getTipoHabt() {
        return tipoHabt;
    }

    public void setTipoHabt(String tipoHabt) {
        this.tipoHabt = tipoHabt;
    }

    public int getNumHabt() {
        return numHabt;
    }

    public void setNumHabt(int numHabt) {
        this.numHabt = numHabt;
    }

    public String getDescripcionHabt() {
        return descripcionHabt;
    }

    public void setDescripcionHabt(String descripcionHabt) {
        this.descripcionHabt = descripcionHabt;
    }

    public float getPrecioBaseHabt() {
        return precioBaseHabt;
    }

    public void setPrecioBaseHabt(float precioBaseHabt) {
        this.precioBaseHabt = precioBaseHabt;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getVistaAlmar() {
        return vistaAlmar;
    }

    public void setVistaAlmar(int vistaAlmar) {
        this.vistaAlmar = vistaAlmar;
    }

    
    


    public void mostrarHabitaciones() {
        System.out.println("Tipo de habitacion: " + tipoHabt);
        System.out.println("Numero de la habitacion: " + numHabt);
        System.out.println("Descripcion de la Habitacion: " + descripcionHabt);
        System.out.println("Precio Base: " + precioBaseHabt);
        if (vistaAlmar == 1) {
            System.out.println("La habitacion cuenta con vista al mar");
        } else {
            System.out.println("La ahabitacion no cuenta con vista al mar");
        }
        if(disponibilidad==1){
            System.out.println("Habitacion Disponible");
        }else{
            System.out.println("Habitacion Ocupada");
        }
    }
    public void mostrarHabitacionesReserva() {
        System.out.println("Tipo de habitacion: " + tipoHabt);
        System.out.println("Numero de la habitacion: " + numHabt);
        System.out.println("Descripcion de la Habitacion: " + descripcionHabt);
        System.out.println("Precio Base: " + precioBaseHabt);
        if (vistaAlmar == 1) {
            System.out.println("La habitacion cuenta con vista al mar");
        } else {
            System.out.println("La ahabitacion no cuenta con vista al mar");
        }

    }

    @Override
    public String toString() {
        return getTipoHabt() + ", número " + getNumHabt();
    }
}
