import java.awt.Graphics;
import javax.swing.JButton;

// La classe DrawingButton hérite de JButton et permet de dessiner des formes (comme X ou O) à l'intérieur du bouton.
public class DrawingButton extends JButton {
    private ShapeDrawer drawer;  // Objet responsable du dessin de la forme (par exemple, X ou O)
    private String drawType = ""; // Stocke le type de forme à dessiner ("X" ou "O")

    // Constructeur : initialise le bouton sans forme par défaut
    public DrawingButton() {
        this.drawer = null;
    }

    // Définir le type de forme à dessiner (par exemple, "X" ou "O")
    public void setDrawType(String drawType) {
        this.drawType = drawType;
    }

    // Obtenir le type de forme actuellement défini
    public String getDrawType() {
        return this.drawType;
    }

    // Définir l'objet responsable du dessin et redessiner le bouton
    public void setDrawing(ShapeDrawer drawer) {
        // Assigner la forme et demander un redessin si le bouton n'a pas déjà été dessiné
        this.drawer = drawer;
        repaint();  // Demande une mise à jour de l'affichage après avoir défini la forme
    }

    // Obtenir l'objet dessinateur de la forme
    public ShapeDrawer getDrawing() {
        return this.drawer;
    }

    // Surcharger la méthode paintComponent pour dessiner la forme
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Si une forme est définie, dessiner la forme sur le bouton
        if (drawer != null) {
            drawer.drawShape(g, getWidth(), getHeight());
        }
    }
}
