import java.awt.event.ActionListener;

// La classe ExitButton hérite de CustomButton et représente un bouton pour quitter l'application.
public class ExitButton extends CustomButton {
    
    // Constructeur qui initialise le bouton avec une icône, des dimensions spécifiques, une commande d'action et un listener d'événements.
    public ExitButton(ActionListener listener) {
        super("/images/exit.png", 90, 90, "EXIT", listener);
    }
}
