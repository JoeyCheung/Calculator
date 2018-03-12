import javax.script.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CalculatorGUI extends JFrame {

	JFrame jframe = new JFrame("Calculator");
	JTextArea textArea = new JTextArea(2,10);
	private JButton zero = new JButton("0");
	private JButton one = new JButton("1");
	private JButton two = new JButton("2");
	private JButton three = new JButton("3");
	private JButton four = new JButton("4");
	private JButton five = new JButton("5");
	private JButton six = new JButton("6");
	private JButton seven = new JButton("7");
	private JButton eight = new JButton("8");
	private JButton nine = new JButton("9");
	private JButton add = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mult = new JButton("*");
	private JButton div = new JButton("/");
	private JButton dot = new JButton(".");
	private JButton tau = new JButton("\u03C4");
	private JButton pi = new JButton("\u03C0");
	private JButton e = new JButton("\u00E9");
	private JButton C = new JButton("C");
	private JButton equals = new JButton("=");
	
	public void initialize() {
		JPanel panel = new JPanel();
		jframe.setSize(350,450);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(panel);
		panel.setBackground(Color.black);
		panel.add(textArea);
		panel.add(getButtons());
		textArea.setBorder(BorderFactory.createLineBorder(Color.red));
		textArea.setFont(new Font("arial",Font.BOLD,33));
		textArea.setForeground(Color.black);
		textArea.setLineWrap(true);
		jframe.setVisible(true);
	}
	
	protected JComponent getButtons() {
		JPanel panel = new JPanel(new GridLayout(5,4));
		handler handler = new handler();
		zero.setPreferredSize(new Dimension(73,60));
		zero.addActionListener(handler);
		one.addActionListener(handler);
		two.addActionListener(handler);
		three.addActionListener(handler);
		four.addActionListener(handler);
		five.addActionListener(handler);
		six.addActionListener(handler);
		seven.addActionListener(handler);
		eight.addActionListener(handler);
		nine.addActionListener(handler);
		add.addActionListener(handler);
		sub.addActionListener(handler);
		mult.addActionListener(handler);
		div.addActionListener(handler);
		dot.addActionListener(handler);
		tau.addActionListener(handler);
		pi.addActionListener(handler);
		e.addActionListener(handler);
		C.addActionListener(handler);
		equals.addActionListener(handler);
		panel.add(tau);
		panel.add(pi);
		panel.add(e);
		panel.add(add);
		panel.add(seven);
		panel.add(eight);
		panel.add(nine);
		panel.add(sub);
		panel.add(four);
		panel.add(five);
		panel.add(six);
		panel.add(mult);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(div);
		panel.add(C);
		panel.add(zero);
		panel.add(dot);
		panel.add(equals);
		return panel;
	}
	
	private class handler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
		
			String cmd = e.getActionCommand();
			if (cmd.equals("+")) {textArea.append("+");}
			else if (cmd.equals("-")) {textArea.append("-");}
			else if (cmd.equals("*")) {textArea.append("*");}
			else if (cmd.equals("/")) {textArea.append("/");}
			else if (cmd.equals("0")) {textArea.append("0");}
			else if (cmd.equals("1")) {textArea.append("1");}
			else if (cmd.equals("2")) {textArea.append("2");}
			else if (cmd.equals("3")) {textArea.append("3");}
			else if (cmd.equals("4")) {textArea.append("4");}
			else if (cmd.equals("5")) {textArea.append("5");}
			else if (cmd.equals("6")) {textArea.append("6");}
			else if (cmd.equals("7")) {textArea.append("7");}
			else if (cmd.equals("8")) {textArea.append("8");}
			else if (cmd.equals("9")) {textArea.append("9");}
			else if (cmd.equals(".")) {textArea.append(".");}
			else if (cmd.equals("\u03C4")) {textArea.append("6.28");}
			else if (cmd.equals("\u03C0")) {textArea.append("3.14");}
			else if (cmd.equals("\u00E9")) {textArea.append("2.72");}
			else if (cmd.equals("C")) {textArea.setText("");}
			else if (cmd.equals("=")) {
				ScriptEngineManager mgr = new ScriptEngineManager();
				ScriptEngine engine = mgr.getEngineByName("JavaScript");
				String equation = textArea.getText();
				try {
					Object answer = engine.eval(equation);
					if(answer.equals((Object)(Double.POSITIVE_INFINITY))){
						throw new ArithmeticException();
					}
					textArea.setText("");
					textArea.append("" + answer);
				} catch (ScriptException e1) {
					e1.printStackTrace();
				} catch (ArithmeticException e2) {
					JOptionPane.showMessageDialog(null, "ERROR: Cannot divide by 0");
					textArea.setText("");
				}
			}
		}
	}
}
