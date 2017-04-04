<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
  <title>Login Example</title>
</head>
<body>
<html:form action="/login" focus="userName">
  Username : <html:text property="userName"/>
  <br>
  Password : <html:password property="password"/>
  <br>
  <html:submit value="login"/>
</html:form>

</body>
</html>
