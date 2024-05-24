# Controlar las Ventas en la Tienda de Pepito Pérez

## Administrar Clientes

**Requerimiento Funcional:**
El sistema debe permitir la gestión completa de los clientes que compran en la tienda de Pepito Pérez. Esto incluye la capacidad de crear, leer, actualizar y eliminar registros de clientes. Además, debe ofrecer funcionalidades para buscar clientes por diversos criterios, como nombre, correo electrónico o teléfono.

**Posibles Atributos:**
- **ID de Cliente:** Identificador único del cliente.
- **Nombre Completo:** Nombre y apellidos del cliente.
- **Correo Electrónico:** Dirección de correo del cliente.
- **Teléfono:** Número de contacto del cliente.
- **Dirección:** Domicilio del cliente.
- **Fecha de Registro:** Fecha en la que se registró el cliente.
- **Historial de Compras:** Listado de compras realizadas por el cliente.

## Administrar Categorías de los Productos

**Requerimiento Funcional:**
El sistema debe permitir la administración de las categorías en las que se clasifican los productos de la tienda. Esto incluye la capacidad de agregar nuevas categorías, actualizar las existentes, eliminar las que ya no sean necesarias y visualizar todas las categorías disponibles.

**Posibles Atributos:**
- **ID de Categoría:** Identificador único de la categoría.
- **Nombre de la Categoría:** Nombre descriptivo de la categoría.
- **Descripción:** Detalles adicionales sobre la categoría.
- **Fecha de Creación:** Fecha en la que se creó la categoría.
- **Productos Asociados:** Listado de productos que pertenecen a esta categoría.

## Administrar Productos

**Requerimiento Funcional:**
El sistema debe permitir la gestión de los productos disponibles para la venta en la tienda. Esto incluye la capacidad de crear, leer, actualizar y eliminar productos. Además, debe permitir la búsqueda de productos por diferentes criterios y la asociación de estos con sus respectivas categorías.

**Posibles Atributos:**
- **ID de Producto:** Identificador único del producto.
- **Nombre del Producto:** Nombre descriptivo del producto.
- **Descripción:** Descripción detallada del producto.
- **Precio:** Precio de venta del producto.
- **Categoría:** Categoría a la que pertenece el producto.
- **Stock:** Cantidad disponible en inventario.
- **Fecha de Creación:** Fecha en la que se agregó el producto.
- **Proveedor:** Información sobre el proveedor del producto.

## Administrar Facturas

**Requerimiento Funcional:**
El sistema debe permitir la creación, consulta, actualización y eliminación de facturas generadas por las ventas en la tienda. Debe ser capaz de emitir facturas, registrar la fecha de emisión, el cliente asociado y el total de la venta, entre otros detalles relevantes.

**Posibles Atributos:**
- **ID de Factura:** Identificador único de la factura.
- **Número de Factura:** Número secuencial de la factura.
- **Fecha de Emisión:** Fecha en que se emitió la factura.
- **Cliente:** Cliente al que se emitió la factura.
- **Total:** Monto total de la factura.
- **Detalles de la Venta:** Listado de productos y cantidades incluidas en la factura.
- **Método de Pago:** Forma de pago utilizada (efectivo, tarjeta, etc.).

## Administrar Detalle de las Facturas

**Requerimiento Funcional:**
El sistema debe gestionar los detalles específicos de cada factura emitida, lo cual incluye la información sobre cada producto vendido, la cantidad, el precio unitario y el subtotal de cada ítem. Esto permite una mejor descomposición de las ventas y facilita la auditoría de las transacciones.

**Posibles Atributos:**
- **ID de Detalle:** Identificador único del detalle.
- **ID de Factura:** Identificador de la factura a la que pertenece este detalle.
- **Producto:** Producto vendido en esta línea de la factura.
- **Cantidad:** Número de unidades vendidas.
- **Precio Unitario:** Precio por unidad del producto.
- **Subtotal:** Importe total de esta línea (cantidad x precio unitario).

## Administrar el Inventario

**Requerimiento Funcional:**
El sistema debe permitir la gestión del inventario de la tienda, controlando las existencias de cada producto. Esto incluye registrar entradas y salidas de productos, actualizar cantidades disponibles, y generar alertas cuando el stock esté por debajo de un nivel mínimo predefinido.

**Posibles Atributos:**
- **ID de Inventario:** Identificador único del registro de inventario.
- **Producto:** Producto registrado en el inventario.
- **Cantidad Actual:** Cantidad actual disponible en el inventario.
- **Cantidad Mínima:** Cantidad mínima antes de generar una alerta de reabastecimiento.
- **Fecha de Última Actualización:** Fecha en la que se actualizó por última vez el inventario.
- **Historial de Movimientos:** Registro de entradas y salidas de inventario para cada producto.
