package Validator;

import domain.Cliente;
import exceptions.ValidationException;

public class UserValidation {

    public UserValidation() {
    }

    public static void VerifyModel(final Cliente cliente) throws ValidationException {
        if (stringisBlank(cliente.getNome()))
            throw new ValidationException("Informe um nome valido!");

        if (cliente.getNome().length() <=1 )
            throw new ValidationException("O nome precisa ter mais de 1 caracter");

        if (stringisBlank(cliente.getCpf()))
            throw new ValidationException("Informe um CPF válido!");

        if (!isValidCpfFormat(cliente.getCpf()))
            throw new ValidationException("O CPF deve estar no formato 000.000.000-00");
    }

    private static boolean stringisBlank(final String value) {
        return value == null || value.isBlank();
    }
    private static boolean isValidCpfFormat(String cpf) {
        return cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
    }
}
