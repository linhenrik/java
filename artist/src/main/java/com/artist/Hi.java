/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.artist;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author linhenrik
 */
public class Hi {

    public static void main(String[] args) throws SQLException {
         String dbUrl = "jdbc:sqlite:Music.db";
        MusicRepository repository = new MusicRepository(dbUrl);

        System.out.println("--- Összes zene előadóval (TrackQuery) ---");
        List<TrackQuery> allTracksWithArtist = repository.getAll();
        if (allTracksWithArtist.isEmpty()) {
            System.out.println("Nincsenek zenék az adatbázisban, vagy hiba történt a lekérdezés során.");
        } else {
            for (TrackQuery tq : allTracksWithArtist) {
                System.out.println(tq);
            }
        }
        System.out.println("-----------------------------------------\n");


        System.out.println("--- Leghosszabb zene (Track) ---");
        Track longestTrack = repository.getLongest();
        if (longestTrack != null) {
            System.out.println(longestTrack);
        } else {
            System.out.println("Nem található zene az adatbázisban a leghosszabb kereséséhez.");
        }
        System.out.println("--------------------------------\n");


        System.out.println("--- 'rock' szót tartalmazó zenék száma ---");
        int rockTracksCount = repository.getRocks();
        System.out.println("Zenék száma 'rock' szóval a címben: " + rockTracksCount);
        System.out.println("-----------------------------------------\n");


        System.out.println("--- Új zene hozzáadása ---");
        // Figyelem: Az ArtistId-nak léteznie kell az Artists táblában!
        // Tegyük fel, hogy van egy előadó 1-es ID-val.
        // A többi ID (AlbumId, MediaTypeId, GenreId) is létező ID kell legyen,
        // vagy NULL, ha az adatbázis megengedi.
        // Itt most feltételezzük, hogy a NULL értékek megengedettek az opcionális mezőknél.
        Track newTrack = new Track(0, "My New Song", null, null, null,
                                   "New Composer", 240000, null, 1.29, 1);
                                   // A TrackId-t (első paraméter) a DB generálja, itt 0-t adhatunk meg,
                                   // de az addTrack metódus nem használja fel.
        boolean added = repository.addTrack(newTrack);
        if (added) {
            System.out.println("Új zene sikeresen hozzáadva.");
            // Kiírathatjuk újra az összes zenét, hogy lássuk a változást
            System.out.println("Frissített lista:");
            repository.getAll().forEach(System.out::println); // Rövidített kiíratás
        } else {
            System.out.println("Új zene hozzáadása sikertelen.");
        }
        System.out.println("--------------------------\n");


        System.out.println("--- Zene árának frissítése ---");
        // Tegyük fel, hogy frissíteni akarjuk az 1-es ID-jú zene árát
        // (Ha nincs ilyen ID, vagy a newTrack ID-ját szeretnénk használni, azt kellene kideríteni)
        // Most egy létező, pl. az elsőként listázott zene árát módosítjuk, ha van ilyen.
        List<TrackQuery> currentTracks = repository.getAll();
        if (!currentTracks.isEmpty()) {
            int trackIdToUpdate = currentTracks.get(0).getTrackId(); // Első zene ID-ja
            double newPrice = 2.99;
            System.out.println("Árfrissítés a TrackId=" + trackIdToUpdate + " zenéhez, új ár: " + newPrice);
            boolean updated = repository.updateTrackPrice(trackIdToUpdate, newPrice);
            if (updated) {
                System.out.println("Zene ára sikeresen frissítve.");
                // Ellenőrzésképpen újra lekérdezzük és kiírjuk a frissített zenét
                System.out.println("Frissített zene adatai:");
                repository.getAll().stream()
                    .filter(t -> t.getTrackId() == trackIdToUpdate)
                    .findFirst()
                    .ifPresent(System.out::println);
            } else {
                System.out.println("Zene árának frissítése sikertelen (lehet, hogy nincs ilyen TrackId).");
            }
        } else {
            System.out.println("Nincsenek zenék az árfrissítéshez.");
        }
        System.out.println("----------------------------\n");
    }
}
