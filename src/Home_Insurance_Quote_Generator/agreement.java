package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class agreement {

    public static List<String> agreementList = new ArrayList<>();

    public static int addAgreement(String input, GridPane grid, int lastPosition, CheckBox lastBox) {

        int newPosition = lastPosition + 1;


        CheckBox newBox = new CheckBox(input);
        newBox.setSelected(true);
        GridPane.setConstraints(newBox, 0, newPosition);
        GridPane.setColumnSpan(newBox, 6);
        grid.getChildren().add(newBox);


        agreementList.add("• " + input);
        System.out.println(agreementList);

        lastPosition += 1;
        return lastPosition;

    }

    public static List<String> getAgreementList() {
        return agreementList;
    }

}
