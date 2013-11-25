<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
<head>
<title><bean:message key="hello.jsp.title"/></title>
<html:base/>
</head>
<body bgcolor="white"><p>

<h2><bean:message key="hello.jsp.page.heading"/></h2><p>

<logic:present name="com.objis" scope="request">
     <h2>
     Hello  <bean:write name="com.objis" property="person" />!
     </h2>
     <p>
     
</logic:present>


<html:form action="/HelloWorld.do?action=gotName" focus="username" >

  <bean:message key="hello.jsp.prompt.person"/>
  <html:text property="person" size="16" maxlength="16"/><br>
  <bean:message key="hello.jsp.prompt.ville"/>
  <html:text property="ville" size="16" maxlength="16"/><br>

  <html:submit property="submit" value="Submit"/>
  <html:reset/>

</html:form><br>

<html:errors/><p>

<html:img page="/struts-power.gif" alt="Powered by Struts"/>
<a href='http://www.objis.com'>
<html:img page="/logo_objis.png" alt="Objis, sp�cialiste formation JAVA" border="0"/></a>

</body>
</html:html>
