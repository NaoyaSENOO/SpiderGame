import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// La classe ExplicationPhase2 représente une fenêtre d'explication pour la deuxième phase du jeu.
// Elle hérite de JFrame et implémente ActionListener pour gérer les actions des boutons.
public class ExplicationPhase2 extends JFrame implements ActionListener {

    // Constructeur de la classe ExplicationPhase2
    public ExplicationPhase2() {

        setTitle("Explication Phase 2");  // Définir le titre de la fenêtre
        setSize(600, 600);  // Définir la taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Définir le comportement à la fermeture
        setLayout(new BorderLayout());  // Utiliser un BorderLayout pour l'organisation des composants
        this.setLocationRelativeTo(null);  // Centrer la fenêtre sur l'écran

        // Créer un panneau supérieur (topPanel) qui contient deux sous-panneaux
        JPanel topPanel = new JPanel(new BorderLayout());

        // Panneau à gauche contenant le bouton pour retourner à la phase 1
        JPanel topLeftPanel = new JPanel(new BorderLayout());
        topLeftPanel.setOpaque(false);  // Rendre le panneau transparent

        // Bouton pour revenir à l'explication de la phase 1
        BackToPhase1Button backToPhase1Button = new BackToPhase1Button(this);
        topLeftPanel.add(backToPhase1Button, BorderLayout.CENTER);

        // Panneau pour le texte explicatif et l'image
        JPanel textAndImagePanel = new JPanel(new BorderLayout());

        // Label contenant l'explication de la phase 2
        JLabel explanationText = new JLabel("<html><div style='text-align: center;'>"
                + "Phase 2: Dans cette phase, vous déplacerez vos pièces sur le plateau.<br>"
                + "L'objectif est d'aligner vos pièces en une ligne."
                + "</div></html>");
        explanationText.setHorizontalAlignment(JLabel.CENTER);  // Centrer horizontalement le texte
        explanationText.setVerticalAlignment(JLabel.TOP);  // Aligner le texte en haut
        explanationText.setFont(new Font("Serif", Font.PLAIN, 18));  // Définir la taille de la police

        // Charger et redimensionner l'image de la phase 2
        ImageIcon phase2Icon = new ImageIcon(getClass().getResource("/images/phase_2.jpg"));
        Image phase2Image = phase2Icon.getImage();
        Image resizedPhase2 = phase2Image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon2 = new ImageIcon(resizedPhase2);
        JLabel phase2Label = new JLabel(resizedIcon2);

        // Ajouter le texte explicatif et l'image dans le panneau
        textAndImagePanel.add(explanationText, BorderLayout.NORTH);
        textAndImagePanel.add(phase2Label, BorderLayout.SOUTH);

        // Ajouter les deux sous-panneaux (texte/image et bouton retour) dans le panneau supérieur
        topPanel.add(topLeftPanel, BorderLayout.WEST);
        topPanel.add(textAndImagePanel, BorderLayout.CENTER);

        // Créer un panneau inférieur (bottomPanel) avec une grille pour les boutons "Accueil" et "Commencer"
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2, 20, 0));  // Disposer les boutons avec un espacement

        // Créer les boutons "Retour à l'accueil" et "Commencer le jeu"
        HomeButton homeButton = new HomeButton(this);
        StartButton startButton = new StartButton(this);
        bottomPanel.add(homeButton);
        bottomPanel.add(startButton);

        // Créer un panneau principal qui contient le panneau supérieur et le panneau inférieur
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Ajouter le panneau principal à la fenêtre et la rendre visible
        this.add(mainPanel);
        this.setVisible(true);
    }

    // Gérer les actions des boutons en fonction de la commande associée
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("BACK")) {
            System.out.println("Retour à l'accueil");
            // Fermer la fenêtre et revenir à l'écran d'accueil
            this.dispose();
            new StartingPage();
        } else if (command.equals("START")) {
            // Démarrer le jeu en fermant la fenêtre actuelle et en ouvrant la grille de jeu
            System.out.println("Le jeu a commencé !");
            this.dispose();
            new Beforegame();  // Lancer le jeu
        } else if (command.equals("BACK_TO_PHASE_1")) {
            // Revenir à l'explication de la phase 1
            this.dispose();
            new Explication();  // Ouvrir l'explication de la phase 1
        }
    }
}
