import javax.swing.*;
import java.util.stream.DoubleStream;

public class Controller {
    private ViewCalculator viewCalculator;

    public Controller(){
        viewCalculator = new ViewCalculator();
        handleEvents();
    }

    public ViewCalculator getViewCalculator(){
        return viewCalculator;
    }

    private void handleEvents(){
        viewCalculator.getAddButton().addActionListener(e->{
            clearResultTextField();
            try{
                double number1 = getNumber(viewCalculator.getNumber1TextField());
                double number2 = getNumber(viewCalculator.getNumber2TextField());
                viewCalculator.getResultTextField().setText(String.valueOf(number1+number2));
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Not a valid number: " + exception.getMessage(), "INVALID NUMBER", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                clearNumberInputs();
            }
        });

        viewCalculator.getSubstractButton().addActionListener(e->{
            clearResultTextField();
            try{
                double number1 = getNumber(viewCalculator.getNumber1TextField());
                double number2 = getNumber(viewCalculator.getNumber2TextField());
                viewCalculator.getResultTextField().setText(String.valueOf(number1-number2));
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Not a valid number: " + exception.getMessage(), "INVALID NUMBER", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                clearNumberInputs();
            }
        });

        viewCalculator.getMultiplyButton().addActionListener(e->{
            clearResultTextField();
            try{
                double number1 = getNumber(viewCalculator.getNumber1TextField());
                double number2 = getNumber(viewCalculator.getNumber2TextField());
                viewCalculator.getResultTextField().setText(String.valueOf(number1*number2));
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Not a valid number: " + exception.getMessage(), "INVALID NUMBER", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                clearNumberInputs();
            }
        });

        viewCalculator.getDivideButton().addActionListener(e->{
            clearResultTextField();
            try{
                double number1 = getNumber(viewCalculator.getNumber1TextField());
                double number2 = getNumber(viewCalculator.getNumber2TextField());
                viewCalculator.getResultTextField().setText(String.valueOf(number1/number2));
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null, "Not a valid number: " + exception.getMessage(), "INVALID NUMBER", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                clearNumberInputs();
            }
        });
    }

    public double getNumber(JTextField numberTextField) throws Exception{

        return Double.parseDouble(numberTextField.getText());
    }

    public void clearNumberInputs(){
        viewCalculator.getNumber1TextField().setText("");
        viewCalculator.getNumber2TextField().setText("");
    }

    public void clearResultTextField(){
        viewCalculator.getResultTextField().setText("");
    }
}
