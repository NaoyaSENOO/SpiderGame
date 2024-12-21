import java.awt.event.ActionListener;

public class StartButton extends CustomButton {
    public StartButton(ActionListener listener) {
        super("/images/start.png", 90, 90, "START", listener);
    }
}
