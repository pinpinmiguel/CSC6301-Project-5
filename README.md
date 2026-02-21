# Flexible Notification System

A modular notification system built in Java demonstrating the **Strategy Design Pattern** and **Composition over Inheritance**. The system simulates sending notifications through multiple platforms (Email, SMS, WhatsApp) with runtime-swappable delivery methods and session logging.

## Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Usage Examples](#usage-examples)
- [Documentation](#documentation)
- [Maintenance](#maintenance)
- [Author](#author)

## Overview

This notification system allows users to:

- Send notifications through multiple platforms (Email, SMS, WhatsApp)
- Switch notification mediums at runtime without recompiling
- Track all sent messages in a session log
- Display message history in reverse chronological order

The system prioritizes maintainability and extensibility. New notification services can be added without modifying the core `AlertSystem` class.

## Requirements

### Hardware

- Any system capable of running Java (Windows, macOS, Linux)
- Minimum 512 MB RAM
- 50 MB disk space

### Software

| Software | Version | Download |
|----------|---------|----------|
| Java JDK | 17.0.1 or higher | [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/) |

Verify installation:

```
java -version
javac -version
```

### Optional

- IntelliJ IDEA (recommended IDE)
- Git for version control

## Quick Start

### 1. Clone or Download

Download and extract the project to your local machine.

### 2. Navigate to Project Root

```
cd /path/to/Week5
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
=== Notification System Demo ===

Switching to EMAIL service.
[EMAIL] Sending email: LinkedIn Job Alerts
[EMAIL] Sending email: Amazon Order Confirmation
[EMAIL] Sending email: Canvas Notification

Switching to SMS service.
[SMS] Sending text: Verification Code
[SMS] Sending text: Doctor's Appointment Reminder
[SMS] Sending text: Mom

--- Session Message Log ---
1. [SMS] Mom
2. [SMS] Doctor's Appointment Reminder
3. [SMS] Verification Code
4. [EMAIL] Canvas Notification
5. [EMAIL] Amazon Order Confirmation
6. [EMAIL] LinkedIn Job Alerts
Total messages: 6
```

## Project Structure

```
Week 5/
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
├── out/                    (compiled classes)
├── docs/                   (generated documentation)
└── README.md
```

## Architecture

The system implements the **Strategy Design Pattern**:

| Component | Role | Description |
|-----------|------|-------------|
| `NotificationMedium` | Interface | Contract for all delivery services |
| `EmailService` | Concrete Strategy | Handles email delivery |
| `SMSService` | Concrete Strategy | Handles SMS delivery |
| `WhatsAppService` | Concrete Strategy | Handles WhatsApp delivery |
| `AlertSystem` | Context | Manages medium selection and message logging |

### Design Principles

- **Composition over Inheritance:** `AlertSystem` holds a `NotificationMedium` reference rather than extending a service class.
- **Open/Closed Principle:** System is open for extension (new services) but closed for modification (no changes to `AlertSystem`).
- **Encapsulation:** Services are organized in a separate package with single responsibilities.

## Usage Examples

### Basic Usage

```java
AlertSystem alerts = new AlertSystem();

alerts.setMedium(new EmailService());
alerts.notifyUser("Welcome to the platform!");

alerts.setMedium(new SMSService());
alerts.notifyUser("Your code is 123456");

alerts.setMedium(new WhatsAppService());
alerts.notifyUser("Meeting at 3pm");

alerts.displayLog();
```

### Runtime Switching

```java
AlertSystem alerts = new AlertSystem();
NotificationMedium currentMedium;

// Switch based on user preference
String userChoice = "whatsapp";

switch (userChoice) {
    case "email":
        currentMedium = new EmailService();
        break;
    case "sms":
        currentMedium = new SMSService();
        break;
    case "whatsapp":
        currentMedium = new WhatsAppService();
        break;
}

alerts.setMedium(currentMedium);
alerts.notifyUser("Dynamic notification!");
```

## Documentation

Generate JavaDoc HTML documentation:

```
javadoc -d docs -author -version src/apps/*.java src/services/*.java
```

Open `docs/index.html` in a browser to view.

## Maintenance

### Adding a New Notification Service

1. Create a new class in `src/services/`:

```java
package services;

public class SlackService implements NotificationMedium {
    
    @Override
    public void send(String message) {
        System.out.println("[Slack] Sending message: " + message);
    }
    
    @Override
    public String toString() {
        return "Slack";
    }
}
```

2. Use it immediately — no changes to `AlertSystem` required:

```java
alerts.setMedium(new SlackService());
alerts.notifyUser("Hello from Slack!");
```

## Author

**Miguel Pinpin**  
CSC6301 — Object-Oriented Programming  
Week 5 Assignment
