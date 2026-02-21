package services;

/**
 * Interface that allows for delivery of notification messages to
 * terminal output through different platforms.
 *
 * @author Miguel Pinpin
 * @version 1.0
 */

public interface NotificationMedium {

    /**
     * Sends a notification message as requested medium to terminal output.
     *
     * @param message the message to send through the notification platform
     */
    public void send(String message);
}
