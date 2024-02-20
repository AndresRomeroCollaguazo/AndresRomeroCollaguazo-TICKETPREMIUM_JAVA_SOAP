/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.monster.prueba;

import ec.edu.monster.bd.AccesoDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mateo
 */
public class PruebaConexionDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("OK");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}