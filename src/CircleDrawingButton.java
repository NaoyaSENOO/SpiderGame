import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

// La classe CircleDrawingButton implémente l'interface ShapeDrawer
// et est responsable de dessiner un "O" rouge centré sur le bouton.
public class CircleDrawingButton implements ShapeDrawer {
    @Override
    public void drawShape(Graphics g, int width, int height) {
        // Définir la police et la taille du texte
        g.setFont(new Font("Arial", Font.BOLD, 50)); // Taille ajustable selon les besoins
        g.setColor(Color.RED); // Définir la couleur du texte en rouge

        // Calculer la position pour centrer le texte "O" sur le bouton
        String text = "O";
        int textWidth = g.getFontMetrics().stringWidth(text);  // Obtenir la largeur du texte
        int textHeight = g.getFontMetrics().getHeight();       // Obtenir la hauteur du texte

        // Dessiner le texte centré sur le bouton
        int x = (width - textWidth) / 2;  // Calcul pour centrer horizontalement
        int y = (height + textHeight) / 2 - 10;  // Calcul pour centrer verticalement
        g.drawString(text, x, y);  // Dessiner le texte "O" à la position calculée
    }
}
