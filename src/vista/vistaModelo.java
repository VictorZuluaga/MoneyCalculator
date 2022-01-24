
package vista;
import controlador.moneyCalculator;
import modelo.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class vistaModelo extends JFrame{
    private JPanel j1;
    private JButton convertir;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JTextField t1;
    private JTextField t2;
    private JComboBox cb1;
    private JComboBox cb2;
    
    public vistaModelo(){
        //añado una lista para probar el combobox
        ArrayList<String> s2 = listaDivisas.lista();
        String[] s1 = new String[s2.size()];
        s1 = s2.toArray(s1);
        
        //configuraciones inciales tipicas
        this.setSize(600,300);
        this.setTitle("MoneyCalculator");
        this.setLocationRelativeTo(null);
        j1 = new JPanel();
        this.getContentPane().add(j1);
        
        //invocando metodos de inicialización
        j1.setLayout(new GridLayout(2,8));
        
        //label
        l1 = new JLabel("Divisa de entrada");
        j1.add(l1);
        
        //combobox
        cb1 = new JComboBox(s1);
        j1.add(cb1);
        //label2, cantidad
        l2 = new JLabel("Cantidad");
        j1.add(l2);
        //textfield, con la cantidad
        t1 = new JTextField();
        j1.add(t1);
        
        //segunda fila 
        l3 = new JLabel("Divisa de salida");
        j1.add(l3);
        //combobox
        cb2 = new JComboBox(s1);
        j1.add(cb2);
        //textfield, no editable con la salida
        t2 = new JTextField();
        t2.setEditable(false);
        t2.setText("0");
        j1.add(t2);
        //
        //boton
        this.convertir = new JButton("Convertir!");
        j1.add(this.convertir);
        
        convertir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //quizas esta parte deberia de ir en controlador
                float res = moneyCalculator.ejecucion((String)cb1.getSelectedItem(),
                                                      (String)cb2.getSelectedItem(),
                                                       Float.parseFloat(t1.getText()));
                t2.setText(res+"");
            }

        });
        //Operaciones finales
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
