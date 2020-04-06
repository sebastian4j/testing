## JUnit_in_Action_Third_Edition: https://www.manning.com/books/junit-in-action-third-edition
```
- inner class annotated as @Nested that contains one or more test methods
- test method: @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, or @TestTemplate
- life cycle method: @BeforeAll, @AfterAll, @BeforeEach, or @AfterEach
- todos los test en la misma instancia: @TestInstance(Lifecycle.PER_CLASS)
- por defecto cada test method crea una nueva instancia
- @BeforeAll: ejecutado antes de todos los test, tiene que ser ESTATICO a menos que se ocupe @TestInstance(Lifecycle.PER_CLASS).
- @BeforeEach: antes de cada test
- @AfterEach: despues de cada test
- @AfterAll: ejecutado despues de todos los test, tiene que ser estatico a menos que se ocupe @TestInstance(Lifecycle.PER_CLASS).
- @DisplayName: nombre desplegado en el metodo de test (por defecto es el nombre del metodo)
- @Disabled: omite clases o metodos, acepta una descripcion.
- @Tag("txt"): permite agrupar metodos o clases con tags para luego filtrarlos
- org.junit.jupiter.api.Assumptions: verificaciones del entorno necesarias para poder ejecutar los test (usado para prevenir que se ejecuten los test bajo ciertas circunstancias del entorno)
- ParameterResolver: resuelve parametros en runtime, hay 3 resolvers por defecto usando @ExtendWith se pueden registrar otros.
: TestInfo
    @Test, @BeforeEach, @AfterEach, @BeforeAll & @AfterAll
: TestReporter
    @BeforeEach, @AfterEach & @Test
: RepetitionInfo
    @RepeatedTest

```
- A JUnit 4 runner is responsible for running JUnit tests (class that extends the JUnit 4 abstract Runner). 
Extensions are the JUnit 5 equivalent. 
xej: podría ejecutar código antes o despues de los test


- JUnit 4 rule es un componente que intercepta llamadas a test, permite hacer algo antes que un test corra
y algo despues que el test corra (especificos a JUnit 4).
JUnit 5 obliga a implementar extensions

- @Rule: public nonstatic field or a public nonstatic method

- TemporaryFolder: permite crear archivos y carpetas que deben ser borradas cuando el test termine (pase o falle)

- JUnit 5 platform --- JUnit 5 Jupiter --- JUnit 5 Vintage


```
junit-      junit-       junit-             junit-platform-   IDEs
platform-   platform-    platform-          gradle-plugin
runne       console      surefire-provider
  V           V             V                   V              V
_____________________________________________________________________
junit-platform-launcher
---------------------------------------------------------------------
        V
_______________________________
junit-platform-engine
-------------------------------
    V         V            V
|junit  |  |junit  |  |custom-engine|
|vintage|  |jupiter|       V
|engine |  |engine |    custom-api
   V             V
junt-4.12     junit-jupiter-api
```

```
anotaciones
@BeforeClass, @AfterClass -> @BeforeAll, @AfterAll
@Before, @After -> @BeforeEach, @AfterEach
@Ignore -> @Disable
@Category -> @Tag

Assertions
Assert -> Assertions
assertThat -> assertAll, assertThrows.

Assumptions
Assume -> Assumptions
assumeNotNull and assumeNoException -> removidos

mensaje al principiio -> mensaje al final
```
@RunWith(MockitoJUnitRunner.class) -> @ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class) -> @ExtendWith(SpringExtension.class)


### Tipos de Test doubles
Dummy: se ocupan de relleno, no intervienen en la funcionalidad que se está probando (argumentos en firmas de métodos)
Fake: implementaciones de componentes de la app que funcionan y son operativas pero no son adecuados de desplegar en producción, solo tienen que ser usados en ámbito de test (bd en memoria x reemplazo de una real en test)
Stubs: respuestas predefinidas que se ofrecen como resultado a llamadas, importanta solo el estado retornado no como fue obtenido (relacion con otras entidades). (Json respondido de un servicio)
Mocks: son capaces de analizar como se relacionan los distintos componentes, permiten verificar si un metodo concreto ha sido invocado, que parametros recibió, cuantas veces se invoco, … su foco es el analisis del comportamiento, como fue el paso de los mensajes



