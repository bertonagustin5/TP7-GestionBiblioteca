
# 📚 TP7 Integrador POO - Gestión de Biblioteca


## 📌 Descripción del proyecto
Trabajo practico integrador de la asignatura **Programación Orientada a Objetos**, desarrollado en **Java** con el entorno **BlueJ.**

El proyecto implementa un **sistema de gestión de biblioteca** que permite administrar libros, socios y prestamos. Existen dos tipos de socios: **Estudiantes** Y **Docentes**, que heredan de la clase abstracta **Socio** y tienen reglas distintas para pedir libros. 

El sistema se maneja desde el **menú por consola** (GesionBiblioteca), que permite cargar datos iniciales, simular prestamos y devoluciones, y realizar distintas consultas. 

El trabajo se realizo de forma **colaborativa**: cada integrante implemento un conjunto de clases del diseño UML entregado por la catedra, y luego se integraron en una aplicación ejecutable común.

### Funcionalidades principales

- Registrar libros y socios (estudiantes y docentes) de la biblioteca.
- Gestionar préstamos y devoluciones de libros.
- Verificar préstamos vencidos.
- Controlar las condiciones de préstamo segun el tipo de socio.
- Consultar qué socio tiene pestado un libro determinado (con manejo de excepciones si el libro no esta prestado)
- Generar listados de libros, socios y docentes responsables.
- Contar socios por tipo.


## 🎯 Objetivo

## Objetivo General

Integrar los conocimientos adquiridos durante la asignatura mediante el desarrollo colaborativo de una aplicación orientada a objetos, respetando el diseño UML proporcionado por la catedra 

## Objetivos especificos
- Aplicar los conceptos de **encapsulamiento**, **herencia** y **polimorfismo** (clase abstracta Socio y sus subclases)
- Utilizar **colecciones** (ArrayList) para modelar las relaciones entre biblioteca. socios, libros y prestamos.
- Manejar situaciones excepcionales mediante excepciones propias (libroNoPrestadoExcepcion).
- Trabajar con fechas utilizando **Calendar** y **GregorianCalendar**
- Practicar el trabajo en equipo con Git, GitHub y Trello.

## 🛠️ Tecnologías utilizadas

| categoría | herramienta |
|---|---| 
| Lenguaje | Java |
| IDE | BlueJ |
| Control de Versiones | Git y GitHub |
| Gestión de tareas | Trello | 


## 👥 Distribucion de clases
| Subgrupo | Integrante/s | Clases |
|---|---|---|
| 1 | Berton Agustin | Prestamo, Socio |
| 2 | Gonzalez Avril Araceli | Estudiante, Docente |
| 3 | Balenzuela Tobias | Libro |
| 4 | Acevedo Horacio, Fernandez Zalazar Jeremias, Rodriguez Martemucci Lucciana | Biblioteca |
| Todos | Los 6 | GestionBiblioteca |

## Descripcion de las Clases 

| Clase | Rol dentro del sistema |
|---|----|
| Biblioteca | Clase central: administra las colecciones de socios y libros, y ofrece las operaciones de préstamo, devolución y consulta. |
| Socio | Clase abstracta que representa a un socio (DNI, nombre, días de préstamo, préstamos). Define puedePedir() y el método abstracto soyDeLaClase(). |
| Estudiante | 	Subclase de Socio. Agrega la carrera y limita la cantidad de libros prestados. |
| Docente | 	Subclase de Socio. Agrega el área, permite cambiar los días de préstamo y determina si es responsable (esResponsable()).|
|Libro | Representa un libro (título, edición, editorial, año) y su historial de préstamos. |
| Prestamo | Registra un préstamo: fecha de retiro, fecha de devolución, socio y libro. Permite saber si está vencido. |
| lbroNoPrestadoException | Excepción propia que se lanza cuando se consulta o devuelve un libro que no está prestado. |
| Menu | Clase auxiliar para mostrar menús por consola. |
|GestionBiblioteca | 	Clase ejecutable (main) con el menú principal del sistema.|

## 📂 Estructura del proyecto

```text
TP7-GestionBiblioteca/
│
├── biblioteca/
│   ├── Prestamo.java
│   ├── Socio.java
│   ├── Estudiante.java
│   ├── Docente.java
│   ├── Libro.java
│   ├── Biblioteca.java
│   ├── LibroNoPrestadoException.java
│   └── GestionBiblioteca.java
│
└── README.md
```
*##Documentación

El código está documentado con Javadoc. Para generarla desde BlueJ: Herramientas > Documentación del proyecto.
