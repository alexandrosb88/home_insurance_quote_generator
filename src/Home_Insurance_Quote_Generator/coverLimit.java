
package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

public class coverLimit {

    public static void setCoverLimit(TextField input1, TextField input2,
                                     CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4,
                                     CheckBox box5, CheckBox box6, CheckBox box7, CheckBox box8, CheckBox box9, CheckBox box10, CheckBox box11,
                                     CheckBox box12, CheckBox box13, CheckBox box14, CheckBox box15,
                                     TextField buildingField1, TextField buildingField2, TextField buildingField3, TextField buildingField4,
                                     TextField buildingField5, TextField buildingField6, TextField buildingField7, TextField buildingField8,
                                     TextField buildingField9, TextField buildingField10, TextField buildingField11, TextField buildingField12,
                                     TextField buildingField13, TextField buildingField14, TextField buildingField15,
                                     TextField contentField1, TextField contentField2, TextField contentField3, TextField contentField4, TextField contentField5,
                                     TextField contentField6, TextField contentField7, TextField contentField8, TextField contentField9, TextField contentField10,
                                     TextField contentField11, TextField contentField12, TextField contentField13, TextField contentField14, TextField contentField15,
                                     TextField sumField1, TextField sumField2, TextField sumField3, TextField sumField4, TextField sumField5, TextField sumField6,
                                     TextField sumField7, TextField sumField8, TextField sumField9, TextField sumField10, TextField sumField11, TextField sumField12,
                                     TextField sumField13, TextField sumField14, TextField sumField15) {

        int homeCapital = Integer.parseInt(input1.getText());
        int contentCapital = Integer.parseInt(input2.getText());
        int sumCapital = homeCapital + contentCapital;

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String formattedHomeCapital = numberFormat.format(homeCapital);
        String formattedContentCapital = numberFormat.format(contentCapital);
        String formattedSumCapital = numberFormat.format(sumCapital);

        String shortCircuitPath1 = "C:\\Users\\Sonic\\IdeaProjects\\home_insurance_quote_generator\\src\\Home_Insurance_Quote_Generator\\configuration_files\\short_circuit_building_config.txt";
        String shortCircuitPath2 = "C:\\Users\\Sonic\\IdeaProjects\\home_insurance_quote_generator\\src\\Home_Insurance_Quote_Generator\\configuration_files\\short_circuit_content_config";
        String allRiskPath = "C:\\Users\\Sonic\\IdeaProjects\\home_insurance_quote_generator\\src\\Home_Insurance_Quote_Generator\\configuration_files\\all_risk_config.txt";




        // Flexa

        if (box1.isSelected()) {
            buildingField1.setText(formattedHomeCapital);
            contentField1.setText(formattedContentCapital);
            sumField1.setText(formattedSumCapital);
        }

        if (box2.isSelected()) {
            buildingField2.setText(formattedHomeCapital);
            contentField2.setText(formattedContentCapital);
            sumField2.setText(formattedSumCapital);
        }

        if (box3.isSelected()) {
            buildingField3.setText(formattedHomeCapital);
            contentField3.setText(formattedContentCapital);
            sumField3.setText(formattedSumCapital);
        }

        if (box4.isSelected()) {
            buildingField4.setText(formattedHomeCapital);
            contentField4.setText(formattedContentCapital);
            sumField4.setText(formattedSumCapital);
        }

        
        // Firefighting & debris removal

        if (box5.isSelected()) {

            double bfield5Value = homeCapital * 0.05;
            double cfield5Value = contentCapital * 0.05;
            double sfield5Value = bfield5Value + cfield5Value;

            buildingField5.setText(numberFormat.format(bfield5Value));
            contentField5.setText(numberFormat.format(cfield5Value));
            sumField5.setText(numberFormat.format(sfield5Value));

        }

        // Weather conditions

        if (box6.isSelected()) {
            buildingField6.setText(formattedHomeCapital);
            contentField6.setText(formattedContentCapital);
            sumField6.setText(formattedSumCapital);
        }


        // Water damage

        if (box7.isSelected()) {
            buildingField7.setText(formattedHomeCapital);
            contentField7.setText(formattedContentCapital);
            sumField7.setText(formattedSumCapital);
        }


        // Earthquake

        if (box8.isSelected()) {
            buildingField8.setText(formattedHomeCapital);
            contentField8.setText(formattedContentCapital);
            sumField8.setText(formattedSumCapital);
        }

        // Terrorist attacks

        if (box9.isSelected()) {
            buildingField9.setText(formattedHomeCapital);
            contentField9.setText(formattedContentCapital);
            sumField9.setText(formattedSumCapital);
        }

        
        // Malicious acts

        if (box10.isSelected()) {
            buildingField10.setText(formattedHomeCapital);
            contentField10.setText(formattedContentCapital);
            sumField10.setText(formattedSumCapital);
        }

        
        // Theft of content

        if (box11.isSelected() && contentCapital > 0) {
            buildingField11.setText("-");
            contentField11.setText(formattedContentCapital);
            sumField11.setText(formattedContentCapital);
        }

        else if (box11.isSelected() && contentCapital <= 0) {
            box11.setSelected(false);
        }


        // Short-circuit

        if (box12.isSelected()) {

            double bfield12Value = 0;
            double cfield12Value = 0;
            double sfield12Value;

            if (homeCapital > 0) {

                configurationFile.readConfigFile(shortCircuitPath1);

                bfield12Value = 0;

                for (configurationFile.Range range : configurationFile.configData) {

                    if (homeCapital > range.min && homeCapital <= range.max) {
                        bfield12Value = range.value;

                    }
                }

                buildingField12.setText(numberFormat.format(bfield12Value));

            }

            else {
                bfield12Value = 0;
                buildingField12.setText(numberFormat.format(bfield12Value));
            }


            if (contentCapital > 0) {

                configurationFile.readConfigFile(shortCircuitPath2);

                cfield12Value = 0;

                for (configurationFile.Range range : configurationFile.configData) {

                    if (contentCapital > range.min && contentCapital <= range.max) {
                        cfield12Value = range.value;

                    }
                }

                contentField12.setText(numberFormat.format(cfield12Value));
            }

            else {
                cfield12Value = 0;
                contentField12.setText(numberFormat.format(cfield12Value));
            }

            sfield12Value = bfield12Value + cfield12Value;

            sumField12.setText(numberFormat.format(sfield12Value));

        }
        


        // Third-party liability

        double sfield13Value = 0;

        if (box13.isSelected()) {


            if (sumCapital <= 150000) {
                sfield13Value = sumCapital * 0.2;
                buildingField13.setText("-");
                contentField13.setText("-");

            }

            if (sumCapital > 150000 && sumCapital <= 800000) {
                sfield13Value = (15000 + (sumCapital * 0.1));
                buildingField13.setText("-");
                contentField13.setText("-");

            }

            if (sumCapital > 800000) {
                sfield13Value = 100000;
                buildingField13.setText("-");
                contentField13.setText("-");
            }

            sumField13.setText(numberFormat.format(sfield13Value));

        }


        // Legal expenses

        if (box14.isSelected()) {
            buildingField14.setText("-");
            contentField14.setText("-");
            sumField14.setText("1,000");
        }


        // All risk

        if (box15.isSelected()) {

            Home_Insurance_Quote_Generator.configurationFile.readConfigFile(allRiskPath);

            double sfield15Value = 0;


            for (configurationFile.Range range : configurationFile.configData) {

                if (sumCapital > range.min && sumCapital <= range.max) {
                    sfield15Value = range.value;
                }
            }

            buildingField15.setText("-");
            contentField15.setText("-");
            sumField15.setText(numberFormat.format(sfield15Value));
        }

    }

    

}

