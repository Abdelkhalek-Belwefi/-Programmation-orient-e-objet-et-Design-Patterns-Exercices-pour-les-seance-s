package org.example;

import java.util.*;

// dans cette etape en va ajouter iterator pour que la methode affichetous doit etre appeller dans le code et cette methode est creer dans la place incoorect

public class Catalogue<T extends Document> implements Iterable<T> {
    private final List<T> elements = new ArrayList<>();

    public void ajouter(T element) {
        elements.add(element);
    }

    public Optional<T> rechercherParTitre(String titre) {
        return elements.stream()
                .filter(d -> d.getTitre().equalsIgnoreCase(titre))
                .findFirst();
    }

    // public void afficherTout() {
    //     elements.forEach(d -> System.out.println(d.descriptionCourte()));
    // }

    public static <T extends Comparable<T>> T max(List<T> liste) { // bonus
        T m = liste.get(0);
        for (T e : liste) {
            if (e.compareTo(m) > 0) {
                m = e;
            }
        }
        return m;
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
    // lorsque en utilise cette methode avec ca
    // for(Document d : ........ dans la class
}