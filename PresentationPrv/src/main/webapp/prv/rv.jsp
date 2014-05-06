<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head parseContent="true" />
<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 720px;
	margin-bottom: 6px;
}

.errors li {
	list-style: none;
}
</style>
<script type="text/javascript">
	function desactiverChamp(id) {
		var objet = document.getElementById(id);
		objet.value = '';
		objet.disabled = 'true';
	}

	function activerChamp(id) {
		var objet = document.getElementById(id);
		objet.disabled = '';
	}

	function toggleNatureDemande() {
		var nature = document.getElementById('natureDemande');

		if (nature.options[nature.selectedIndex].value == 'Autres') {
			//activer le champ
			activerChamp('natureAutre');

		} else if (nature.options[nature.selectedIndex].value != 'Autres') {
			// desactiver le champ 
			desactiverChamp('natureAutre');
		}
	}
</script>

<s:if test="hasActionErrors()">
	<div class="errors">
		<s:actionerror />
	</div>
</s:if>
<s:form action="rv" namespace="/prv" method="POST">

	<fieldset>
		<legend>
			<s:text name="client.legend" />
		</legend>
		<div>
			<table>
				<tr>
					<td>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td><s:select key="client.civilite" list="listeSexes" value=""
							name="rv.codeClient.civilite" /></td>

				</tr>
				<tr>
					<td><s:textfield size="20" name="rv.codeClient.codeClient"
							key="client.identifiant" requiredLabel="true" /></td>

				</tr>
				<tr>
					<td><s:textfield size="50" name="rv.codeClient.nom"
							key="client.nom" requiredLabel="true" /></td>
					<td><s:textfield size="50" name="rv.codeClient.prenom"
							key="client.prenom" requiredLabel="true" /></td>
				</tr>
				<tr>
					<td><sx:datetimepicker name="rv.codeClient.dateNaissance"
							displayFormat="yyyy-MM-dd" key="client.dateNaissance" /></td>
				</tr>
				<tr>
					<td><s:textarea cols="35" rows="4" key="client.adresse"
							name="rv.codeClient.adresse" requiredLabel="true" /></td>
				</tr>
				<tr>
					<td><s:textfield size="50" name="rv.codeClient.courriel"
							key="client.mail" requiredLabel="true" /></td>
				</tr>
			</table>
		</div>
	</fieldset>

	<fieldset>
		<legend>
			<s:text name="client.legend.plage" />
		</legend>
		<table>
			<tr>
				<td><sx:datetimepicker name="rv.jourRv"
						displayFormat="yyyy-MM-dd" key="client.dateRv"
						requiredLabel="true" /></td>
			</tr>
			<tr>
				<td><s:select list="listeNatureDemande" id="natureDemande"
						name="rv.natureDemande" key="client.natureDemande"
						onchange="javascript:toggleNatureDemande();" /></td>
			</tr>
			<tr>
				<td><s:textfield size="50" id="natureAutre"
						name="rv.natureDemandeAutre" disabled="true"
						key="client.autreDemande" /></td>
			</tr>
			<!--  <tr>	
                	<td><s:select list="listeHeures" name="rv.idCreneaux.heureDebut" key="rv.heure"/></td>
                	<td><s:select list="listeMinutes" name="rv.idCreneaux.minuteDebut" key="rv.minute"/></td>
                </tr> -->
			<tr>
				<td><s:textarea cols="35" rows="4" key="rv.notes"
						name="rv.notesRv" /></td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><s:radio list="listePreferences"
						name="rv.modeCommunication" key="client.preference" /></td>
			</tr>
		</table>

	</fieldset>
	<s:div>
		<s:submit type="button" key="client.reset" method="clearModel" />
		<s:submit key="client.soumettre" method="soumettreRv" />
	</s:div>

</s:form>
<script type="text/javascript">
	toggleNatureDemande();
</script>
