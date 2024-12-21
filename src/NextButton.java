import java.awt.event.ActionListener;

public class NextButton extends CustomButton {
    public NextButton(ActionListener listener) {
        super("/images/rightArrow.png", 90, 90, "NEXT", listener);
    }
}
