import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// La classe CustomButton hérite de JButton et permet de créer des boutons personnalisés
// avec des icônes redimensionnées, sans fond ni bordure visible, tout en assignant des actions spécifiques.
public class CustomButton extends JButton {

    // Constructeur pour créer un bouton personnalisé
    public CustomButton(String iconPath, int width, int height, String actionCommand, ActionListener listener) {
        
        // Charger l'icône à partir du chemin spécifié et la redimensionner
        ImageIcon icon = new ImageIcon(getClass().getResource(iconPath)); 
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon = new ImageIcon(image); // Créer une nouvelle icône redimensionnée

        // Appliquer l'icône au bouton
        this.setIcon(resizedIcon); 

        // Rendre le bouton transparent et sans bordure
        this.setContentAreaFilled(false); 
        this.setBorderPainted(false); 
        this.setFocusPainted(false); // Supprimer l'effet de focus sur le bouton
        
        // Assigner une commande d'action au bouton et l'écouter pour des événements
        this.setActionCommand(actionCommand); 
        this.addActionListener(listener); 
    }
}
