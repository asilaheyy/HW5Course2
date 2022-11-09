

public class Main {
    public static void main(String[] args) {
        System.out.println(checkData("K", "l", "l"));

    }

    public static boolean checkData(String login, String password, String confirmPassword) {
        try {
            return Data.checkData(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

}

