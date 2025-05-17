/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.etterem;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author linhenrik
 */
public class Etterem {

    public static void main(String[] args) {
        try{
            dbManager db = new dbManager();
            
            List<RendelesQuery> rendelesek = db.getAll();
            for (RendelesQuery rendeles : rendelesek){
                System.out.println(rendeles);
            }
            
            System.out.println("Legdrágább étel: " + db.getExpensive());
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Kérem az étel nevét: ");
            String nev = scanner.nextLine();
            System.out.println("Kérem az étel árát: ");
            int ar = scanner.nextInt();
            db.addNewMenu(nev, ar);
            
            System.out.println("Módosítandó étel ID: ");
            int id = scanner.nextInt();
            System.out.println("Új ár: ");
            int ujAr = scanner.nextInt();
            db.setNewPrice(id, ujAr);
        }
        catch(SQLException e){
            System.out.println("hiba: " + e.getMessage());
        }
    }
}
