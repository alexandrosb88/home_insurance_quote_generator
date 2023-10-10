package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class specialAgreements {

    public static void handleSpecialAgreements(CheckBox box11, TextField underinsuranceProtection) {

        box11.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box11.isSelected()) {
                underinsuranceProtection.setDisable(true);
            } else {
                underinsuranceProtection.setDisable(false);
            }
        });
    }

}
