package Home_Insurance_Quote_Generator;

import javafx.scene.control.TextField;

public class initializeCapital {

    public static void setToZero(TextField input1, TextField input2) {

        String homeCapital = input1.getText();
        String contentCapital = input2.getText();

        if (homeCapital.isEmpty()) {
            input1.setText("0");
        }

        if (contentCapital.isEmpty()) {
            input2.setText("0");
        }


    }

}
