<%-- 
    Document   : Alta_libros
    Created on : 10 ene 2024, 19:09:00
    Author     : moro-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Inicio de Sesión - Gestion de Biblioteca</title>
</head>
<body>
  <table width="100%" border="0" align="center">
    <tr>
      <td bgcolor="#007bff" colspan="2" align="center" height="100">
        <h1 style="color: #fff;">Gestion de Libreria</h1>
      </td>
    </tr>
    <tr>
      <td width="50%" bgcolor="#fff" valign="top" align="center">
        <img src="img/inicio.png" alt="Imagen de Biblioteca" style="max-width: 100%; height: auto; margin: 20px;">
        <br>
        <a href="Alta_libros.jsp">Alta de libro</a>
        <a href="Modificar_libros.jsp">Modificacion de libro</a>
        <a href="Baja_libros.jsp">Baja de libro</a>
        <a href="Listado_libros.jsp">Listado de libros</a>
      </td>
    </tr>
  </table>
     <form action="procesar_alta_libro.php" method="post">
    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" pattern="0-13-\d{6}-\d" required>
    <br><br>
    
    <label for="titulo">Título:</label>
    <input type="text" id="titulo" name="titulo" required>
    <br><br>
    
    <label for="autor">Autor:</label>
    <select id="autor" name="autor" required>
      <!-- Aquí deberías cargar los autores desde la base de datos -->
      <option value="autor1">Autor 1</option>
      <option value="autor2">Autor 2</option>
      <!-- Agregar más opciones según los autores de la base de datos -->
    </select>
    <br><br>
    
    <label for="editorial">Editorial:</label>
    <select id="editorial" name="editorial" required>
      <!-- Aquí deberías cargar las editoriales desde la base de datos -->
      <option value="editorial1">Editorial 1</option>
      <option value="editorial2">Editorial 2</option>
      <!-- Agregar más opciones según las editoriales de la base de datos -->
    </select>
    <br><br>
    
    <label for="anio">Año de edición:</label>
    <input type="number" id="anio" name="anio" min="2000" max="2022" required>
    <br><br>
    
    <label for="descripcion">Descripción:</label>
    <textarea id="descripcion" name="descripcion" required></textarea>
    <br><br>
    
    <input type="submit" value="Agregar Libro">
  </form>
</body>
</html>
