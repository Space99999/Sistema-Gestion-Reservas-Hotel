/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2p;

import static proyecto_2p.Proyecto_2p.fun_buscarReservaciones;

/**
 *
 * @author PANDORA
 */
public class Factura {

    private int num_Fatura;
    private String Cedula;
    private int num_Dias;
    private float precioPordias;
    private float tasaTemporada;
    private float subtotal;
    private float precioConIva;
    private float totalApagar;

    public Factura(int num_Fatura, String Cedula, int num_Dias, float precioPordias, float tasaTemporada, float subtotal, float precioConIva, float totalApagar) {
        this.num_Fatura = num_Fatura;
        this.Cedula = Cedula;
        this.num_Dias = num_Dias;
        this.precioPordias = precioPordias;
        this.tasaTemporada = tasaTemporada;
        this.subtotal = subtotal;
        this.precioConIva = precioConIva;
        this.totalApagar = totalApagar;
    }

    public int getNum_Fatura() {
        return num_Fatura;
    }

    public void setNum_Fatura(int num_Fatura) {
        this.num_Fatura = num_Fatura;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public int getNum_Dias() {
        return num_Dias;
    }

    public void setNum_Dias(int num_Dias) {
        this.num_Dias = num_Dias;
    }

    public float getPrecioPordias() {
        return precioPordias;
    }

    public void setPrecioPordias(float precioPordias) {
        this.precioPordias = precioPordias;
    }

    public float getTasaTemporada() {
        return tasaTemporada;
    }

    public void setTasaTemporada(float tasaTemporada) {
        this.tasaTemporada = tasaTemporada;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getPrecioConIva() {
        return precioConIva;
    }

    public void setPrecioConIva(float precioConIva) {
        this.precioConIva = precioConIva;
    }

    public float getTotalApagar() {
        return totalApagar;
    }

    public void setTotalApagar(float totalApagar) {
        this.totalApagar = totalApagar;
    }

    public void mostrarFactura() {
        Reservaciones dirReservacion;
        dirReservacion = fun_buscarReservaciones(Cedula);
        String temporada;
         switch (dirReservacion.getTipoTemporada()) {
                    case 1:
                        temporada = "ALTA";
                        break;
                    case 2:
                        temporada = "MEDIA";
                        break;
                    default:
                        temporada = "BAJA";
                        break;
                }
        
        System.out.println("Número de Factura: "+num_Fatura);
        System.out.println("Ceddula cliente: "+ Cedula);
        System.out.println("Numero de dias Hospedados: " + num_Dias);
        System.out.println("Precio Por dias: " + precioPordias);
        System.out.println("Tasa por temporada " + temporada + ": " + tasaTemporada);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Precio del iva del 12%: " + precioConIva);
        System.out.println("Total a pagar: " + totalApagar);
        System.out.println("");

    }

}
