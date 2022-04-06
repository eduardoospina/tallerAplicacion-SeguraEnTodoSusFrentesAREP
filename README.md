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

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/Corriendo%20Local.PNG)
![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/Corriendo%20Local2.PNG)
   
4) se ejecutan ya sea por comandos de consola o directamente desde al IDE que corra cad auno de los programas:

```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.app"
```

```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.app"
```

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/Corriendo%20Local3.PNG)

##### Requisitos:
1)   [Java 8](https://www.java.com/download/ie_manual.jsp)
2)   [Maven](https://maven.apache.org/download.cgi)
3)   [Git](https://git-scm.com/downloads)
4)   IDE de java.

### Solucion.

Para la solucion del problema, lo pensamos con 2 servicios web a traves de spark que permiten le ocnecion segura a traves del uso de certificados
y la generacion de llaves para que s epermita la conecion segura desde afuera y entr eellos, siendo este el problema planteado para este laboratorio. 
para lograr esto se necesit agenerar un par de llaves para cada uno de los dos creados, a partir de esto hacemos los certificados que unimeros dentro de los certificados que se aceptan 
dentro de los certicados confiables dentro de cada uno. permitiendo la conecion segura entre los servidores y con esto la comunicacion necesaria. 

se genera un sistema de login, que revisa un usario y una contraseña convertida en hash para la autenticacion de los usuarios registrados dentro de la palicacion, en dodne no entra al tener 
las credenciales para entrar, lo envia a una interfaz donde se puede trear del servicio de matematicas ceado, en donde se puede pedir el atan o el sqrt del numero que ingrese el usuario. 
este se conecta de manera segura a otro servidor que regresa en Json los resultados matematicos de las operaciones dadas. 

dentro de los dos servidores se registra al momento en quemanda las peticiones y regresa los reusltados buscados. facilitando la ocmunicacion entre los servidores de manera segura resolviendo asi el problema 
planteado para lo qu ese pide. 


### Coriendo localmente:

para poder correrlo localmente lo primero que se hace es generar ocrrectamente las credenciales y certificados: 

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/CreacionKey.PNG)
![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/CreacionKeyp2.PNG)
![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/CreacionKeyp3.PNG)
![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/CreacionKeyp4.PNG)
![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/CreacionKeyp5.PNG)

cuando los certificados estan creados correctamente, se manda a correr los programas, como se menciono anteriormente y usando las url de localhost, se accede a la solucion: 

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal1.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal2.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal3.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal4.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal5.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal6.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal7.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal8.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal9.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal10.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/pruebalocal11.PNG)



### AWS:

se repiten lo sismo pasos para cada una de las maquncas y se crean 2 EC2 en donde en cada una se monta un servidor utilizado para 
solucionar el proyecto completmanete, los siguientes screenshots muestran los procedimientos necesarios. la ssiguiente s imagenes muestran la forma de crear 
la sinstancia ec2 en aws(no especificamne este lab)

![](https://i.postimg.cc/Wpy9TnHn/Capture1.png)

![](https://i.postimg.cc/y8mnhzYQ/Capture2.png)

![](https://i.postimg.cc/MGtD4bB1/Capture3.png)

![](https://i.postimg.cc/Qttbr9gw/Capture4.png
)
![](https://i.postimg.cc/PxRMfX2x/Capture5.png)

![](https://i.postimg.cc/yx3ykMbT/Capture6.png)

![](https://i.postimg.cc/59XhB6cs/Capture7.png)

![](https://i.postimg.cc/g2W1bsx7/Capture8.png)

![](https://i.postimg.cc/5NcR8gSt/Capture9.png)

- keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3605
- keytool -export -Keystore ./ecikeystore.p12 -storetype PKCS12 -alias ecikeypair -file ecicert.cer
- keytool -import -file ./ecicert.cer -alias firstCA -keystore myTrustStore

- keytool -genkeypair -alias ecikeypair2 -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore2.p12 -validity 3605
- keytool -export -Keystore ./ecikeystore2.p12 -storetype PKCS12 -alias ecikeypair2 -file ecicert2.cer
- keytool -import -file ./ecicert2.cer -alias firstCA2 -keystore myTrustStore

a partir de estos comandos se generan nuevamente las llaves para ser utilizadas en aws. imagenes correspondientes. 

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws1.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws2.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws3.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws4.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws5.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws6.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws7.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws8.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws9.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws10.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws11.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws12.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws13.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws14.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws15.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws16.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws17.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws18.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws19.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws20.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws21.PNG)

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/aws22.PNG)


video de corrido en vivo de esta pruebas se encuentra dentor de la carpeta videofuncionAWS.


### Arquitectura implementada

La arquitectura implementada es: 

![](https://github.com/eduardoospina/tallerAplicacion-SeguraEnTodoSusFrentesAREP/blob/main/Img/arquitectura.PNG)

llegamos a implemntar un sistemas de loging para asegurarnos de utilizar los certificados y la autorizacion dentro de nuestro servidores, de aca sale para otro servidor que ofrece un servicio especifico, al mismo tiempo que 
es seguro, y llega a implementar las validaciones necesitadas. en mi caso se hace un servicio de dos matematicos que regresan suys valores calculados. 

### Escalabilidad:

la escalabilidad de este proyecto llega a ser elevada, ya que solo es necesario modificar levemente el servidor qu emaneja el login, ya que seri agregar nuevos botones de procesos matematicos que manden peticiones al backend, en donde se requeriria codificar estos procesos matematicos nuevos y decirle que dependiento de estas nuevas peticiones manden 
los valores calculados por el codigo. no llega a ser un proceso complejo y permite eslara el poryecto de un amanera muy elevada. las dificulades relacionadas con esto seria el de continuar empleando los procesos de validacion de usarios para cada uno de estps nuevos servicios que se ofrecerian en el servicio como adiciones. Gracias a esto la escalibilidad es elevada para el proceso desarrollado. 


### Limitaciones: 

la limitacion de este desarrollo es que solo esta definido para dos procesos matematicos especificos, por lo qu esi se desea continuar ocn el desarrollo es necesario extender el proyecto dependiendo del nivel de aumento y reducion de limitaciones que se quier aver para el proyecto.

## Construido con
-   HTML
-   javascript
-   java

### Javadoc: 

generar documentacion:

$ mvn javadoc:javadoc

### Licencia.

Licencia.
