/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author PANDORA
 */
public class ArchivoReservaciones {
    //grabar en el archivo

    public static void grabarArchivo(String nombreArchivo2, Reservaciones objRe) {
        try {
            File f = new File(nombreArchivo2);
            FileWriter fw;
            BufferedWriter bw;

            if (!f.exists()) {
                //crear y agregar el registro
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);
                bw.write(objRe.getNum_habitacion() + "," + objRe.getFechaInicio() + "," + objRe.getFechaSalida() + "," + objRe.getCedula() + "," + objRe.getTipoTemporada());
            } else {
                //agregar un nuevo registro
                fw = new FileWriter(f, true);
                bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(objRe.getNum_habitacion() + "," + objRe.getFechaInicio() + "," + objRe.getFechaSalida() + "," + objRe.getCedula() + "," + objRe.getTipoTemporada());
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }

    }

    //leer el archivo
    
    public static ArrayList<Reservaciones> listaReservaciones(String nombreArchivo2) {
        try {
            ArrayList<Reservaciones> listaaux = new ArrayList<Reservaciones>();
            File f = new File(nombreArchivo2);
            if (f.exists()) {
                //cargar la información
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String lineaTexto = "";
                while ((lineaTexto = br.readLine()) != null) {
                    String[] vectorReservaciones = lineaTexto.split(",");
                    
                    String fechaInicioStr = vectorReservaciones[1];
                    LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String fechaFinStr = vectorReservaciones[2];
                    LocalDate fechaFin = LocalDate.parse(fechaFinStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    
                    Reservaciones objReservaciones = new Reservaciones(Integer.parseInt(vectorReservaciones[0]), fechaInicio, fechaFin, vectorReservaciones[3], Integer.parseInt(vectorReservaciones[4]));
                    listaaux.add(objReservaciones);
                    
                }
                br.close();
                fr.close();
                return listaaux;
            } else {
                //System.out.println("No existe el archivo con el siguiente nombre: " + nombreArchivo2);
            }
            return null;
        } catch (IOException e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    
}
