import exception.WrongConfirmPasswordException;
import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        try {
            receivingParam("Sky_pro", "Number1", "Number2");
        } catch (WrongLoginException e) {
            System.out.println("Логин содержит недопустимые символы или его длина больше 20 символов");
        } catch (WrongPasswordException e) {
            System.out.println("Пароль содержит недопустимые символы или его длина больше 20 символов");
        } catch (WrongConfirmPasswordException e) {
            System.out.println("Не корректное подтверждение пароля");
        } finally {
            System.out.println("Проверка завершена!");
        }
    }

    public static void receivingParam(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException, WrongConfirmPasswordException {
        if (!(login.matches("\\w+") && (login.length() < 20))) {
            throw new WrongLoginException();
        }
        if (!(password.matches("\\w+") && (password.length() < 20))) {
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongConfirmPasswordException();
        }
    }
}

