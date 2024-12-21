import java.awt.event.ActionListener;

public class HomeButton extends CustomButton {
    public HomeButton(ActionListener listener) {
        super("/images/home.png", 90, 90, "BACK", listener);
    }
}

