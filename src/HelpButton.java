import java.awt.event.ActionListener;

public class HelpButton extends CustomButton {
    public HelpButton(ActionListener listener) {
        super("/images/help.jpeg", 150, 70, "HELP", listener);
    }
}