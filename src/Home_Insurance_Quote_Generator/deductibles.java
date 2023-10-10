package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class deductibles {

    public static void handleDeductibles(CheckBox box4, CheckBox box5, CheckBox box8, CheckBox box9, TextField deductField1, TextField deductField2) {

        box4.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box4.isSelected()) {
                box8.setVisible(false);
                deductField1.setVisible(false);
            } else {
                box8.setVisible(true);
                deductField1.setVisible(true);
            }
        });


        box5.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box5.isSelected()) {
                box9.setVisible(false);
                deductField2.setVisible(false);
            } else {
                box9.setVisible(true);
                deductField2.setVisible(true);
            }

        });

    }

}
