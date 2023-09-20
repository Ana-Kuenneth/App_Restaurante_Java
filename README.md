# App_Restaurante_Java - Administracion del menu y pedidos en bar / restaurant
Proyecto desarrollado en JAVA durante el cursado de la materia Programacion II de la carrera Ingenieria en computacion en el anio 2023. Docentes: Luis Nieto, Mariana Sanchez.

*** CASO PRACTICO
Se desea desarrollar una aplicacion para ser usada en un bar. La aplicacion es utilizada
por tres tipos de usuarios: empleados, encargados y clientes. De los usuarios se conoce
su cuenta de correo y clave de acceso a la aplicacion, apellido y nombre. Tener en
cuenta que no puede haber dos usuarios con el mismo correo.
Los encargados pueden crear empleados.
Cada cliente puede hacer pedidos agregando y quitando los productos que desea
solicitar y consultar los pedidos que va haciendo. Al crear un pedido este queda en
estado ''creado''.
Cuando el cliente realiza la solicitud del pedido, ya no puede modificarlo y esta
disponible para que lo vean los empleados del bar. pasando al estado ''procesando''.
Los empleados pueden ver los pedidos solicitados, pero no pueden realizar pedidos.
Cuando el empleado termina de preparar el pedido lo envia al cliente y el mismo se
marca como ''entregado''.
Para cada pedido se registra un numero correlativo, la fecha y hora en la que se crea y
los productos solicitados, con sus correspondientes cantidades. Para un mismo pedido
no pueden agregarse dos productos iguales.
Cada producto se identifica con un nombre, una descripcion y un precio unitario. Un
producto puede estar ''disponible'' o ''no disponible''. En la lista de productos no puede
haber dos que tengan la misma descripcion. Un producto pertenece a una categoria
que puede ser: entrada, plato principal, postre. Estas permiten organizar los productos
en el menu. El cliente puede consultar el menu que presenta la lista de productos
disponibles en un momento determinado organizado por categorias. Los empleados
son los que se ocupan de indicar el estado actual de los productos.
