<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin título</title>
    </head>

    <body>

        <table width="100%" border="0">
            <tr>
                <td colspan="7" bgcolor="#333333">&nbsp;</td>
            </tr>
            <tr align="center">
                <td colspan="7" bgcolor="#CCCCCC"><h1>APLICACIÓN DE GESTIÓN COMERCIAL</h1></td>
            </tr>

            <tr align="center">
                <td>
                    <a href="pagina_ventas.jsp"><img src="img/ventas.jpg" width="180" height="123" /></a>

                </td>
                <td><a href="pagina_productos.jsp"><img src="img/productos.jpg" width="180" height="123" /></a></td>
                <td><a href="pagina_comerciales.jsp"><img src="img/comerciales.jpg" alt="" width="180" height="123" /></a>
                    <br />
                    <a href="listadocomerciales.jsp"><img src="img/listado-comerciales.jpg" width="180" height="50" /></a>
                    <br />
                    <a href="NuevoComercial.jsp"><img src="img/alta-comerciales.jpg" width="180" height="50" /></a>

                </td>
            </tr>
            <tr>
                <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
             </tr>
            <tr>
                <td colspan="7">

                    <table width="50%" border="0" align="center">
                        <form action="ServletComerciales" method="post">
                            <tr align="center">
                                <td colspan="2"><h3></h3></td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <label>Codigo</label>
                                    <input type="text" name="codigo" pattern="[a-zA-Z0-9 ]+" required>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <label>Nombre</label>
                                    <input type="text" name="nombre" pattern="[a-zA-Z ]+" required>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <label>Sueldo</label>
                                    <input type="text" name="sueldo" pattern="[0-9 ]+" required>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <label>Fecha de nacimiento</label>
                                    <input type="date" name="fecha"  required>
                                </td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <label>Numero de hijos</label>
                                    <input type="text" name="hijos" pattern="[0-9 ]+" required>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input name="aceptar" type="submit" value="aceptar" />
                                    <input name="cancelar" type="reset" value="cancelar" />
                                </td>
                            </tr>

                        </form>
                    </table>





                </td>
            </tr>

            <tr>
                <td colspan="7">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
            </tr>
        </table>

    </body>
</html>