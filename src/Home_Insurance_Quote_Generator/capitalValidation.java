package Home_Insurance_Quote_Generator;

import javafx.scene.control.TextField;

public class capitalValidation {

    static void isHomeCapitalValid(TextField input) {

        try {
            int homeCapital = Integer.parseInt(input.getText());

            if (homeCapital < 0) {
                alertMessage.displayAlertMessage("Building value cannot be a negative number!");
                throw new IllegalArgumentException("Building value cannot be a negative number!");
            }

        } catch (NumberFormatException e) {
            alertMessage.displayAlertMessage("Invalid input for building!");

        }
    }


    static void isContentCapitalValid(TextField input) {
        try {
            int contentCapital = Integer.parseInt(input.getText());

            if (contentCapital < 0) {
                alertMessage.displayAlertMessage("Content value cannot be a negative number!");
                throw new IllegalArgumentException("Content value cannot be a negative number!");
            }

        } catch (NumberFormatException e) {
            alertMessage.displayAlertMessage("Invalid input for content!");

        }
    }
}
