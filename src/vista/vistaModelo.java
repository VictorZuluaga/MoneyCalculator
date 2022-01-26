
package vista;
import controlador.moneyCalculator;
import modelo.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class vistaModelo extends JFrame{
    private final JPanel j1;
    private final JButton convertir;
    private final JLabel l1;
    private final JLabel l2;
    private final JLabel l3;
    private JTextField t1;
    private JTextField t2;
    private JComboBox cb1;
    private JComboBox cb2;
    private Float conversion = 0.0f;
    
    public vistaModelo(){
        
        ArrayList<String> s2 = listaDivisas.lista();
        String[] s1 = new String[s2.size()];
        s1 = s2.toArray(s1);
        
        
        this.setSize(600,300);
        this.setTitle("MoneyCalculator");
        this.setLocationRelativeTo(null);
        j1 = new JPanel();
        this.getContentPane().add(j1);
        
        
        j1.setLayout(new GridLayout(2,8));
        
        l1 = new JLabel("Divisa de entrada");
        j1.add(l1);
        
        
        cb1 = new JComboBox(s1);
        j1.add(cb1);
        
        l2 = new JLabel("Cantidad");
        j1.add(l2);
        
        t1 = new JTextField();
        j1.add(t1);
        
        
        l3 = new JLabel("Divisa de salida");
        j1.add(l3);
        
        cb2 = new JComboBox(s1);
        j1.add(cb2);
        
        t2 = new JTextField();
        t2.setEditable(false);
        t2.setText("0");
        j1.add(t2);
        
        this.convertir = new JButton("Convertir!");
        j1.add(this.convertir);
        
        convertir.addActionListener((ActionEvent e) -> {
            moneyCalculator.ejecucion((String)cb1.getSelectedItem(),
                    (String)cb2.getSelectedItem(),
                    Float.parseFloat(t1.getText()),
                    vistaModelo.this);
            t2.setText(vistaModelo.this.conversion+"");
        });
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void setConversion(Float new_conversion){
        this.conversion = new_conversion;
    }
}
