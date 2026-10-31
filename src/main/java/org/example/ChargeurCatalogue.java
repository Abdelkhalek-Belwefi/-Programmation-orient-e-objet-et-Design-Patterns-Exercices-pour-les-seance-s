package org.example;

import org.example.Exception.CatalogueCorrompuException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ChargeurCatalogue {

    public static List<String> chargerTitres(Path chemin)
            throws CatalogueCorrompuException {
        try (var lecteur = Files.newBufferedReader(chemin)) {
            return lecteur.lines().toList();
        } catch (IOException e) {
            throw new CatalogueCorrompuException(
                    "Echec du chargement : " + chemin, e);
        }
    }
}