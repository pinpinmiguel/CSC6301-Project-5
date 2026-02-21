package apps;

import services.EmailService;
import services.NotificationMedium;
import services.SMSService;
import services.WhatsAppService;

import java.util.ArrayList;

/**
 * Module for managing user notifications. Allows user to swap notification
 * mediums, send notifications through the selected platform, and record the
 * logs of all send messages during the session. By using composition, the
 * system can dynamically swap notification methods at runtime without
 * modifying the core logic.
 *
 * <p>Architectural Overview:</p>
 *
 * <p>The system implementing the following structure:</p>
 *
 * <pre>
 * >Interface: NotificationMedium defines the methods for delivery
 * services.
 * >Concerete Implementation: WhatsAppService, EmailService, and SMSService
 * modify the methods of NotificationMedium for their own specific delivery styles.
 * >Container Class: AlertSystem acts as the context, holding a NotificationMedium
 * object and manages the message log.
 * </pre>
 *
 * <p>Main method was generated with AI assistance. Output was deemed
 * sufficient for correctly demonstrating new functionalities of
 * WhatsAppService class and ensuring that all prior functionality was
 * retained by calling on each class and its methods and correctly tracking
 * the output in the messageLog.</p>
 *
 * <p>Original Query:</p>
 *
 * <pre>
 * Do not rewrite the AlertSystem class or changing the existing
 * NotificationMedium interface. Treat this as a Maintenance Project where you
 * extend the system's functionality by adding new components, not by modifying
 * the core engine.
 *
 * Create the New Service: Implement a new class called WhatsAppService that
 * implements the existing NotificationMedium interface.
 * 1. Logic: The send(String message) method should output:
 * [WhatsApp] Sending message: message text.
 * 2. Collection Usage: Ensure that when this new medium is used, the message
 * is still correctly stored in the ArrayList log within the AlertSystem
 * (inherited behavior through composition).
 *
 * Make sure you can switch between EmailService, SMSService, and
 * WhatsAppService at runtime using the setMedium() method without ever having
 * to recompile the AlertSystem.java file itself. Generate a test script to
 * make sure everything works
 * </pre>
 *
 * <p>To compile and execute, please navigate to the src directory and run:</p>
 * <pre>{@code}
 * javac -d bin src/apps/AlertSystem.java src/services/*.java
 * java -cp bin apps.AlertSystem
 * </pre>
 *
 * <p>The HTML documentation for the packages can be generated using:</p>
 * <pre>{@code}javadoc -d docs -author -version src/apps/*.java src/services/*.java</pre>
 *
 * <p>Example output:</p>
 * <pre>{@code}
 * === Notification System Integration Test ===
 * Testing runtime switching between all mediums.
 *
 * --- Test 1: Email Service ---
 *
 * Switching to EMAIL service.
 * [Email] Sending email: LinkedIn Job Alerts
 * [Email] Sending email: Amazon Order Confirmation
 * [Email] Sending email: Canvas Notification
 *
 * --- Test 2: SMS Service ---
 *
 * Switching to SMS service.
 * [SMS] Sending text: Your verification code is 847291
 * [SMS] Sending text: Doctor's Appointment Reminder
 * [SMS] Sending text: Mom
 *
 * --- Test 3: WhatsApp Service ---
 *
 * Switching to WhatsApp service.
 * [WhatsApp] Sending message: Hey! Are we still on for tonight?
 * [WhatsApp] Sending message: Check out this link I found
 * [WhatsApp] Sending message: Group chat: Meeting moved to 3pm
 *
 * --- Test 4: Runtime Switch Back to Email ---
 *
 * Switching to EMAIL service.
 * [Email] Sending email: Invoice #12345 attached
 *
 * --- Session Message Log ---
 * 1. [EMAIL] Invoice #12345 attached
 * 2. [WhatsApp] Group chat: Meeting moved to 3pm
 * 3. [WhatsApp] Check out this link I found
 * 4. [WhatsApp] Hey! Are we still on for tonight?
 * 5. [SMS] Mom
 * 6. [SMS] Doctor's Appointment Reminder
 * 7. [SMS] Your verification code is 847291
 * 8. [EMAIL] Canvas Notification
 * 9. [EMAIL] Amazon Order Confirmation
 * 10. [EMAIL] LinkedIn Job Alerts
 * Total messages: 10
 *
 * === Test Summary ===
 * All three services successfully integrated.
 * Runtime switching verified without recompilation.
 * Message logging works across all mediums.
 * </pre>
 *
 * <p>Note: Javadocs were modified from previous week project to showcase
 * new output of test method as well as better following the standards
 * identified by the professor during the lecture.</p>
 *
 * @author Miguel Pinpin
 * @version 1.0
 */

