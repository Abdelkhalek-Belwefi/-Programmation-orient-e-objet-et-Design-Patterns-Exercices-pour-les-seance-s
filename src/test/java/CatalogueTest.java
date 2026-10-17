import org.example.Catalogue;
import org.example.Document;
import org.example.DocumentIndisponibleException;
import org.example.Dvd;
import org.example.Livre;
import org.example.Revue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {

    // throws : emprunter() est une exception checked
    @Test
    void empruntNominal() throws DocumentIndisponibleException {
        Livre l = new Livre("Clean Code", 2008, "R. Martin", 464);
        l.emprunter();
        assertFalse(l.estDisponible());
        l.rendre();
        assertTrue(l.estDisponible());
    }

    @Test
    void doubleEmpruntLeveUneExceptionMetier()
            throws DocumentIndisponibleException {
        Livre l = new Livre("Refactoring", 1999, "M. Fowler", 448);
        l.emprunter();
        DocumentIndisponibleException ex =
                assertThrows(DocumentIndisponibleException.class, l::emprunter);
        assertTrue(ex.getMessage().contains("Refactoring"));
    }

    @Test
    void rechercheInfructueuse() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Revue("Science", 2026, 412));
        assertTrue(c.rechercherParTitre("Nature").isEmpty());
    }

    @Test
    void rechercheIgnoreLaCasse() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Dvd("Inception", 2010, 148));
        assertTrue(c.rechercherParTitre("INCEPTION").isPresent());
    }
}