# Binance Automation with Selenium Grid
## Selenium 4.17, Docker Compose (Selenium Grid)


The automation project includes 4 cases which have been written on excel and attached to the repository.

## Features

- Constant variables have been added to the resources/inputs.properties file
- Coin Excel saved to the ./downloads/coinlist.xlsx path.
- Manual test cases has been attached to the repository.
- Parallel execution is supported.
- Chrome, Firefox and Edge browsers supported 


## Tech

- [Docker] - Docker installation for Selenium Grid
- [Java] - Java 11 installation for Selenium
- [Maven] - Maven installation for dependency management
- [Git] - Git installation to clone project


## Installation

Please follow below steps to execute automation.

- Install the dependencies and Dependencies before starting project.
```sh
mvn clean install
```

- Run testng.xml to run all test cases.


## Docker

Please follow below steps for Docker - Selenium Grid.

- "docker-compose up -d" command should be executed in project folder to up Selenium Grid.

```sh
docker-compose up -d
```

- Browse the url to access Selenium Grid.

```sh
http://localhost:4444/ui#
```


![test_result](https://github.com/kuzeycaliskan/binanceSelenium/blob/master/Test_execution_result.png)

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[Git]: <https://git-scm.com/downloads>
[Maven]: <https://maven.apache.org/download.cgi>
[Docker]: <https://www.docker.com/products/docker-desktop/>
[Java]: <https://www.oracle.com/tr/java/technologies/javase/jdk11-archive-downloads.html>