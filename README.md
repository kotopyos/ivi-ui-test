## Проект UI автотестов ivi.ru

<p align="center">
<a href="https://www.ivi.ru/"><img src="images/logos/ivi-logo.png"/></a>

## Проект реализован с использованием
Java Gradle IntelliJ IDEA Selenide Selenoid JUnit5 Jenkins Allure Report Allure TestOps Telegram

![This is an image](/images/logos/Java.png)![This is an image](/images/logos/Gradle.png)![This is an image](/images/logos/Intelij_IDEA.png)![This is an image](/images/logos/Selenide.png)![This is an image](/images/logos/Selenoid.png)![This is an image](/images/logos/JUnit5.png)![This is an image](/images/logos/Jenkins.png)![This is an image](/images/logos/Allure_Report.png)![This is an image](/images/logos/AllureTestOps.png)![This is an image](/images/logos/Telegram.png)

<!-- Тест кейсы -->

### Что проверяем
* Проверка фитьтра на странице фильмов


### <img width="5%" title="Jenkins" src="images/logos/Jenkins.png"> Запуск проекта в Jenkins

### [Job](https://jenkins.autotests.cloud/job/c20-Stayarr-ivi-ui-tests/)

##### При нажатии на "Собрать сейчас" начнется сборка тестов и их прохождение, через виртуальную машину в Selenide.
![This is an image](images/screenshots/jenkins_screenshot.png)

<!-- Allure report -->

### <img width="5%" title="Allure Report" src="images/logos/allure_report.png"> Allure report
### [Report](https://jenkins.autotests.cloud/job/c20-Stayarr-ivi-ui-tests/allure/)
##### После прохождения тестов, результаты можно посмотреть в Allure отчете, где так же содержится ссылка на Jenkins
![This is an image](images/screenshots/allure_dashboard_screenshot.png)

##### Во вкладке Graphs можно посмотреть графики о прохождении тестов, по их приоритезации, по времени прохождения и др.
![This is an image](images/screenshots/allure_graphs_screenshot.png)

##### Во вкладке Suites находятся собранные тест кейсы, у которых описаны шаги и приложены логи, скриншот и видео о прохождении теста
![This is an image](images/screenshots/allure_suites_screenshot.png)

##### Видео прохождение теста
![This is an image](images/screenshots/images/screenshots/test_ui.gif)

<!-- Allure TestOps -->

### <img width="5%" title="Allure TestOps" src="images/logos/AllureTestOps.png"> Интеграция с Allure TestOps

### [Dashboard](https://allure.autotests.cloud/project/3608/dashboards)

##### Так же вся отчетность сохраняется в Allure TestOps, где строятся аналогичные графики.
![This is an image](images/screenshots/allure_testops_dashboard_screenshot.png)

#### Во вкладке со сьютами, мы можем:
- Управлять всеми тест-кейсами или с каждым отдельно
- Перезапускать каждый тест отдельно от всех тестов
- Настроить интеграцию с Jira
- Добавлять ручные тесты и т.д

![This is an image](images/screenshots/allure_suites_screenshot.png)


<!-- Telegram -->

### <img width="5%" title="Telegram" src="images/logos/Telegram.png"> Интеграция с Telegram
##### После прохождения тестов, в Telegram bot приходит сообщение с графиком и небольшой информацией о тестах.

![This is an image](images/screenshots/tg_bot_schreenshot.png)