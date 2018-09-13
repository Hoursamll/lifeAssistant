<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>500错误</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctxStatic}/bootstrap.min.css?v=1.0.0" rel="stylesheet">
    <link href="${ctxStatic}/font-awesome.css?v=1.0.0" rel="stylesheet">
    <link href="${ctxStatic}/layuidemo/css/animate.css" rel="stylesheet">
    <link href="${ctxStatic}/layui/css/style.css?v=1.0.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="middle-box text-center animated fadeInDown">
    <h1>500</h1>
    <h3 class="font-bold">服务器内部错误</h3>

    <div class="error-desc">
        服务器好像出错了...
        <br/>您可以返回主页看看
        <br/><a href="${ctx}/index.html" class="btn btn-primary m-t">主页</a>
    </div>
</div>

</body>
</html>
