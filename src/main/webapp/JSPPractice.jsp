<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String message = "Hello, JSP!";
    out.println(message);
%>
<%

    int a = 3;
    int b = 2;

    if (a > b) {
        out.println(minus(a, b));
    }
%>
<%= 17 * 5 %>
<%= request.getParameter("name") %>
<%! String name = "James"; %>
<%!
    public int minus(int i, int j) {
        return i - j;
    }
%>
<% int x = 0; %>
<% if (x < 0) { %>
<p>negative</p>
<% } else { %>
<p>zero or positive</p>
<% } %>
<table>
    <tr>
        <% for (int i = 0; i < 10; i++) { %>
        <td><%= i + 1 %>
        </td>
        <% } %>
    </tr>
</table>
</body>
</html>
