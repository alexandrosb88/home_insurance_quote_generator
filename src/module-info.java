module Main {
        requires javafx.controls;
        requires javafx.fxml;

        opens Home_Insurance_Quote_Generator to javafx.fxml;


        exports Home_Insurance_Quote_Generator;

    }
