<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<style type="text/css">
.divMaitre {
	margin-left: auto;
	margin-right: auto;
	text-align: left;
	width: 760px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
}

.divBas {
	text-align: center;
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
</head>
<body>
	<s:div id="divMaitre" cssClass="divMaitre">
		<table border="0" cellpadding="2" cellspacing="2" align="center"
			width="100%">
			<tr>
				<td height="30" colspan="2"><tiles:insertAttribute
						name="pivHaut" /></td>
			</tr>
			<tr>
				<td height="30" colspan="2"><tiles:insertAttribute name="menu" />
				</td>
			</tr>
			<tr>
				<!-- <td height="500"><tiles:insertAttribute name="menu" /></td> -->
				<td><tiles:insertAttribute name="body" /></td>
			</tr>
			<tr>
				<td height="30" colspan="2"><tiles:insertAttribute
						name="pivBas" /></td>
			</tr>
		</table>
	</s:div>
</body>
</html>