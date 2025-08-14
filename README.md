# Event Registration System

### Overview
This is an **Event Registration System** built using **Spring Boot** and **SQLite** for persistent storage.  
It allows event organizers to create and manage events, register attendees, track statistics, and handle capacity & validation rules.

This project was developed as part of the **Junior Developer assignment for Paybrook Payments Tech Pvt. Ltd.**.

---

## Tech Stack

- **Backend**: Spring Boot (Java)
- **Database**: SQLite
- **ORM**: Hibernate / JPA
- **Build Tool**: Maven
- **Java Version**: 11
- **Tools Used**: IntelliJ IDEA, Postman (for API testing)

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/event-registration-system.git
cd event-registration-system.
```


### Demo Video

https://drive.google.com/file/d/1r075Hauh4DrdydPKhhVPOoaiwOs6Xh3S/view?usp=drivesdk

## Build and Run
mvn clean install
mvn spring-boot:run

### The API will be available at:
http://localhost:8080

## API Endpoints
### Create Event
POST api/eventDetails

{
  "title": "Test EVENT",
  "description": "EVENT DESC.",
  "eventDate": "2026-01-10T10:30:00",
  "eventDuration": 3.5,
  "venue": "Grand Convention Center, Mumbai",
  "maxSeatsAllowed": 100,
  "ticketPrice": 1499.99,
  "organizer": "TechWorld Events Pvt. Ltd."
}
### event details find all
GET api/eventDetails?title=test event&venue=mumbai

### Author
#### AKASH VIJAY KSHATRIYA

