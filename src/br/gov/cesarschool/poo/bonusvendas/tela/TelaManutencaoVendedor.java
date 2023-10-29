package br.gov.cesarschool.poo.bonusvendas.tela;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;
import br.gov.cesarschool.poo.bonusvendas.negocio.ResultadoInclusaoVendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaManutencaoVendedor extends JFrame {
  
    // 1. Create a mediator attribute of type VendedorMediator
    // Initialize it with the Singleton instance.
    private VendedorMediator mediator = VendedorMediator.getInstance();

    // Fields on the screen
    private JTextField txtCPF;
    private JTextField txtFullName;
    private JRadioButton rbMale, rbFemale;
    private JTextField txtDateOfBirth;
    private JTextField txtIncome;
    // ... (other fields to be added)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaManutencaoVendedor frame = new TelaManutencaoVendedor();
            frame.setVisible(true);
        });
    }
    
    public TelaManutencaoVendedor() {
        setTitle("Tela Manutenção Vendedor");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize components and add them to JFrame
        initializeComponents();  // This line was missing
    }

    private void initializeComponents() {
        txtCPF = new JTextField(15);
        txtFullName = new JTextField(30);
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        txtDateOfBirth = new JTextField(10);
        txtIncome = new JTextField(10);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        
        add(new JLabel("CPF:"));
        add(txtCPF);
        add(new JLabel("Full Name:"));
        add(txtFullName);
        add(new JLabel("Gender:"));
        add(rbMale);
        add(rbFemale);
        add(new JLabel("Date of Birth:"));
        add(txtDateOfBirth);
        add(new JLabel("Income:"));
        add(txtIncome);
        
        // ... (Add other components)
        
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new SaveButtonHandler());
        add(btnSave);
    }

    // Event handler for Save button
    private class SaveButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	JButton btnSave = new JButton("Save");
            btnSave.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		if (!validateInput()) {
                        return;
                    }
            	    // Collect data from Vendedor fields
            	    String cpf = txtCPF.getText();
            	    String nomeCompleto = txtFullName.getText();
            	    Sexo sexo = rbMale.isSelected() ? Sexo.MASCULINO : Sexo.FEMININO;
            	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            	    String dateText = txtDateOfBirth.getText();
            	    LocalDate dataNascimento = LocalDate.parse(dateText, formatter);
            	    String incomeText = txtIncome.getText();
            	    double renda = Double.parseDouble(incomeText);
            	    
            	    // Collect data from Endereco fields
            	    JTextComponent txtLogradouro = null;
    				String logradouro = txtLogradouro.getText();
            	    JTextComponent txtNumero = null;
    				int numero = Integer.parseInt(txtNumero.getText());
            	    JTextComponent txtComplemento = null;
    				String complemento = txtComplemento.getText();
            	    JTextComponent txtCEP = null;
    				String cep = txtCEP.getText();
            	    JTextComponent txtCidade = null;
    				String cidade = txtCidade.getText();
    				JComboBox<String> cbEstado = null;
    				String estado = (String) cbEstado.getSelectedItem(); // Assuming it's a JComboBox
            	    String pais = "Brasil"; // Fixed value as mentioned in the specification

            	    // Create an Endereco object
            	    Endereco endereco = new Endereco(logradouro, numero, complemento, cep, cidade, estado, pais);

            	    // Create a Vendedor object
            	    Vendedor newVendedor = new Vendedor(cpf, nomeCompleto, sexo, dataNascimento, renda, endereco);

            	    // Call the mediator to include or alter the Vendedor
            	    VendedorMediator mediator = VendedorMediator.getInstance();
            	    String result;
            	    Vendedor existingVendedor = mediator.buscar(newVendedor.getCPF());
            	    if (existingVendedor == null) {
            	        ResultadoInclusaoVendedor resultadoInclusao = mediator.incluir(newVendedor);
            	        result = resultadoInclusao.getMensagemErroValidacao();
            	    } else {
            	        result = mediator.alterar(newVendedor);
            	    }

            	    // Check the result
            	    if (result == null) {
            	        JOptionPane.showMessageDialog(null, "Operation Successful!");
            	    } else {
            	        JOptionPane.showMessageDialog(null, "Error: " + result);
            	    }
            	}

            });
            add(btnSave);        }
    }
    
    // Helper methods for validation, data conversion, etc.
    private boolean validateInput() {
        // Check if CPF is empty
        if (txtCPF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF cannot be empty!");
            return false;
        }
        
        // Check if full name is empty
        if (txtFullName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Full name cannot be empty!");
            return false;
        }
        
        // Check if gender is selected
        if (!rbMale.isSelected() && !rbFemale.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select a gender!");
            return false;
        }
        
        // Check if date of birth is empty
        if (txtDateOfBirth.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Date of Birth cannot be empty!");
            return false;
        }
        
        // Check if income is empty or invalid
        try {
            Double.parseDouble(txtIncome.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid income value!");
            return false;
        }
        
        // Add additional validations as needed
        
        return true;
    }

    // ... (other functionalities)
}
