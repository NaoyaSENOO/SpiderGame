import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

// La classe BackgroundPanel hérite de JPanel et permet d'afficher une image en arrière-plan
class BackgroundPanel extends JPanel {
    private Image backgroundImage;  // Variable pour stocker l'image de fond

    // Constructeur qui prend en paramètre l'image de fond
    public BackgroundPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    // Méthode qui redéfinit paintComponent pour dessiner l'image de fond
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Appel à la méthode parent pour s'assurer que le reste est bien dessiné
        // Si une image est présente, elle est dessinée sur tout le panneau
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
