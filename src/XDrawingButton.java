import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class XDrawingButton implements ShapeDrawer {
    @Override
    public void drawShape(Graphics g, int width, int height) {
        // Définir la taille et le style de la police
        g.setFont(new Font("Arial", Font.BOLD, 50)); // Ajustez la taille si nécessaire
        g.setColor(Color.BLACK); // Définir la couleur du texte

        // Calculer la position pour centrer le texte
        String text = "X"; // Le texte à dessiner
        int textWidth = g.getFontMetrics().stringWidth(text); // Largeur du texte
        int textHeight = g.getFontMetrics().getHeight(); // Hauteur du texte

        // Dessiner le texte au centre du bouton
        int x = (width - textWidth) / 2; // Calculer la position x
        int y = (height + textHeight) / 2 - 10; // Calculer la position y et ajuster pour le centrage vertical
        g.drawString(text, x, y); // Dessiner le texte
    }
}
