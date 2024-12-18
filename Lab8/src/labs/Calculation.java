package labs;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.lang.Math;

public class Calculation extends JFrame 
{

    private int factorial(int n) 
    {
        if (n == 0 || n == 1) 
        {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= n; i++) 
        {
            result *= i;
        }
        return result;
    }

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField txtM;

    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    Calculation frame = new Calculation();
                    frame.setVisible(true);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public Calculation() 
    {
        setTitle("Решитель");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 333, 413);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("N");
        lblNewLabel.setBounds(86, 79, 21, 23);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(117, 80, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(117, 110, 86, 20);
        contentPane.add(textField_1);

        txtM = new JTextField();
        txtM.setText("X");
        txtM.setEditable(false);
        txtM.setBounds(86, 110, 21, 20);
        contentPane.add(txtM);
        txtM.setColumns(10);

        Choice choice = new Choice();
        choice.setBounds(117, 182, 86, 20);
        contentPane.add(choice);

        choice.add("1");
        choice.add("2");

        JLabel lblNewLabel_2 = new JLabel("Выбор метода решения");
        lblNewLabel_2.setBounds(107, 156, 182, 20);
        contentPane.add(lblNewLabel_2);

        Button button = new Button("Рассчитать");
        button.setBounds(117, 270, 70, 22);
        contentPane.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(62, 323, 193, 40);
        contentPane.add(textArea);

        choice.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
                int method = Integer.parseInt(choice.getSelectedItem());
                if (method == 1) 
                {
                    txtM.setText("X");
                } 
                else if (method == 2) 
                {
                    txtM.setText("M");
                }
            }
        });

        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    int n = Integer.parseInt(textField.getText());
                    int m = Integer.parseInt(textField_1.getText());
                    int method = Integer.parseInt(choice.getSelectedItem());

                    double result = 0;
                    if (method == 1) 
                    {
                        for (int i = 1; i <= n; i++) 
                        {
                            result += (Math.pow(-m, i)) / factorial(i + 1);
                        }
                    } 
                    else if (method == 2)
                    {
                        for (int i = 1; i <= n; i++) 
                        {
                            for (int j = 1; j <= m; j++) 
                            {
                                double denominator = Math.pow(i, 3) + Math.pow(j, 3);
                                if (denominator != 0) 
                                {
                                    result += Math.pow(i, 2) / denominator;
                                }
                            }
                        }
                    }

                    textArea.setText("Результат: " + result);
                } 
                catch (NumberFormatException ex) 
                {
                    textArea.setText("Ошибка: неверный ввод.");
                }
            }
        });
    }
}
