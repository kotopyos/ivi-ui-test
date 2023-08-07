## Проект UI автотестов ivi.ru

<p align="center">
<a href="https://www.ivi.ru/"><img src="images/logos/ivi-logo.png"/></a>

## Содержание
- [Что проверяем](#что-проверяем)
- [Запуск из терминала](#запуск-тестов-из-терминала)
- [Запуск проекта в Jenkins](#job)
- [Allure report](#-allure-report)
- [Видео прохождение теста](#видео-прохождение-теста)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Telegram](#-интеграция-с-telegram)

## Проект реализован с использованием

<p align="center">
<a href="https://www.java.com/"><img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://junit.org/junit5/"><img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit5"/></a>
<a href="https://gradle.org/"><img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logos/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a><img src="images/logos/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a><img src="images/logos/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>
<!-- Тест кейсы -->

### Что проверяем
* Проверка фильтра фильмов:
  * С помощью Suggestion list
  * По рейтингу
  * По жанру с помощью карусели
  * По жанру с помощью списка
  * С помощью Sausage list

## Запуск тестов из терминала
Локальный запуск:
```
gradle clean test -Denv=local
```

Удаленный запуск:
```
gradle clean test -Denv=${remote}
```

### <img width="5%" title="Jenkins" src="images/logos/Jenkins.svg"> Запуск проекта в Jenkins

### [Job](https://jenkins.autotests.cloud/job/c20-Stayarr-ivi-ui-tests/)

##### При нажатии на "Собрать сейчас" начнется сборка тестов и их прохождение, через виртуальную машину в Selenide.
![This is an image](images/screenshots/jenkins_screenshot.png)

<!-- Allure report -->

### <img width="5%" title="Allure Report" src="images/logos/Allure.svg"> Allure report
### [Report](https://jenkins.autotests.cloud/job/c20-Stayarr-ivi-ui-tests/allure/)
##### После прохождения тестов, результаты можно посмотреть в Allure отчете, где так же содержится ссылка на Jenkins
![This is an image](images/screenshots/allure_dashboard_screenshot.png)

##### Во вкладке Graphs можно посмотреть графики о прохождении тестов, по их приоритезации, по времени прохождения и др.
![This is an image](images/screenshots/allure_graphs_screenshot.png)

##### Во вкладке Suites находятся собранные тест кейсы, у которых описаны шаги и приложены логи, скриншот и видео о прохождении теста
![This is an image](images/screenshots/allure_suites_screenshot.png)

##### Видео прохождение теста
![This is an image](images/screenshots/test_ui.gif)

<!-- Allure TestOps -->

### <img width="5%" title="Allure TestOps" src="images/logos/Allure_TO.svg"> Интеграция с Allure TestOps

### [Dashboard](https://allure.autotests.cloud/project/3608/dashboards)

##### Так же вся отчетность сохраняется в Allure TestOps, где строятся аналогичные графики.
![This is an image](images/screenshots/allure_testops_dashboard_screenshot.png)

#### Во вкладке со сьютами, мы можем:
- Управлять всеми тест-кейсами или с каждым отдельно
- Перезапускать каждый тест отдельно от всех тестов
- Настроить интеграцию с Jira
- Добавлять ручные тесты и т.д

![This is an image](images/screenshots/allure_testops_suites_screenshot.png)


<!-- Telegram -->

### <img width="5%" title="Telegram" src="images/logos/Telegram.svg"> Интеграция с Telegram
##### После прохождения тестов, в Telegram bot приходит сообщение с графиком и небольшой информацией о тестах.

![This is an image](images/screenshots/tg_bot_schreenshot.png)