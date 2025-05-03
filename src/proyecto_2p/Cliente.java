/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_2p;

/**
 *
 * @author PANDORA
 */
public class Cliente {


    private String nombre;
    private String apellido;
    private String CedulaRuc;
    private String telefono;
    private String email;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String CedulaRuc, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CedulaRuc = CedulaRuc;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedulaRuc() {
        return CedulaRuc;
    }

    public void setCedulaRuc(String CedulaRuc) {
        this.CedulaRuc = CedulaRuc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void mostrarCliente(){
        System.out.println("Datos del cliente ");
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Cedula/Ruc: "+CedulaRuc);
        System.out.println("Telefono: "+telefono);
        System.out.println("Correo: "+ email);
    }
}
