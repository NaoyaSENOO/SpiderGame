import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WinnerPage extends JFrame implements ActionListener {
    private String winnerName; // Stocker le nom du gagnant

    public WinnerPage(String winner) {
        this.winnerName = winner; // Initialiser le nom du gagnant
        setUndecorated(true); // Supprimer les décorations de la fenêtre (optionnel)
        this.setSize(600, 600); // Définir la taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); // Centrer la fenêtre

        // Créer un JPanel avec un gestionnaire de mise en page
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Utiliser BorderLayout pour centrer le label
        panel.setBackground(Color.WHITE); // Définir la couleur de fond

        // Créer un JLabel pour afficher le nom du gagnant
        JLabel winnerLabel = new JLabel("C'est le "+winnerName + " qui a gagné !", SwingConstants.CENTER); // Créer un label centré
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Définir la taille et le style de la police
        winnerLabel.setForeground(Color.BLUE); // Définir la couleur du texte

        // Ajouter le label au panneau
        panel.add(winnerLabel, BorderLayout.CENTER); // Ajouter au centre

        // Créer un JPanel pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Utiliser FlowLayout pour l'alignement des boutons

        // Créer le bouton de rejouer
        ResetButton resetButton = new ResetButton(this);
        

        // Créer le bouton de sortie
        ExitButton exitButton = new ExitButton(this);

        // Ajouter les boutons au panneau de boutons
        buttonPanel.add(resetButton); // Ajouter le bouton de rejouer
        buttonPanel.add(exitButton); // Ajouter le bouton de sortie

        // Ajouter le panneau de boutons au panneau principal
        panel.add(buttonPanel, BorderLayout.SOUTH); // Ajouter en bas de la fenêtre

        // Ajouter le panneau au cadre
        this.getContentPane().add(panel); // Ajouter le panneau principal au contenu
        this.setVisible(true); // Rendre le cadre visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("EXIT")) {
            System.exit(0); // Quitter l'application
        } 
        else if (command.equals("RESET")) {
            System.out.println("Jeu redémarré !"); // Message d'information
            this.dispose();
            new Beforegame(); // Démarrer la phase précédente
        }
    }
}
