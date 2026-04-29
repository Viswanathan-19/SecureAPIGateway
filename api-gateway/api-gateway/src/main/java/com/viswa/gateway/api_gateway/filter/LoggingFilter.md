# 🛡️ Secure API Gateway — Logging Filter (Deep Explanation)

## 📌 Overview

In this step, we implemented our **first real gateway component** — a **Global Logging Filter**.

This is a **core building block** because:

* Every request passes through it
* It helps in debugging, monitoring, and security
* It introduces you to **reactive flow and filter chains**

---

# 🧠 How API Gateway Works Internally

```
Client → API Gateway → Filters → Route → Backend Service
```

Our filter sits in the **middle**:

```
Client → LoggingFilter → (next filters...) → Route → Service
```

---

# 🔥 What We Built

A **Global Logging Filter** that logs:

* HTTP Method (GET, POST, etc.)
* Request Path (/users, /orders)
* Client IP Address
* Response Status Code
* Time taken to process request

---

# Key Concepts
### 🔹 GlobalFilter
Applies to every request
No need to configure per route
### 🔹 ServerWebExchange
Holds both:
Request
Response
Central object in reactive flow
### 🔹 GatewayFilterChain
Represents next filters in chain
chain.filter(exchange) → passes request forward
### 🔹 Mono (Reactive Programming)

From Project Reactor

Represents an asynchronous operation
Executes non-blocking
### 🔹 Pre vs Post Execution
log.info("Incoming Request...");

👉 Executes before routing

.then(Mono.fromRunnable(...))

👉 Executes after response returns

### 🔹 getOrder()
return -1;
Lower value = higher priority
Ensures this filter runs early

# Example Output
Incoming Request → Method: GET, Path: /users, IP: 127.0.0.1
Response → Status: 200, Time: 15 ms