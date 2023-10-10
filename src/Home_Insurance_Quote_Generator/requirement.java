package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class requirement {

    public static int addRequirement(String input, GridPane grid, int lastPosition) {

        int newPosition = lastPosition + 1;

        CheckBox box16 = new CheckBox(input);
        box16.setSelected(true);
        GridPane.setConstraints(box16, 0, newPosition);
        GridPane.setColumnSpan(box16, 6);
        //GridPane.setRowSpan(box16, 2);
        grid.getChildren().add(box16);

        lastPosition += 1;
        return lastPosition;

    }

}
