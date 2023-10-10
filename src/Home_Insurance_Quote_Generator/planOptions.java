package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;

public class planOptions {

    public static void handleOptionsPlan(String selectedOption, CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4, CheckBox box5, CheckBox box6, CheckBox box7) {

        switch (selectedOption) {
            case "Essential":
                box1.setSelected(true);
                box1.setDisable(true);
                box2.setSelected(true);
                box2.setDisable(true);
                box3.setSelected(true);
                box3.setDisable(true);
                box4.setSelected(false);
                box5.setSelected(false);
                box6.setSelected(false);
                box7.setSelected(false);
                break;
            case "Excess":
                box1.setSelected(true);
                box1.setDisable(true);
                box2.setSelected(true);
                box2.setDisable(true);
                box3.setSelected(true);
                box3.setDisable(true);
                box4.setSelected(true);
                box5.setSelected(true);
                box6.setSelected(true);
                box7.setSelected(false);
                break;
            case "Complete":
                box1.setSelected(true);
                box1.setDisable(true);
                box2.setSelected(true);
                box2.setDisable(true);
                box3.setSelected(true);
                box3.setDisable(true);
                box4.setSelected(true);
                box5.setSelected(true);
                box6.setSelected(true);
                box7.setSelected(true);
                break;
        }

    }

}
