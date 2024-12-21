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

// La classe Explication représente une fenêtre d'explication pour la première phase du jeu.
// Elle hérite de JFrame et implémente ActionListener pour gérer les interactions avec les boutons.
public class Explication extends JFrame implements ActionListener {

    // Constructeur de la classe Explication
    public Explication() {
        setTitle("Explication");  // Définir le titre de la fenêtre
        setSize(600, 600);  // Définir la taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Définir le comportement de fermeture
        setLayout(new BorderLayout());  // Utiliser un BorderLayout pour organiser les composants
        this.setLocationRelativeTo(null);  // Centrer la fenêtre sur l'écran

        // Créer le panneau supérieur contenant le texte et l'image d'explication
        JPanel topPanel = new JPanel(new BorderLayout());

        // Panneau pour le texte et l'image
        JPanel textAndImagePanel = new JPanel(new BorderLayout());
        
        // Créer et configurer le label pour l'explication de la phase 1
        JLabel explanationText = new JLabel("<html><div style='text-align: center;'>"
                + "Phase 1: Dans cette phase, vous allez placer des pièces sur le plateau. "
                + "Essayez de positionner vos pièces de manière stratégique pour prendre l'avantage."
                + "</div></html>");
        explanationText.setHorizontalAlignment(JLabel.CENTER);  // Centrer le texte horizontalement
        explanationText.setVerticalAlignment(JLabel.TOP);  // Aligner le texte en haut
        explanationText.setFont(new Font("Serif", Font.PLAIN, 18));  // Changer la taille du texte

        // Charger et redimensionner l'image représentant la phase 1
        ImageIcon phase1Icon = new ImageIcon(getClass().getResource("/images/phase_1.jpg"));
        Image phase1Image = phase1Icon.getImage();
        Image resizedPhase1 = phase1Image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(resizedPhase1);
        JLabel phase1Label = new JLabel(resizedIcon1);

        // Ajouter le texte et l'image au panneau
        textAndImagePanel.add(explanationText, BorderLayout.NORTH);
        textAndImagePanel.add(phase1Label, BorderLayout.SOUTH);

        // Créer un panneau pour le bouton "Suivant"
        JPanel nextButtonPanel = new JPanel(new BorderLayout());
        nextButtonPanel.setOpaque(false);  // Rendre le panneau transparent
        NextButton nextButton = new NextButton(this);  // Créer un bouton "Suivant"
        nextButtonPanel.add(nextButton, BorderLayout.CENTER);

        // Ajouter le panneau de texte et d'image, ainsi que le bouton "Suivant" au panneau supérieur
        topPanel.add(textAndImagePanel, BorderLayout.CENTER);
        topPanel.add(nextButtonPanel, BorderLayout.EAST);

        // Créer le panneau inférieur contenant les boutons "Retour" et "Commencer"
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2, 20, 0));  // Disposer les boutons en grille
        bottomPanel.setOpaque(false);  // Rendre le panneau transparent

        // Créer les boutons "Retour à l'accueil" et "Commencer le jeu"
        HomeButton backButton = new HomeButton(this);
        StartButton startButton = new StartButton(this);
        bottomPanel.add(backButton);
        bottomPanel.add(startButton);

        // Assembler les panneaux supérieur et inférieur dans le panneau principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Ajouter le panneau principal à la fenêtre et rendre la fenêtre visible
        this.add(mainPanel);
        this.setVisible(true);
    }

    // Gérer les événements liés aux boutons
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("BACK")) {
            // Fermer la fenêtre et retourner à l'accueil
            this.dispose();
            new StartingPage();
        } else if (command.equals("START")) {
            // Commencer le jeu en fermant la fenêtre actuelle et en ouvrant la grille du jeu
            System.out.println("Le jeu a commencé !");
            this.dispose();
            new Beforegame();  // Lancer le jeu
        } else if (command.equals("NEXT")) {
            // Afficher les explications pour la phase 2 du jeu
            this.dispose();
            System.out.println("Afficher l'explication de la phase 2");
            new ExplicationPhase2();  // Passer à l'explication de la phase 2
        }
    }
}
