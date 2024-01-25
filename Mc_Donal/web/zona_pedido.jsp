<%-- 
    Document   : zona_pedido
    Created on : 25 ene. 2024, 9:08:48
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>;
<%@page import="java.text.*"%>;

<%
 String nombreUsuario = (String) session.getAttribute("nombre");
if (nombreUsuario==null) {
    
    RequestDispatcher rd;
ServletContext contex=getServletContext();
    
    rd=contex.getRequestDispatcher("/index.html");
    rd.forward(request, response);
        
    } else {

%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Documento sin tÃ­tulo</title>
<style type="text/css">
body,td,th {
	color: #030;
	font-size: 14px;
	font-family: Tahoma, Geneva, sans-serif;
	font-weight: bold;
}
h5 {
	font-size: large;
	color: #FF0;
}
</style>
</head>

<body text="#030">
   
<table width="611" height="330" border="5" align="center" bordercolor="#003300">
  <tr>
    <td width="593"><table width="601" bgcolor="#F4F4F4" align="right">
<form id="form1" name="form1" method="post" action="zona_localizacion">
  <tr>
    <td width="69" height="15"><img src="images/img-logo-head.gif" width="69" height="68" /></td>
    <td height="15" colspan="2" align="right"><h6>Bienvenido &nbsp;${nombre}<br><br>Usted ha acedido a nuestra zona de pedidos a las &nbsp;${hora}&nbsp;del &nbsp;${fecha}</h6></td>
    <td width="8" height="15"></td>
  </tr>
  
  <tr>
    <td height="2" >&nbsp;</td>
    <td width="304" height="2" align="left" valign="middle"><img src="images/menus.gif"/></td>
    <td width="200" height="2" align="left" valign="middle" ><label for="menus"></label>
      <select  name="menus" id="menus">
        <option value="0">------------------------------</option>
        <option value="Mc MENU">Mc MENU</option>
        <option value="HAPPY MEAL">HAPPY MEAL</option>
        <option value="MENU ENSALADA">MENU ENSALADA</option>
      </select>      
     </td>
    <td height="2" >&nbsp;</td>
  </tr>
   <tr>
    <td height="2" >&nbsp;</td>
    <td height="2" align="left" valign="middle"><img src="images/sandwis.gif" width="293" height="67" /></td>
    <td height="2" align="left" valign="middle" >
       <select name="sandwiches" id="sandwiches">
       <option value="0">------------------------------</option>
        <option value="CHICKEN CLASSIC-SUPREME">CHICKEN CLASSIC-SUPREME</option>
        <option value="MCPOLLO">MCPOLLO</option>
        <option value="MC BACON">MC BACON</option>
        <option value="BIG MAC">BIG MAC</option>
        </select>
    </td>
    <td height="2" >&nbsp;</td>
  </tr>
   <tr>
    <td height="2" >&nbsp;</td>
    <td height="2" align="left" valign="middle"><img src="images/complementos.gif" width="293" height="67" /></td>
    <td height="2" align="left" valign="middle" >
    <select name="complementos" id="complementos">
      <option value="0">------------------------------</option>
      <option value="CHICKEN BBQ">CHICKEN BBQ</option>
      <option value="ALITAS DE POLLO">ALITAS DE POLLO</option>
      <option value="HAMBURGUESA CON QUESO">HAMBURGUESA CON QUESO</option>
      <option value="HAMBURGUESA">HAMBURGUESA</option>
      <option value="McNUGGETS">McNUGGETS</option>
      <option value="PATATAS DELUXE">PATATAS DELUXE</option>
      <option value="PATATAS FRITAS">PATATAS FRITAS</option>
      <option value="HAPPY ZANAHORIAS">HAPPY ZANAHORIAS</option>
      <option value="HAPPY CHERRITO">HAPPY CHERRITO</option>
    </select> </td>
    <td height="2" >&nbsp;</td>
  </tr>
   <tr>
    <td height="2" >&nbsp;</td>
    <td height="2" align="left" valign="middle"><img src="images/ensaladas.gif"/></td>
    <td height="2" align="left" valign="middle" >
     <select name="ensaladas" id="ensaladas">
      <option value="0">------------------------------</option>
      <option value="MANHATAN">MANHATAN</option>
      <option value="CESAR CON POLLO CISPY">CESAR CON POLLO CISPY</option>
      <option value="MEDITERRANEA CON ATUN">MEDITERRANEA CON ATUN</option>
      <option value="DE LA HUERTA">DE LA HUERTA</option>
    </select></td>
    <td height="2" >&nbsp;</td>
  </tr>
   <tr>
    <td height="2" >&nbsp;</td>
    <td height="2" align="left" valign="middle"><img src="images/bebidas.gif"/></td>
    <td height="2" align="left" valign="middle" >
    <select name="bebidas" id="bebidas">
    <option value="0">------------------------------</option>
      <option value="COCACOLA">COCACOLA</option>
      <option value="FANTA">FANTA</option>
      <option value="CERVEZA">CERVEZA</option>
      <option value="AGUA">AGUA</option>
    </select>
    </td>
    <td height="2" >&nbsp;</td>
  </tr>
   <tr>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
   <tr>
     <td><img src="images/img-24h.png" alt="" width="110" height="65" /></td>
     <td colspan="2" align="center" valign="middle">Por favor selecciones los artículos  y  confirme su pedido.<br />
       Gracias.</td>
     <td>&nbsp;</td>
   </tr>
   <tr>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
  <tr>
    <td >&nbsp;</td>
    <td colspan="2" align="center">
      
        <input name="aceptar" type="submit" value="Confirmar pedido" />
      </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td >&nbsp;</td>
    <td colspan="2" align="center">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  
  </form>
</table>
</td>
  </tr>
</table>

</body>
</html>
<% }%>