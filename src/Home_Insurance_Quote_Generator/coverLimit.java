package Home_Insurance_Quote_Generator;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

public class coverLimit {

    public static void setCoverLimit(TextField input1, TextField input2, CheckBox box1, CheckBox box2, CheckBox box3, CheckBox box4, CheckBox box5,
                               CheckBox box6, CheckBox box7, TextField bfield1, TextField cfield1, TextField sField1,
                               TextField bfield2, TextField cfield2, TextField sField2, TextField bfield3, TextField cfield3, TextField sField3,
                               TextField bfield4, TextField cfield4, TextField sField4, TextField bfield5, TextField cfield5,
                               TextField sfield5, TextField bfield6, TextField cfield6, TextField sfield6, TextField bfield7, TextField cfield7, TextField sfield7) {

        int homeCapital = Integer.parseInt(input1.getText());
        int contentCapital = Integer.parseInt(input2.getText());
        int sumCapital = homeCapital + contentCapital;

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String formattedHomeCapital = numberFormat.format(homeCapital);
        String formattedContentCapital = numberFormat.format(contentCapital);
        String formattedSumCapital = numberFormat.format(sumCapital);

        // Basic Covers Limit

        if (box1.isSelected()) {
            bfield1.setText(formattedHomeCapital);
            cfield1.setText(formattedContentCapital);
            sField1.setText(formattedSumCapital);
        }

        if (box2.isSelected()) {
            bfield2.setText(formattedHomeCapital);
            cfield2.setText(formattedContentCapital);
            sField2.setText(formattedSumCapital);
        }

        if (box3.isSelected()) {
            bfield3.setText(formattedHomeCapital);
            cfield3.setText(formattedContentCapital);
            sField3.setText(formattedSumCapital);
        }

        if (box4.isSelected()) {
            bfield4.setText("-");
            cfield4.setText(formattedContentCapital);
            sField4.setText(formattedContentCapital);
        }


        // Short Circuit Limit

        if (box5.isSelected()) {

            double bfield5Value = 0;
            double cfield5Value = 0;

            // Short Circuit (building) - configuration file
            for (configurationFile.Range range : configurationFile.configData) {

                if (homeCapital > range.min && homeCapital <= range.max) {
                    bfield5Value = range.value;

                }


                // Short Circuit (content)
                //0 50000 0.03
                if (contentCapital > 0 && contentCapital <= 50000) {
                    cfield5Value = contentCapital * 0.03;
                }
                //50000 500000 0.01
                else if (contentCapital > 50000 && contentCapital <= 500000) {
                    cfield5Value = (1000 + (contentCapital * 0.01));
                }
                //500000 -1 7000
                else if (contentCapital > 500000) {
                    cfield5Value = 7000;
                }

                double sfield5Value = bfield5Value + cfield5Value;


                bfield5.setText(numberFormat.format(bfield5Value));
                cfield5.setText(numberFormat.format(cfield5Value));
                sfield5.setText(numberFormat.format(sfield5Value));
            }
        }

        // All Risk Limit
        if (box7.isSelected()) {

            if (sumCapital <= 250000) {
                bfield7.setText("2500");
                cfield7.setText("2500");
                sfield7.setText("2500");
            }

            if (sumCapital > 250000) {
                bfield7.setText("5000");
                cfield7.setText("5000");
                sfield7.setText("5000");
            }

        }

        // Civil Liability Limit
        if (box6.isSelected()) {

            double sfield6Value = 0; // Πρέπει να γίνει αρχικοποίηση γιατί εάν δεν ταιριάζει σε μια συνθήκη if μπορεί να οδηγήσει σε σφάλματα

            if (sumCapital <= 150000) {
                sfield6Value = sumCapital * 0.2;
                bfield6.setText("-");
                cfield6.setText("-");

            }

            if (sumCapital > 150000 && sumCapital <= 800000) {
                sfield6Value = (15000 + (sumCapital * 0.1));
                bfield6.setText("-");
                cfield6.setText("-");

            }

            if (sumCapital > 800000) {
                sfield6Value = 100000;
                bfield6.setText("-");
                cfield6.setText("-");
            }


            sfield6.setText(numberFormat.format(sfield6Value));
        }


    }

}
