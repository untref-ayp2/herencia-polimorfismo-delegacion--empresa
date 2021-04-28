# herencia-polimorfismo-delegacion--empresa

Demostración del flujo de trabajo con TDD (Test-Driven Development) aplicado a la resolución de un problema que requiere la combinación de: herencia, polimorfismo y delegación.

## Nuestro problema

### Consigna Inicial ("Empleados y Empresa")

Nos contrataron para desarrollar un sistema de gestión de empleados en una empresa. La empresa tiene una lista de todos sus empleados.

Los empleados pueden ser de planta permanente o temporaria. A su vez, los de planta permanente pueden ser gerentes o ser empleados sin ninguna categoría especial. Y los de planta temporaria pueden ser sólo empleados sin categoría especial. Finalmente, los empleados sin categoría especial pueden ser a tiempo completo o a tiempo parcial.

Aclaración: Los gerentes no se categorizan por tiempo completo o tiempo parcial. Eso es solo para los empleados sin categoría especial.


- Se debe implementar el método toString() en las clases que correspondan, de modo que al listar todos los empleados de la empresa se muestre el nombre, apellido, y tipo de empleado.
- La empresa debe poder agregar nuevos empleados y listar todos sus empleados.

Por ejemplo:

Ana García: Gerente. Planta Permanente
Pedro Perez: empleado/a a tiempo completo. Planta transitoria
María López: empleado/a a tiempo parcial. Planta permanente

- Resolver usando POO.
- Incluir:
-- una clase Demo con un main donde se muestre la funcionalidad solicitada (crear los empleados, agregarlos a la lista de empleados y listar todos los empleados).
-- un conjunto de pruebas de cada una de las clases desarrolladas, y
-- el diagrama de clases correspondiente (no hace falta incluir la clase Demo en el diagrama).

### Consigna expandida ("Empleados y Empresa, recargado")

_(Nota importante: Para resolver este desafío es importante primero asegurarse que el desafío anterior está bien hecho, si tienen dudas consulten a la Cátedra.)_

Dada la realidad anterior, se nos solicita implementar la liquidación de sueldos.
Debemos implementar el método liquidarSueldo() en la clase Empresa. Este método:
- calcula **polimórficamente** el sueldo de cada empleado, y
- muestre por pantalla el listado de empleados con su correspondiente sueldo.

El sueldo de cada empleado se calcula de acuerdo a su categoría (permanente/temporaria).
Todos los empleados de planta permanente tienen un sueldo básico consistente en 1000 unidades retributivas o UR (el valor de la unidad retributiva se actualiza mensualmente).

- En el caso de los empleados en planta permanente a tiempo completo, al sueldo básico se le suma salario familiar (200 UR por cada hijo y 100 UR por conyugue) y antigüedad (100 UR por año cumplido hasta un tope de 2000 UR).

- En el caso de los empleados en planta permanente a tiempo parcial, el sueldo se calcula como 1/3 del sueldo básico, más la cantidad de horas trabajadas en el mes a un valor de 10 UR la hora (con un tope de 1000 UR, es decir si 1/3 del básico mas la cant. de horas x 10 UR supera 1000 UR se toma sólo 1000 UR), más salario familiar y antigüedad como en el caso de los empleados a tiempo completo.

- En el caso de los gerentes, su sueldo se calcula como el de un empleado a tiempo completo y se le suma un adicional fijo por personal a cargo de 2000 UR.

- En el caso de los empleados en planta temporaria, el sueldo se calcula igual que en el caso de empleados en planta permanente pero no cobran el adicional por antigüedad.

- Resolver usando POO.
- Incluir:
-- una clase Demo con un main donde se muestre la funcionalidad solicitada (crear los empleados con todos los datos necesarios para poder calcular su sueldo, agregarlos a la lista de empleados y liquidarSueldo de todos los empleados).
-- el valor de la UR se debe poder modificar desde Demo.
-- un conjunto de pruebas de cada una de las clases desarrolladas, y
-- el diagrama de clases correspondiente (no hace falta incluir la clase Demo en el diagrama).

## Uso

Clonar este repositorio y seguir el desarrollo con alguna herramienta que permita avanzar y retroceder a través de los commits, tal como [Git-Time-Machine](https://github.com/littlebee/git-time-machine).

### Cómo clonar este repo

```
git clone https://github.com/untref-ayp2/herencia-polimorfismo-delegacion--empresa
```

## Acerca de la Solución Propuesta

Se propone una solución **parcial** en la rama `main`. Dicha propuesta sólo incluye los aspectos esenciales a la solución. Queda como ejercicio para quien lea esto completarla.
También se incluyen ramas adicionales para las resoluciones parciales, por si alguien desea trabajar exclusivamente en la segunda parte del ejercicio.

## Agradecimientos

Se agradece especialmente a Lucas Videla (@delucas) por la puntillosa revisión de borradores de este repo. Tambíen se le agradece a Santiago Rojo (@tiagox) por sus valiosos comentarios.

## Licencia

Copyleft © 2021, Leandro Doctors.

Este programa es Software Libre: puede redistribuirse y/o modificarse bajo los términos de la Licencia Apache, ya sea la versión 2 de la Licencia, o (a libre elección) cualquier versión posterior publicada por la Apache Software Foundation.

Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA; incluso sin la garantía implícita de COMERCIABILIDAD o ADECUACIÓN PARA UN PROPÓSITO PARTICULAR. Leer la Licencia Apache para más detalles.

En este repo hay disponible una copia de la Licencia Apache. Si no, ver <http://www.apache.org/licenses/LICENSE-2.0>.
