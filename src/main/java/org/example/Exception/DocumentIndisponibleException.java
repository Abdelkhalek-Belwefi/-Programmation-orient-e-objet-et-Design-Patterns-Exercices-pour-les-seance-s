package org.example.Exception;

import org.example.Exception.MediathequeException;

public class DocumentIndisponibleException extends MediathequeException {

    /** Cas principal : le document est déjà emprunté. */
    public DocumentIndisponibleException(String titre) {
        super("Document déjà emprunté : " + titre);
    }

    /** Autre cas d'indisponibilité (ex. : consultation sur place uniquement). */
    public DocumentIndisponibleException(String titre, String motif) {
        super("Document indisponible à l'emprunt (" + motif + ") : " + titre);
    }
}