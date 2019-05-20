# Golden Raspberry Awards

A aplicação lerá um arquivo .csv para inserir os dados na base em memória ao iniciar. O local desse arquivo deve ser informado no arquivo **_application.properties_**.

Para executar a aplicação, execute os seguintes comandos na pasta do projeto:
```
mvn clean install
java -jar target/raspberryawards-0.0.1-SNAPSHOT.jar
```

Para executar os testes, execute o seguinte comando:
```
mvn clean test
```

A api para obter o produtor com o maior e menor intervalo entre prêmios estará disponível em [localhost:8080/interval](http://localhost:8080/interval)
