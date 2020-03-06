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

```


