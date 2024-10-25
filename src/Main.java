import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Home Work exceptions");

        try {
            inputDataUser("kasablanka","BeladonnA2024","BeladonnA2024");
            System.out.println("Всё ок ");
        }catch (WrongPasswordExceptions|WrongLoginExceptions e){
            System.out.println("Проверьте данные");
        }

    }

    public static void inputDataUser(String login, String password, String confirmPassword) throws WrongLoginExceptions, WrongPasswordExceptions {
        String regexLogin = "^[a-z0-9_]{0,20}$";
        Pattern patternLogin = Pattern.compile(regexLogin);
        Matcher matcherLogin = patternLogin.matcher(login);

        String regexPassword = "^[a-zA-Z0-9_]{0,20}$";
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(password);

        if (!matcherLogin.matches()) {
            throw new WrongLoginExceptions();
        }
        if (!matcherPassword.matches()) {
            throw new WrongPasswordExceptions();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordExceptions();
        }

    }
}