![Backend CI](https://github.com/DCarmichael92/shady-rest-fullstack/actions/workflows/backend-ci.yml/badge.svg)
![Frontend CI](https://github.com/DCarmichael92/shady-rest-fullstack/actions/workflows/frontend-ci.yml/badge.svg)

# Shady Rest Hotel — Full-Stack Booking App 🏨

A modern, production-style rewrite of a basic Java console assignment — transformed into a full-stack hotel booking web application.

This project demonstrates:

- ✅ Angular 20 (Vite) SPA  
- ✅ Spring Boot 3 backend (Java 17)  
- ✅ REST API communication  
- ✅ Real pricing logic (weekend/season/loyalty rules)  
- ✅ Dockerized frontend + backend  
- ✅ GitHub Actions CI pipeline  
- ✅ Clean project structure & modern Dev practices  

---

## 🚀 Features

- View available hotel room types  
- Select check-in date, nights, and loyalty status  
- Real-time quote calculation  
- Tax, nightly breakdown, and total  
- Booking confirmation generator (demo mode)  

> Designed to showcase full-stack engineering, not hotel operations.

---

## 🧠 Tech Stack

| Category | Tech |
|---------|------|
| Frontend | Angular 20, TypeScript, Vite |
| Backend | Spring Boot 3, Java 17 |
| API Style | REST + JSON |
| Build & Runtime | Maven, Node 20 |
| DevOps | Docker, Docker Compose |
| CI/CD | GitHub Actions |
| Compatibility | macOS / Windows / Linux |

---

## 📦 Run the App (Easiest Way — Docker)

### ✅ Prerequisites

Install Docker Desktop:

- macOS / Windows: https://www.docker.com/products/docker-desktop  
- Linux: install Docker via your package manager  

> No coding tools or Java/Node installs required.

### ▶️ Start the App

From the project root:

`docker compose up --build`

### 🌐 Access the App

| Service     | URL                           |
|-------------|-------------------------------|
| Frontend UI | http://localhost:4200         |
| Backend API | http://localhost:8080/api/rooms |

### 🛑 Stop the App

Press `CTRL + C`, then run:

`docker compose down`


## 🧑‍💻 Run Locally (No Docker)

### ▶️ Backend (Spring Boot)

**Requirements:** Java 17+, Maven

`cd backend`

`mvn spring-boot:run`

Backend runs at:

http://localhost:8080

### ▶️ Frontend (Angular)

**Requiremants:** Node 20, npm

`cd shady-rest-ui`

`npm install`

`npm start`

Frontend runs at:

http://localhost:4200

## 🔧 Project Structure

| Path | Description |
|------|------------|
| `backend/` | Spring Boot API service |
| `backend/src/main/java` | Java source code |
| `backend/pom.xml` | Maven build config |
| `shady-rest-ui/` | Angular 20 UI |
| `shady-rest-ui/src` | Angular source code |
| `shady-rest-ui/package.json` | Node project settings |
| `shady-rest-ui/angular.json` | Angular workspace config |
| `docker-compose.yml` | Runs both services together |

## 📐 System Design (High Level)

```
[ Angular UI ] --> calls --> [ Spring Boot REST API ]
        |                            |
        |                            v
   User loads UI             Pricing logic (Java)
        |                            |
        v                            v
 JSON request                  JSON response
```

- API responds with room data & real-time quotes

- Frontend calculates nothing — backend is system of record

- Easily extensible (DB, JWT auth, cloud deploy)

## 🧪 CI/CD

Automated GitHub Actions workflows:

| Workflow         | Purpose                     |
|------------------|-----------------------------|
| Frontend CI      | Install → Build Angular     |
| Backend CI       | Maven build & tests         |
| Release (future) | Package UI & JAR artifacts  |

## 🎯 Roadmap

| Feature                 | Status       |
|-------------------------|--------------|
| Docker containerization | ✅ Complete  |
| GitHub CI pipelines     | ✅ Complete  |
| Deploy to cloud         | 🔜 Planned   |
| JWT authentication      | 🔜 Planned   |
| Postgres persistence    | 🔜 Planned   |
| Unit + E2E tests        | 🔜 Planned   |

## 🙋 Support / Notes

This project was built to demonstrate:

- Full-stack engineering capability  
- Modern Angular + Spring best practices  
- Production-like dev workflows (CI, Docker, architecture)  
- Ability to expand into real enterprise features  

## 💡 Author

**Devin Carmichael**  

Cloud Software Engineer
WGU Software Engineering Student (June 2026)
TS//SCI FSP • 3x AWS Certified • DoD Experience

## ⭐ Like this repo?

If you're reviewing this project, feedback is welcome!  
If you're a hiring manager — let's talk — I’d love to walk you through the architecture.
