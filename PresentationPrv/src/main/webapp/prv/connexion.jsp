<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head parseContent="true" />

<s:form action="connexion">
	<fieldset class="formulaire">
		<!--  <legend>
			<s:text name="accueil.connexion" />
		</legend> -->
		
		<s:div>
			<s:text name="validation.messageSucces"></s:text>
		</s:div>
		<table>
    <s:textfield key="username"/>
    <s:password key="password" />
    </table>
    </fieldset>
    <s:submit/>
</s:form>

