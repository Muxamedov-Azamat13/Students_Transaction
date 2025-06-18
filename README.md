# Student Payments Management API

Это RESTful back-end‑сервис для управления и анализа платежей студентов в вузах.

## Основной функционал

### Студенты (CRUD)
- **Создать:** `POST /api/students`
- **Получение списка (с постраничным выводом):** `GET /api/students?page=0&size=20`
- **Получение данных студента:** `GET /api/students/{id}`
- **Обновление:** `PUT /api/students/{id}`
- **Удаление:** `DELETE /api/students/{id}`

### Транзакции (CRUD)
- **Добавление транзакции к студенту:** `POST /api/students/{studentId}/transactions`
- **Получение списка транзакций с фильтром и пагинацией:**  
  `GET /api/transactions?from=2025-05-01&to=2025-05-31&minAmount=100&page=0&size=20`
- **Получение отдельной транзакции:** `GET /api/transactions/{id}`
- **Обновление транзакции:** `PUT /api/transactions/{id}`
- **Удаление транзакции:** `DELETE /api/transactions/{id}`

### Отчёты
- **Транзакции конкретного студента:** `GET /api/students/{studentId}/transactions`
- **Сводный отчёт (общая сумма и количество транзакций за период):**  
  `GET /api/reports/summary?from=2025-05-01&to=2025-06-01`

## Технический стек
- Java 17
- Spring Boot (Web, Data JPA, Security)
- PostgreSQL
- Maven

## Аутентификация
Все эндпоинты защищены HTTP Basic Authentication.  
**Данные для входа:**  
Username: `student`  
Password: `password`
