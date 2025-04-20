# FiscalAPI SDK para Java Spring

[![Maven Central](https://img.shields.io/maven-central/v/com.fiscalapi/fiscalapi)](https://search.maven.org/artifact/com.fiscalapi/fiscalapi)
[![License](https://img.shields.io/github/license/FiscalAPI/fiscalapi-java)](https://github.com/FiscalAPI/fiscalapi-java/blob/main/LICENSE)


Ejemplos del SDK de FiscalAPI para Java Spring, la API de facturación CFDI y otros servicios fiscales en México. Simplifica la integración con los servicios de facturación electrónica, eliminando las complejidades de la autoridad tributaria (SAT) y facilitando la generación de facturas, notas de crédito y complementos de pago, nómina, carta porte, etc.

El proyecto consiste en una aplicación Spring Boot que contiene diversos ejemplos para demostrar las diferentes funcionalidades de la API, organizados en controladores REST.

## 🚀 Características

El SDK de FiscalAPI para Java Spring ofrece una amplia gama de funcionalidades para la facturación electrónica en México:

### Facturación CFDI 4.0
- Timbrado de facturas de ingreso
- Timbrado de notas de crédito (facturas de egreso)
- Timbrado de complementos de pago
- Consulta del estatus de facturas en el SAT
- Cancelación de facturas
- Generación de archivos PDF de las facturas
- Personalización de logos y colores en los PDF
- Envío de facturas por correo electrónico
- Descarga de archivos XML

### Gestión de personas
- Administración de personas (emisores, receptores, clientes, usuarios, etc)
- Gestión de certificados CSD (subir archivos .cer y .key a fiscalapi)
- Configuración de datos fiscales (RFC, domicilio fiscal, régimen fiscal)

### Gestion de productos/servicios
- Gestión de productos y servicios
- Administración de impuestos aplicables (IVA, ISR, IEPS)

### Consulta de catalogos SAT
- Consulta en catálogos oficiales del SAT
- Búsqueda de información en catálogos del SAT

### Integración y configuración
- Configuración de ambiente (pruebas o producción)
- Gestión de credenciales y tokens de autenticación
- Respuestas en formato estructurado para fácil procesamiento

## Requisitos previos:

- Java JDK 17 o superior
- Maven 3.6+ o utilizar el Maven Wrapper incluido
- Opcional: VSCode, Eclipse o altamente recomendado **IntelliJ IDEA**

## Configuración del entorno

### 1. Instalar Java JDK 17

Es necesario instalar Java JDK 17 o superior para ejecutar este proyecto.

#### Opción A: Descargar JDK
Puedes descargar OpenJDK 17 desde: [Microsoft](https://learn.microsoft.com/en-us/java/openjdk/download#openjdk-17)

#### Opción B: Instalación mediante winget (Windows)

```bash
winget install Microsoft.OpenJDK.17
```

### 2. Clonar el repositorio

```bash
git clone https://github.com/FiscalAPI/fiscalapi-samples-spring.git
cd fiscalapi-samples-spring
```

### 3. Configurar propiedades de la aplicación

Crea un archivo `application.properties` en la carpeta `src/main/resources` basado en el archivo de ejemplo:

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Edita el archivo `application.properties` y configura tus [credenciales](https://docs.fiscalapi.com/credentials-info):

```properties
fiscalapi.api-url=https://test.fiscalapi.com
fiscalapi.api-key=tu_api_key
fiscalapi.tenant=tu_tenant_key
```

Reemplaza `tu_api_key` y `tu_tenant_key` con tus [credenciales](https://docs.fiscalapi.com/credentials-info) obtenidas del portal de FiscalAPI.

### 4. VSCode settings (IntelliJ IDEA resuelve esto automaticamente)

Si utilizas Visual Studio Code, crea o actualiza el archivo `.vscode/settings.json` con el siguiente contenido:

```json
{
    "java.configuration.updateBuildConfiguration": "automatic",
    "java.home": "C:\\jdk-17.0.14",
    "maven.executable.path": "mvnw.cmd",
    "java.project.referencedLibraries": [ "lib/**/*.jar"],
    "java.compile.nullAnalysis.mode": "automatic"
}
```

**Importante**: Ajusta la ruta `java.home` a la ubicación donde instalaste el JDK 17 en tu sistema.

## Compilar y ejecutar el proyecto

### 5. VSCode variables entorno (IntelliJ IDEA resuelve esto automaticamente)

Configurar el JDK temporalmente para la terminal actual de vscode:

```powershell
$env:JAVA_HOME = "C:\jdk-17.0.14"
$env:Path += ";$env:JAVA_HOME\bin"
```

Asegúrate de ajustar la ruta a la ubicación donde instalaste el JDK 17 en tu sistema.

### Ejecuta Usando Maven Wrapper

#### En Windows:

```bash
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
```

#### En macOS/Linux:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

### Ejecuta Usando Maven instalado en el sistema

#### En Windows:

```bash
mvn clean install
mvn spring-boot:run
```

#### En macOS/Linux:

```bash
mvn clean install
mvn spring-boot:run
```

### Ejecuta: Desde un IDE

1. Importa el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, etc.)
2. Asegúrate de que el IDE esté configurado para utilizar JDK 17
3. Ejecuta la clase `FiscalapiSamplesSpringApplication` como una aplicación Java

## Acceso a los ejemplos

Una vez que la aplicación esté en ejecución, puedes acceder a:

- **Documentación Swagger UI**: Disponible en `http://localhost:8080/swagger-ui/index.html`

### Ejemplos disponibles

La aplicación contiene varios controladores que muestran diferentes funcionalidades:

- `InvoicesController`: Ejemplos de timbrado de facturas, consultas y cancelaciones
- `ProductController`: Ejemplos de gestión de productos y servicios

Consulta la documentación Swagger para ver todos los endpoints disponibles y probarlos interactivamente.

## Estructura del proyecto

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/fiscalapi/samples/spring
│   │   │       ├── FiscalapiSamplesSpringApplication.java
│   │   │       ├── config
│   │   │       │   ├── FiscalApiConfig.java
│   │   │       │   └── SwaggerConfig.java
│   │   │       ├── controller
│   │   │       │   ├── InvoicesController.java
│   │   │       │   └── ProductController.java
│   │   │       └── service
│   │   │           └── ProductService.java
│   │   └── resources
│   │       └── application.properties
└── pom.xml
```

## Solución de problemas

Si encuentras errores relacionados con la compilación o ejecución del proyecto:

1. Verifica que estás utilizando Java JDK 17 o superior
   - Puedes comprobar la versión con `java -version`
2. Asegúrate de que Maven esté correctamente instalado o utiliza el Maven Wrapper incluido
   - Puedes comprobar la versión de Maven con `mvn -version` o `.\mvnw.cmd -version`
3. Verifica que el archivo `application.properties` exista y contenga las credenciales correctas
4. Si utilizas una versión anterior del SDK, actualiza a la última versión en el archivo `pom.xml`
5. Si estás en Windows y usas PowerShell, asegúrate de ejecutar los comandos con `.\mvnw.cmd` en lugar de solo `mvnw`
6. Revisa la documentación oficial de FiscalAPI para más información

## 🤝 Contribuir

1. Haz un fork del repositorio.
2. Crea una rama para tu feature: `git checkout -b feature/AmazingFeature`
3. Realiza commits de tus cambios: `git commit -m 'Add some AmazingFeature'`
4. Sube tu rama: `git push origin feature/AmazingFeature`
5. Abre un Pull Request en GitHub.

## 🐛 Reportar Problemas

1. Asegúrate de usar la última versión del SDK.
2. Verifica si el problema ya fue reportado.
3. Proporciona un ejemplo mínimo reproducible.
4. Incluye los mensajes de error completos.

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia **MPL**. Consulta el archivo [LICENSE](LICENSE.txt) para más detalles.

## 🔗 Enlaces Útiles

- [Documentación Oficial](https://docs.fiscalapi.com)
- [Como obtener mis credenciales](https://docs.fiscalapi.com/credentials-info)
- [Portal de FiscalAPI](https://fiscalapi.com)
- [Sdk Java](https://github.com/FiscalAPI/fiscalapi-java)
- [Soporte técnico](https://fiscalapi.com/contact-us)
- [Certificados prueba](https://docs.fiscalapi.com/tax-files-info)
- [Más ejemplos Java](https://github.com/FiscalAPI/fiscalapi-samples-spring/blob/main/src/main/java/com/fiscalapi/samples/spring/AllSamples.java)
---

Desarrollado con ❤️ por [Fiscalapi](https://www.fiscalapi.com)
