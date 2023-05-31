import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        try {
            receivingParam("Sky_pro", "Number1", "Number2");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка завершена!");
        }
    }

    public static void receivingParam(String login, String password, String confirmPassword) {
        if (!(login.matches("\\w+") && (login.length() < 20))) {
            throw new WrongLoginException("Логин содержит недопустимые символы или его длина больше 20 символов");
        }
        if (!(password.matches("\\w+") && (password.length() < 20))) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы или его длина больше 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Не корректное подтверждение пароля");
        }
    }
}

