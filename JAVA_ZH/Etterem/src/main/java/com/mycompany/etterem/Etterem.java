/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.etterem;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author szoky
 */

public class Etterem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Adatbázis kapcsolat létrehozása
            DbManager db = new DbManager("Etterem.db");

            boolean running = true;
            while (running) {
                System.out.println("\nVálassz egy lehetőséget:");
                System.out.println("1 - Összes rendelés listázása");
                System.out.println("2 - Legdrágább étel megjelenítése");
                System.out.println("3 - Új étel hozzáadása");
                System.out.println("4 - Étel árának módosítása");
                System.out.println("0 - Kilépés");
                System.out.print("Választás: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Enter karakter kezelése

                switch (choice) {
                    case 1:
                        // 4. Feladat - Összes rendelés listázása
                        List<RendelesQuery> rendelesek = db.getAll();
                        for (RendelesQuery r : rendelesek) {
                            System.out.println(r);
                        }
                        break;

                    case 2:
                        // 5. Feladat - Legdrágább étel megjelenítése
                        String expensive = db.getExpensive();
                        System.out.println("Legdrágább étel(ek): " + expensive);
                        break;

                    case 3:
                        // 6. Feladat - Új étel hozzáadása
                        System.out.print("Étel neve: ");
                        String etelNev = scanner.nextLine();
                        System.out.print("Étel ára: ");
                        int etelAr = scanner.nextInt();
                        scanner.nextLine(); // Enter karakter kezelése
                        db.addNewMenu(etelNev, etelAr);
                        break;

                    case 4:
                        // 7. Feladat - Étel árának módosítása
                        System.out.print("Étel ID: ");
                        int etelId = scanner.nextInt();
                        System.out.print("Új ár: ");
                        int ujAr = scanner.nextInt();
                        scanner.nextLine(); // Enter karakter kezelése
                        boolean success = db.setNewPrice(etelId, ujAr);
                        if (success) {
                            System.out.println("Az ár módosítása sikeres volt.");
                        } else {
                            System.out.println("Nem sikerült az ár módosítása.");
                        }
                        break;

                    case 0:
                        // Kilépés
                        running = false;
                        db.close();
                        System.out.println("Program vége.");
                        break;

                    default:
                        System.out.println("Érvénytelen választás, próbáld újra.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Adatbázis hiba: " + e.getMessage());
        }
    }
}

