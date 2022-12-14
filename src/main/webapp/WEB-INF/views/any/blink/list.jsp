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

<acme:list readonly="true">
	<acme:list-column code="any.blink.list.label.instantiationMoment" path="instantiationMoment" width="20%"/>
	<acme:list-column code="any.blink.list.label.caption" path="caption" width="10%"/>
	<acme:list-column code="any.blink.list.label.authorAlias" path="authorAlias" width="20%"/>
	<acme:list-column code="any.blink.list.label.message" path="message" width="50%"/>
	<acme:list-column code="any.blink.list.label.email" path="email" width="20%"/>
</acme:list>

<acme:button code="any.blink.form.button.create" action="/any/blink/create"/>