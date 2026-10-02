package br.edu.cs.poo.ac.seguro.mediators;

public class ValidadorCpfCnpj {

    public static boolean ehCpfValido(String cpf) {
        if (cpf == null || cpf.length() != 11 || !StringUtils.temSomenteNumeros(cpf)) {
            return false;
        }
        // primeiro digito verificador: pesos de 10 a 2 nos 9 primeiros numeros
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma = soma + (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        // segundo digito verificador: pesos de 11 a 2 nos 10 primeiros numeros
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma = soma + (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        return digito1 == (cpf.charAt(9) - '0') && digito2 == (cpf.charAt(10) - '0');
    }

    public static boolean ehCnpjValido(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || !StringUtils.temSomenteNumeros(cnpj)) {
            return false;
        }
        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        // primeiro digito verificador
        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma = soma + (cnpj.charAt(i) - '0') * pesos1[i];
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        // segundo digito verificador
        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma = soma + (cnpj.charAt(i) - '0') * pesos2[i];
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        return digito1 == (cnpj.charAt(12) - '0') && digito2 == (cnpj.charAt(13) - '0');
    }
}