package org.example;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private int jetons; // Total des jetons du joueur
    private List<Mise> mises; // Liste des mises effectuées

    public Joueur() {
        this.jetons = 0; // Initialisé à 0 par défaut
        this.mises = new ArrayList<>();
    }

    // Permet au joueur de miser sur un numéro avec une certaine quantité de jetons
    public void jouer(int numero, int mise) {
        mises.add(new Mise(numero, mise)); // Ajoute une nouvelle mise
    }

    // Notifier le joueur du numéro sorti et calculer ses gains ou pertes
    public void notifierResultat(int numeroSorti) {
        int gainTotal = 0;

        for (Mise mise : mises) {
            if (mise.numero == numeroSorti) {
                gainTotal += mise.montant * 7; // Gain : 7 fois la mise
            } else {
                gainTotal -= mise.montant; // Perte : mise perdue
            }
        }

        jetons += gainTotal; // Mise à jour des jetons du joueur
        mises.clear(); // Réinitialiser les mises après chaque manche
    }

    // Getter pour connaître le total des jetons du joueur
    public int getJetons() {
        return jetons;
    }

    // Classe interne pour représenter une mise
    private static class Mise {
        int numero; // Numéro misé
        int montant; // Montant misé

        Mise(int numero, int montant) {
            this.numero = numero;
            this.montant = montant;
        }
    }
}
