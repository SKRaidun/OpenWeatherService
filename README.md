# OpenWeatherService

Веб-приложение для просмотра текущей погоды с аутентификацией пользователей и персональными списками локаций. Проект был разработан в рамках обучающего курса по Java Backend разработке [weather-viewer](https://zhukovsd.github.io/java-backend-learning-course/projects/weather-viewer/).

## Стек

![Java](https://img.shields.io/badge/java-59666C.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Jakarta EE](https://img.shields.io/badge/jakarta_ee-59666C?style=for-the-badge&labelColor=white)
![MVC(S)](https://img.shields.io/badge/mvc(s)-59666C?style=for-the-badge&labelColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![JPA](https://img.shields.io/badge/jpa-59666C?style=for-the-badge&labelColor=white)
![HikariCP](https://img.shields.io/badge/hikari_cp-59666C.svg?style=for-the-badge)
![Postgres](https://img.shields.io/badge/postgres-59666C.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![HTTP](https://img.shields.io/badge/http-59666C?style=for-the-badge&labelColor=white)
![Rest Api](https://img.shields.io/badge/REST%20API-59666C?style=for-the-badge&labelColor=white)
![JSON](https://img.shields.io/badge/json-59666C?style=for-the-badge&labelColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-59666C?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![HTML](https://img.shields.io/badge/HTML-59666C?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS-59666C?&style=for-the-badge&logo=css3&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/thymeleaf-59666C?style=for-the-badge&logo=thymeleaf)
![JUnit5](https://img.shields.io/badge/junit-59666C?style=for-the-badge&logo=junit5&logoColor=white)


## Демонстрация работы приложения

![](https://github.com/SKRaidun/OpenWeatherService/blob/main/ScreenCast.gif)

## Основные функции

### Работа с пользователями:
- Регистрация
- Авторизация
- Logout

### Работа с локациями:
- Поиск
- Добавление в список
- Просмотр списка локаций, для каждой локации отображается название и температура
- Удаление из списка

### Работа с сессиями
Использование cookies и сессий для авторизации пользователей без использования фреймворков.
- Создание сессии для пользователя на заданное время
- Проверка наличия сессии при каждом redirect
- Удаление сессии при logout


### Работа с внешним API [OpenWeatherAPI](https://openweathermap.org/):

- Поиск локаций по названию


### База данных
- PostgreSQL/MySQL/MariaDB
- Таблицы:
  - Users (пользователи)
  - Locations (локации)
  - Sessions (сессии)

### Frontend
- HTML5/CSS3
- Bootstrap 5
- JavaScript (базовый)

### Тестирование
- JUnit 5
- Интеграционные тесты
- Моки для тестирования

## Установка и запуск

### Требования
- JDK 17+
- Maven/Gradle
- PostgreSQL/MySQL
- API ключ OpenWeatherMap

## Инструкция по запуску

### Предварительные требования
1. **Java 17+** 
2. **Apache Maven** 
3. **PostgreSQL** (версия 12+)

### 1. Клонирование репозитория
```bash
git clone https://github.com/SKRaidun/OpenWeatherService.git
cd OpenWeatherService
```

### 2. Настройка базы данных
1. Создайте базу данных в PostgreSQL weather_service_db:
   ```sql
   CREATE DATABASE weather_service_db;
   ```

### 3. Сборка проекта
```bash
mvn clean install
```

### 4. Запуск приложения
```bash
mvn spring-boot:run
```

### 5. Доступ к приложению
Откройте в браузере: [http://localhost:8080/login](http://localhost:8080/login)
