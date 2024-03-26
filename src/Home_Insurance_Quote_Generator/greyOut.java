package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class greyOut {

    public static void greyOutFields(CheckBox box5, CheckBox box6, CheckBox box7, CheckBox box8, CheckBox box9, CheckBox box10, CheckBox box11,
                                     CheckBox box12, CheckBox box13, CheckBox box14, CheckBox box15, CheckBox box16, CheckBox box17, CheckBox box18, CheckBox box19,
                                     CheckBox box20, CheckBox box25, CheckBox box29,

                                     TextField bfield5, TextField bfield6, TextField bfield7, TextField bfield8, TextField bfield9, TextField bfield10,
                                     TextField bfield11, TextField bfield12, TextField bfield13, TextField bfield14, TextField bfield15,

                                     TextField cfield5, TextField cfield6, TextField cfield7, TextField cfield8, TextField cfield9, TextField cfield10,
                                     TextField cfield11, TextField cfield12, TextField cfield13, TextField cfield14, TextField cfield15,

                                     TextField sfield5, TextField sfield6, TextField sfield7, TextField sfield8, TextField sfield9, TextField sfield10,
                                     TextField sfield11, TextField sfield12, TextField sfield13, TextField sfield14, TextField sfield15,
                                     TextField deductField1, TextField deductField2, TextField deductField3, TextField deductField4, ComboBox<String> earthquake,
                                     TextField underInsurance, TextArea theftMeasures
                               
                               ) {

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
                bfield8.setDisable(true);
                cfield8.setDisable(true);
                sfield8.setDisable(true);

            } else {
                bfield8.setDisable(false);
                cfield8.setDisable(false);
                sfield8.setDisable(false);
            }
        });

        box9.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box9.isSelected()) {
                bfield9.setDisable(true);
                cfield9.setDisable(true);
                sfield9.setDisable(true);

            } else {
                bfield9.setDisable(false);
                cfield9.setDisable(false);
                sfield9.setDisable(false);
            }
        });

        box10.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box10.isSelected()) {
                bfield10.setDisable(true);
                cfield10.setDisable(true);
                sfield10.setDisable(true);

            } else {
                bfield10.setDisable(false);
                cfield10.setDisable(false);
                sfield10.setDisable(false);
            }
        });

        box11.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box11.isSelected()) {
                bfield11.setDisable(true);
                cfield11.setDisable(true);
                sfield11.setDisable(true);

            } else {
                bfield11.setDisable(false);
                cfield11.setDisable(false);
                sfield11.setDisable(false);
            }
        });

        box12.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box12.isSelected()) {
                bfield12.setDisable(true);
                cfield12.setDisable(true);
                sfield12.setDisable(true);

            } else {
                bfield12.setDisable(false);
                cfield12.setDisable(false);
                sfield12.setDisable(false);
            }
        });

        box13.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box13.isSelected()) {
                bfield13.setDisable(true);
                cfield13.setDisable(true);
                sfield13.setDisable(true);

            } else {
                bfield13.setDisable(false);
                cfield13.setDisable(false);
                sfield13.setDisable(false);
            }
        });

        box14.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box14.isSelected()) {
                bfield14.setDisable(true);
                cfield14.setDisable(true);
                sfield14.setDisable(true);

            } else {
                bfield14.setDisable(false);
                cfield14.setDisable(false);
                sfield14.setDisable(false);
            }
        });

        box15.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box15.isSelected()) {
                bfield15.setDisable(true);
                cfield15.setDisable(true);
                sfield15.setDisable(true);

            } else {
                bfield15.setDisable(false);
                cfield15.setDisable(false);
                sfield15.setDisable(false);
            }
        });

        box16.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box16.isSelected()) {
                earthquake.setDisable(true);

            } else {
                earthquake.setDisable(false);
            }
        });

        box17.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box17.isSelected()) {
                deductField1.setDisable(true);

            } else {
                deductField1.setDisable(false);
            }
        });

        box18.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box18.isSelected()) {
                deductField2.setDisable(true);

            } else {
                deductField2.setDisable(false);
            }
        });

        box19.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box19.isSelected()) {
                deductField3.setDisable(true);

            } else {
                deductField3.setDisable(false);
            }
        });

        box20.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box20.isSelected()) {
                deductField4.setDisable(true);

            } else {
                deductField4.setDisable(false);
            }
        });


        box25.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box25.isSelected()) {
                underInsurance.setDisable(true);

            } else {
                underInsurance.setDisable(false);
            }
        });


        box29.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (!box29.isSelected()) {
                theftMeasures.setDisable(true);

            } else {
                theftMeasures.setDisable(false);
            }
        });

    }



}
