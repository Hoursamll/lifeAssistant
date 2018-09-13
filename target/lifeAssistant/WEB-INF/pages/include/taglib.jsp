<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="ctxBase" value="${pageContext.request.contextPath}/base" />
<c:set var="baseurl" value="http://localhost:8080/" />

<link rel="stylesheet" href="${ctxStatic}/layuidemo/plugin/layui/css/layui.css">
<link rel="stylesheet" href="${ctxStatic}/layuidemo/css/animate.min.css">
<link rel="stylesheet" href="${ctxStatic}/layuidemo/css/global.min.css">

<script src="${ctxStatic}/layuidemo/plugin/layui/lay/lib/jquery.min.js"></script>
<script src="${ctxStatic}/layui/lay/modules/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="${ctxStatic}/js/cache.js"></script>--%>

<script type="text/javascript">
    var baseurl = '<%=request.getAttribute("path_url") %>';
</script>