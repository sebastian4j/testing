```

#### JUnit_in_Action_Third_Edition: https://www.manning.com/books/junit-in-action-third-edition

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
