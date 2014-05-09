<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head parseContent="true" />

<s:form action="listerv" namespace="/pilotage" method="POST">
	<fieldset class="formulaire">
		<legend>
			<s:text name="prv.pilotage.listerv" />
		</legend>
		<s:div>
			<s:text name="validation.messageSucces"></s:text>
		</s:div>
		<br />
		<s:div>
			<b><span style="color: red"> <u><s:text
							name="validation.important"></s:text></u></span></b>
			<br />
			<p>
				<s:text name="validation.noteImportante"></s:text>
				</span>
			</p>
		</s:div>


		<table class="tableresultat">

			<!--<s:iterator value="listeRv" status="rvStatut" var="item">
				<tr>
					<td><s:property value="%{#item.natureDemande}"/></td>
					<td><s:property value="%{#item.jourRv}" /></td>
					<td><s:property value="%{#item.codeClient.prenom}" /> <s:property value="%{#item.codeClient.nom}" /></td>
				</tr>
			</s:iterator> -->
			<colgroup>
				<col width="20%">
				<col width="25%">
				<col width="25%">
				<col width="30%">
			</colgroup>
			<tr>
				<th><s:text name="prv.header.natureDemande"/></th>
				<th><s:text name="prv.header.modeCommunication" /></th>
				<th><s:text name="prv.header.dateRv" /></th>
				<th><s:text name="prv.header.nom" /></th>
			</tr>
			<s:iterator value="listeRv" status="rvStatut" var="item">
				<s:url id="modifUrl" namespace="/prv" action="rv"
					method="modifierRv">
					<s:param name="idCourant" value="%{#item.idRv}" />
				</s:url>
				<tr>
					<td><s:a href="%{modifUrl}" tooltip="Modifier le rendez-vous courant">
							<s:property value="natureDemande" />
						</s:a></td>
					<td><s:property value="modeCommunication" /></td>
					<td><s:property value="jourRv" /></td>
					<td><s:property value="codeClient.prenom" /> <s:property
							value="codeClient.nom" /></td>
				</tr>
			</s:iterator>
		</table>

	</fieldset>
</s:form>