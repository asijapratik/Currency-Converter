package swingpractice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Currency_Converter extends JFrame implements  ActionListener{
    
    JLabel val,from,to,res;
    JTextField input,Result;
    JComboBox c1,c2;
    JButton b1,b2;
    Currency_Converter()
    {
        setVisible(true);
        setSize(630,320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Currency_Converter");
        
        val=new JLabel("Input Value");
        add(val);
        val.setBounds(10,30,100,30);
        input=new JTextField(10);        
        add(input);
        input.setBounds(10,61,100,30);
        
        from=new JLabel("Convert From");
        add(from);
        from.setBounds(200,30,180,30);
        c1=new JComboBox();
        add(c1);
        c1.addItem("Select Currency");
        c1.addItem("United States Dollar USD");
        c1.addItem("Euro EUR");
        c1.addItem("Indian Ruppee INR");
        c1.addItem("Australian Dollar AUD");
        c1.addItem("Chinese Yuan");
        c1.addItem("British Pound GBP");
        c1.addItem("Japanese Yen JPY");
        c1.setBounds(200,61,180,30);
        
        to=new JLabel("Convert To");
        add(to);
        to.setBounds(400,30,180,30);
        c2=new JComboBox();
        add(c2);       
        c2.setBounds(400,61,180,30);
        c2.addItem("Select Currency");
        c2.addItem("United States Dollar USD");
        c2.addItem("Euro EUR");
        c2.addItem("Indian Ruppee INR");
        c2.addItem("Australian Dollar AUD");
        c2.addItem("Chinese Yuan");
        c2.addItem("British Pound GBP");
        c2.addItem("Japanese Yen JPY");
        res=new JLabel("Result");
        add(res);
        res.setBounds(120,140,100,30);
        
        Result=new JTextField(20);
        add(Result);
        Result.setBounds(120,171,140,30);
        
        b1=new JButton("Convert");
        add(b1);
        b1.setBounds(350,230,100,30);
        b1.addActionListener(this);
        b2=new JButton("Close");
        add(b2);
        b2.setBounds(460,230,70,30);
        b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2)
            System.exit(0);
        String k=input.getText();
        double in;
        if(k.isEmpty())
            JOptionPane.showMessageDialog(this,"No input.Please enter Something","Error",JOptionPane.ERROR_MESSAGE);
        else
        {
            in=Double.parseDouble(k);
       
        String f=(String)c1.getSelectedItem();
        String t=(String)c2.getSelectedItem();
        
        HashMap<String,Double> m=new HashMap<String,Double>();
        m.put("United States Dollar USD",1.3673);
        m.put("Euro EUR",1.1406);
        m.put("Indian Ruppee INR",99.688);
        m.put("Australian Dollar AUD",1.796);
        m.put("Chinese Yuan",8.8438);
        m.put("British Pound GBP",1.00);
        m.put("Japanese Yen JPY",144.06);
        if(f=="Select Currency"||t=="Select Currency")
            JOptionPane.showMessageDialog(this,"Currency not Selected . Please try again.","Error",JOptionPane.ERROR_MESSAGE);
        else
            Result.setText(String.valueOf(in*(m.get(t)/m.get(f))));
        }
    }
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(()->new Currency_Converter());
    }
}
