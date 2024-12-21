import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// La classe Beforegame représente une fenêtre qui s'affiche avant le début du jeu,
// avec un message indiquant le rôle des joueurs et un compte à rebours avant le démarrage du jeu.
public class Beforegame extends JFrame {
    private JLabel messageLabel; // Label pour afficher le message aux joueurs
    private JLabel timerLabel;   // Label pour afficher le compte à rebours
    private int timeLeft = 5;    // Temps restant avant le début du jeu (5 secondes)
    private Timer timer;         // Minuterie pour gérer le compte à rebours

    // Constructeur de la classe Beforegame
    public Beforegame() {
        setTitle("Préparation de Jeu");           // Titre de la fenêtre
        setSize(600, 200);                      // Dimensions de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Fermeture de la fenêtre lorsqu'on clique sur la croix
        setLocationRelativeTo(null);            // Centrer la fenêtre sur l'écran

        // Création d'un JPanel avec un gestionnaire de disposition
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));  // Deux lignes : une pour le message, une pour le timer
        panel.setBackground(Color.WHITE);       // Définir la couleur de fond du panneau

        // Création du label de message pour indiquer les rôles des joueurs
        messageLabel = new JLabel("Joueur 1 utilisera X, Joueur 2 utilisera O.", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));  // Définir la police du message
        panel.add(messageLabel);  // Ajouter le label au panneau

        // Création du label de timer pour le compte à rebours
        timerLabel = new JLabel("Le jeu commencera dans " + timeLeft + " secondes", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Définir la police du timer
        panel.add(timerLabel);  // Ajouter le label de timer au panneau

        // Ajouter le panneau à la fenêtre
        this.getContentPane().add(panel);

        // Création et démarrage du timer
        timer = new Timer(1000, new ActionListener() {  // Intervalle de 1000 ms (1 seconde)
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;  // Décrémenter le temps restant
                timerLabel.setText("Le jeu commencera dans : " + timeLeft + " secondes");  // Mettre à jour le label du timer

                if (timeLeft <= 0) {  // Lorsque le temps atteint 0
                    timer.stop();  // Arrêter la minuterie
                    dispose();  // Fermer la fenêtre de préparation
                    new Table3x3();  // Lancer la fenêtre du jeu
                }
            }
        });
        timer.start();  // Démarrer le timer

        setVisible(true);  // Rendre la fenêtre visible
    }
}
