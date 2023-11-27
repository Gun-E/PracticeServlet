<%@ page contentType="text/plan;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<jsp:useBean id="htmlBeautifier" scope="request" class="com.nhnacademy.hello.beans.HtmlBeautifier" />
<jsp:setProperty name="htmlBeautifier" property="html" param="html" />
<jsp:getProperty name="htmlBeautifier" property="html" />
