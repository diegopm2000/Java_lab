# Laboratorios de Java

### Repositorio principal de laboratorios de Java de propósito General.

A continuación se detallan los pasos para instalar un entorno de ejecución y desarrollo en Linux Ubuntu

### Instalación de la Máquina Virtual de Java Oracle 8

- Instalación de la Máquina Virtual de Java Oracle 8

Hay que hacer lo siguiente:

```shell
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
```

Comprobamos si ha tenido éxito:

```shell
$ java -version

java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)

```


### Instalación de Eclipse Neon

#### 1. Donde obtener el instalable

En el siguiente enlace encontramos la página de descarga del instalador de Eclipse Neon:

https://eclipse.org/downloads/

Pulsando en el enlace nos descarga un instalador para nuestro sistema operativo, que en nuestro caso es:

eclipse-inst-linux64.tar.gz

#### 2. Descomprimimos la carpeta y ejecutamos el instalador

```shell
./eclipse-inst-linux64
```

Nos abrirá una ventana donde se nos pide escoger la versión a instalar. Elegimos la versión:

*Eclipse IDE for Java EE developers*

Se nos pide un directorio de instalación. Dejamos el que aparezca por defecto:

*/home/user/eclipse/jee-neon*

Y pulsamos el botón de __Install__

Comenzará el proceso de descarga e instalación del programa. Tarda un tiempo en función de la velocidad de la conexión y de nuestro ordenador. Cuando nos pregunte por la licencia, la aceptamos.

#### 3. Elección del workspace

Una vez instalado, se nos pide que elijamos el workspace:

*/home/user/workspace/laboratorios/java_lab*

Cuando esté arrancado ya podemos cerrarlo.

#### 4. Modificaciones para Ubuntu 16.04

Nos falta ahora hacer una serie de modificaciones para que nos aparezca el icono en la barra del lanzador de Ubuntu.

En un terminal escribimos:

```shell
$ gedit .local/share/applications/eclipse.desktop
```

en el fichero que se abre, copiamos esto:

```code
[Desktop Entry]
Name=Eclipse
Type=Application
Exec=/home/user/eclipse/jee-neon/eclipse/eclipse
Terminal=false
Icon=/home/user/eclipse/jee-neon/eclipse/icon.xpm
Comment=Integrated Development Environment
NoDisplay=false
Categories=Development;IDE;
Name[en]=Eclipse
```

Además, en el caso de Ubuntu 16 hay que editar el fichero eclipse.ini que se encuentra en el directorio de instalación de Eclipse:

```shell
$ gedit /home/user/eclipse/jee-neon/eclipse/eclipse.ini
```

Añadimos esto:

```code
--launcher.GTK_version
2
```

justo encima de la línea

```code
--launcher.appendVmargs
```

Al arrancar ahora el Eclipse, si todo ha ido bien nos debería aparecer el icono de Eclipse en el lanzador.
