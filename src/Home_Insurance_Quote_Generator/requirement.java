package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class requirement {


    public static List<String> requirementList = new ArrayList<>();
    public static int addRequirement(String input, GridPane grid, int lastPosition, CheckBox lastBox) {

        int newPosition = lastPosition + 1;


        CheckBox newBox = new CheckBox(input);
        newBox.setSelected(true);
        GridPane.setConstraints(newBox, 0, newPosition);
        GridPane.setColumnSpan(newBox, 6);
        grid.getChildren().add(newBox);


        requirementList.add("• " + input);
        System.out.println(requirementList);


        lastPosition += 1;
        return lastPosition;

    }

    public static List<String> getRequirementList() {
        return requirementList;
    }

}
