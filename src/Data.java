import java.util.Objects;

public class Data {


    private static final String INVALID_LENGTH = "Длина символов от 1-20";
    private static final String INVALID_SYMBOL = "Строка может состоять из латинских букв, цифр и нижних подчеркиваний";
    private static final String PASSWORDS_NOT_MATCH = "Пароли не совпадают";

    public static boolean checkData(String login, String password, String passwordConfirmation) {

        if (isLengthNot(login, 1, 20)) { //проверка на длину
            throw new WrongLoginException(INVALID_LENGTH);
        }
        if (isSymbolNot(login)) { //проверка на символы
            throw new WrongLoginException(INVALID_SYMBOL);
        }
        if (isLengthNot(password, 1, 20)) {
            throw new WrongPasswordException(INVALID_LENGTH);
        }
        if (isSymbolNot(password)) {
            throw new WrongPasswordException(INVALID_SYMBOL);
        }
        if (!Objects.equals(password, passwordConfirmation)) { //проверка на идентичность
            throw new WrongPasswordException(PASSWORDS_NOT_MATCH);
        }
        return true;
    }

    private static boolean isLengthNot(String value, int min, int max) {
        if (value == null) {//если строка не подходит по параметрам
            return true;
        }
        int length = value.length();//получаем длину строки
        return length < min || length > max;//в зависимости от того, выходит или нет за границы возвращаем true false
    }


    public static boolean isValid(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.matches("^[a-zA-Z0-9_]{1,20}$");
    }

    private static boolean isSymbolNot(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        for (char c : value.toCharArray()) {//перебор каждого символа строки
            boolean symbolMatches = (c >= 'a' && c <= 'z')//символ валидный если лежит в этих границах
                    || (c >= 'A' && c <= 'Z')
                    || (Character.isDigit(c))//валидный если является цифрой
                    || (c == '_');//являтся знаком подчеркивания
            if (!symbolMatches) {//если символ не подходит возвращаем true ==не все символы в строке валидны
                return true;
            }
        }
        return false;
    }

}





