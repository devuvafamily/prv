<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Prv ::. Formulaire de prise de RV</title>
</head>
<body>

<s:div>
	<s:include value="/prv/menu.jsp"/>
</s:div>
	<s:form action="Rv">
		<fieldset>
			<legend><s:text name="client.legend" /></legend>
			<table>
            	<tr>
                	<td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
                <tr>
                	<td><s:select key="client.civilite" list="listeSexes" value="" name="rv.codeClient.civilite"/></td>
                	<td>&nbsp;&nbsp;</td>
                </tr>
                <tr>
                	<td><s:textfield name="rv.codeClient.nom" key="client.nom"/></td>
                	<td><s:textfield name="rv.codeClient.prenom" key="client.prenom"/></td>
                </tr>
               </table>
		</fieldset>
		
		<fieldset>
			<legend><s:text name="client.legend.plage" /></legend>
			<table>
            	<tr>
                	<td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
                <tr>
                	<td><s:date  name="rv.date"/></td>
                	<td>&nbsp;&nbsp;</td>
                </tr>
                <tr>	
                	<td><s:select list="listeHeures" name="rv.idCreneaux.heure" key="rv.heure"/></td>
                	<td><s:select list="listeMinutes" name="rv.idCreneaux.heure" key="rv.minute"/></td>
                </tr>
                <tr>
                	<td><s:textarea key="rv.notes" name="rv.notesRv"/></td>
                </tr>
                <tr>
                	<td>&nbsp;&nbsp;</td>
                    <td>&nbsp;&nbsp;</td>
                </tr>
                </table>
                
         <s:div>
		 	<s:radio list="listePreferences" key="client.preference"/>
		</s:div>
		  <s:div>
		 	&nbsp;&nbsp;
		</s:div>
		</fieldset>

	</s:form>
</body>
</html>