package cajero;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Operaciones extends JFrame{
    JTextField sup;
    JTextField precio;
    JButton recibo,agregar,reiniciar;
    JPanel izq, der,inter; 
    double resultado;
    boolean rein=true;
    String opcoperacion;
       
    public Operaciones(){
        
        super();
	setSize(280, 300);
        //setLocation(0,0);
	setResizable(false);
        setTitle("Cajero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
        JPanel panelsup = (JPanel) this.getContentPane();
		panelsup.setLayout(new BorderLayout());
                
               sup = new JTextField(" ", 35);
		sup.setFont(new Font("Century Gothic", Font.BOLD, 20));
                //superior.setBorder(new EmptyBorder(4, 4, 4, 4));
		sup.setHorizontalAlignment(JTextField.LEFT);
		sup.setEditable(false);
                sup.setForeground(Color.getHSBColor(63,84,85));
		sup.setBackground(Color.white);
                panelsup.add("North", sup);
                
                  izq = new JPanel();
		izq.setLayout(new GridLayout(3, 1));
                
                precio=new JTextField(" ",20);
                precio.setFont(new Font("Century Gothic", Font.BOLD,16));
                precio.setHorizontalAlignment(JTextField.LEFT);
                precio.setForeground(Color.getHSBColor(63,84,85));
		precio.setBackground(Color.white);
                izq.add("North",precio);
            
                //newnum("");
                
                inter=new JPanel();
                izq.add(inter);
                
                recibo= new JButton("Recibo");
                recibo.setForeground(Color.white);
                recibo.setFont(new Font("Century Gothic", Font.BOLD, 18));
                recibo.setBackground(Color.getHSBColor(63,84,85));
                izq.add(recibo);
                
                panelsup.add("Center", izq);
                
                der = new JPanel();
                
		der.setLayout(new GridLayout(2, 1));
		//oper.setBorder(new EmptyBorder(4, 4, 4, 4));
		newoper("Agregar");
                newoper("Reiniciar");
        	panelsup.add("East", der);

		validate();
                setVisible(true);
                
    }
    
      //IGUAL Y FALTA EL NEW NUM
    private void newoper(String opcoperacion) {
		JButton bot2 = new JButton(opcoperacion);
		bot2.setForeground(Color.white);
                bot2.setBackground(Color.getHSBColor(63,84,85));
                bot2.setFont(new Font("Century Gothic", Font.BOLD, 18));

		bot2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton bot2 = (JButton) evt.getSource();
				eleoper(bot2.getText());
			}
		});

		der.add(bot2);
	}    
    
    private void numele(String digito) {
		if (sup.getText().equals("0") || rein) {
			sup.setText(digito);
		} else {
			sup.setText(sup.getText() + digito);
		}
		rein= false;
	}
    
    private void eleoper(String tecla) {
		if (tecla.equals("Agregar")) {
			calcularResultado();
		} else if (tecla.equals("Reiniciar")) {
			resultado = 0;
			sup.setText("");
			rein= true;
		} else {
			opcoperacion = tecla;
			if ((resultado > 0) && !rein) {
				calcularResultado();
			} else {
                            resultado = new Double(sup.getText());    
                        }
		}

		rein= true;
	}
    private void calcularResultado() {
		if (opcoperacion.equals("Agregar")) {
			resultado += new Double(sup.getText());
		} 

		sup.setText("" + resultado);
		opcoperacion = "";
	}
    
                
                
}

    