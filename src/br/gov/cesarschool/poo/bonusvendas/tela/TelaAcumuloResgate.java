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
import javax.swing.JComboBox;
import br.gov.cesarschool.poo.bonusvendas.mediator.AcumuloResgateMediator;

public class TelaAcumuloResgate extends JFrame {

    private JPanel contentPane;
    private JTextField txtNumeroDaCaixa;
    private JRadioButton rbOperacaoAcumular;
    private JRadioButton rbOperacaoResgatar;
    private JButton btnBuscar;
    private JTextField txtSaldoAtual;
    private JComboBox<String> cmbTipoResgate;
    private JTextField txtValor;
    private JButton btnAcumularResgatar;
    private JButton btnVoltar;
    private AcumuloResgateMediator mediator = AcumuloResgateMediator.getInstance();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaAcumuloResgate frame = new TelaAcumuloResgate();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaAcumuloResgate() {
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtNumeroDaCaixa = new JTextField();
        txtNumeroDaCaixa.setBounds(120, 20, 150, 20);
        contentPane.add(txtNumeroDaCaixa);

        rbOperacaoAcumular = new JRadioButton("Acumular");
        rbOperacaoAcumular.setBounds(20, 50, 100, 20);
        contentPane.add(rbOperacaoAcumular);

        rbOperacaoResgatar = new JRadioButton("Resgatar");
        rbOperacaoResgatar.setBounds(120, 50, 100, 20);
        contentPane.add(rbOperacaoResgatar);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbOperacaoAcumular);
        buttonGroup.add(rbOperacaoResgatar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(280, 20, 100, 30);
        contentPane.add(btnBuscar);

        JLabel lblSaldoAtual = new JLabel("Saldo Atual:");
        lblSaldoAtual.setBounds(20, 100, 100, 20);
        contentPane.add(lblSaldoAtual);

        txtSaldoAtual = new JTextField();
        txtSaldoAtual.setBounds(120, 100, 150, 20);
        contentPane.add(txtSaldoAtual);

        JLabel lblTipoResgate = new JLabel("Tipo de Resgate:");
        lblTipoResgate.setBounds(20, 140, 100, 20);
        contentPane.add(lblTipoResgate);

        cmbTipoResgate = new JComboBox<String>();
        cmbTipoResgate.addItem("Opção 1");
        cmbTipoResgate.addItem("Opção 2");
        cmbTipoResgate.setBounds(120, 140, 150, 20);
        contentPane.add(cmbTipoResgate);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(20, 180, 100, 20);
        contentPane.add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(120, 180, 150, 20);
        contentPane.add(txtValor);

        btnAcumularResgatar = new JButton("Acumular/Resgatar");
        btnAcumularResgatar.setBounds(120, 220, 150, 30);
        contentPane.add(btnAcumularResgatar);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(280, 220, 100, 30);
        contentPane.add(btnVoltar);

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnAcumularResgatar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
