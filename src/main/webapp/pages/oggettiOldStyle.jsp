<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="qs2" uri="/quix-strut2-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  	<head>
  		<jsp:include page="_head.jsp"></jsp:include>
  	</head>
  	<body ng-app="qborrow"> 
  		<div class="qcontainer-fluid"> 
  			ciao
  			<ul>
  			
  			<s:iterator value="oggettiList" var="oggetto">
  			<li><s:property value="#oggetto.titolo" /></li>
  			</s:iterator>
	  	</ul>
	  	<s:form action="oggetto">
	  	<s:hidden name="task" value="listMieiOggettiStruts"/>
	  	<s:textfield name="oggetto.titolo"></s:textfield>
	  	<button type="submit">Cerca</button>
	  	</s:form>
	  	</div>
	  		
  	</body>
</html>
