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

###  Clone the Repository
```bash
git clone https://github.com/<your-username>/event-registration-system.git
cd event-registration-system
```



## Build and Run
mvn clean install,
mvn spring-boot:run

### The API will be available at:
http://localhost:8080

## API Endpoints
### 1)Create Event
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
### 2)event details find all
GET api/eventDetails?title=test event&venue=mumbai

### 3)event details find by id
GET api/eventDetails/2

### 4)event details update (PUT)
PUT api/eventDetails/2

### 5)event details delete
DELETE api/eventDetails/1

### 6)event details statistics
GET api/eventDetails/2/eventStatistics

### 7)event details cencel (Patch)
PATCH api/eventDetails/2/cancel

### 8)attendees save
POST api/attendees

### 9)attendee details find all
GET api/attendees?city=nashik

### 10)attendee details find by id
GET api/attendees/2

### 11)attendees update
PUT api/attendees/1

### 12)attendee details delete
DELETE api/attendees/1

### 13)event has attendee save
POST api/eventHasAttendee

### 14)event has attendee fetch
GET api/eventHasAttendee

## Assumptions
The application will be run on Java 17 or higher.
SQLite database file (eventReg.db) is located in the resources directory.
Required dependencies are installed via Maven before running.




## Demo Video

https://drive.google.com/file/d/1r075Hauh4DrdydPKhhVPOoaiwOs6Xh3S/view?usp=drivesdk


### Author
#### AKASH VIJAY KSHATRIYA

