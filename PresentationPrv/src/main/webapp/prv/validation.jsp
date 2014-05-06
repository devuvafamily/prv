<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<sx:head parseContent="true" />
<s:form action="rv" namespace="/prv" method="POST">
	<fieldset>
		<legend>
			<s:text name="validation.legend" />
		</legend>
		<s:div>
			<s:text name="validation.messageSucces"></s:text>
		</s:div>
		<br />
		<s:div>
			<span style="color: red"> <s:text name="validation.important"></s:text></span>
			<br />
			<p>
				<s:text name="validation.noteImportante"></s:text>
				</span>
			</p>
		</s:div>

	</fieldset>
	<s:div>
		<s:url id="retour" value="rv.action" />
		<s:a href="%{retour}" r="false" id="retour" cssClass="anchors">
			<s:text name="prv.href.retour"></s:text>
		</s:a>
	</s:div>
</s:form>