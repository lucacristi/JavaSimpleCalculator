import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EnhancedController {
    private double value;
    private EnhancedView viewCalculator;
    private String operation;

    public EnhancedController() {
        value = 0;
        viewCalculator = new EnhancedView();
        handleEvents();
    }

    public EnhancedView getViewCalculator() {
        return viewCalculator;
    }

    private void handleEvents() {
        //Number buttons
        viewCalculator.getA0Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "0");
        });
        viewCalculator.getA1Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "1");
        });

        viewCalculator.getA2Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "2");
        });

        viewCalculator.getA3Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "3");
        });

        viewCalculator.getA4Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "4");
        });

        viewCalculator.getA5Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "5");
        });

        viewCalculator.getA6Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "6");
        });

        viewCalculator.getA7Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "7");
        });

        viewCalculator.getA8Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "8");
        });

        viewCalculator.getA9Button().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + "9");
        });



        //First Row Buttons
        viewCalculator.getModuloButton().addActionListener(e -> {
                operation = "%";
        });

        viewCalculator.getCEButton().addActionListener(e -> {
            viewCalculator.getTextFieldResult().setText("");
        });

        viewCalculator.getCButton().addActionListener(e -> {
            viewCalculator.getTextFieldResult().setText("");
            value = 0;
        });

        viewCalculator.getBackspaceButton().addActionListener(e -> {
            String actualString = viewCalculator.getTextFieldResult().getText();
            String resultedString = actualString.substring(0, actualString.length() - 1);
            viewCalculator.getTextFieldResult().setText(resultedString);
        });



        //Second Row Buttons
        viewCalculator.getA1XButton().addActionListener(e->{
            operation = "1/x";
        });

        viewCalculator.getX2Button().addActionListener(e->{
            operation = "x^2";
        });

        viewCalculator.getSqrtXButton().addActionListener(e->{
            operation = "sqrt";
        });

        viewCalculator.getDivideButton().addActionListener(e -> {
            try {
                value = getNumber(viewCalculator.getTextFieldResult());
                viewCalculator.getTextFieldResult().setText("");
                operation = "/";
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        viewCalculator.getAddButton().addActionListener(e -> {

            try {
                value = getNumber(viewCalculator.getTextFieldResult());
                viewCalculator.getTextFieldResult().setText("");
                operation = "+";
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        viewCalculator.getMinusButton().addActionListener(e -> {
            try {
                value = getNumber(viewCalculator.getTextFieldResult());
                viewCalculator.getTextFieldResult().setText("");
                operation = "-";
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        viewCalculator.getMultiplyButton().addActionListener(e -> {
            try {
                value = getNumber(viewCalculator.getTextFieldResult());
                viewCalculator.getTextFieldResult().setText("");
                operation = "*";
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });



        viewCalculator.getDotButton().addActionListener(e->{
            String actualString = viewCalculator.getTextFieldResult().getText();
            viewCalculator.getTextFieldResult().setText(actualString + ".");
        });

        viewCalculator.getChangeSingButton().addActionListener(e->{
            String actualString = viewCalculator.getTextFieldResult().getText();
            if(actualString.charAt(0)=='-') {
                viewCalculator.getTextFieldResult().setText(actualString.substring(1));
            }
            else{
                viewCalculator.getTextFieldResult().setText("-" + actualString);
            }
        });


        viewCalculator.getEqualsButton().addActionListener(e -> {

            try {
                double currentValue = getNumber(viewCalculator.getTextFieldResult());

                switch (operation) {
                    case "+": {
                        value += currentValue;
                        break;
                    }
                    case "-": {
                        value -= currentValue;
                        break;
                    }
                    case "*": {
                        value *= currentValue;
                        break;
                    }
                    case "/": {
                        value /= currentValue;
                        break;
                    }
                    case "%": {
                        value += currentValue/100*value;
                        break;
                    }
                    case "x^2": {
                        value = Math.pow(currentValue,2);
                        break;
                    }
                    case "sqrt": {
                        value = Math.sqrt(currentValue);
                        break;
                    }
                    case "1/x": {
                        if(currentValue == 0){
                            viewCalculator.getTextFieldResult().setText("Cannot divide by zero");
                        }
                        else{
                            value = 1/currentValue;
                            break;
                        }
                    }


                }
                viewCalculator.getTextFieldResult().setText(String.valueOf(value));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public double getNumber(JTextField numberTextField) throws Exception {
        return Double.parseDouble(numberTextField.getText());
    }
}