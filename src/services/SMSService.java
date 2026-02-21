package services;

/**
 * Notification platform that allows for sending messages to terminal output
 * via SMS message medium.
 *
 * @author Miguel Pinpin
 * @version 1.0
 */

public class SMSService implements NotificationMedium {

    /**
     * Sends a message as an SMS to terminal output.
     *
     * @param message the message to send through the SMS platform
     */
    public void send(String message) {
        System.out.println("[SMS] Sending text: " + message);
    }

    /**
     * Overrides the default string method to detail just the medium name.
     *
     * @return string of the SMS platform
     */
    @Override
    public String toString() {
        return "SMS";
    }
}
