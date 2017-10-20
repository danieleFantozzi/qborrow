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
  			<jsp:include page="_header.jsp" />
	  		<div class="qcontainer">
	  		<div class=qrow >
		  		<%-- <div class="frameworkLeftMenuCell">
					<jsp:include page="_left.jsp">
						<jsp:param name="menuActive" value="Home"/>
					</jsp:include>
				</div> --%>
  				<div class="frameworkMainCell">
					<div class="qpage-header">
						<h1>BENVENUTO, <s:property value="userContext.realUserDn"/></h1>
					</div>
					<div class="qrow">
						<div class="qcol-md-3 menuIcon">
						<div>
								<i class="fa fa-book" aria-hidden="true"></i>
								</div>
						
						<s:a href="%{#oggettoUrl}">Oggetto</s:a>
								<s:url id="oggettoUrl" action="oggetto" escapeAmp="false" includeParams="none">
									<s:param name="task">mainPage</s:param>
								</s:url>
								
						</div>
						<div class="qcol-md-3 menuIcon">
						
						<div>
								<i class="fa fa-usd" aria-hidden="true"></i>
								</div>
						<s:a href="%{#oggettoUrl}">Prestito</s:a>
								<s:url id="prestitoUrl" action="prestito" escapeAmp="false" includeParams="none">
									<s:param name="task">mainPage</s:param>
								</s:url>
						</div>
						<div class="qcol-md-3 menuIcon">
						<div>
								<i class="fa fa-users" aria-hidden="true"></i>
								</div>
						<s:a href="%{#oggettoUrl}">Soggetto</s:a>
								<s:url id="soggettoUrl" action="soggetto" escapeAmp="false" includeParams="none">
									<s:param name="task">mainPage</s:param>
								</s:url>
						</div>
						<div class="qcol-md-3 menuIcon">
						<div>
								<i class="fa fa-university" aria-hidden="true"></i>
								</div>
						<s:a href="%{#oggettoUrl}">Framework</s:a>
								<s:url id="frmkUrl" namespace="/framework" action="admin" escapeAmp="false" includeParams="none">
				  					<s:param name="version">2</s:param>
				  				</s:url>
						</div>
<!-- 							<%-- <ul class="qnav qnav-pills qnav-stacked">
 -->								<s:url id="oggettoUrl" action="oggetto" escapeAmp="false" includeParams="none">
									<s:param name="task">mainPage</s:param>
								</s:url>
								<li><s:a href="%{#oggettoUrl}">Oggetto</s:a></li>
								<s:url id="prestitoUrl" action="prestito" escapeAmp="false" includeParams="none">
									<s:param name="task">mainPage</s:param>
								</s:url>
								<li><s:a href="%{#prestitoUrl}">Prestito</s:a></li>
								<s:url id="soggettoUrl" action="soggetto" escapeAmp="false" includeParams="none">
									<s:param name="task">mainPage</s:param>
								</s:url>
								<li><s:a href="%{#soggettoUrl}">Soggetto</s:a></li>						
								<s:url id="frmkUrl" namespace="/framework" action="admin" escapeAmp="false" includeParams="none">
				  					<s:param name="version">2</s:param>
				  				</s:url>
				  				<li><s:a href="%{#frmkUrlUrl}">Amministrazione Framework</s:a></li> --%>
							<!-- </ul> -->
						
					</div>
  				</div>
			</div>
			</div>
  		 	<jsp:include page="_footer.jsp" />
	  	</div>
	  		
  	</body>
</html>
