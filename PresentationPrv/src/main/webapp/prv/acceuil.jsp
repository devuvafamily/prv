<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Prv ::. Accueil</title>
    <link href="<s:url value="/css/examplecss"/>" rel="stylesheet"
          type="text/css"/>
</head>

<body>
<h3>Bienvenue</h3>
<ul>
    <li><a href="<s:url action="connexion_input"/>">Connexion</a></li>
    <li><a href="<s:url action="inscription"/>">Inscription</a></li>
</ul>

</body>
</html>
