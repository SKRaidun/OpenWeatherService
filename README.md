# OpenWeatherService

Веб-приложение для просмотра текущей погоды с аутентификацией пользователей и персональными списками локаций. Проект был разработан в рамках обучающего курса по Java Backend разработке [weather-viewer](https://zhukovsd.github.io/java-backend-learning-course/projects/weather-viewer/).

## Стек

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![JPA](https://img.shields.io/badge/jpa-59666C?style=for-the-badge&labelColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![JSON](https://img.shields.io/badge/json-59666C?style=for-the-badge&labelColor=white)
![Rest Api](https://img.shields.io/badge/REST%20API-59666C?style=for-the-badge&labelColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)


## Демонстрация работы приложения

![](https://github.com/SKRaidun/OpenWeatherService/blob/main/ScreenCast.gif)

## Основные функции

### Работа с пользователями:
- Регистрация
- Аутентификация
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

## Задачи
- [50%] Подключить Spring Security
- [ ] Автоматизировать сборку проекта
- [ ] Автоматизировать развертывание приложения
