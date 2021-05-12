import javax.swing.*;

public class ViewCalculator extends JFrame {
    private JTextField number1TextField;
    private JTextField number2TextField;
    private JTextField resultTextField;
    private JButton addButton;
    private JButton divideButton;
    private JButton substractButton;
    private JButton multiplyButton;
    private JPanel mainPanel;

    public ViewCalculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public JTextField getNumber1TextField() {
        return number1TextField;
    }

    public JTextField getNumber2TextField() {
        return number2TextField;
    }

    public JTextField getResultTextField() {
        return resultTextField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getSubstractButton() {
        return substractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public void setResultTextField(JTextField resultTextField) {
        this.resultTextField = resultTextField;
    }
}
