import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main { // mplement a MessageProcessor class that uses a StringBuilder to process and format chat messages.
	public static void main(String args[] ) throws Exception {
		Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        MessageProcessor messageProcessor = new MessageProcessor();

        for (int i = 0; i < N; i++) {
            String sender = scanner.nextLine();

            String message = scanner.nextLine();

            messageProcessor.appendMessage(sender, message);
        }

        System.out.println(messageProcessor.getChatLog());
	}
	
	static class MessageProcessor {
        private StringBuilder chatLog;

        public MessageProcessor() {
            chatLog = new StringBuilder();
        }

        public void appendMessage(String sender, String message) {
            chatLog.append(sender).append(": ").append(message).append("\n");
        }

        public String getChatLog() {
            return chatLog.toString();
        }
    }

}