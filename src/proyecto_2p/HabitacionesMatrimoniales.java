/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2p;

/**
 *
 * @author PANDORA
 */
public class HabitacionesMatrimoniales extends Habitaciones {

    public HabitacionesMatrimoniales(String tipoHabt, int numHabt, String descripcionHabt, float precioBaseHabt, int disponibilidad, int vistaAlmar) {
        super(tipoHabt, numHabt, descripcionHabt, precioBaseHabt, disponibilidad, vistaAlmar);
    }



    public void mostarHabitacionMatri() {
        super.mostrarHabitaciones();

    }

    @Override
    public String toString() {
        return "HabitacionesMatrimoniales, número " + getNumHabt();
    }
}
