<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Welcome ${name}</h1>
    <div>Your name is: ${name}</div>
    <a href="list-todos">Manage </a>your todos.
</div>
<%@ include file="common/footer.jspf" %>