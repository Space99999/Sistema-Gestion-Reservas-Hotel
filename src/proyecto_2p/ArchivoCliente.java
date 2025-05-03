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
public class ArchivoCliente {
        public static void grabarArchivoCli(String nombreArchivo,Cliente objCliente){
        try {
            File f =new File(nombreArchivo);
            FileWriter fw;
            BufferedWriter bw;
            
            if(!f.exists()){
                //crear y agregar el registro
                fw=new FileWriter(f);
                bw=new BufferedWriter(fw);
                bw.write(objCliente.getNombre()+","+objCliente.getApellido()+","+objCliente.getCedulaRuc()+","+objCliente.getTelefono()+","+objCliente.getEmail());
            }else{
                //agregar un nuevo registro
                fw=new FileWriter(f,true);
                bw=new BufferedWriter(fw);
                bw.newLine();
                bw.write(objCliente.getNombre()+","+objCliente.getApellido()+","+objCliente.getCedulaRuc()+","+objCliente.getTelefono()+","+objCliente.getEmail());
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error : "+e);
        }
        
    }
    
    //leer el archivo
    public static ArrayList<Cliente> listaCliente(String nombreArchivo){
        try {
            ArrayList<Cliente> listaaux=new ArrayList<Cliente>();
            File f= new File(nombreArchivo);
            if(f.exists()){
                //cargar la información
                FileReader fr=new FileReader(f);
                BufferedReader br=new BufferedReader(fr);
                String lineaTexto="";
                while((lineaTexto=br.readLine())!=null){
                    String[] vectorCliente=lineaTexto.split(",");
                    Cliente objCliente=new 
        Cliente(vectorCliente[0],vectorCliente[1],vectorCliente[2],vectorCliente[3],vectorCliente[4]);
                    listaaux.add(objCliente);
                }
                br.close();
                fr.close();
                return listaaux;
            }//else{
               // System.out.println("No existe el archivo con el siguiente nombre: "+nombreArchivo);
            //}
             return null;
        } catch (IOException e) {
            System.out.println("Error: "+e);
             return null;
        }
       
    }
}
