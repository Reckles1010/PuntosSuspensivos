# ⚡ CRM Puntos Suspensivos

---

Bienvenido al repositorio oficial de **Puntos Suspensivos**, un sistema CRM centralizado diseñado específicamente para optimizar la gestión operativa, el control de inventario y la administración de relaciones con clientes de una librería. El sistema permite gestionar de manera integral el stock de libros, sus respectivos autores, los clientes de la librería, los usuarios del sistema (vendedores) y la disponibilidad del inventario integrando Programación(Java), Base de Datos(Oracle PL/SQL y MySQL Server), Diseño Web(HTML, CSS, JavaScript). 

Este proyecto nace con el objetivo de ofrecer una solución integral, ágil y estructurada para que tanto el personal de ventas como la administración puedan llevar un control absoluto del flujo comercial del negocio.

## ✨ Características Principales

El sistema permite interactuar y gestionar de forma eficiente los siguientes módulos:

* **Gestión de Stock:** Control en tiempo real del inventario de libros, permitiendo altas, bajas y modificaciones de títulos.
* **Disponibilidad Automatizada:** Indicadores visuales y lógicos sobre si un artículo se encuentra en almacén o listo para la venta.
* **Control de Autores:** Organización detallada de los escritores, vinculando directamente sus perfiles con sus respectivas obras.
* **Gestión de Clientes:** Registro de compradores, historial de interacciones y datos de contacto para fidelización.
* **Roles de Usuario (Vendedores):** Sistema de accesos para el equipo de ventas, permitiendo trazar qué vendedor realiza cada operación.

* **Base de Datos:** Se trata del motor de almacenamiento del sistema. El diseño original y la lógica de negocio en PL/SQL se ejecutan sobre Oracle Database, mientras que para la aplicación Java se migró el modelo a MySQL. El script incluye pruebas automatizadas para: Operaciones CRUD (Creación, Lectura, Modificación y Eliminación de registros).

* **Aplicación de Consola:** Una aplicación de consola construida bajo el paradigma de la Programación Orientada a Objetos (POO), arquitectura en capas (Controller-Service-Repository) y acceso a datos mediante JDBC. Localiza la clase principal Main.java (o la que contenga el método main). Haz clic en Run. Se desplegará un menú interactivo en la consola que te permitirá: Navegar mediante opciones programadas ante excepciones.  Realizar un CRUD completo sobre las entidades del sistema de la librería.
* **Aplicación Web:** Una interfaz dinámica, responsive y maquetada con la metodología BEM, que procesa la lógica de negocio en cliente mediante JavaScript y mantiene el estado de la sesión mediante SessionStorage. 

---

## 🛠️ Requisitos Previos 

Antes de comenzar, asegúrate de tener instalado en tu máquina local:

*Guía completa de instalación, despliegue y operación del sistema multiplataforma CRM orientado a la gestión de clientes, usuarios, catálogo de libros y flujos de venta en tiempo real:*
* **Backend:**
1. **Java Development Kit (JDK) Versión 21:** Para poder clonar, configurar y ejecutar este proyecto de forma local, asegúrate de tener instalado el siguiente software en tu entorno.
2. **IntelliJ IDEA:** Versión 2023.x / 2024.x o superior (compatible con Java 21).

* **Frontend:** 
1. **Visual Studio Code:** Configurado con extensiones para desarrollo web.
2. **Gestores de Bases de Datos:** Oracle SQL Developer y MySQL Server.

* **Base de Datos:**
1. **Cliente SQL:** DBeaver, MySQL Workbench o PL/SQL Developer.
2. **MySQL Server:** Versión 8.0 o superior operando en el puerto estándar `3307` (o instancia de Oracle Database).

---

## Resumen de Aplicación Web y Modelo de Datos y Relaciones

