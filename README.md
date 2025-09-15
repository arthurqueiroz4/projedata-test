# Teste Prático Projedata

Criei o projeto usando Maven com o seguinte comando:

```bash
mvn archetype:generate \
  -DgroupId=com.projedata \
  -DartifactId=teste-pratico \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

Usei Java 24 e Stream API para resolver a maioria dos problemas com elegância que a programação funcional e essa API nos propociona.

Além das classes pedidas nos testes, criei a classe "Formatter" que auxilia na formatação de valores monetários e nos valores temporais.

Para compilar e verificar o resultado, usei o comando:

```bash
mvn package
java -cp target/projedata-test-1.0-SNAPSHOT.jar com.projedata.Principal
```
