package br.gov.cesarschool.poo.bonusvendas.negocio;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean ehNuloOuBranco(String str) {
        return str == null || str.trim().isEmpty();
    }
}
