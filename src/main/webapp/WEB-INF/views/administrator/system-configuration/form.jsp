<%--
- form.jsp
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

<h2>
	<acme:message code="administrator.configuration.form.title.general-indicators"/>
</h2>

<acme:form readonly="false">
	<acme:input-textbox code="administrator.configuration.form.label.system-currency" path="systemCurrency"/>	
	<acme:input-textbox code="administrator.configuration.form.label.accepted-currencies" path="acceptedCurrencies"/>	
	<acme:input-textbox code="administrator.configuration.form.label.spamRecords" path="spamRecords"/>	
	<acme:input-textbox code="administrator.configuration.form.label.spamThreshold" path="spamThreshold"/>	
	<acme:input-textbox code="administrator.configuration.form.label.spamBoosterFactor" path="spamBoosterFactor"/>	
	<acme:submit code="administrator.item.form.button.update" action="/administrator/system-configuration/update"/>
</acme:form>