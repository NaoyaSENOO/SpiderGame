import java.awt.event.ActionListener;

public class ResetButton extends CustomButton {
    public ResetButton(ActionListener listener) {
        super("/images/ResetButton.png", 90, 90, "RESET", listener);
    }
}
