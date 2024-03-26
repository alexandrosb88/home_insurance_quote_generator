package Home_Insurance_Quote_Generator;

/*

<--- Home Insurance Quote Generator --->
Copyright (c) 2023 alexandrosb88


This application is designed for the purpose of generating quotes for a tailor-made home insurance product.

The user is required to input the insured value for building and/or content.

Additionally, the user has the option to select a plan in which coverage components are automatically selected, while
retaining the ability to check/uncheck any specific coverage item individually.

The calculation of the limit of several covers is automated based on pre-configured rules.

Furthermore, the user has the capability to review and adjust contract clauses as needed.
Any contract clause that may not be initially included can be manually appended.

Finally, the quote is delivered in XLS format.

 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;


public class Main extends Application {


    Stage window;
    ComboBox<String> comboBoxPlans, comboBoxUnderwriters, comboBoxResidenceType, comboBoxEarthquake;
    CheckBox box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15, box16, box17,
    box18, box19, box20, box21, box22, box23, box24, box25, box26, box27, box28, box29, box30;
    TextArea requirementInput;

    int lastRow, lastPosition;

    CheckBox lastBox = box30;



    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Home Insurance Quote Generator");


        // Setting the grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40, 10, 40, 10));
        grid.setVgap(8);
        grid.setHgap(4);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        scrollPane.setContent(grid);


        // Header
        ImageView imageView = new ImageView();
        Image image = new Image("C:\\Users\\Sonic\\IdeaProjects\\home_insurance_quote_generator\\src\\Home_Insurance_Quote_Generator\\app_logo.png"); // Replace with the actual path to your image
        imageView.setImage(image);
        GridPane.setConstraints(imageView, 0, 0);
        GridPane.setColumnSpan(imageView, 6);


        // Broker label
        Label brokerLabel = new Label("Broker ID:");
        GridPane.setConstraints(brokerLabel, 0, 2);

        // Broker input
        TextField brokerInput =  new TextField();
        GridPane.setConstraints(brokerInput, 1, 2);
        GridPane.setColumnSpan(brokerInput, 2);
        brokerInput.setMaxWidth(100);

        // Name label
        Label nameLabel = new Label("Name");
        GridPane.setConstraints(nameLabel, 0, 3);

        // Name input
        TextField nameInput =  new TextField();
        GridPane.setConstraints(nameInput, 1, 3);
        GridPane.setColumnSpan(nameInput, 2);
        nameInput.setMaxWidth(200);

        // VAT label
        Label vatLabel = new Label("VAT number:");
        GridPane.setConstraints(vatLabel, 0, 4);

        // VAT input
        TextField vatInput =  new TextField();
        GridPane.setConstraints(vatInput, 1, 4);
        GridPane.setColumnSpan(vatInput, 2);
        vatInput.setMaxWidth(100);

        vatInput.setTextFormatter(new TextFormatter<String>((Change change) -> {
            if (change.getControlNewText().matches("\\d{0,9}")) {
                return change;
            } else {
                return null;
            }
        }));

        // Email label
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 5);

        // Email input
        TextField emailInput =  new TextField();
        GridPane.setConstraints(emailInput, 1, 5);
        GridPane.setColumnSpan(emailInput, 2);
        emailInput.setMaxWidth(200);

        // Address label
        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 6);

        // Address input
        TextField addressInput =  new TextField();
        GridPane.setConstraints(addressInput, 1, 6);
        addressInput.setMaxWidth(200);
        GridPane.setColumnSpan(addressInput, 2);

        // Postal Code label
        Label postalCodeLabel = new Label("                         P.C. ");
        GridPane.setConstraints(postalCodeLabel, 3, 6);


        // Postal Code input
        TextField postalCodeInput =  new TextField();
        GridPane.setConstraints(postalCodeInput, 4, 6);
        postalCodeInput.setMinWidth(50);
        postalCodeInput.setMaxWidth(50);
        GridPane.setColumnSpan(postalCodeInput, 2);

        // Combo Box - Residence type
        Label residenceTypeLabel = new Label("Residence Type");
        GridPane.setConstraints(residenceTypeLabel, 0, 7);

        comboBoxResidenceType = new ComboBox<>();
        comboBoxResidenceType.getItems().addAll(
                "Main residence",
                "Secondary Residence"
        );

        comboBoxResidenceType.setValue("Main residence");
        GridPane.setConstraints(comboBoxResidenceType, 1, 7);
        GridPane.setColumnSpan(comboBoxResidenceType,2);
        comboBoxResidenceType.setMaxWidth(200);

        ChangeListener<String> residenceTypeListener = (observable, oldValue, newValue) -> {
            if ("Secondary Residence".equals(comboBoxResidenceType.getValue())) {
                box29.setSelected(true);
            } else {
                box29.setSelected(false);
            }
        };

        comboBoxResidenceType.getSelectionModel().selectedItemProperty().addListener(residenceTypeListener);

        // Description label
        Label descriptionLabel = new Label("Description:");
        GridPane.setConstraints(descriptionLabel, 0, 8);

        // Description input
        TextField descriptionInput =  new TextField();
        GridPane.setConstraints(descriptionInput, 1, 8);
        descriptionInput.setPromptText("Construction type, surface (in sq.m.), year of construction...");
        GridPane.setColumnSpan(descriptionInput, 3);
        descriptionInput.setMaxWidth(500);

        //Building Label
        Label homeLabel = new Label("Building:");
        GridPane.setConstraints(homeLabel, 0, 10);

        //Building Field
        TextField homeInput = new TextField();
        homeInput.setPromptText("e.g. 400000");
        homeInput.setMaxWidth(150);
        GridPane.setConstraints(homeInput, 1, 10);
        GridPane.setColumnSpan(homeInput, 2);

        //Content Label
        Label contentLabel = new Label("Content:");
        GridPane.setConstraints(contentLabel, 0, 11);

        //Content Field
        TextField contentInput = new TextField();
        contentInput.setPromptText("e.g. 50000");
        contentInput.setMaxWidth(150);
        GridPane.setConstraints(contentInput, 1, 11);
        GridPane.setColumnSpan(contentInput, 2);


        //Combo Box - Plans
        comboBoxPlans = new ComboBox<>();
        comboBoxPlans.getItems().addAll(
                "Essential",
                "Excess",
                "Complete"
        );

        comboBoxPlans.setPromptText("Select Plan...");
        comboBoxPlans.setOnAction(e -> {
            planOptions.handleOptionsPlan(comboBoxPlans.getValue(), box1, box2, box3, box4, box5, box6, box7, box9, box10, box11, box12,
                    box13, box14, box15);
        });

        GridPane.setConstraints(comboBoxPlans, 1, 13);


        // Building - Content - Sum Labels
        Label buildingLabelCover = new Label("Building");
        GridPane.setConstraints(buildingLabelCover, 1, 15);

        Label contentLabelCover = new Label("Content");
        GridPane.setConstraints(contentLabelCover, 2, 15);

        Label sumLabelCover = new Label("Total");
        GridPane.setConstraints(sumLabelCover, 3, 15);

        // Covers
        box1 = new CheckBox("Fire");
        box2 = new CheckBox("Lighting");
        box3 = new CheckBox("Explosion");
        box4 = new CheckBox("Aircraft Damage");
        box5 = new CheckBox("Firefighting & debris removal");
        box6 = new CheckBox("Weather conditions");
        box7 = new CheckBox("Water damage");
        box8 = new CheckBox("Earthquake");
        box9 = new CheckBox("Terrorist attacks");
        box10 = new CheckBox("Malicious acts");
        box11 = new CheckBox("Theft of content");
        box12 = new CheckBox("Short Circuit");
        box13 = new CheckBox("Third-party liability");
        box14 = new CheckBox("Legal expenses");
        box15 = new CheckBox("All risk");


        box1.setSelected(true);
        box1.setDisable(true);
        box2.setSelected(true);
        box2.setDisable(true);
        box3.setSelected(true);
        box3.setDisable(true);
        box4.setSelected(true);
        box4.setDisable(true);
        box5.setSelected(false);
        box6.setSelected(false);
        box7.setSelected(false);
        box8.setSelected(false);
        box9.setSelected(false);
        box10.setSelected(false);
        box11.setSelected(false);
        box12.setSelected(false);
        box13.setSelected(false);
        box14.setSelected(false);
        box15.setSelected(false);

        GridPane.setConstraints(box1, 0, 17);
        GridPane.setConstraints(box2, 0, 18);
        GridPane.setConstraints(box3, 0, 19);
        GridPane.setConstraints(box4, 0, 20);
        GridPane.setConstraints(box5, 0, 21);
        GridPane.setConstraints(box6, 0, 22);
        GridPane.setConstraints(box7, 0, 23);
        GridPane.setConstraints(box8, 0, 24);
        GridPane.setConstraints(box9, 0, 25);
        GridPane.setConstraints(box10, 0, 26);
        GridPane.setConstraints(box11, 0, 27);
        GridPane.setConstraints(box12, 0, 28);
        GridPane.setConstraints(box13, 0, 29);
        GridPane.setConstraints(box14, 0, 30);
        GridPane.setConstraints(box15, 0, 31);

        TextField buildingField1 = new TextField();
        buildingField1.setMaxWidth(100);
        TextField buildingField2 = new TextField();
        buildingField2.setMaxWidth(100);
        TextField buildingField3 = new TextField();
        buildingField3.setMaxWidth(100);
        TextField buildingField4 = new TextField();
        buildingField4.setMaxWidth(100);
        TextField buildingField5 = new TextField();
        buildingField5.setMaxWidth(100);
        buildingField5.setDisable(true);
        TextField buildingField6 = new TextField();
        buildingField6.setMaxWidth(100);
        buildingField6.setDisable(true);
        TextField buildingField7 = new TextField();
        buildingField7.setMaxWidth(100);
        buildingField7.setDisable(true);
        TextField buildingField8 = new TextField();
        buildingField8.setMaxWidth(100);
        buildingField8.setDisable(true);
        TextField buildingField9 = new TextField();
        buildingField9.setMaxWidth(100);
        buildingField9.setDisable(true);
        TextField buildingField10 = new TextField();
        buildingField10.setMaxWidth(100);
        buildingField10.setDisable(true);
        TextField buildingField11 = new TextField();
        buildingField11.setMaxWidth(100);
        buildingField11.setDisable(true);
        TextField buildingField12 = new TextField();
        buildingField12.setMaxWidth(100);
        buildingField12.setDisable(true);
        TextField buildingField13 = new TextField();
        buildingField13.setMaxWidth(100);
        buildingField13.setDisable(true);
        TextField buildingField14 = new TextField();
        buildingField14.setMaxWidth(100);
        buildingField14.setDisable(true);
        TextField buildingField15 = new TextField();
        buildingField15.setMaxWidth(100);
        buildingField15.setDisable(true);

        GridPane.setConstraints(buildingField1, 1, 17);
        GridPane.setConstraints(buildingField2, 1, 18);
        GridPane.setConstraints(buildingField3, 1, 19);
        GridPane.setConstraints(buildingField4, 1, 20);
        GridPane.setConstraints(buildingField5, 1, 21);
        GridPane.setConstraints(buildingField6, 1, 22);
        GridPane.setConstraints(buildingField7, 1, 23);
        GridPane.setConstraints(buildingField8, 1, 24);
        GridPane.setConstraints(buildingField9, 1, 25);
        GridPane.setConstraints(buildingField10, 1, 26);
        GridPane.setConstraints(buildingField11, 1, 27);
        GridPane.setConstraints(buildingField12, 1, 28);
        GridPane.setConstraints(buildingField13, 1, 29);
        GridPane.setConstraints(buildingField14, 1, 30);
        GridPane.setConstraints(buildingField15, 1, 31);


        TextField contentField1 = new TextField();
        contentField1.setMaxWidth(100);
        TextField contentField2 = new TextField();
        contentField2.setMaxWidth(100);
        TextField contentField3 = new TextField();
        contentField3.setMaxWidth(100);
        TextField contentField4 = new TextField();
        contentField4.setMaxWidth(100);
        TextField contentField5 = new TextField();
        contentField5.setMaxWidth(100);
        contentField5.setDisable(true);
        TextField contentField6 = new TextField();
        contentField6.setMaxWidth(100);
        contentField6.setDisable(true);
        TextField contentField7 = new TextField();
        contentField7.setMaxWidth(100);
        contentField7.setDisable(true);
        TextField contentField8 = new TextField();
        contentField8.setMaxWidth(100);
        contentField8.setDisable(true);
        TextField contentField9 = new TextField();
        contentField9.setMaxWidth(100);
        contentField9.setDisable(true);
        TextField contentField10 = new TextField();
        contentField10.setMaxWidth(100);
        contentField10.setDisable(true);
        TextField contentField11 = new TextField();
        contentField11.setMaxWidth(100);
        contentField11.setDisable(true);
        TextField contentField12 = new TextField();
        contentField12.setMaxWidth(100);
        contentField12.setDisable(true);
        TextField contentField13 = new TextField();
        contentField13.setMaxWidth(100);
        contentField13.setDisable(true);
        TextField contentField14 = new TextField();
        contentField14.setMaxWidth(100);
        contentField14.setDisable(true);
        TextField contentField15 = new TextField();
        contentField15.setMaxWidth(100);
        contentField15.setDisable(true);
        

        GridPane.setConstraints(contentField1, 2, 17);
        GridPane.setConstraints(contentField2, 2, 18);
        GridPane.setConstraints(contentField3, 2, 19);
        GridPane.setConstraints(contentField4, 2, 20);
        GridPane.setConstraints(contentField5, 2, 21);
        GridPane.setConstraints(contentField6, 2, 22);
        GridPane.setConstraints(contentField7, 2, 23);
        GridPane.setConstraints(contentField8, 2, 24);
        GridPane.setConstraints(contentField9, 2, 25);
        GridPane.setConstraints(contentField10, 2, 26);
        GridPane.setConstraints(contentField11, 2, 27);
        GridPane.setConstraints(contentField12, 2, 28);
        GridPane.setConstraints(contentField13, 2, 29);
        GridPane.setConstraints(contentField14, 2, 30);
        GridPane.setConstraints(contentField15, 2, 31);


        TextField sumField1 = new TextField();
        sumField1.setMaxWidth(100);
        TextField sumField2 = new TextField();
        sumField2.setMaxWidth(100);
        TextField sumField3 = new TextField();
        sumField3.setMaxWidth(100);
        TextField sumField4 = new TextField();
        sumField4.setMaxWidth(100);
        TextField sumField5 = new TextField();
        sumField5.setMaxWidth(100);
        sumField5.setDisable(true);
        TextField sumField6 = new TextField();
        sumField6.setMaxWidth(100);
        sumField6.setDisable(true);
        TextField sumField7 = new TextField();
        sumField7.setMaxWidth(100);
        sumField7.setDisable(true);
        TextField sumField8 = new TextField();
        sumField8.setMaxWidth(100);
        sumField8.setDisable(true);
        TextField sumField9 = new TextField();
        sumField9.setMaxWidth(100);
        sumField9.setDisable(true);
        TextField sumField10 = new TextField();
        sumField10.setMaxWidth(100);
        sumField10.setDisable(true);
        TextField sumField11 = new TextField();
        sumField11.setMaxWidth(100);
        sumField11.setDisable(true);
        TextField sumField12 = new TextField();
        sumField12.setMaxWidth(100);
        sumField12.setDisable(true);
        TextField sumField13 = new TextField();
        sumField13.setMaxWidth(100);
        sumField13.setDisable(true);
        TextField sumField14 = new TextField();
        sumField14.setMaxWidth(100);
        sumField14.setDisable(true);
        TextField sumField15 = new TextField();
        sumField15.setMaxWidth(100);
        sumField15.setDisable(true);

        GridPane.setConstraints(sumField1, 3, 17);
        GridPane.setConstraints(sumField2, 3, 18);
        GridPane.setConstraints(sumField3, 3, 19);
        GridPane.setConstraints(sumField4, 3, 20);
        GridPane.setConstraints(sumField5, 3, 21);
        GridPane.setConstraints(sumField6, 3, 22);
        GridPane.setConstraints(sumField7, 3, 23);
        GridPane.setConstraints(sumField8, 3, 24);
        GridPane.setConstraints(sumField9, 3, 25);
        GridPane.setConstraints(sumField10, 3, 26);
        GridPane.setConstraints(sumField11, 3, 27);
        GridPane.setConstraints(sumField12, 3, 28);
        GridPane.setConstraints(sumField13, 3, 29);
        GridPane.setConstraints(sumField14, 3, 30);
        GridPane.setConstraints(sumField15, 3, 31);


        // Deductibles

        Label deductiblelabel = new Label("Deductibles");
        GridPane.setConstraints(deductiblelabel, 0, 33);
        deductiblelabel.setFont(Font.font(deductiblelabel.getFont().getFamily(), FontWeight.BOLD, deductiblelabel.getFont().getSize()));

        box16 = new CheckBox("Earthquake");

        comboBoxEarthquake = new ComboBox<>();
        comboBoxEarthquake.getItems().addAll(
                "2% of the total insured property value",
                "4% of the total insured property value"
        );

        comboBoxEarthquake.setValue("2% of the total insured property value");
        comboBoxEarthquake.setVisible(false);
        GridPane.setConstraints(comboBoxEarthquake, 1, 34);
        GridPane.setColumnSpan(comboBoxEarthquake, 2);

        box17 = new CheckBox("Weather conditions");
        box18 = new CheckBox("Water damage");
        box19 = new CheckBox("Theft of content");
        box20 = new CheckBox("Short circuit");

        box16.setSelected(false);
        box16.setVisible(false);
        box17.setSelected(false);
        box17.setVisible(false);
        box18.setSelected(false);
        box18.setVisible(false);
        box19.setSelected(false);
        box19.setVisible(false);
        box20.setSelected(false);
        box20.setVisible(false);

        GridPane.setConstraints(box16, 0, 34);
        GridPane.setConstraints(box17, 0, 35);
        GridPane.setConstraints(box18, 0, 36);
        GridPane.setConstraints(box19, 0, 37);
        GridPane.setConstraints(box20, 0, 38);

        TextField deductField1 = new TextField("10% of total damages / minimum € 750,00");
        deductField1.setMaxWidth(300);
        deductField1.setVisible(false);
        deductField1.setDisable(true);

        TextField deductField2 = new TextField("10% of total damages / minimum € 750,00");
        deductField2.setMaxWidth(300);
        deductField2.setVisible(false);
        deductField2.setDisable(true);

        TextField deductField3 = new TextField("€ 300,00 for each damage");
        deductField3.setMaxWidth(200);
        deductField3.setVisible(false);
        deductField3.setDisable(true);
        
        TextField deductField4 = new TextField("€ 150,00 for each damage");
        deductField4.setMaxWidth(200);
        deductField4.setVisible(false);
        deductField4.setDisable(true);

        GridPane.setConstraints(deductField1, 1, 35);
        GridPane.setColumnSpan(deductField1, 3);
        GridPane.setConstraints(deductField2, 1, 36);
        GridPane.setColumnSpan(deductField2, 3);
        GridPane.setConstraints(deductField3, 1, 37);
        GridPane.setColumnSpan(deductField3, 4);
        GridPane.setConstraints(deductField4, 1, 38);
        GridPane.setColumnSpan(deductField4, 3);


        deductibles.handleDeductibles(box8, box6, box7, box11, box12, box16, box17, box18, box19, box20, deductField1, deductField2, deductField3, deductField4,
                comboBoxEarthquake);


        // General exclusions

        Label generalExclusionsLabel = new Label("General exclusions");
        GridPane.setConstraints(generalExclusionsLabel, 0, 40);
        generalExclusionsLabel.setFont(Font.font(generalExclusionsLabel.getFont().getFamily(), FontWeight.BOLD, generalExclusionsLabel.getFont().getSize()));


        box21 = new CheckBox("Loss, destruction or damage caused by war");
        box22 = new CheckBox("Damage due to any process of cleaning, dyeing, repairing or restoring to which the property is subjected");
        box23 = new CheckBox("Cyber Act: loss or damage in connection with unauthorised, malicious or criminal act involving access to or use" +
                " of an electronic device");

        box21.setSelected(true);
        box21.setDisable(true);
        box22.setSelected(true);
        box22.setDisable(true);
        box23.setSelected(true);
        box23.setDisable(true);

        GridPane.setConstraints(box21, 0, 41);
        GridPane.setConstraints(box22, 0, 42);
        GridPane.setColumnSpan(box22, 6);
        GridPane.setConstraints(box23, 0, 43);
        GridPane.setColumnSpan(box23, 6);


        // Special Agreements

        Label specialAgreementsLabel = new Label("Special Agreements");
        GridPane.setConstraints(specialAgreementsLabel, 0, 45);
        specialAgreementsLabel.setFont(Font.font(specialAgreementsLabel.getFont().getFamily(), FontWeight.BOLD, specialAgreementsLabel.getFont().getSize()));

        box24 = new CheckBox("72-hour clause");
        box25 = new CheckBox("Underinsurance protection clause");
        box26 = new CheckBox("The insurance coverage extends to sheds and other outdoor structures");

        box24.setSelected(true);
        box25.setSelected(true);
        box26.setSelected(true);

        GridPane.setConstraints(box24, 0, 46);
        GridPane.setConstraints(box25, 0, 47);
        GridPane.setConstraints(box26, 0, 48);
        GridPane.setColumnSpan(box26, 3);

        TextField underinsuranceProtection = new TextField("10%");
        underinsuranceProtection.setMaxWidth(47);

        GridPane.setConstraints(underinsuranceProtection, 1, 47);

        specialAgreements.handleSpecialAgreements(box25, underinsuranceProtection);


        // Conditions & special exclusions

        Label conditionsLabel = new Label("Conditions & special exclusions");
        GridPane.setConstraints(conditionsLabel, 0, 50);
        conditionsLabel.setFont(Font.font(conditionsLabel.getFont().getFamily(), FontWeight.BOLD, conditionsLabel.getFont().getSize()));

        box27 = new CheckBox("5-year damage free clause");
        box28 = new CheckBox("The insured property must have been constructed in full compliance with all applicable building codes and regulations");
        box29 = new CheckBox("Theft prevention measures");
        box30 = new CheckBox("Outdoor furniture, gardening equipment, and any other outdoor home items are excluded");

        box27.setSelected(true);
        box28.setSelected(true);
        box29.setSelected(false);
        box30.setSelected(true);

        TextArea theftMeasures = new TextArea("Security locks, Alarm system connected with an Alarm Receiving Center");
        theftMeasures.setMinWidth(400);
        theftMeasures.setMinHeight(42);
        theftMeasures.setWrapText(true);
        theftMeasures.setDisable(true);

        GridPane.setConstraints(theftMeasures, 2, 53);
        GridPane.setColumnSpan(theftMeasures, 3);


        GridPane.setConstraints(box27, 0, 51);
        GridPane.setColumnSpan(box27, 2);
        GridPane.setConstraints(box28, 0, 52);
        GridPane.setColumnSpan(box28, 6);
        GridPane.setConstraints(box29, 0, 53);
        GridPane.setConstraints(box30, 0, 55);
        GridPane.setColumnSpan(box30, 6);


        // Draw Line

        Line horizontalLine = new Line(50, 100, 500, 100);
        GridPane.setConstraints(horizontalLine, 0, 57);
        GridPane.setColumnSpan(horizontalLine, 6);


        // Last Row

        lastRow = GridPane.getRowIndex(horizontalLine);
        lastPosition = lastRow;


        // Requirement Input

        requirementInput = new TextArea();
        requirementInput.setPromptText("Add clause...");
        requirementInput.setMinWidth(400);
        requirementInput.setMinHeight(45);
        GridPane.setConstraints(requirementInput, 2, 60);
        GridPane.setColumnSpan(requirementInput, 3);


        // Add-Requirement button

        Button addReqButton = new Button("Add a condition/exclusion");
        addReqButton.setMaxWidth(150);
        GridPane.setConstraints(addReqButton, 1, 60);
        addReqButton.setWrapText(true);


        // Add-Agreement button

        Button addAgrButton = new Button("Add a special agreement");
        addAgrButton.setMaxWidth(150);
        GridPane.setConstraints(addAgrButton, 0, 60);


        // Add-Requirement button - Enter functionality

        requirementInput.setWrapText(true);
        requirementInput.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                addReqButton.fire();
            }
        });



        greyOut.greyOutFields(box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15, box16,
                box17, box18, box19, box20, box25, box29,
                buildingField5, buildingField6, buildingField7, buildingField8, buildingField9, buildingField10, buildingField11, buildingField12,
                buildingField13, buildingField14, buildingField15,
                contentField5, contentField6, contentField7, contentField8, contentField9, contentField10, contentField11, contentField12,
                contentField13, contentField14, contentField15,
                sumField5, sumField6, sumField7, sumField8, sumField9, sumField10, sumField11, sumField12, sumField13, sumField14,
                sumField15,
                deductField1, deductField2, deductField3, deductField4, comboBoxEarthquake,
                underinsuranceProtection, theftMeasures
        );




        // Premium
        Label premiumLabel = new Label("Annual Premium Amount: €");
        TextField premiumField = new TextField();
        premiumField.setMaxWidth(100);


        GridPane.setConstraints(premiumLabel, 1, 63);
        GridPane.setConstraints(premiumField, 2, 63);


        // Combo Box - Underwriters
        comboBoxUnderwriters = new ComboBox<>();
        comboBoxUnderwriters.getItems().addAll(
                "Alexandros B",
                "John Doe",
                "Jimmy Spam"
        );

        comboBoxUnderwriters.setPromptText("Underwriter");

        GridPane.setConstraints(comboBoxUnderwriters, 2, 65);



        // Submit Button

        Button submitButton = new Button("Submit Values");


        submitButton.setOnAction(e -> {
            initializeCapital.setToZero(homeInput, contentInput);
            capitalValidation.isHomeCapitalValid(homeInput);
            capitalValidation.isContentCapitalValid(contentInput);
            coverLimit.setCoverLimit(homeInput, contentInput, box1, box2, box3, box4, box5, box6, box7, box8, box9, box10,
                    box11, box12, box13, box14, box15,
                    buildingField1, buildingField2, buildingField3, buildingField4, buildingField5, buildingField6, buildingField7,
                    buildingField8, buildingField9, buildingField10, buildingField11, buildingField12, buildingField13, buildingField14,
                    buildingField15,
                    contentField1, contentField2, contentField3, contentField4, contentField5, contentField6, contentField7,
                    contentField8, contentField9, contentField10, contentField11, contentField12, contentField13, contentField14,
                    contentField15,
                    sumField1, sumField2, sumField3, sumField4, sumField5, sumField6, sumField7, sumField8, sumField9, sumField10,
                    sumField11, sumField12, sumField13, sumField14, sumField15
            );
        });


        GridPane.setConstraints(submitButton, 1, 12);


        // Print button

        Button printButton = new Button("Generate Quote");
        GridPane.setConstraints(printButton, 2, 70);


        addReqButton.setOnAction(e -> {
            lastPosition = requirement.addRequirement(requirementInput.getText(), grid, lastPosition, lastBox);
            GridPane.setConstraints(requirementInput, 2, lastPosition + 2);
            GridPane.setConstraints(addReqButton, 1, lastPosition + 2);
            GridPane.setConstraints(addAgrButton, 0, lastPosition + 2);
            GridPane.setConstraints(premiumLabel, 1, lastPosition + 3);
            GridPane.setConstraints(premiumField, 2, lastPosition + 3);
            GridPane.setConstraints(comboBoxUnderwriters, 2, lastPosition + 6);
            GridPane.setConstraints(printButton, 2, lastPosition + 12);
        });

        addAgrButton.setOnAction(e -> {
            lastPosition = agreement.addAgreement(requirementInput.getText(), grid, lastPosition, lastBox);
            //List<String> agreementList = agreement.getAgreementList(requirementInput.getText());
            GridPane.setConstraints(requirementInput, 2, lastPosition + 2);
            GridPane.setConstraints(addReqButton, 1, lastPosition + 2);
            GridPane.setConstraints(addAgrButton, 0, lastPosition + 2);
            GridPane.setConstraints(premiumLabel, 1, lastPosition + 3);
            GridPane.setConstraints(premiumField, 2, lastPosition + 3);
            GridPane.setConstraints(comboBoxUnderwriters, 2, lastPosition + 6);
            GridPane.setConstraints(printButton, 2, lastPosition + 12);
        });


        printButton.setOnAction(e -> {
            EXCEL_COPY.generateEXCEL(homeInput.getText(), contentInput.getText(), brokerInput.getText(), nameInput.getText(),
                    vatInput.getText(), emailInput.getText(), addressInput.getText(), postalCodeInput.getText(), comboBoxResidenceType,
                    descriptionInput.getText(),
                    box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15, box16, box17, box18, box19, box20,
                    box21, box22, box23, box24, box25, box26, box27, box28, box29, box30,
                    buildingField5.getText(), buildingField12.getText(),
                    contentField5.getText(), contentField12.getText(),
                    sumField5.getText(), sumField12.getText(), sumField13.getText(), sumField14.getText(), sumField15.getText(),
                    comboBoxEarthquake, deductField1.getText(), deductField2.getText(), deductField3.getText(), deductField4.getText(),
                    underinsuranceProtection.getText(), theftMeasures.getText(), premiumField.getText(), comboBoxUnderwriters,
                    agreement.getAgreementList(), requirement.getRequirementList()
            );
        });



        grid.getChildren().addAll(imageView, brokerLabel, brokerInput, nameLabel, nameInput, vatLabel, vatInput,
                emailLabel, emailInput, addressLabel, addressInput, postalCodeLabel, postalCodeInput, residenceTypeLabel,
                comboBoxResidenceType, comboBoxUnderwriters, descriptionLabel, descriptionInput, homeLabel, homeInput,
                contentLabel, contentInput, comboBoxPlans, buildingLabelCover, contentLabelCover, sumLabelCover,
                box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15, box16,
                box17, box18, box19, box20, box21, box22, box23, box24, box25, box26, box27, box28, box29, box30,
                deductiblelabel, deductField1, deductField2, deductField3, deductField4,
                specialAgreementsLabel, underinsuranceProtection, conditionsLabel, theftMeasures,
                buildingField1, buildingField2, buildingField3, buildingField4, buildingField5, buildingField6, buildingField7,
                buildingField8, buildingField9, buildingField10, buildingField11, buildingField12, buildingField13, buildingField14,
                buildingField15,
                contentField1, contentField2, contentField3, contentField4, contentField5, contentField6, contentField7,
                contentField8, contentField9, contentField10, contentField11, contentField12, contentField13, contentField14,
                contentField15,
                sumField1, sumField2, sumField3, sumField4, sumField5, sumField6, sumField7, sumField8, sumField9, sumField10,
                sumField11, sumField12, sumField13, sumField14, sumField15,
                horizontalLine, submitButton, comboBoxEarthquake, generalExclusionsLabel, addReqButton, addAgrButton,
                requirementInput, printButton, premiumLabel, premiumField);


        // Create Scene
        Scene scene = new Scene(scrollPane, 1200, 800);

        window.setScene(scene);
        window.show();

    }



}








