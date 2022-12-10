# PracticaServlet

La práctica consiste en la realización de una misma aplicación web utilizando Servltes y JSP.

Ambas tienen un CDI Bean, Elemento.java que sirve de apoyo para mantener el estado de la aplicación e intercambio de datos entre las páginas.

Con el uso exclusivo de Servlets para la creación de las páginas se necesitan dos servlets, uno por página, Controlador y Resultados.  La lógica de negocio, los cálculos y concatenación de texto, así como la carga de datos en el CDI Bean, se implementa en el método doPost() del servlet destino Resultados.

Utilizando JSP, a parte de la comodidad en la formación de las páginas, se ha utilizado un único servlet, Controlador, donde de forma dinámica se resuelve la navegación de las páginas en la implementación del método processRequest() mientras que la lógica de negocio, los cálculos y concatenación de texto, así como la carga de datos en el CDI Bean, se implementa en el método doPost().

Llegado a este punto el siguiente paso sería realizar el mismo ejercicio utilizando JavaServer Faces…

