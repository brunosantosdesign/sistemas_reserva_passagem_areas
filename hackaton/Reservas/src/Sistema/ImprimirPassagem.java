package Sistema;
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
 
public class ImprimirPassagem extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea mensagemLabel;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImprimirPassagem frame = new ImprimirPassagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the frame.
	 */
	public ImprimirPassagem() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 450, 300);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    JButton button = new JButton("Imprimir Passagem:");
	    button.setBounds(126, 27, 165, 23);
	    contentPane.add(button);
	    
	    mensagemLabel = new JTextArea();
	    mensagemLabel.setBounds(126, 66, 165, 133);
	    contentPane.add(mensagemLabel);
 
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Imprimi1();
	        }
	    });
	}
 
	public void Imprimi1() {
	    Voo v1 = new Voo("adc569", 0, 1, 20);
	    
	    String NumVoo = v1.getNumeroVoo();
	    String dest = v1.getDestino();
	    String valor = String.valueOf(v1.realizarPagamento(1));
	    
	    mensagemLabel.setText("Numero do Voo: " + NumVoo + "\nDestino: " + dest + "\nValor: " + valor);	}
	


public void Imprimi() {
    Voo v1 = new Voo("adc569", 0, 1, 20);

    String NumVoo = v1.getNumeroVoo();
    String dest = v1.getDestino();
    double valor = v1.realizarPagamento(1);

    try (Connection conexao = Conexao.obterConexao()) {
        if (conexao != null) {
            // Inserir informações no banco de dados
            String query = "INSERT INTO Reservas (numero_voo, origem, destino, assentos_disponiveis) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conexao.prepareStatement(query)) {
                ps.setString(1, NumVoo);
                ps.setString(2, "Santos"); // Coloque a origem desejada ou ajuste conforme necessário
                ps.setString(3, dest);
                ps.setInt(4, 20); // Coloque o número de assentos disponíveis desejado ou ajuste conforme necessário
                ps.executeUpdate();
            }

            // Exibir mensagem na interface gráfica
            mensagemLabel.setText("Reserva realizada com sucesso e registrada no banco de dados!");
        } else {
            mensagemLabel.setText("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException ex) {
        mensagemLabel.setText("Erro ao realizar a reserva e registrar no banco de dados.");
        ex.printStackTrace();
    }
}
}
