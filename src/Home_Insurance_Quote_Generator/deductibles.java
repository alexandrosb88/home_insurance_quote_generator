package Home_Insurance_Quote_Generator;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class deductibles {

    public static void handleDeductibles(CheckBox box8, CheckBox box6, CheckBox box7, CheckBox box11, CheckBox box12, CheckBox box16,
                                         CheckBox box17, CheckBox box18, CheckBox box19, CheckBox box20,
                                         TextField deductField1, TextField deductField2, TextField deductField3,
                                         TextField deductField4, ComboBox<String> earthquake) {




        // Earthquake

        ChangeListener<Boolean> box8Listener = (observable, oldValue, newValue) -> {
            if (!box8.isSelected()) {
                box16.setVisible(false);
                earthquake.setVisible(false);
            } else {
                box16.setVisible(true);
                box16.setSelected(true);
                earthquake.setVisible(true);
            }
        };

        box8.selectedProperty().addListener(box8Listener);


        // Weather conditions

        ChangeListener<Boolean> box6Listener = (observable, oldValue, newValue) -> {
            if (!box6.isSelected()) {
                box17.setVisible(false);
                deductField1.setVisible(false);
            } else {
                box17.setVisible(true);
                deductField1.setVisible(true);
            }
        };

        box6.selectedProperty().addListener(box6Listener);


        // Water damage

        ChangeListener<Boolean> box7Listener = (observable, oldValue, newValue) -> {
            if (!box7.isSelected()) {
                box18.setVisible(false);
                deductField2.setVisible(false);
            } else {
                box18.setVisible(true);
                deductField2.setVisible(true);
            }
        };

        box7.selectedProperty().addListener(box7Listener);


        // Theft of content

        ChangeListener<Boolean> box11Listener = (observable, oldValue, newValue) -> {

            if (!box11.isSelected()) {
                box19.setVisible(false);
                deductField3.setVisible(false);
            } else {
                box19.setVisible(true);
                deductField3.setVisible(true);
            }
        };

        box11.selectedProperty().addListener(box11Listener);


        // Short circuit

        ChangeListener<Boolean> box12Listener = (observable, oldValue, newValue) -> {
            if (!box12.isSelected()) {
                box20.setVisible(false);
                deductField4.setVisible(false);
            } else {
                box20.setVisible(true);
                deductField4.setVisible(true);
            }
        };

        box12.selectedProperty().addListener(box12Listener);


    }


}
