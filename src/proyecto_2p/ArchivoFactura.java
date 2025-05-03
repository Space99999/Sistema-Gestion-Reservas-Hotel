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

/**
 *
 * @author PANDORA
 */
public class ArchivoFactura {
        //grabar en el archivo
    public static void grabarFactura(String nombreArchivo,Factura objFa){
        try {
            File f =new File(nombreArchivo);
            FileWriter fw;
            BufferedWriter bw;
            
            if(!f.exists()){
                //crear y agregar el registro
                fw=new FileWriter(f);
                bw=new BufferedWriter(fw);
                bw.write(objFa.getNum_Fatura()+","+objFa.getCedula()+","+objFa.getNum_Dias()+","+objFa.getPrecioPordias()+","+objFa.getTasaTemporada()+","+objFa.getSubtotal()+","+objFa.getPrecioConIva()+","+objFa.getTotalApagar());
            }else{
                //agregar un nuevo registro
                fw=new FileWriter(f,true);
                bw=new BufferedWriter(fw);
                bw.newLine();
                bw.write(objFa.getNum_Fatura()+","+objFa.getCedula()+","+objFa.getNum_Dias()+","+objFa.getPrecioPordias()+","+objFa.getTasaTemporada()+","+objFa.getSubtotal()+","+objFa.getPrecioConIva()+","+objFa.getTotalApagar());
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error : "+e);
        }
        
    }
    
    //leer el archivo
    public static ArrayList<Factura> listarFactura(String nombreArchivo){
        try {
            ArrayList<Factura> listaaux=new ArrayList<Factura>();
            File f= new File(nombreArchivo);
            if(f.exists()){
                //cargar la información
                FileReader fr=new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                String lineaTexto="";
                while((lineaTexto=br.readLine())!=null){
                    String[] vectorFactura=lineaTexto.split(",");
                    Factura objFa=new 
        Factura(Integer.parseInt(vectorFactura[0]),vectorFactura[1],Integer.parseInt(vectorFactura[2]),Float.parseFloat(vectorFactura[3]),Float.parseFloat(vectorFactura[4]),Float.parseFloat(vectorFactura[5]),Float.parseFloat(vectorFactura[6]),Float.parseFloat(vectorFactura[7]));
                    listaaux.add(objFa);
                }
                br.close();
                fr.close();
                return listaaux;
            }else{
                //System.out.println("No existe el archivo con el siguiente nombre: "+nombreArchivo);
            }
             return null;
        } catch (IOException e) {
            System.out.println("Error: "+e);
             return null;
        }
       
    }
    
}
