import java.awt.event.ActionListener;

// La classe BackToPhase1Button hérite de CustomButton et représente un bouton permettant de revenir à la phase 1 du jeu
public class BackToPhase1Button extends CustomButton {

    // Constructeur qui prend un ActionListener en paramètre
    // Il initialise le bouton avec une image, des dimensions et une commande spécifique
    public BackToPhase1Button(ActionListener listener) {
        // Appel au constructeur de la classe mère (CustomButton) en passant l'image, la taille et la commande associée
        super("/images/leftArrow.png", 90, 90, "BACK_TO_PHASE_1", listener);
    }
}
