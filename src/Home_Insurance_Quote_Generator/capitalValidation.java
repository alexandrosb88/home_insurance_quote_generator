package Home_Insurance_Quote_Generator;

import javafx.scene.control.TextField;

public class capitalValidation {

    static void isHomeCapitalValid(TextField input, String message) {
        try {
            int homeCapital = Integer.parseInt(input.getText()); // Μετατροπή σε integer

            if (homeCapital >= 0) {
                System.out.println("The building value is: " + homeCapital);
            } else {
                System.out.println("Error: The value cannot be a negative number!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + "is not a valid number!");

        }
    }


    static void isContentCapitalValid(TextField input, String message) {
        try {
            int contentCapital = Integer.parseInt(input.getText());

            if (contentCapital >= 0) {
                System.out.println("The content value is: " + contentCapital);
            } else {
                System.out.println("Error: The value cannot be a negative number!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + "is not a valid number!");

        }
    }
}
