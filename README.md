# Flexible Notification System

A modular notification system built in Java demonstrating the SOLID design principle and Composition over Inheritance. The system simulates sending notifications through multiple platforms (Email, SMS, WhatsApp) with runtime-swappable delivery methods and session logging.

## Overview

This notification system allows users to:

- Send notifications through multiple platforms (Email, SMS, WhatsApp)
- Switch notification mediums at runtime without recompiling
- Track all sent messages in a session log
- Display message history in reverse chronological order

The system simulates a long-term software maintenance project and thus prioritizes maintainability and extensibility. New notification services can be added without modifying the core `AlertSystem` class.

## Requirements

### Hardware

- Any modern system capable of running Java

### Software

| Software | Version |
|----------|---------|
| Java JDK | 17.0.1 or higher |
Verify installation:

```
java -version
javac -version
```

## Quick Start

### 1. Clone or Download

Download and extract the project to your local machine.

/src should contain the apps and services folders. Apps should contain:

```
AlertSystem.java
package-info.java
```

Services should contain:

```
EmailService.java
NotificationMedium.java
SMSService.java
WhatsAppService.java
package-info.java
```

### 2. Navigate to Project Root

Place the /src folder whereever desired, then run in the terminal:

```
cd [directory]/src
```

### 3. Compile

```
javac -d out src/apps/*.java src/services/*.java
```

### 4. Run

```
java -cp out apps.AlertSystem
```

### Expected Output

```
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
```

## Project Structure

```
├── src/
│   ├── apps/
│   │   ├── package-info.java
│   │   └── AlertSystem.java
│   └── services/
│       ├── package-info.java
│       ├── NotificationMedium.java
│       ├── EmailService.java
│       ├── SMSService.java
│       └── WhatsAppService.java
```

## Documentation

Generate JavaDoc HTML documentation by navigating to the /src directory and running in the terminal:

```
javadoc -d docs -author -version src/apps/*.java src/services/*.java
```
