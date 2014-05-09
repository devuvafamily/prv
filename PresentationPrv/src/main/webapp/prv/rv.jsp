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

.errorsBg {
	background-color: #fdd;
	color: red;
	border: 1px solid;
}

.errorMessage {
	padding: 0px 8px;
}

table {
	border-spacing: 2px;
}

td {
	padding: 2px;
}
.formulaire {	/* Mise en forme des cadres */
	border:1px solid #126EA1;
	font-weight:normal;
	padding:5px 10px 10px 10px;
	margin-top:15px;
	background-color: #89C6D8;
}

.formulaire legend{

  font-weight: bold;
  color:#CE4300;
  font-size:13px;
  padding: 0.1em;
  margin-bottom: 10px;
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

	<s:url id="localeEN" namespace="/prv" action="rv">
		<s:param name="request_locale">en</s:param>
	</s:url>
	<s:url id="localeFR" namespace="/prv" action="rv">
		<s:param name="request_locale">fr</s:param>
	</s:url>
	<s:div>
		<s:if test="langue=='fr'">
			<s:a href="%{localeEN}">
				<s:text name="prv.langue"></s:text>
			</s:a>
		</s:if>
		<s:if test="langue=='en'">
			<s:a href="%{localeFR}" >
				<s:text name="prv.langue"></s:text>
			</s:a>
		</s:if>

	</s:div>
	<fieldset class="formulaire">
		<legend>
			<s:text name="client.legend" />
		</legend>
           <table>
			<s:select key="client.civilite" list="listeSexes" value="" 
				name="rv.codeClient.civilite" />
			<s:textfield size="20" name="rv.codeClient.codeClient"
				key="client.identifiant" requiredLabel="true" />

			<s:textfield size="50" name="rv.codeClient.nom" key="client.nom"
				requiredLabel="true" />
			<s:textfield size="50" name="rv.codeClient.prenom"
				key="client.prenom" requiredLabel="true" />
			<sx:datetimepicker name="rv.codeClient.dateNaissance"
				displayFormat="yyyy-MM-dd" key="client.dateNaissance" />
			<s:textarea cols="35" rows="4" key="client.adresse"
				name="rv.codeClient.adresse" requiredLabel="true" />
			<s:textfield size="50" name="rv.codeClient.courriel"
				key="client.mail" requiredLabel="true" />
        </table>
     </fieldset>
     <br/>
     <fieldset class="formulaire">
		<legend>
			<s:text name="client.legend.plage" />
		</legend>
        <table>
		<sx:datetimepicker name="rv.jourRv" displayFormat="yyyy-MM-dd"
			key="client.dateRv" requiredLabel="true" />
		<s:select list="listeNatureDemande" id="natureDemande"
			name="rv.natureDemande" key="client.natureDemande"
			onchange="javascript:toggleNatureDemande();" />
		<s:textfield size="50" id="natureAutre" name="rv.natureDemandeAutre"
			disabled="true" key="client.autreDemande" />

		<!--  <tr>	
                	<td><s:select list="listeHeures" name="rv.idCreneaux.heureDebut" key="rv.heure"/></td>
                	<td><s:select list="listeMinutes" name="rv.idCreneaux.minuteDebut" key="rv.minute"/></td>
                </tr> -->
		<s:textarea cols="35" rows="4" key="rv.notes" name="rv.notesRv" />

		<s:radio list="listePreferences" name="rv.modeCommunication"
			key="client.preference" />
			</table>
		<s:submit type="button" key="client.reset" method="clearModel" />
		<s:submit key="client.soumettre" method="soumettreRv" />
	</fieldset>



</s:form>
<script type="text/javascript">
	toggleNatureDemande();
</script>
