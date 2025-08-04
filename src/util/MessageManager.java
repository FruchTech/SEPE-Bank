package util;

public class MessageManager {

    public void sendBankHomeMessage() {
        System.out.println("-".repeat(75) + "\n" +
                "Welcome! Please select your desired action!\n" +
                "[R]egister as a new customer\n" +
                "[L]ogin to your account\n" +
                "[E]xit your current session\n" +
                "-".repeat(75));
    }
}