### 🌐 Aplicación Web (Frontend - JavaScript)
La aplicación web simula el entorno visual interactivo del CRM en el lado del cliente (sin persistencia en base de datos). Abre la carpeta /web-frontend con Visual Studio Code.Haz clic derecho sobre el archivo index.html y selecciona Open with Live Server (o simplemente arrastra el archivo a cualquier navegador web moderno). Uso de SessionStorage: Puedes realizar operaciones CRUD en las tablas de la interfaz y navegar libremente entre las páginas del portal; notarás que los datos no se pierden gracias al almacenamiento de sesión (SessionStorage). Si se cierra el navegador por completo, el sistema se reiniciará a su estado por defecto. 

### 📐 Modelo de Datos y Relaciones
El núcleo transversal de datos está diseñado en torno al flujo comercial de la librería, estructurándose de la siguiente forma a través de 5 entidades principales: CLIENTES: Almacena los datos de los compradores de libros. USUARIOS: Registra las cuentas del personal/vendedores de la librería y sus roles en el CRM. LIBROS: Inventario físico de libros (Stock, descripción y precio). AUTORES: Registro de autores. CATERGORÍAS: Registra a que categoría pertenece cada libro. VENTAS: Cabecera que asocia una transacción efectuada por un Cliente y gestionada por un Usuario/Comercial. DETALLE_VENTA: Tabla intermedia que rompe la relación N:M entre Ventas y Productos, permitiendo desglosar la cantidad y el precio unitario de cada libro vendido.

---

## 🗄️ 1. Configuración de la Base de Datos (MySQL)

El proyecto cuenta con dos entornos de base de datos de acuerdo a los requerimientos del módulo. Sigue estos pasos para levantar el esquema de persistencia desde cero:

### Paso 1: Inicialización del Esquema
1. Abre **DBeaver** o **MySQL Workbench** y conéctate a tu servidor local de MySQL.
2. Abre un nuevo editor SQL.
3. Copia el contenido de los archivos estructurados ubicados en el directorio `/BaseDatos/DDL.sql` y `/BaseDatos/DML.sql` del proyecto y pégalo en el editor.
4. Las tablas son CLIENTES, USUARIOS, VENTAS, LIBROS, AUTORES, CATEGORÍAS y DETALLE_VENTA.

### Paso 2: Ejecución Completa
* Para asegurar que el script procese todas las instrucciones secuencialmente sin conflictos de dependencias, puedes ejecutar la sentencia actual usando **`Control + Enter`** o el script completo usando la combinación de teclas **`Alt + X`** en DBeaver (o el botón *Execute SQL Script*).

### Paso 3: Verificación de Tablas e Integridad
Haz un refresco (`F5`) sobre el árbol de navegación izquierdo y valida la existencia de las siguientes 7 entidades:
* `usuarios` (Personal administrativo/vendedores del CRM)
* `clientes` (Compradores y entidades destino)
* `autores` y `categorias` (Catálogos maestros)
* `libros` (Inventario físico con control de stock y precios decimales)
* `ventas` y `detalle_venta` (Transacciones financieras con integridad referencial)

---

## 🗄️ 2. Configuración de la Base de Datos en PL/SQL Developer

Si prefieres desplegar el entorno o revisar el diseño lógico original utilizando **PL/SQL Developer** conectado a una instancia de Oracle Database, sigue estos pasos secuenciales:

### Paso 1: Establecer la Conexión
1. Abre **PL/SQL Developer**.
2. En la ventana de inicio de sesión (*Logon*), introduce tus credenciales de Oracle:
   * **Username:** `user1`
   * **Password:** `1234`
   * **Database:** Nombre del servicio de tu base de datos (ej. `XE`, `ORCL` o el alias de tu archivo `tnsnames.ora`).
   * **Connect as:** Selecciona `Normal` (o `SYSDBA` si vas a crear el usuario/esquema desde cero).

### Paso 2: Ejecución del Script de Estructura (DDL y DML)
Para insertar las tablas y datos en este entorno, evitamos usar una ventana SQL estándar de consultas debido al procesamiento de múltiples bloques. En su lugar:
1. Ve al menú superior y selecciona **File > New > Command Window**.
2. Copia el código SQL original con sintaxis Oracle (el que utiliza `NUMBER`, `VARCHAR2` y `GENERATED ALWAYS AS IDENTITY`).
3. Pega el código dentro de la **Command Window** y presiona `Enter`.
4. **¡Importante!** Al finalizar las inserciones, ejecuta el comando `COMMIT;` en la ventana para asegurar que los datos queden grabados permanentemente.

