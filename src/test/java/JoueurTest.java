import org.example.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JoueurTest {
    private Joueur joueur; // Instance de la classe Joueur à tester

    @BeforeEach
    void setUp() {
        joueur = new Joueur(); // Initialiser un nouveau joueur avant chaque test
    }

    @Test
    void testJoueurGagne() {
        // Le joueur mise 3 jetons sur le numéro 8
        joueur.jouer(8, 3);

        // Le numéro 8 sort
        joueur.notifierResultat(8);

        // Vérifier le nombre de jetons après la victoire
        assertEquals(21, joueur.getJetons(),
                "Le joueur aurait dû gagner 21 jetons (3 * 7)");
    }

    @Test
    void testJoueurPerd() {
        // Le joueur mise 3 jetons sur le numéro 8
        joueur.jouer(8, 3);

        // Le numéro 9 sort
        joueur.notifierResultat(9);

        // Vérifier le nombre de jetons après la perte
        assertEquals(-3, joueur.getJetons(),
                "Le joueur aurait dû perdre 3 jetons");
    }






}
