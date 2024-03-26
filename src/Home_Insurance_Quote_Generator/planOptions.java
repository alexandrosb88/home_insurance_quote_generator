package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;

public class planOptions {

    public static void handleOptionsPlan(String selectedOption, CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4, CheckBox box5, CheckBox box6, CheckBox box7,
                                         CheckBox box9, CheckBox box10, CheckBox box11, CheckBox box12, CheckBox box13, CheckBox box14, CheckBox box15) {

        switch (selectedOption) {
            case "Essential":
                box1.setSelected(true);
                box1.setDisable(true);
                box2.setSelected(true);
                box2.setDisable(true);
                box3.setSelected(true);
                box3.setDisable(true);
                box4.setSelected(true);
                box4.setDisable(true);
                box5.setSelected(true);
                box6.setSelected(true);
                box7.setSelected(true);
                box9.setSelected(false);
                box10.setSelected(false);
                box11.setSelected(false);
                box12.setSelected(false);
                box13.setSelected(false);
                box14.setSelected(false);
                box15.setSelected(false);
                break;
            case "Excess":
                box1.setSelected(true);
                box1.setDisable(true);
                box2.setSelected(true);
                box2.setDisable(true);
                box3.setSelected(true);
                box3.setDisable(true);
                box4.setSelected(true);
                box4.setDisable(true);
                box5.setSelected(true);
                box6.setSelected(true);
                box7.setSelected(true);
                box9.setSelected(true);
                box10.setSelected(true);
                box11.setSelected(true);
                box12.setSelected(true);
                box13.setSelected(false);
                box14.setSelected(false);
                box15.setSelected(false);
                break;
            case "Complete":
                box1.setSelected(true);
                box1.setDisable(true);
                box2.setSelected(true);
                box2.setDisable(true);
                box3.setSelected(true);
                box3.setDisable(true);
                box4.setSelected(true);
                box4.setDisable(true);
                box5.setSelected(true);
                box6.setSelected(true);
                box7.setSelected(true);
                box9.setSelected(true);
                box10.setSelected(true);
                box11.setSelected(true);
                box12.setSelected(true);
                box13.setSelected(true);
                box14.setSelected(true);
                box15.setSelected(true);
                break;
        }

    }

}