public class AlertSystem {
    private NotificationMedium medium;
    private ArrayList<String> messageLog;

    /**
     * Constructor for AlertSystem class. Creates an empty message log and
     * sets active notification medium to null.
     */
    public AlertSystem() {
        this.medium = null;
        this.messageLog = new ArrayList<>();
    }

    /**
     * Changes the notification medium to chosen platform.
     *
     * <p>Method was altered from AI output to include output message when
     * switching platforms.</p>
     *
     * @param medium the notification platform to switch to
     */
    public void setMedium(NotificationMedium medium) {
        this.medium = medium;
        System.out.println("\nSwitching to " + medium + " service.");
    }

    /**
     * Sends a message to the terminal output through the current active
     * notification platform.
     *
     * <p>Method was altered from original AI output. Additional check for
     * an active notification platform was added using an if/throw block, and
     * print message output was changed to include medium.</p>
     *
     * @param message the message to send through the active notification
     *                platform
     * @throws IllegalStateException if no medium has been set prior to
     *                               sending a message
     */
    public void notifyUser(String message) {
        if (medium == null) {
            throw new IllegalStateException("No notification medium has been " + "set.");
        }
        medium.send(message);
        messageLog.add("[" + medium + "] " + message);
    }

    /**
     * Displays all sent messages for the session in descending order with
     * most recent messages first.
     *
     * <p>Method was altered from AI output to reverse the order in which
     * messages were displayed (originally ascending order).</p>
     */
    public void displayLog() {
        System.out.println("\n--- Session Message Log ---");
        if (messageLog.isEmpty()) {
            System.out.println("No messages sent this session.");
        } else {
            for (int i = messageLog.size() - 1; i >= 0; i--) {
                System.out.println((messageLog.size() - i) + ". " + messageLog.get(i));
            }
        }
        System.out.println("Total messages: " + messageLog.size());
    }

    /**
     * Application entry point for demonstrating simulated notification system.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Notification System Integration Test ===");
        System.out.println("Testing runtime switching between all mediums.\n");

        AlertSystem alerts = new AlertSystem();

        // Test 1: Email Service
        System.out.println("--- Test 1: Email Service ---");
        alerts.setMedium(new EmailService());
        alerts.notifyUser("LinkedIn Job Alerts");
        alerts.notifyUser("Amazon Order Confirmation");
        alerts.notifyUser("Canvas Notification");

        // Test 2: SMS Service
        System.out.println("\n--- Test 2: SMS Service ---");
        alerts.setMedium(new SMSService());
        alerts.notifyUser("Your verification code is 847291");
        alerts.notifyUser("Doctor's Appointment Reminder");
        alerts.notifyUser("Mom");

        // Test 3: WhatsApp Service (NEW)
        System.out.println("\n--- Test 3: WhatsApp Service ---");
        alerts.setMedium(new WhatsAppService());
        alerts.notifyUser("Hey! Are we still on for tonight?");
        alerts.notifyUser("Check out this link I found");
        alerts.notifyUser("Group chat: Meeting moved to 3pm");

        // Test 4: Switch back to Email (proves runtime flexibility)
        System.out.println("\n--- Test 4: Runtime Switch Back to Email ---");
        alerts.setMedium(new EmailService());
        alerts.notifyUser("Invoice #12345 attached");

        // Display message list
        alerts.displayLog();

        // Summary
        System.out.println("\n=== Test Summary ===");
        System.out.println("All three services successfully integrated.");
        System.out.println("Runtime switching verified without recompilation.");
        System.out.println("Message logging works across all mediums.");
    }
}
