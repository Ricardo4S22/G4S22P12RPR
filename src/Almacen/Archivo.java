/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;
import Informacion.Datos;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ABIGAILSOFIA
 */
public class Archivo {

    private String cadena;
    
    public void agregarUsuario(Datos datos){
        String cadena = convertirJson(datos);
        try{
            FileWriter archivo = new FileWriter("Datos.txt",true);
            BufferedWriter bw = new BufferedWriter(archivo);
            bw.write(cadena + "\n");
            bw.close();
        }catch(Exception ex){
        ex.getStackTrace();
        } 
    }
    
    public List<Datos> LeerUsuarios(){
        List<Datos> listdatos = new ArrayList <> ();
        try{
            FileReader archivo = new FileReader("Datos.txt");
            BufferedReader br = new BufferedReader (archivo);
            while((cadena = br.readLine()) !=null){
                listdatos.add(convEstructura(cadena));
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        } return listdatos;
    }
    
    private String convertirJson(Datos datos){
        Gson gson = new Gson();
        String cadena;
        cadena = gson.toJson(datos);
        return cadena;    
    }
    
    private Datos convEstructura(String cadena){
        Gson gson = new Gson();
        Datos datos = new Datos();
        datos = gson.fromJson(cadena, Datos.class);
        return datos;
  }
}

