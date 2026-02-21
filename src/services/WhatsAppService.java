package services;

/**
 * Notification platform that allows for sending messages to terminal output
 * via WhatsApp medium.
 *
 * @author Miguel Pinpin
 * @version 1.0
 */
public class WhatsAppService implements NotificationMedium {

    /**
     * Sends a message as a WhatsApp message to terminal output.
     *
     * @param message the message to send through the WhatsApp platform
     */
    @Override
    public void send(String message) {
        System.out.println("[WhatsApp] Sending message: " + message);
    }

    /**
     * Overrides the default string method to detail just the medium name.
     *
     * @return string of the WhatsApp platform
     */
    @Override
    public String toString() {
        return "WhatsApp";
    }
}