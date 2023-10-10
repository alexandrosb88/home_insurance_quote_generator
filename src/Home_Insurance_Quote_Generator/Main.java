package Home_Insurance_Quote_Generator;

/*

This application is designed for the purpose of generating quotes for a tailor-made home insurance product.

The user is required to input the insured value for building and/or content.

Additionally, the user has the option to select a plan in which coverage components are automatically selected, while
retaining the ability to check/uncheck any specific coverage item individually.

The calculation of the limit of each cover is automated based on pre-configured rules.

Furthermore, the user has the capability to review and adjust contract clauses as needed.
Any contract clause that may not be initially included can be manually appended.

Finally, the quote is delivered in PDF format.

 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {


    Stage window;
    ComboBox<String> comboBox, comboBox2;
    CheckBox box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15;
    TextField requirementInput;

    int lastPosition = 36; // Setting the position of an item to adjust any further additions accordingly



    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Home Insurance Quote Generator");

        String filename = "C:\\Users\\Sonic\\IdeaProjects\\project_offer\\src\\package_8\\short-circuit-building-config.txt";
        configurationFile.readConfigFile(filename);

        // Setting the grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40, 10, 40, 10));
        grid.setVgap(8);
        grid.setHgap(4);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        scrollPane.setContent(grid);

        //Building Label
        Label homeLabel = new Label("Building:");
        GridPane.setConstraints(homeLabel, 0, 0);

        //Building Field
        TextField homeInput = new TextField();
        homeInput.setPromptText("e.g. 400000");
        homeInput.setMaxWidth(150);
        GridPane.setConstraints(homeInput, 1, 0);

        //Content Label
        Label contentLabel = new Label("Content:");
        GridPane.setConstraints(contentLabel, 0, 1);

        //Content Field
        TextField contentInput = new TextField();
        contentInput.setPromptText("e.g. 50000");
        contentInput.setMaxWidth(150);
        GridPane.setConstraints(contentInput, 1, 1);


        //Combo Box - Plan
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Essential",
                "Excess",
                "Complete"
        );

        comboBox.setPromptText("Select Plan...");
        comboBox.setOnAction(e -> {
            planOptions.handleOptionsPlan(comboBox.getValue(), box1, box2, box3, box4, box5, box6, box7);
            System.out.println("Plan selected: " + comboBox.getValue());
        });

        GridPane.setConstraints(comboBox, 1, 3);


        // Building - Content - Sum Labels
        Label buildingLabelCover = new Label("Building");
        GridPane.setConstraints(buildingLabelCover, 1, 6);

        Label contentLabelCover = new Label("Content");
        GridPane.setConstraints(contentLabelCover, 2, 6);

        Label sumLabelCover = new Label("Total");
        GridPane.setConstraints(sumLabelCover, 3, 6);

        // Covers
        box1 = new CheckBox("Fire");
        box2 = new CheckBox("Lighting");
        box3 = new CheckBox("Explosion");
        box4 = new CheckBox("Theft of content as a result of burglary / robbery");
        box5 = new CheckBox("Short Circuit");
        box6 = new CheckBox("Civil liability");
        box7 = new CheckBox("All risk");


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

        GridPane.setConstraints(box1, 0, 7);
        GridPane.setConstraints(box2, 0, 8);
        GridPane.setConstraints(box3, 0, 9);
        GridPane.setConstraints(box4, 0, 10);
        GridPane.setConstraints(box5, 0, 11);
        GridPane.setConstraints(box6, 0, 12);
        GridPane.setConstraints(box7, 0, 13);

        TextField buildingField1 = new TextField();
        buildingField1.setMaxWidth(100);
        TextField buildingField2 = new TextField();
        buildingField2.setMaxWidth(100);
        TextField buildingField3 = new TextField();
        buildingField3.setMaxWidth(100);
        TextField buildingField4 = new TextField();
        buildingField4.setMaxWidth(100);
        buildingField4.setDisable(true);
        TextField buildingField5 = new TextField();
        buildingField5.setMaxWidth(100);
        buildingField5.setDisable(true);
        TextField buildingField6 = new TextField();
        buildingField6.setMaxWidth(100);
        buildingField6.setDisable(true);
        TextField buildingField7 = new TextField();
        buildingField7.setMaxWidth(100);
        buildingField7.setDisable(true);

        GridPane.setConstraints(buildingField1, 1, 7);
        GridPane.setConstraints(buildingField2, 1, 8);
        GridPane.setConstraints(buildingField3, 1, 9);
        GridPane.setConstraints(buildingField4, 1, 10);
        GridPane.setConstraints(buildingField5, 1, 11);
        GridPane.setConstraints(buildingField6, 1, 12);
        GridPane.setConstraints(buildingField7, 1, 13);


        TextField contentField1 = new TextField();
        contentField1.setMaxWidth(100);
        TextField contentField2 = new TextField();
        contentField2.setMaxWidth(100);
        TextField contentField3 = new TextField();
        contentField3.setMaxWidth(100);
        TextField contentField4 = new TextField();
        contentField4.setMaxWidth(100);
        contentField4.setDisable(true);
        TextField contentField5 = new TextField();
        contentField5.setMaxWidth(100);
        contentField5.setDisable(true);
        TextField contentField6 = new TextField();
        contentField6.setMaxWidth(100);
        contentField6.setDisable(true);
        TextField contentField7 = new TextField();
        contentField7.setMaxWidth(100);
        contentField7.setDisable(true);

        GridPane.setConstraints(contentField1, 2, 7);
        GridPane.setConstraints(contentField2, 2, 8);
        GridPane.setConstraints(contentField3, 2, 9);
        GridPane.setConstraints(contentField4, 2, 10);
        GridPane.setConstraints(contentField5, 2, 11);
        GridPane.setConstraints(contentField6, 2, 12);
        GridPane.setConstraints(contentField7, 2, 13);


        TextField sumField1 = new TextField();
        sumField1.setMaxWidth(100);
        TextField sumField2 = new TextField();
        sumField2.setMaxWidth(100);
        TextField sumField3 = new TextField();
        sumField3.setMaxWidth(100);
        TextField sumField4 = new TextField();
        sumField4.setMaxWidth(100);
        sumField4.setDisable(true);
        TextField sumField5 = new TextField();
        sumField5.setMaxWidth(100);
        sumField5.setDisable(true);
        TextField sumField6 = new TextField();
        sumField6.setMaxWidth(100);
        sumField6.setDisable(true);
        TextField sumField7 = new TextField();
        sumField7.setMaxWidth(100);
        sumField7.setDisable(true);

        GridPane.setConstraints(sumField1, 3, 7);
        GridPane.setConstraints(sumField2, 3, 8);
        GridPane.setConstraints(sumField3, 3, 9);
        GridPane.setConstraints(sumField4, 3, 10);
        GridPane.setConstraints(sumField5, 3, 11);
        GridPane.setConstraints(sumField6, 3, 12);
        GridPane.setConstraints(sumField7, 3, 13);


        // Deductibles
        Label deductiblelabel = new Label("Deductibles");
        GridPane.setConstraints(deductiblelabel, 0, 16);
        deductiblelabel.setFont(Font.font(deductiblelabel.getFont().getFamily(), FontWeight.BOLD, deductiblelabel.getFont().getSize()));

        box8 = new CheckBox("Theft of content");
        box9 = new CheckBox("Short circuit");

        box8.setSelected(false);
        box9.setSelected(false);
        box8.setVisible(false);
        box9.setVisible(false);

        GridPane.setConstraints(box8, 0, 18);
        GridPane.setConstraints(box9, 0, 20);

        TextField deductField1 = new TextField("€ 300,00 for each damage");
        deductField1.setMaxWidth(450);
        deductField1.setVisible(false);
        deductField1.setDisable(true);
        TextField deductField2 = new TextField("€ 150,00 for each damage");
        deductField2.setMaxWidth(200);
        deductField2.setVisible(false);
        deductField2.setDisable(true);

        GridPane.setConstraints(deductField1, 1, 18);
        GridPane.setColumnSpan(deductField1, 4);
        GridPane.setConstraints(deductField2, 1, 20);

        deductibles.handleDeductibles(box4, box5, box8, box9, deductField1, deductField2);

        // Additional Agreements
        Label specialAgreementsLabel = new Label("Additional Agreements");
        GridPane.setConstraints(specialAgreementsLabel, 0, 22);
        specialAgreementsLabel.setFont(Font.font(specialAgreementsLabel.getFont().getFamily(), FontWeight.BOLD, specialAgreementsLabel.getFont().getSize()));

        box10 = new CheckBox("72-hour clause");
        box11 = new CheckBox("Underinsurance protection clause");
        box12 = new CheckBox("The insurance coverage extends to sheds and other outdoor structures");

        box10.setSelected(true);
        box11.setSelected(true);
        box12.setSelected(true);

        GridPane.setConstraints(box10, 0, 24);
        GridPane.setConstraints(box11, 0, 25);
        GridPane.setConstraints(box12, 0, 26);
        GridPane.setColumnSpan(box12, 6);

        TextField underinsuranceProtection = new TextField("10%");
        underinsuranceProtection.setMaxWidth(50);

        GridPane.setConstraints(underinsuranceProtection, 1, 25);

        specialAgreements.handleSpecialAgreements(box11, underinsuranceProtection);

        // Contract Clauses
        Label conditionsLabel = new Label("Contract Clauses");
        GridPane.setConstraints(conditionsLabel, 0, 28);
        conditionsLabel.setFont(Font.font(conditionsLabel.getFont().getFamily(), FontWeight.BOLD, conditionsLabel.getFont().getSize()));

        box13 = new CheckBox("5-year damage free clause");
        box14 = new CheckBox("The insured property must have been constructed in full compliance with all applicable building codes and regulations");
        box15 = new CheckBox("The insured property must have theft prevention measures in place, including security locks and alarm system");

        box13.setSelected(true);
        box14.setSelected(true);
        box15.setSelected(true);

        GridPane.setConstraints(box13, 0, 30);
        GridPane.setConstraints(box14, 0, 32);
        GridPane.setConstraints(box15, 0, 34);
        GridPane.setColumnSpan(box13, 2);
        GridPane.setColumnSpan(box14, 6);
        GridPane.setRowSpan(box14, 2);
        GridPane.setColumnSpan(box15, 6);
        GridPane.setRowSpan(box15, 2);


        // Requirement Input
        requirementInput = new TextField();
        requirementInput.setPromptText("Add Clause...");
        requirementInput.setMinWidth(300);
        requirementInput.setMinHeight(50);
        GridPane.setConstraints(requirementInput, 3, 40);

        // Add Clause Button
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 2, 40);

        // Add Clause by pressing "Enter" in requirementInput field
        requirementInput.setOnAction( e -> {
            addButton.fire();
        });



        greyOut.greyOutFields(box4, box5, box6, box7, box8, box9, buildingField4, buildingField5, buildingField6, buildingField7,
                contentField4, contentField5, contentField6, contentField7, sumField4, sumField5, sumField6, sumField7,
                deductField1, deductField2);


        // Premium
        Label premiumLabel = new Label("Annual Premium Amount: €");
        TextField premiumField = new TextField();
        premiumField.setMaxWidth(100);


        GridPane.setConstraints(premiumLabel, 2, 41);
        GridPane.setConstraints(premiumField, 3, 41);


        // Combo Box 2 - Underwriters
        comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll(
                "Alexandros B",
                "John Doe",
                "Jimmy Spam"
        );

        comboBox2.setPromptText("Underwriter");

        GridPane.setConstraints(comboBox2, 3, 44);

        // Submit Button
        Button submitButton = new Button("Submit Values");
        submitButton.setOnAction(e -> {
            capitalValidation.isHomeCapitalValid(homeInput, homeInput.getText());
            capitalValidation.isContentCapitalValid(contentInput, contentInput.getText());
            initializeCapital.setToZero(homeInput, contentInput);
            coverLimit.setCoverLimit(homeInput, contentInput, box1, box2, box3, box4, box5, box6, box7, buildingField1, contentField1, sumField1,
                    buildingField2, contentField2, sumField2, buildingField3, contentField3, sumField3,
                    buildingField4, contentField4, sumField4, buildingField5, contentField5, sumField5,
                    buildingField6, contentField6, sumField6, buildingField7, contentField7, sumField7);
        });

        GridPane.setConstraints(submitButton, 1, 2);

        // Export PDF Button
        Button printButton = new Button("Export to PDF");
        GridPane.setConstraints(printButton, 3, 50);


        addButton.setOnAction(e -> {
            lastPosition = requirement.addRequirement(requirementInput.getText(), grid, lastPosition);
            GridPane.setConstraints(requirementInput, 3, lastPosition + 2);
            GridPane.setConstraints(addButton, 2, lastPosition + 2);
            GridPane.setConstraints(premiumLabel, 2, lastPosition + 3);
            GridPane.setConstraints(premiumField, 3, lastPosition + 3);
            GridPane.setConstraints(comboBox2, 3, lastPosition + 6);
            GridPane.setConstraints(printButton, 3, lastPosition + 12);
        });

        grid.getChildren().addAll(homeLabel, homeInput, contentLabel, contentInput, buildingLabelCover, contentLabelCover, sumLabelCover,
                box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15,
                deductiblelabel, deductField1, deductField2, specialAgreementsLabel, underinsuranceProtection, conditionsLabel,
                buildingField1, buildingField2, buildingField3, buildingField4, buildingField5, buildingField6, buildingField7,
                contentField1, contentField2, contentField3, contentField4, contentField5, contentField6, contentField7,
                submitButton, comboBox, comboBox2, addButton, requirementInput, printButton, sumField1, sumField2, sumField3, sumField4, sumField5, sumField6, sumField7,
                premiumLabel, premiumField);


        // Create Scene
        Scene scene = new Scene(scrollPane, 1200, 800);

        window.setScene(scene);
        window.show();

    }



}








