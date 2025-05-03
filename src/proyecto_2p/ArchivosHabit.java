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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PANDORA
 */
public class ArchivosHabit {

    //grabar en el archivo
    public static Scanner scan = new Scanner(System.in).useDelimiter("\n");

    public static void grabarArchivo(String nombreArchivo, Habitaciones objHabt) {
        try {
            File f = new File(nombreArchivo);
            FileWriter fw;
            BufferedWriter bw;

            if (!f.exists()) {
                //crear y agregar el registro
                if (objHabt instanceof HabitacionesMultiples) {
                    fw = new FileWriter(f);
                    bw = new BufferedWriter(fw);
                    bw.write(objHabt.getTipoHabt() + "," + objHabt.getNumHabt() + "," + objHabt.getDescripcionHabt() + "," + objHabt.getPrecioBaseHabt() + "," + objHabt.getDisponibilidad() + "," + objHabt.getVistaAlmar() + "," + ((HabitacionesMultiples) objHabt).getCantidadCamas());

                } else {
                    fw = new FileWriter(f);
                    bw = new BufferedWriter(fw);
                    bw.write(objHabt.getTipoHabt() + "," + objHabt.getNumHabt() + "," + objHabt.getDescripcionHabt() + "," + objHabt.getPrecioBaseHabt() + "," + objHabt.getDisponibilidad() + "," + objHabt.getVistaAlmar());

                }
            } else {
                //agregar un nuevo registro
                if (objHabt instanceof HabitacionesMultiples) {
                    fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    bw.newLine();
                    bw.write(objHabt.getTipoHabt() + "," + objHabt.getNumHabt() + "," + objHabt.getDescripcionHabt() + "," + objHabt.getPrecioBaseHabt() + "," + objHabt.getDisponibilidad() + "," + objHabt.getVistaAlmar() + "," + ((HabitacionesMultiples) objHabt).getCantidadCamas());

                } else {
                    fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    bw.newLine();
                    bw.write(objHabt.getTipoHabt() + "," + objHabt.getNumHabt() + "," + objHabt.getDescripcionHabt() + "," + objHabt.getPrecioBaseHabt() + "," + objHabt.getDisponibilidad() + "," + objHabt.getVistaAlmar());
                }

            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error : " + e);
        }

    }

    //leer el archivo
    public static ArrayList<Habitaciones> listaHabitaciones(String nombreArchivo) {
        try {
            ArrayList<Habitaciones> listaaux = new ArrayList<Habitaciones>();
            File f = new File(nombreArchivo);
            if (f.exists()) {
                //cargar la información
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String lineaTexto = "";
                while ((lineaTexto = br.readLine()) != null) {
                    String[] vectorHabitaciones = lineaTexto.split(",");
                    String tipoHabit = vectorHabitaciones[0].trim();

                    switch (tipoHabit) {
                        case "Habitacion Sencilla":
                            HabitacionSencilla objHabit = new HabitacionSencilla(vectorHabitaciones[0], Integer.parseInt(vectorHabitaciones[1]), vectorHabitaciones[2], Float.parseFloat(vectorHabitaciones[3]), Integer.parseInt(vectorHabitaciones[4]), Integer.parseInt(vectorHabitaciones[5]));
                            listaaux.add(objHabit);
                            break;
                        case "Habitacion Matrimonial":
                            HabitacionesMatrimoniales objHabit2 = new HabitacionesMatrimoniales(vectorHabitaciones[0], Integer.parseInt(vectorHabitaciones[1]), vectorHabitaciones[2], Float.parseFloat(vectorHabitaciones[3]), Integer.parseInt(vectorHabitaciones[4]), Integer.parseInt(vectorHabitaciones[5]));
                            listaaux.add(objHabit2);
                            break;
                        case "Habitacion Multiple":
                            HabitacionesMultiples objHabitacion = new HabitacionesMultiples(vectorHabitaciones[0], Integer.parseInt(vectorHabitaciones[1]), vectorHabitaciones[2], Float.parseFloat(vectorHabitaciones[3]), Integer.parseInt(vectorHabitaciones[4]), Integer.parseInt(vectorHabitaciones[5]), Integer.parseInt(vectorHabitaciones[6]));
                            listaaux.add(objHabitacion);
                            break;

                    }

                }
                br.close();
                fr.close();
                return listaaux;
            } //else {
            //System.out.println("No existe el archivo con el siguiente nombre: " + nombreArchivo);
            //}
            return null;
        } catch (IOException e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    public static void eliminarHabitacion(String nombreArchivo, int numeroHabitacion) {
        try {
            File archivoOriginal = new File(nombreArchivo);
            File archivoTemporal = new File("temporal.txt");
            BufferedReader lector = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea = "";
            while ((linea = lector.readLine()) != null) {
                String[] elementos = linea.split(",");
                int valor = Integer.parseInt(elementos[1]);
                if (valor != numeroHabitacion) {
                    escritor.write(linea);
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();
            archivoOriginal.delete();
            archivoTemporal.renameTo(archivoOriginal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ModificarHabitacion(String nombreArchivo, int numeroHabitacion) {
        try {
            File archivoOriginal = new File(nombreArchivo);
            File archivoTemporal = new File("temporal.txt");
            BufferedReader lector = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea = "";
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue; // saltar línea en blanco
                }
                if (!linea.contains(",")) {
                    continue; // saltar líneas que no contienen comas
                }
                String[] elementos = linea.split(",");
                if (elementos.length < 2) {
                    continue; // saltar líneas que no tienen suficientes elementos
                }
                String tipoHabit = elementos[0].trim();
                int valor = Integer.parseInt(elementos[1].trim());
                if (valor == numeroHabitacion) {
                    // Solicitar al usuario los nuevos valores
                    System.out.println("Ingrese los nuevos valores");
                    int numHabt, vistaAlmar, disponibilidad;
                    String descripcionHabt;
                    float precioBaseHabt;
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
                    do {
                        System.out.println("Disponibilidad  Si(1) No(0)");
                        disponibilidad = scan.nextInt();
                    } while (disponibilidad < 0 || disponibilidad > 1);
                    switch (tipoHabit) {
                        case "Habitacion Sencilla":
                            escritor.write("Habitacion Sencilla" + "," + Integer.toString(numHabt) + "," + descripcionHabt + "," + Float.toString(precioBaseHabt) + "," + Integer.toString(disponibilidad) + "," + Integer.toString(vistaAlmar));
                            escritor.newLine();
                            break;
                        case "Habitacion Matrimonial":
                            escritor.write("Habitacion Matrimonial" + "," + Integer.toString(numHabt) + "," + descripcionHabt + "," + Float.toString(precioBaseHabt) + "," + Integer.toString(disponibilidad) + "," + Integer.toString(vistaAlmar));
                            escritor.newLine();
                            break;
                        case "Habitacion Multiple":
                            int cantidadCamas;
                            System.out.println("Ingrese la cantidad de Camas: ");
                            cantidadCamas = scan.nextInt();
                            escritor.write("Habitacion Multiple" + "," + Integer.toString(numHabt) + "," + descripcionHabt + "," + Float.toString(precioBaseHabt) + "," + Integer.toString(disponibilidad) + "," + Integer.toString(vistaAlmar) + "," + Integer.toString(cantidadCamas));
                            escritor.newLine();
                            break;

                    }

                    // Escribir la nueva línea en el archivo temporal
                } else {

                    // Escribir la línea original en el archivo temporal
                    escritor.write(linea);
                    escritor.newLine();
                }
            }
            lector.close();
            escritor.close();
            archivoOriginal.delete();
            archivoTemporal.renameTo(archivoOriginal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void ModificarHabitacionDisponibilidad(String nombreArchivo, int numeroHabitacion) {
        try {
            File archivoOriginal = new File(nombreArchivo);
            File archivoTemporal = new File("temporal.txt");
            BufferedReader lector = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea = "";
            while ((linea = lector.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue; // saltar línea en blanco
                }
                if (!linea.contains(",")) {
                    continue; // saltar líneas que no contienen comas
                }
                String[] elementos = linea.split(",");
                if (elementos.length < 2) {
                    continue; // saltar líneas que no tienen suficientes elementos
                }
                String tipoHabit = elementos[0].trim();
                int valor = Integer.parseInt(elementos[1].trim());
                if (valor == numeroHabitacion) {
                    // Solicitar al usuario los nuevos valores
                    
                    int  disponibilidad=0;

                    switch (tipoHabit) {
                        case "Habitacion Sencilla":
                            escritor.write("Habitacion Sencilla" + "," + elementos[1]+ "," + elementos[2] + "," + elementos[3] + "," + Integer.toString(disponibilidad) + "," + elementos[5]);
                            escritor.newLine();
                            break;
                        case "Habitacion Matrimonial":
                            escritor.write("Habitacion Matrimonial" + "," + elementos[1]+ "," + elementos[2] + "," + elementos[3] + "," + Integer.toString(disponibilidad) + "," + elementos[5]);
                            escritor.newLine();
                            break;
                        case "Habitacion Multiple":

                            escritor.write("Habitacion Multiple" + "," + elementos[1]+ "," + elementos[2] + "," + elementos[3] + "," + Integer.toString(disponibilidad) + "," + elementos[5]+","+elementos[6]);
                            escritor.newLine();
                            break;

                    }

                    // Escribir la nueva línea en el archivo temporal
                } else {

                    // Escribir la línea original en el archivo temporal
                    escritor.write(linea);
                    escritor.newLine();
                }
            }
            lector.close();
            escritor.close();
            archivoOriginal.delete();
            archivoTemporal.renameTo(archivoOriginal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
