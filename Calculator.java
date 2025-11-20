import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Simple GUI Calculator Application
public class Calculator extends JFrame implements ActionListener  {
    JTextField t1, t2, result;  
    JButton add, sub, mul, div, sqrt, pow, sin, cos;

    Calculator(){
        setTitle("Calculator");
        setLayout(new GridLayout(5, 2, 5, 5));

        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        add(new JLabel("Number 1:")); 
        add(t1);
        add(new JLabel("Number 2:")); 
        add(t2);
        add(new JLabel("Result:")); 
        add(result);

        add = new JButton("Add"); 
        sub = new JButton("Sub");
        mul = new JButton("Multiplication");
        div = new JButton("Division");
        sqrt = new JButton("Square Root");
        pow = new JButton("Power");
        sin = new JButton("Sin");
        cos = new JButton("Cos");

        JButton[] btns = {add, sub, mul, div, sqrt, pow, sin, cos};
        for (JButton b : btns){
            add(b);
            b.addActionListener(this);
        }

        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        try{
            double n1 = t1.getText().isEmpty()?0:Double.parseDouble(t1.getText());
            double n2 = t2.getText().isEmpty()?0:Double.parseDouble(t2.getText());
            double res = 0;

            if(e.getSource() == add)res = n1+n2;
            else if(e.getSource() == sub)res = n1-n2;
            else if(e.getSource() == mul)res = n1*n2;
            else if(e.getSource() == div)res = n1/n2;
            else if(e.getSource() == sqrt)res = Math.sqrt(n1);
            else if(e.getSource() == pow)res = Math.pow(n1,n2);
            else if(e.getSource() == sin)res = Math.sin(Math.toRadians(n1));
            else if(e.getSource() == cos)res = Math.cos(Math.toRadians(n1));

            result.setText(String.valueOf(res));
        }catch(Exception ex){
            result.setText("Error:");
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}