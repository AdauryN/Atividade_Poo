package br.gov.cesarschool.poo.bonusvendas.tela;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import br.gov.cesarschool.poo.bonusvendas.mediator.VendedorMediator;

public class TelaManutencaoVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField txtNomeCompleto;
	private JTextField txtDataNascimento;
	private JTextField txtRenda;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCEP;
	private JTextField txtCidade;
	private VendedorMediator mediator = VendedorMediator.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaManutencaoVendedor frame = new TelaManutencaoVendedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaManutencaoVendedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(20, 20, 80, 20);
		contentPane.add(lblCPF);

		txtCPF = new JTextField();
		txtCPF.setBounds(120, 20, 150, 20);
		contentPane.add(txtCPF);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setBounds(20, 50, 100, 20);
		contentPane.add(lblNomeCompleto);

		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(120, 50, 300, 20);
		contentPane.add(txtNomeCompleto);


		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(120, 220, 100, 30);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(230, 220, 100, 30);
		contentPane.add(btnAlterar);

		JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(120, 80, 100, 20);
		buttonGroup.add(rbMasculino);
		contentPane.add(rbMasculino);

		JRadioButton rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(220, 80, 100, 20);
		buttonGroup.add(rbFeminino);
		contentPane.add(rbFeminino);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = txtCPF.getText();
				String nomeCompleto = txtNomeCompleto.getText();
				mediator.cadastrarVendedor(cpf, nomeCompleto);
			}
		});

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
