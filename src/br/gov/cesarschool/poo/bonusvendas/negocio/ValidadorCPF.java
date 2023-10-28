package br.gov.cesarschool.poo.bonusvendas.negocio;

public class ValidadorCPF {

    private ValidadorCPF() {
    }

    public static boolean ehCpfValido(String cpf) {
        cpf = cpf.replaceAll("[.-]", "");
        
        if (cpf.length() != 11 || !cpf.matches("\\d+")) {
            return false;
        }

        for (int j = 0; j < 2; j++) {
            int soma = 0, resto;
            for (int i = 0; i < 9 + j; i++) {
                soma += Integer.parseInt(cpf.charAt(i) + "") * (10 + j - i);
            }
            resto = (soma * 10) % 11;
            if (resto == 10) resto = 0;
            if (resto != Integer.parseInt(cpf.charAt(9 + j) + "")) {
                return false;
            }
        }
        
        return true;
    }
}
