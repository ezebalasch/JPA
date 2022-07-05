# JPA

![Book Lover_Two Color (1)](https://user-images.githubusercontent.com/64716417/177235945-b6b47b21-5263-41ad-9ec6-7e1c39496996.svg)

<h2>1_ Sistema de Guardado de una Librería</h2>

El objetivo de este ejercicio es el desarrollo de un sistema de guardado de libros en JAVA
utilizando una base de datos MySQL y JPA como framework de persistencia.

<h4>Creación de la Base de Datos MySQL:</h4>

Lo primero que se debe hacer es crear la base de datos sobre el que operará el sistema de
reservas de libros. Para ello, se debe abrir el IDE de base de datos que se está utilizando
(Workbench) y ejecutar la siguiente sentencia:

<h3>CREATE DATABASE libreria</h3>

De esta manera se habrá creado una base de datos vacía llamada librería.
Paquetes del Proyecto Java:

Los paquetes que se utilizarán para este proyecto son los siguientes:

    Ø entidades: en este paquete se almacenarán aquellas clases que se quiere persistir en la base de datos.

    Ø servicios: en este paquete se almacenarán aquellas clases que llevarán adelante la lógica del negocio. En general se crea un servicio para administrar las operaciones CRUD (Create, Remove, Update, Delele) cada una de las entidades y las consultas de cada entidad.

Nota: En este proyecto vamos a eliminar entidades, pero no es considerado una buena
practica. Por esto, además de eliminar nuestras entidades, vamos a practicar que nuestras
entidades estén dados de alta o de baja. Por lo que las entidades tendrán un atributo alta
booleano, que estará en true al momento de crearlas y en false cuando las demos de baja,
que sería cuando se quiere eliminar esa entidad.

![image](https://user-images.githubusercontent.com/64716417/177236558-611d6636-b57f-458c-87dc-274098fa9b48.png)

<h4>a) Entidades

Crearemos el siguiente modelo de entidades:

![image](https://user-images.githubusercontent.com/64716417/177236590-6ceab146-61ce-439a-8b6b-60962203d419.png)


<h4>Entidad Libro</h4>

La entidad libro modela los libros que están disponibles en la biblioteca para ser
prestados. En esta entidad, el atributo “ejemplares” contiene la cantidad total de
ejemplares de ese libro, mientras que el atributo “ejemplaresPrestados” contiene
cuántos de esos ejemplares se encuentran prestados en este momento y el atributo
“ejemplaresRestantes” contiene cuántos de esos ejemplares quedan para prestar.

<h4>Entidad Autor</h4>

La entidad autor modela los autores de libros.

<h4>Entidad Editorial</h4>

La entidad editorial modela las editoriales que publican libros.

<h4>b) Unidad de Persistencia</h4>

Para configurar la unidad de persistencia del proyecto, se recomienda leer el Instructivo
Unidad de Persistencia recuerde hacer click con el botón derecho sobre el proyecto y
seleccionar nuevo. 

<h4>Base de Datos</h4>

Para este proyecto nos vamos a conectar a la base de datos Librería, que creamos
previamente.

<h4>Generación de Tablas</h4>

La estrategia de generación de tablas define lo que hará JPA en cada ejecución, si debe
crear las tablas faltantes, si debe eliminar todas las tablas y volver a crearlas o no hacer
nada. Recomendamos en este proyecto utilizar la opción: “Create”

<h4>Librería de Persistencia</h4>

Se debe seleccionar para este proyecto la librería “EclipseLink”.

<h4>c) Servicios</h4>

<h4>AutorServicio</h4>

Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para administrar autores (consulta, creación, modificación y eliminación).

<h4>EditorialServicio</h4>

Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para administrar editoriales (consulta, creación, modificación y eliminación)

<h4>LibroServicio</h4>

Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para administrar libros (consulta, creación, modificación y eliminación).

<h4>d) Main</h4>

Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para interactuar con el usuario. En esta clase se muestra el menú de opciones con las
operaciones disponibles que podrá realizar el usuario.

<h4>e) Tareas a Realizar</h4>

Al alumno le toca desarrollar, las siguientes funcionalidades:

<h4>1) Crear base de datos Librería</h4>

<h4>2) Crear unidad de persistencia</h4>

<h4>3) Crear entidades previamente mencionadas ( excepto Préstamo )</h4>

<h4>4) Generar las tablas con JPA</h4>

<h4>5) Crear servicios previamente mencionados.</h4>

<h4>6) Crear los métodos para persistir entidades en la base de datos librería</h4>

<h4>7) Crear los métodos para dar de alta/bajo o editar dichas entidades.</h4>

<h4>8) Búsqueda de un Autor por nombre.</h4>

<h4>9) Búsqueda de un libro por ISBN.</h4>

<h4>10) Búsqueda de un libro por Título.</h4>

<h4>11) Búsqueda de un libro/s por nombre de Autor.</h4>

<h4>12) Búsqueda de un libro/s por nombre de Editorial.</h4>

<h4>13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:</h4>

<h4>    • Validar campos obligatorios.</h4>
    
<h4>    • No ingresar datos duplicados.</h4>
