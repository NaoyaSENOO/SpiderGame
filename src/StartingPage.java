import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class StartingPage extends JFrame implements ActionListener {

    public StartingPage() throws HeadlessException {
        setUndecorated(true); // Supprimer la décoration de la fenêtre
        this.setSize(400, 400); // Définir la taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'application à la fermeture de la fenêtre
        this.setLocationRelativeTo(null); // Centrer la fenêtre à l'écran

        // Chargement de l'image d'arrière-plan
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/logo.jpeg"));
        Image backgroundImage = backgroundIcon.getImage();

        // Définir l'image d'arrière-plan dans le panneau personnalisé
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(new BorderLayout()); // Définir la mise en page


        TitledBorder title = BorderFactory.createTitledBorder("JEU D'ARAIGNEE"); // Créer un titre pour le panneau
        title.setTitlePosition(TitledBorder.TOP); // Positionner le titre en haut
        title.setTitleJustification(TitledBorder.CENTER); // Centrer le titre
        title.setTitleColor(Color.RED); // Définir la couleur du titre
        backgroundPanel.setBorder(title); // Appliquer la bordure au panneau d'arrière-plan
        
        // Définir les boutons
        StartButton startButton = new StartButton(this); // Créer le bouton de démarrage
        ExitButton exitButton = new ExitButton(this); // Créer le bouton de sortie
        HelpButton helpButton = new HelpButton(this); // Créer le bouton d'aide

        // Créer un panneau
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS)); // Définir la mise en page en colonne
        p1.setOpaque(false); // Rendre le panneau transparent


        // Créer un panneau pour les boutons start et exit
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS)); // Définir la mise en page en ligne
        buttonPanel.setOpaque(false); // Rendre le panneau transparent

        // Ajouter des espaces à gauche et à droite des boutons pour les centrer
        buttonPanel.add(Box.createHorizontalGlue()); // Espace horizontal flexible à gauche
        buttonPanel.add(startButton); // Ajouter le bouton de démarrage
        buttonPanel.add(Box.createHorizontalStrut(20)); // Ajouter un espace entre les boutons
        buttonPanel.add(exitButton); // Ajouter le bouton de sortie
        buttonPanel.add(Box.createHorizontalGlue()); // Espace horizontal flexible à droite

        // Créer un panneau pour le bouton d'aide
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS)); // Définir la mise en page en colonne
        helpPanel.setOpaque(false); // Rendre le panneau transparent

        helpPanel.add(helpButton); // Ajouter le bouton d'aide
        helpPanel.setAlignmentX(CENTER_ALIGNMENT); // Centrer le panneau d'aide


        p1.add(Box.createVerticalGlue()); // Ajouter un espace en haut
        p1.add(buttonPanel); // Ajouter le panneau des boutons
        p1.add(Box.createVerticalStrut(20)); // Ajouter un espace entre les boutons et le bouton d'aide
        p1.add(helpPanel); // Ajouter le panneau d'aide
        p1.add(Box.createVerticalGlue()); // Ajouter un espace en bas

        // Ajouter le panneau p1 au panneau d'arrière-plan
        backgroundPanel.add(p1, BorderLayout.CENTER);

        // Ajouter le panneau d'arrière-plan à la fenêtre
        this.add(backgroundPanel);

        this.setVisible(true); // Rendre la fenêtre visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("EXIT")) {
            System.exit(0); // Quitter l'application
        } 
        else if (command.equals("START")) {
            System.out.println("Jeu démarré !"); // Message d'information
        
            new Beforegame(); // Démarrer la phase précédente
        }
        else if (command.equals("HELP")) {
            System.out.println("Afficher l'explication."); // Message d'information
        
            new Explication(); // Ouvrir la page d'explication
        }
        this.dispose();
    }
}
