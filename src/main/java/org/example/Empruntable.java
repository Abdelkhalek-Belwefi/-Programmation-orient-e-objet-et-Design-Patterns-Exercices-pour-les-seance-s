package org.example;

import org.example.Exception.DocumentIndisponibleException;

public interface Empruntable {
    // checked : la signature engage TOUTES les implementations
    void emprunter() throws DocumentIndisponibleException;
    void rendre();
    boolean estDisponible();
}