### Paso 3: Verificación en el Object Browser
1. Despliega el panel **Object Browser** (izquierda).
2. Selecciona el filtro `My objects` en el desplegable superior.
3. Expande la carpeta **Tables** y verifica las 7 entidades del CRM (`USUARIOS`, `CLIENTES`, `AUTORES`, `CATEGORIAS`, `LIBROS`, `VENTAS`, `DETALLE_VENTA`).
---
### 3. Configuración de la Aplicación Java (IntelliJ)
Abre IntelliJ IDEA y selecciona Open para cargar la carpeta del proyecto Java ubicada en /java-crm-app.Asegúrate de añadir el conector JDBC de MySQL (mysql-connector-j) a las librerías del proyecto (Project Structure > Libraries).Abre el archivo de configuración de conexión (generalmente DatabaseConnection.java o similar) y ajusta las credenciales de tu servidor de MySQL local (usuario y contraseña).## 💻 Instrucciones para Ejecutar cada ParteSigue las siguientes pautas para interactuar con los diferentes módulos evaluables del proyecto: 

---

## 💻 3. Configuración del Proyecto en Java

Para ejecutar el núcleo del programa y levantar la lógica del CRM:

### Paso 1: Importar el Proyecto
1. Abre **IntelliJ IDEA**.
2. Selecciona **File > Open** y navega hasta la carpeta raíz del repositorio.

### Paso 2: Configurar las Dependencias y el Driver JDBC
1. Dirígete a **File > Project Structure** (`Ctrl + Alt + Shift + S`).
2. En **Modules**, pestaña **Dependencies**, haz clic en el botón **`+`** (Plus) y selecciona **JARs or Directories**.
3. Añade el archivo del driver correspondiente (ej. `mysql-connector-j-8.x.x.jar` para MySQL u `ojdbc8.jar` para Oracle) ubicado en la carpeta `/lib`.
4. Configura el **Project SDK** apuntando a Java 21.

### Paso 3: Archivo de Conexión de Base de Datos
Verifica el archivo de conexión a la base de datos llamado DataBaseConnection.java ubicado en el paquete Util. Si usas un puerto para conectarte a MySQL distinto de `3306` cambia ese puerto en el código por el que utilices, aparece en:

```java
    private static final String oracleUrl = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static final String userOracle = "user1";
    
    //! CONEXIÓN MY SQL, CAMBIAR EL PUERTO CUANDO SEA NECESARIO
    private static final String mysqlUrl = "jdbc:mysql://localhost:3306/PuntosSuspensivos";
    
    private static final String userSql = "root";
    
    private static final String password = "1234";

```

---

## 📂 Estructura del Proyecto

```text
CRM-Puntos-Suspensivos/
├── backend-java/                  # APARTADO DE PROGRAMACIÓN
│   ├── lib/                       # Driver MySQL
│   └── src/
│       ├── controller/            # Controladores
│       ├── entitiy/               # Entidades del programa
│       ├── frontend/              # Menú de consola
│       ├── repository/            # Acceso a la base de datos
│       ├── service/               # Gestión de datos
│       └── util/                  # Database connection
├── frontend-web/                  # APARTADO LENGUAJE DE MARCAS
│   ├── css/                       # Estilos (metodología BEM)
│   ├── js/                        # Lógica con JavaScript
│   └── index.html                 # Página principal del CRM
├── database-sql/                  # APARTADO DE BASE DE DATOS
│   ├── mysql/                     # Scripts DDL/DML para MySQL
│   │   ├── ddl.sql
│   │   └── dml.sql
│   └── oracle/                    # Scripts DDL/DML para Oracle
│       ├── ddl.sql
│       └── dml.sql
└── README.md
```
---

## 🤝 Contribuciones
Este proyecto es académico, desarrollado por alumnos de 1º DAM.

Equipo de desarrollo:

[Berta Díaz Flores]
[Carlos Corchado Benito] 
