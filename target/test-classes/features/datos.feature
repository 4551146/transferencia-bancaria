Feature: Formulario de datos
  Scenario: Completar datos del formulario
    Given que el usuario está en el formulario de completar datos
    When completa los siguientes datos:
      | campo    | valor         |
      | nombre   | Carla         |
      | apellido | Soto          |
      | email    | carla@qa.com  |
      | edad     | 35            |
    Then debería imprimir cada valor en consola