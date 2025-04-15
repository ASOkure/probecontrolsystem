# Sea Probe Control API

A RESTful API that simulates the navigation of a remotely controlled sea probe on an ocean floor grid. Built using **Java + Spring Boot**, this API is developed using a **Test-Driven Development (TDD)** approach with unit and integration tests.

---

##  Features

- Move the probe forward (`F`) or backward (`B`)
- Rotate left (`L`) or right (`R`)
- Avoid obstacles on the grid
- Stay within grid boundaries
- Track and return all visited coordinates
- Return meaningful errors when blocked
- Clean object-oriented design with layered architecture

---

##  Technologies

- Java 17+
- Spring Boot
- JUnit 5
- Maven
- REST (JSON-based API)

---

##  TDD First Approach

This project was built using a strict **TDD** workflow:

1.  Wrote unit tests before implementing each class (`Position`, `Direction`, `Probe`, `Grid`, `CommandProcessor`)
2.  All logic verified with isolated tests before building REST layers
3.  Added SpringBoot integration tests for end-to-end behavior
4.  Clean commits for each logical step

---

##  API Overview

### Endpoint
POST /api/probe/command

### Request Body

```json
{
  "startX": 0,
  "startY": 0,
  "startDirection": "NORTH",
  "commands": ["F", "R", "F", "L", "B"]
}
Response
{
  "finalPosition": {
    "x": 1,
    "y": 0
  },
  "visitedPositions": [
    { "x": 0, "y": 0 },
    { "x": 0, "y": 1 },
    { "x": 1, "y": 1 },
    { "x": 1, "y": 0 }
  ]
}

# Build the project
mvn clean install

# Run the app
mvn spring-boot:run
# Run all unit + integration tests
mvn test
## Author
Akanimo Sam Okure ( Built  using TDD and clean architecture practices).
## License
MIT – use it, extend it, learn from it.
