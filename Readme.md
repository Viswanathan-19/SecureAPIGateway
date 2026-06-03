# 🛡️ Secure API Gateway with Rate Limiting & JWT

## 📌 Overview
A production-ready API Gateway built using Spring Cloud Gateway with security and traffic control features.

## 🚀 Features
- API Gateway routing using Spring Cloud Gateway
- Service discovery using Eureka
- JWT-based authentication
- Rate limiting using Redis (Token Bucket Algorithm)
- Request logging using Global Filters

## 🏗️ Architecture
Client → API Gateway → Eureka → Microservices

## ⚙️ Tech Stack
- Java 21
- Spring Boot
- Spring Cloud Gateway (WebFlux)
- Eureka Server
- Redis
- JWT (jjwt)

## 🔐 Security
- Token generation endpoint (/auth/token)
- JWT validation at gateway level

## 🚦 Rate Limiting
- Implemented using Redis
- 5 requests/sec with burst capacity of 10
- IP-based throttling

## 🧪 How to Run
1. Start Redis
2. Start Eureka Server
3. Start User Service
4. Start API Gateway
5. Test using Postman

## 📌 Endpoints
- /auth/token → Generate JWT
- /users → Protected API

## 🧠 Concepts Covered
- Distributed systems
- API Gateway pattern
- Service discovery
- Non-blocking I/O (WebFlux + Netty)
- Rate limiting algorithms