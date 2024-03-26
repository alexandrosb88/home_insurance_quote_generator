package Home_Insurance_Quote_Generator;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class alertMessage {

    public static void displayAlertMessage(String message) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    public static void displayConfirmationMessage(String message) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

}
