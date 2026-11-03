## Student API

Базовый URL:

```text
http://localhost:8080/api/students
```

### Получить всех студентов

```http
GET /api/students
```

Пример ответа:

```json
[
  {
    "id": 1,
    "name": "Вася",
    "email": "vasya@gmail.com",
    "groupId": 1,
    "groupName": "ИСП-101",
    "facultyId": 1,
    "facultyName": "Информационные технологии"
  }
]
```

---

### Получить студента по ID

```http
GET /api/students/{id}
```

Пример:

```http
GET /api/students/1
```

Если студент не найден, API возвращает `404 Not Found`.

---

### Создать студента

```http
POST /api/students
```

Тело запроса:

```json
{
  "name": "Вася",
  "email": "vasya@gmail.com",
  "groupId": 1
}
```

Успешный ответ:

```text
201 Created
```

Пример ответа:

```json
{
  "id": 1,
  "name": "Вася",
  "email": "vasya@gmail.com",
  "groupId": 1,
  "groupName": "ИСП-101",
  "facultyId": 1,
  "facultyName": "Информационные технологии"
}
```

---

### Обновить студента

```http
PUT /api/students/{id}
```

Пример:

```http
PUT /api/students/1
```

Тело запроса:

```json
{
  "name": "Василий",
  "email": "vasiliy@gmail.com",
  "groupId": 2
}
```

Пример ответа:

```json
{
  "id": 1,
  "name": "Василий",
  "email": "vasiliy@gmail.com",
  "groupId": 2,
  "groupName": "ИСП-102",
  "facultyId": 1,
  "facultyName": "Информационные технологии"
}
```

Если студент или группа не найдены, API возвращает `404 Not Found`.

---

### Удалить студента

```http
DELETE /api/students/{id}
```

Пример:

```http
DELETE /api/students/1
```

Успешный ответ:

```text
204 No Content
```

Если студент не найден, API возвращает `404 Not Found`.