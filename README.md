# ApiMatriz
Servicio para rotar matriz en sentido antihorario.

Consideraciones:
- JDK versión 17.0.3.1
- Apache Maven version 3.8.5
- Sprint boot version 2.6.7
- Intellij IDEA Community Edition 2022.1 como IDE de desarrollo.
- Visual Studio Code con Thunder Client para simular las peticiones al api


Comandos para Docker:
docker build -t "api-matriz" .
docker images
docker run --name java-app -p 8081:8080 api-matriz:latest 
docker ps -a   //para ver los contenedores

