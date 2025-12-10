# ✅ Todo App – Full Stack Application

This is a full-stack **Todo Management Application** built using:

- Backend: Java + Spring Boot
- Frontend: Angular
- Database: MySQL (Dockerized)

---

## 📁 Project Structure

todo-app/
├── backend/ (Spring Boot API)
├── frontend/ (Angular UI)
├── docker-compose.yml
└── README.md


---

## ⚙️ Prerequisites

Make sure you have installed:

- Java 17+
- Node.js 18+
- Angular CLI
- Docker & Docker Compose
- Git

---

## 🐳 Run Project Using Docker

### Step 1: Clone the Repository

```bash
git clone https://github.com/DilkaSithari/todo-app.git
cd todo-app

Step 2: Start All Containers
docker-compose up --build

Step 3: Access the Application
Service	URL
Frontend (Angular)	http://localhost:4200

Backend (Spring Boot API)	http://localhost:8080

MySQL Database	localhost:3307

▶️ Run Without Docker (Local Development)
Backend (Spring Boot)
cd backend
./mvnw spring-boot:run

Or on Windows:

mvn spring-boot:run

Frontend (Angular)
cd frontend
npm install
ng serve


Frontend will run at:

http://localhost:4200

🧪 Run Backend Tests
cd backend
mvn test

🧪 Run Frontend Tests
cd frontend
ng test

🔌 API Endpoints
Method	Endpoint
GET    	/api/tasks
POST	/api/tasks

🗄️ Database Configuration

Docker MySQL container uses:

Host: localhost
Port: 3307
Database: assignment_db
Username: assignment_user
Password: pass123

👩‍💻 Author

Developed by Dilka Sithari
