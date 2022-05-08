# ApiMatriz
Servicio para rotar matriz en sentido antihorario.

## Consideraciones:
- JDK versión 17.0.3.1
- Apache Maven version 3.8.5
- Sprint boot version 2.6.7
- Intellij IDEA Community Edition 2022.1 como IDE de desarrollo.
- Visual Studio Code con Thunder Client para simular las peticiones al api

## Comandos para Docker:
docker build -t "api-matriz" .
docker images
docker run --name java-app -p 8081:8080 api-matriz:latest 
docker ps -a   //para ver los contenedores

## ¿Cómo probar el api rest?
- Primera Forma
1. Llamar al método post:  http://localhost:8080/operaciones/rotarmatriz
2. Ingresar la matriz de datos:
```json
{
  [ [1,2,3], 
    [4,5,6],
    [7,8,9]
  ]
}
```
- Segunda Forma
1. Llamar al método post: http://localhost:8080/operaciones/rotarmatrizjson
2. Ingresar la matriz de datos:
```json
{
    "array": 
    [
        [  "1", "2"],
        [  "3", "4" ]
    ]
}
```
