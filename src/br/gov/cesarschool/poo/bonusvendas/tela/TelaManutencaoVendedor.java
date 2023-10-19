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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import br.gov.cesarschool.poo.bonusvendas.mediator.VendedorMediator;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import java.time.LocalDate;



public class TelaManutencaoVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField txtNomeCompleto;
	private JTextField txtDataNascimento;
	private JTextField txtRenda;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCEP;
	private JTextField txtCidade;
	private JComboBox<String> cbEstado;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private VendedorMediator mediator = VendedorMediator.getInstance();

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
		setBounds(100, 100, 450, 400);
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

		JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(120, 80, 100, 20);
		buttonGroup.add(rbMasculino);
		contentPane.add(rbMasculino);

		JRadioButton rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(220, 80, 100, 20);
		buttonGroup.add(rbFeminino);
		contentPane.add(rbFeminino);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(20, 110, 100, 20);
		contentPane.add(lblLogradouro);

		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(120, 110, 300, 20);
		contentPane.add(txtLogradouro);

		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(20, 140, 100, 20);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(120, 140, 300, 20);
		contentPane.add(txtNumero);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(20, 170, 100, 20);
		contentPane.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(120, 170, 300, 20);
		contentPane.add(txtComplemento);

		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(20, 200, 100, 20);
		contentPane.add(lblCEP);

		txtCEP = new JTextField();
		txtCEP.setBounds(120, 200, 300, 20);
		contentPane.add(txtCEP);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(20, 230, 100, 20);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(120, 230, 300, 20);
		contentPane.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(20, 260, 100, 20);
		contentPane.add(lblEstado);

		cbEstado = new JComboBox<>(new String[] { "Selecione", "SP", "RJ", "MG", "PR" });
		cbEstado.setBounds(120, 260, 300, 20);
		contentPane.add(cbEstado);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(120, 290, 100, 30);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(230, 290, 100, 30);
		contentPane.add(btnAlterar);

		btnCadastrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String cpf = txtCPF.getText();
		        String nomeCompleto = txtNomeCompleto.getText();
		        Sexo sexo = rbMasculino.isSelected() ? Sexo.MASCULINO : Sexo.FEMININO;
		        LocalDate dataNascimento = LocalDate.parse(txtDataNascimento.getText());
		        double renda = Double.parseDouble(txtRenda.getText());
		        String logradouro = txtLogradouro.getText();
		        int numero = Integer.parseInt(txtNumero.getText());
		        String complemento = txtComplemento.getText();
		        String cep = txtCEP.getText();
		        String cidade = txtCidade.getText();
		        String estado = cbEstado.getSelectedItem().toString();
		        String pais = "Brasil";
		        

		        mediator.cadastrarVendedor(cpf, nomeCompleto, sexo, dataNascimento, renda, logradouro, numero, complemento, cep, cidade, estado, pais);
		    }
		});


		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
