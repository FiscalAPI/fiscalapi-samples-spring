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

## Requisitos previos de este ejemplo:

- Java JDK 17 o superior
- Maven 3.6+ o utilizar el Maven Wrapper incluido
- Opcional: IntelliJ IDEA o Eclipse para una mejor experiencia de desarrollo

## Configuración del entorno

### 1. Clonar el repositorio

```bash
git clone https://github.com/FiscalAPI/fiscalapi-samples-spring.git
cd fiscalapi-samples-spring
```

### 2. Configurar propiedades de la aplicación

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

## Compilar y ejecutar el proyecto

### Opción 1: Usando Maven

#### En Windows:

```bash
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

#### En macOS/Linux:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

### Opción 2: Desde un IDE

1. Importa el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, etc.)
2. Ejecuta la clase `FiscalapiSamplesSpringApplication` como una aplicación Java

## Acceso a los ejemplos

Una vez que la aplicación esté en ejecución, puedes acceder a:

- **API REST**: Disponible en `http://localhost:8080/api/`
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
2. Asegúrate de que Maven esté correctamente instalado o utiliza el Maven Wrapper incluido
3. Verifica que el archivo `application.properties` exista y contenga las credenciales correctas
4. Si utilizas una versión anterior del SDK, actualiza a la última versión en el archivo `pom.xml`
5. Revisa la documentación oficial de FiscalAPI para más información

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

---

Desarrollado con ❤️ por [Fiscalapi](https://www.fiscalapi.com)