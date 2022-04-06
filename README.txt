
# AREP- ARQUITECTURAS EMPRESARIAL - Taller HTTPS.

## AUTOR.

> Eduardo Ospina Mejia

## Aplicación distribuida segura en todos sus frentes.

### Introduccion.

Desarrolle una aplicación Web segura con los siguientes requerimientos:

1) Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
2) Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.
3) Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios.


#### Entregables

1) Código en github, bien documentado.
2) Informe que describe la arquitectura de seguridad de su prototipo. (en el README)
3) Video de experimento en AWS


### Desplegando localmente.

1) clonar el repositorio, ya se a traves de cmd o de GIT: que contiene todos los ejercicios y retos.

2) ingresamos al proyecto clonado y desde cmd hacer uso de mvn para clean y package:

3) se pueden correr lo servidores directamente de las clases main de cada uno de los dos proyectos, que cuando se ponen a correr permite la conecion local. 
al montarlo en aws las direcciones no quedan correctos para local, requieren cmabio. 
   
4) se ejecutan ya sea por comandos de consola o directamente desde al IDE que corra cad auno de los programas:

```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.app"
```

```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.app"
```

![]()

##### Requisitos:
1)   [Java 8](https://www.java.com/download/ie_manual.jsp)
2)   [Maven](https://maven.apache.org/download.cgi)
3)   [Git](https://git-scm.com/downloads)
4)   IDE de java.

### Solucion.



### Coriendo localmente:



### AWS:

se repiten lo sismo pasos para cada una de las maquncas y se crean 2 EC2 en donde en cada una se monta un servidor utilizado para 
solucionar el proyecto completmanete, los siguientes screenshots muestran los procedimientos necesarios. 


### Arquitectura implementada

La arquitectura implementada es: 

![]()

### Escalabilidad:


## Construido con
-   HTML
-   javascript
-   java


### Licencia.

Licencia.
