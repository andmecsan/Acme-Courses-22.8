<%--
- list.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="teacher.tutorial.list.label.title" path="title" width="20%"/>
	<acme:list-column code="teacher.tutorial.list.label.ticker" path="ticker" width="10%"/>
	<acme:list-column code="teacher.tutorial.list.label.abstractTheory" path="abstractTheory" width="40%"/>
	<acme:list-column code="teacher.tutorial.list.label.cost" path="cost" width="10%"/>
	<acme:list-column code="teacher.tutorial.list.label.link" path="link" width="10%"/>
</acme:list>
<jstl:if test="${acme:anyOf(command, 'list-theory') && courseId == null}">
	<acme:button code="teacher.tutorial.theory.list.button.create" action="/teacher/tutorial/create-theory"/>
</jstl:if>	
<jstl:if test="${acme:anyOf(command, 'list-lab') && courseId == null}">
	<acme:button code="teacher.tutorial.lab.list.button.create" action="/teacher/tutorial/create-lab"/>
</jstl:if>

