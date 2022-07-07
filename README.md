# ShorterUrl
Application cuts long links

Условие:
Необходимо реализовать простой сервис для сокращения длинных ссылок, наподобие https://u.to или https://bitly.com
Сам сервис генерации короткой ссылки представляет собой REST API защищенное Basic авторизаций, принимает на вход любую длинную ссылку (например ссылку на этот документ), а в ответ возвращает короткую ссылку.
Переход по короткой ссылку должен перенаправлять на оригинальную длинную ссылку.
Требования к технической части:
Порт 8080;
Для запуска сервиса не должно требоваться развертывание базы данных, томката и т.п, максимум что должен сделать проверяющий - скачать код с GitHub и кликнуть на “Run” в IDE, в противном случае задание не принимается;
Java 11;
Spring Boot 2+;
Maven.
Исходный код решения должен быть размещен в публичной репозиторий на GitHub + README с описанием как пользоваться сервисом.


Как пользоваться:
1. Необходимо внести нового юзера в "Add new user".
2. Войти в программу, введя зарегестррированные данные в поля "Enter username" и "Password".
3. Ввести длинную ссылку в поле "Full url:".
4. Нажать кнопку "Cut".
5. В "Short link:" появится текстовая ссылка, и рядом ссылка, нажав на которую можно переместиться на нужную страницу
либо копируем ссылку и подставляем в http://localhost:8080/links вместо links. 



          