// La classe GameButtonManager gère l'état des boutons dans une grille de jeu 3x3.
// Elle garde une trace des boutons vides et de leur type (X ou O).
public class GameButtonManager {
    private DrawingButton[][] buttons;  // Tableau des boutons du jeu
    private boolean[][] buttons_empty;   // Tableau pour suivre l'état de chaque bouton (vide ou non)

    // Constructeur de la classe qui initialise le tableau des boutons et leur état (vide)
    public GameButtonManager(DrawingButton[][] buttons) {
        this.buttons = buttons;
        this.buttons_empty = new boolean[3][3];  // Initialiser tous les boutons comme vides

        // Marquer tous les boutons comme vides au départ
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons_empty[i][j] = true;  // Tous les boutons sont vides au début
            }
        }
    }

    // Retourner l'état des boutons vides
    public boolean[][] getButtonsEmptyTable() {
        return buttons_empty;
    }

    // Vérifier si un bouton spécifique est vide
    public boolean isButtonEmpty(int row, int col) {
        return buttons_empty[row][col];
    }

    // Définir l'état d'un bouton (vide ou non)
    public void setButtonEmpty(int row, int col, boolean isEmpty) {
        buttons_empty[row][col] = isEmpty;
    }

    // Obtenir le type d'un bouton spécifique (X ou O)
    public String getButtonType(int row, int col) {
        return buttons[row][col].getDrawType();
    }

    // Définir le type d'un bouton et dessiner la forme correspondante
    public void setButtonType(int row, int col, String type, ShapeDrawer drawer) {
        buttons[row][col].setDrawType(type);
        buttons[row][col].setDrawing(drawer);
    }

    // Vérifier si la grille est pleine (aucun bouton vide)
    public boolean isGridFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons_empty[i][j]) {  // Si un bouton est encore vide, la grille n'est pas pleine
                    return false;
                }
            }
        }
        return true;  // Tous les boutons sont remplis
    }

    // Vérifier si trois boutons spécifiés sont identiques (X ou O)
    public boolean checkThreeButtons(int r1, int c1, int r2, int c2, int r3, int c3) {
        String type1 = buttons[r1][c1].getDrawType();  // Type du premier bouton
        String type2 = buttons[r2][c2].getDrawType();  // Type du deuxième bouton
        String type3 = buttons[r3][c3].getDrawType();  // Type du troisième bouton

        // Vérifier que les trois types ne sont pas vides et qu'ils sont identiques
        return !type1.equals("") && type1.equals(type2) && type2.equals(type3);
    }

    // Vérifier s'il y a un gagnant en inspectant les lignes, colonnes et diagonales
    public boolean checkWinner() {
        // Vérifier les lignes
        for (int i = 0; i < 3; i++) {
            if (checkThreeButtons(i, 0, i, 1, i, 2)) return true;  // Vérifier la ligne
            if (checkThreeButtons(0, i, 1, i, 2, i)) return true;  // Vérifier la colonne
        }

        // Vérifier les diagonales
        return checkThreeButtons(0, 0, 1, 1, 2, 2) || checkThreeButtons(0, 2, 1, 1, 2, 0);
    }

    // Compter le nombre d'espaces vides dans la grille
    public int countEmptySpaces() {
        int emptySpaces = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons_empty[i][j]) {  // Si le bouton est vide, incrémenter le compteur
                    emptySpaces++;
                }
            }
        }
        return emptySpaces;  // Retourner le nombre total d'espaces vides
    }

    // Accéder au tableau des boutons vides
    public boolean[][] getButtons_empty() {
        return buttons_empty;
    }

    // Définir l'état du tableau des boutons vides
    public void setButtons_empty(boolean[][] buttons_empty) {
        this.buttons_empty = buttons_empty;
    }

    // Accéder au tableau des boutons
    public DrawingButton[][] getButtons() {
        return buttons;
    }

    // Définir le tableau des boutons
    public void setButtons(DrawingButton[][] buttons) {
        this.buttons = buttons;
    }
}
