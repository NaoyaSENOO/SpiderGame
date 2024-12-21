import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Table3x3 extends JFrame implements ActionListener {
    private DrawingButton[][] buttons = new DrawingButton[3][3]; // Tableau pour les boutons de dessin
    private GameButtonManager buttonManager; // Gestionnaire de boutons de jeu
    private boolean Who_will_play = false;  // Faux pour "X", Vrai pour "O"
    private boolean inNextPhase = false;  // Indicateur pour savoir si la phase suivante a commencé
    private boolean gameOver = false; // Indicateur si le jeu est terminé
    private int selectedRow = -1; // Ligne du bouton sélectionné
    private int selectedCol = -1; // Colonne du bouton sélectionné
    private JLabel playerIndicator; // Label pour afficher le joueur actuel
    private LineBorder defaultBorder = new LineBorder(Color.LIGHT_GRAY, 1); // Bordure par défaut

    public Table3x3() {
        setTitle("Jeu d'araignée"); // Titre de la fenêtre
        setSize(500, 500); // Taille de la fenêtre
        setLocationRelativeTo(null); // Centrer la fenêtre à l'écran
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'application à la fermeture de la fenêtre

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3)); // Mise en page en grille 3x3

        // Initialiser la grille de boutons
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                buttons[row][column] = new DrawingButton(); // Créer un nouveau bouton de dessin
                buttons[row][column].setBorder(defaultBorder); // Définir la bordure par défaut

                buttons[row][column].addActionListener(this); // Ajouter un ActionListener au bouton
                panel.add(buttons[row][column]); // Ajouter le bouton au panneau
            }
        }

        buttonManager = new GameButtonManager(buttons); // Initialiser le gestionnaire de boutons
        this.add(panel); // Ajouter le panneau principal

        // Panneau pour afficher le joueur actuel
        JPanel indicatorPanel = new JPanel();
        playerIndicator = new JLabel("C'est le tour de : Joueur 1 (X)", JLabel.CENTER); // Indicateur du joueur courant
        playerIndicator.setFont(playerIndicator.getFont().deriveFont(20f)); // Définir la taille de la police
        indicatorPanel.add(playerIndicator); // Ajouter le label au panneau d'indicateur

        this.add(indicatorPanel, BorderLayout.SOUTH); // Ajouter le panneau d'indicateur en bas
        setVisible(true); // Rendre la fenêtre visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return; // Si le jeu est terminé, ne rien faire

        DrawingButton buttonClicked = (DrawingButton) e.getSource(); // Récupérer le bouton cliqué

        int row = -1, col = -1; // Initialiser les indices de ligne et de colonne
        outerLoop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == buttonClicked) { // Trouver la position du bouton cliqué
                    row = i;
                    col = j;
                    break outerLoop; // Sortir des boucles
                }
            }
        }

        if (!inNextPhase) { // Si nous ne sommes pas dans la phase suivante
            handleRegularMove(row, col); // Gérer le mouvement normal
            // Vérifier s'il y a un gagnant après chaque mouvement dans la première phase
            if (buttonManager.checkWinner()) {
                String winner = Who_will_play ? "X" : "O";  // Déterminer le gagnant
                JOptionPane.showMessageDialog(this, "Le joueur " + winner + " a gagné!"); // Afficher le message de victoire
                gameOver = true; // Mettre à jour l'état du jeu
                this.dispose();
                WinnerPage winnerpage = new WinnerPage(winner); // Ouvrir la page des gagnants
            } else if (buttonManager.countEmptySpaces() == 3) { // Vérifier si c'est un match nul
                JOptionPane.showMessageDialog(this, "Passage à la phase 2.");
                System.out.println("Passage à la phase 2.");
                inNextPhase = true; // Passer à la phase suivante
            }
        } else {
            // Gérer la logique de la phase suivante (déplacement des marqueurs) une fois que checkDraw a été exécuté
            handleNextPhase(row, col); // Gérer la phase suivante
        }
    }

    private void updatePlayerIndicator() {
        playerIndicator.setText("Maintenant, c'est le tour de : " + (Who_will_play ? "Joueur 1 (X)" : "Joueur 2 (O)")); // Mettre à jour l'indicateur de joueur
    }

    private void handleRegularMove(int row, int col) {
        if (!buttonManager.isButtonEmpty(row, col)) return; // Vérifier si le bouton est vide

        // Placer le marqueur
        placeMarker(row, col); // Placer le marqueur
        buttonManager.setButtonEmpty(row, col, false); // Marquer le bouton comme non vide
        updatePlayerIndicator(); // Mettre à jour l'indicateur de joueur

        // Changer de tour
        Who_will_play = !Who_will_play;
    }

    private void placeMarker(int row, int col) {
        if (!Who_will_play) { // Si c'est le tour de "X"
            buttonManager.setButtonType(row, col, "X", new XDrawingButton()); // Définir le type de bouton à "X"
        } else {
            buttonManager.setButtonType(row, col, "O", new CircleDrawingButton()); // Définir le type de bouton à "O"
        }
    }

    // Logique pour la phase suivante
    private void handleNextPhase(int row, int col) {
        if (selectedRow == -1 && selectedCol == -1) {
            // Aucun marqueur n'est sélectionné, sélectionner un marqueur appartenant au joueur courant
            if (!buttonManager.isButtonEmpty(row, col) && buttonManager.getButtonType(row, col).equals(Who_will_play ? "O" : "X")) {
                selectedRow = row; // Enregistrer la ligne sélectionnée
                selectedCol = col; // Enregistrer la colonne sélectionnée
                buttons[row][col].setSelected(true); // Définir l'état sélectionné pour le bouton
                buttons[row][col].setBorder(new LineBorder(new Color(255, 165, 0), 5)); // Définir une bordure orange
            }
        } else {
            // Désélectionner le marqueur si le joueur clique sur le même marqueur à nouveau
            if (selectedRow == row && selectedCol == col) {
                // Lors de la désélection
                buttons[selectedRow][selectedCol].setSelected(false); // Réinitialiser la sélection
                buttons[selectedRow][selectedCol].setBorder(defaultBorder); // Réinitialiser à la bordure par défaut
                selectedRow = -1; // Réinitialiser la ligne sélectionnée
                selectedCol = -1; // Réinitialiser la colonne sélectionnée
            } else if (buttonManager.isButtonEmpty(row, col)) {
                // Essayer de déplacer le marqueur sélectionné vers un nouvel emplacement vide
                // Vérifier si le mouvement est légal (seulement vers des cases adjacentes)
                if (isAdjacent(selectedRow, selectedCol, row, col)) {
                    // Déplacer le marqueur vers le nouvel emplacement vide
                    buttonManager.setButtonType(row, col, buttonManager.getButtonType(selectedRow, selectedCol), buttons[selectedRow][selectedCol].getDrawing());
                    buttonManager.setButtonType(selectedRow, selectedCol, "", null);
                    buttonManager.setButtonEmpty(selectedRow, selectedCol, true);
                    buttonManager.setButtonEmpty(row, col, false);

                    // Réinitialiser l'ancien marqueur et sa sélection
                    buttons[selectedRow][selectedCol].setSelected(false); // Désélectionner le marqueur précédent
                    buttons[selectedRow][selectedCol].setBorder(defaultBorder); // Réinitialiser à la bordure par défaut
                    
                    selectedRow = -1; // Réinitialiser la ligne sélectionnée
                    selectedCol = -1; // Réinitialiser la colonne sélectionnée
                    // Vérifier s'il y a un gagnant après le mouvement
                    if (buttonManager.checkWinner()) {
                        String winner = Who_will_play ? "O" : "X";  // Déterminer le gagnant
                        JOptionPane.showMessageDialog(this, "Le joueur "+ winner + " a gagné!"); // Afficher le message de victoire
                        gameOver = true; // Mettre à jour l'état du jeu
                        dispose(); // Fermer la fenêtre actuelle
                        new WinnerPage(winner); // Ouvrir la page des gagnants
                    } else {
                        // Changer de tour après avoir déplacé le marqueur
                        updatePlayerIndicator(); // Mettre à jour l'indicateur de joueur
                        Who_will_play = !Who_will_play; // Changer de joueur
                    }
                } else {
                    // Mouvement invalide : essayer de déplacer vers un emplacement non adjacent  
                    buttons[selectedRow][selectedCol].setBorder(defaultBorder); // Réinitialiser à la bordure par défaut
                    buttons[selectedRow][selectedCol].setSelected(false); // Réinitialiser la sélection
                    selectedCol = -1; // Réinitialiser la colonne sélectionnée
                    selectedRow = -1; // Réinitialiser la ligne sélectionnée
                    JOptionPane.showMessageDialog(null, "Déplacement non valide ! Vous ne pouvez vous déplacer que sur une place adjacente vide."); // Alerte de mouvement invalide
                }
            } else {
                // Mouvement invalide : essayer de déplacer vers un emplacement non vide, ou sélectionner un autre marqueur
                JOptionPane.showMessageDialog(null, "Déplacement non valide ! Sélectionnez votre propre marqueur."); // Alerte de sélection invalide
            }
        }
    }

    private boolean isAdjacent(int selectedRow, int selectedCol, int targetRow, int targetCol) {
        // Vérifier si les cases sont adjacentes
        return (Math.abs(selectedRow - targetRow) == 1 && selectedCol == targetCol) || 
               (Math.abs(selectedCol - targetCol) == 1 && selectedRow == targetRow) ||
               (Math.abs(selectedCol - targetCol) == 1 && Math.abs(selectedRow - targetRow) == 1); 
    }
}
