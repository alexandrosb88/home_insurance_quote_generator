module Main {
    requires javafx.controls;
    requires javafx.fxml;
    requires kernel;
    requires layout;
    requires io;
    requires forms;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.poi;

    opens Home_Insurance_Quote_Generator to javafx.fxml;

    exports Home_Insurance_Quote_Generator;



    }
