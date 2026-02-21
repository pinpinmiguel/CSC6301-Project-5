package services;

/**
 * Notification platform that allows for sending messages to terminal output
 * via email medium.
 *
 * @author Miguel Pinpin
 * @version 1.0
 */

public class EmailService implements NotificationMedium {

    /**
     * Sends a message as an email to terminal output.
     *
     * @param message the message to send through the email platform.
     */
    public void send(String message) {
        System.out.println("[Email] Sending email: " + message);
    }

    /**
     * Overrides the default string method to detail just the medium name.
     *
     * @return string of the email platform
     */
    @Override
    public String toString() {
        return "EMAIL";
    }
}
