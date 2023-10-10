package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class greyOut {

    public static void greyOutFields(CheckBox box4, CheckBox box5, CheckBox box6, CheckBox box7, CheckBox box8, CheckBox box9, TextField bfield4, TextField bfield5, TextField bfield6, TextField bfield7,
                               TextField cfield4, TextField cfield5, TextField cfield6, TextField cfield7, TextField sfield4, TextField sfield5, TextField sfield6, TextField sfield7,
                               TextField deductField1, TextField deductField2) {

        box4.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box4.isSelected()) {
                bfield4.setDisable(true);
                cfield4.setDisable(true);
                sfield4.setDisable(true);

            } else {
                bfield4.setDisable(false);
                cfield4.setDisable(false);
                sfield4.setDisable(false);
            }
        });

        box5.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box5.isSelected()) {
                bfield5.setDisable(true);
                cfield5.setDisable(true);
                sfield5.setDisable(true);

            } else {
                bfield5.setDisable(false);
                cfield5.setDisable(false);
                sfield5.setDisable(false);
            }
        });

        box6.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box6.isSelected()) {
                bfield6.setDisable(true);
                cfield6.setDisable(true);
                sfield6.setDisable(true);

            } else {
                bfield6.setDisable(false);
                cfield6.setDisable(false);
                sfield6.setDisable(false);
            }
        });

        box7.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box7.isSelected()) {
                bfield7.setDisable(true);
                cfield7.setDisable(true);
                sfield7.setDisable(true);

            } else {
                bfield7.setDisable(false);
                cfield7.setDisable(false);
                sfield7.setDisable(false);
            }
        });

        box8.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box8.isSelected()) {
                deductField1.setDisable(true);

            } else {
                deductField1.setDisable(false);
            }
        });

        box9.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box9.isSelected()) {
                deductField2.setDisable(true);

            } else {
                deductField2.setDisable(false);
            }
        });

    }



}
