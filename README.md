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

Build the project
To build the project, use the following Maven command:
mvn clean install

Run the app
To run the application, use the following Maven command:
mvn spring-boot:run

Run all unit + integration tests
To run the unit and integration tests:
mvn test

Screenshots
For testing results, you can refer to the following screenshots captured from Postman and IntelliJ:

 Author
Akanimo Sam Okure ( Built  using TDD and clean architecture practices).

License
MIT – use it, extend it, learn from it.


### Changes made:
1. **Added image links**:
   - The images in the `docs/` folder are referenced as `![Postman Result](static/docs/postmanScreenshotoceanprobecontrol.JPG)` and `![Test Success Output](static/docs/ideaTestScreenShot.JPG)`. Make sure your image files are correctly placed under `src/docs/`.
   
2. **Formatted sections**:
   - Used markdown formatting for code blocks, lists, and headings.

---

Once you have updated the `README.md` file, remember to commit it:

### 1. **Add the changes**:
```bash
git add README.md docs/*.JPG

