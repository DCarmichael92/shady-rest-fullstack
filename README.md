![Backend CI](https://github.com/DCarmichael92/shady-rest-fullstack/actions/workflows/backend-ci.yml/badge.svg)
![Frontend CI](https://github.com/DCarmichael92/shady-rest-fullstack/actions/workflows/frontend-ci.yml/badge.svg)

# Shady Rest Full-Stack Hotel Booking App 🏨

A modern rewrite of a classic Java console application — upgraded to a **full-stack web app** using:

| Layer | Tech |
|------|------|
| Frontend | Angular 20, Vite, Tailwind *(optional)* |
| Backend | Spring Boot 3 / Java 17 |
| API Communication | REST + JSON |
| Infrastructure | Docker, Docker Compose |
| CI/CD | GitHub Actions |
| Auth | (Planned) JWT |
| DB | In-Memory *(SQLite / Postgres upgrade planned)* |

---

## 💡 Overview

Originally a simple Java program to select hotel rooms, this project now simulates a real booking system where users can:

✅ View room types  
✅ Select dates  
✅ Generate booking quotes  
✅ Calculate tax + totals  
✅ Submit booking (demo)  
✅ Run in **Docker**  
✅ Tested via **GitHub Actions**

Future:
- 🧾 Reservation persistence (Postgres)
- 🔐 JWT Login
- ☁️ Deploy to AWS (ECS or EB)

---

## 🛠️ Architecture

/backend # Spring Boot API
/shady-rest-ui # Angular 20 Frontend
/docker # Docker + Compose

**Flow:**
Frontend (Angular) → REST calls → Spring Boot → Pricing Engine → JSON Response

---

## 🚀 Local Run

### Backend
```bash
cd backend
mvn spring-boot:run
Frontend
cd shady-rest-ui
npm install
npm start
Open: http://localhost:4200
API: http://localhost:8080/api/rooms
🐳 Docker
docker compose up --build
Frontend → http://localhost:4200
Backend → http://localhost:8080
✅ GitHub CI/CD
Workflow	Purpose
Backend CI	Maven build + tests
Frontend CI	Angular build
Release	Packages UI + API on tag
🧪 Testing
Backend
cd backend
mvn test
Frontend
cd shady-rest-ui
npm test
📦 Build
Angular Prod build
cd shady-rest-ui
npm run build
📚 API Endpoints
Method	Endpoint	Description
GET	/api/rooms	Room list
POST	/api/quote	Get price quote
POST	/api/bookings	Confirm booking
✨ Screenshots (Add Yours!)
UI	API
(image)	(image)
👨‍💻 Author
Devin Carmichael
Full-Stack & Cloud Engineer
TS/SCI Veteran
Software Engineering @ WGU
AWS Solutions Architect
⭐ Goals of This Project
Level up Java → Full-Stack engineering
Build modern Angular + Spring patterns
Demonstrate DevOps (CI/CD + Docker)
Interview-ready portfolio app
“Simple idea → modern engineering implementation.”
📈 Next Roadmap Items
✅ Docker Compose ✅ CI
🔜 Postgres migrations
🔜 JWT auth
🔜 Deploy on AWS (Fargate or EB)
