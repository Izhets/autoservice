# Хелпа

### Описание проекта

Тестовый стажерский проект для освоения принятой в компании архитектуры приложений.
Предметная область - автосервис.

UPD: Теперь проект состоит из двух, связанных, микросервисов.

### Физическая схема и ER диаграмма БД
* [Схема](https://lucid.app/lucidchart/8e5cbec9-4e94-48ff-8e2d-ae95bfcbe816/edit?invitationId=inv_cefcaaab-6969-4f4f-aa0b-be36e10a6a98/)

### Стек

В проекте используются следующие технологии:

Компоненты Spring фреймворка:
* [Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Spring Boot](https://spring.io/projects/spring-boot/)

### СУБД:
* [PostgreSQL](https://www.postgresql.org/)

Инструменты:
* [Flyway](https://flywaydb.org/)
* [Lombok](https://projectlombok.org/)
* [Swagger](https://swagger.io/)
* [Docker](https://www.docker.com)
* [WebClient]()
* [KeyCloak](https://www.keycloak.org/)

### Для запуска проекта

База пуста и создается каждый раз с запуском проекта

* Склонируйте этот проект, затем проект "orders" на свой компьютер;
* Ведите в терминале из папки данного проекта: docker-compose build;
* Ведите в терминале из папки данного проекта: docker-compose up;
* Перейдите в вашем браузере или в другом калькуляторе на http://localhost:8080/ чтобы использовать api. 

По другим вопросам писать:
[khnykin@redcollar.ru](mailto:khnykin@redcollar.ru)

### Quick start

* Clone this project;
* And clone "orders" project;
* Enter in console gradle: docker-compose build;
* Enter in console gradle: docker-compose up;
* Point your browser or any calculator to http://localhost:8080/ to use api.

If any questions, please, do not hesitate to contact me by e-mail:
[khnykin@redcollar.ru](mailto:khnykin@redcollar.ru)