/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2p;

/**
 *
 * @author PANDORA
 */
public class HabitacionesMultiples extends Habitaciones {

    private int cantidadCamas;

    public HabitacionesMultiples(String tipoHabt, int numHabt, String descripcionHabt, float precioBaseHabt, int disponibilidad, int vistaAlmar,int cantidadCamas) {
        super(tipoHabt, numHabt, descripcionHabt, precioBaseHabt, disponibilidad, vistaAlmar);
        this.cantidadCamas = cantidadCamas;
    }


    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public void mostarHabitacionMulti() {

        System.out.println("La cantidad de camas de esta habitacion es: " + cantidadCamas);
    }

    @Override
    public String toString() {
        return "HabitacionesMultiples, número " + getNumHabt();
    }
}
