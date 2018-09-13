<%@ page import="com.szdx.lifeAssistant.sys.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <%
        User user = (User) request.getSession().getAttribute("user");
    %>
    <meta charset="utf-8">
    <title>生活助手后台管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="${ctxStatic}/beginner_admin/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctxStatic}/beginner_admin/css/global.css" media="all">
    <link rel="stylesheet" href="${ctxStatic}/beginner_admin/plugins/font-awesome/css/font-awesome.min.css">

</head>

<body>
<div class="layui-layout layui-layout-admin" style="border-bottom: solid 5px #1aa094;">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <div class="admin-login-box">
                <a class="logo" style="left: 0;" href="#">
                    <span style="font-size: 22px;">生活助手</span>
                </a>
                <div class="admin-side-toggle">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </div>
                <div class="admin-side-full">
                    <i class="fa fa-life-bouy" aria-hidden="true"></i>
                </div>
            </div>
            <ul class="layui-nav admin-header-item">
                <li class="layui-nav-item">
                    <a href="javascript:;">清除缓存</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">浏览网站</a>
                </li>
                <li class="layui-nav-item" id="video1">
                    <a href="javascript:;">视频</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="admin-header-user">
                        <img src="${ctxStatic}/images/headImg.png" />
                        <span><%=user.getUserName()%></span>
                    </a>
                   <%-- <dl class="layui-nav-child">
                        <dd>
                            <a id="information" href="javascript:;" data-url="${ctx}/manage/information?id=<%=user.getId()%>"><i class="fa fa-user-circle" aria-hidden="true"></i> 个人资料</a>
                        </dd>
                        <dd>
                            <a href="javascript:;" id="login_out" data-url="${ctx}/manage/signOut"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
                        </dd>--%>
                        <%--
                        <dd>
                            <a href="javascript:;"><i class="fa fa-gear" aria-hidden="true"></i> 设置</a>
                        </dd>
                        <dd id="lock">
                            <a href="javascript:;">
                                <i class="fa fa-lock" aria-hidden="true" style="padding-right: 3px;padding-left: 1px;"></i> 锁屏 (Alt+L)
                            </a>
                        </dd>--%>
                    <%--</dl>--%>
                </li>
            </ul>

        </div>
    </div>
    <div class="layui-side layui-bg-black" id="admin-side">
        <div class="layui-side-scroll" id="admin-navbar-side" lay-filter="side"></div>
    </div>
    <div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
        <div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">
                    <i class="fa fa-dashboard" aria-hidden="true"></i>
                    <cite>控制面板</cite>
                </li>
            </ul>
            <div class="layui-tab-content" style="min-height: 150px; padding: 5px 0 0 0;">
                <div class="layui-tab-item layui-show">
                    <iframe src="${ctx}/manage/home"></iframe>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-footer footer footer-demo" id="admin-footer">
        <div class="layui-main">
            <p>2017 &copy;
                <a href="http://www.baidu.com/">you</a> szc
            </p>
        </div>
    </div>
    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <!--锁屏模板 start-->
    <script type="text/template" id="lock-temp">
        <div class="admin-header-lock" id="lock-box">
            <div class="admin-header-lock-img">
                <img src="${ctxStatic}/beginner_admin/images/0.jpg"/>
            </div>
            <div class="admin-header-lock-name" id="lockUserName"><%=user.getUserName()%></div>
            <input type="text" class="admin-header-lock-input" value="输入密码解锁.." name="lockPwd" id="lockPwd" />
            <button class="layui-btn layui-btn-small" id="unlock">解锁</button>
        </div>
    </script>
    <!--锁屏模板 end -->
    <script type="text/javascript" src="${ctxStatic}/beginner_admin/plugins/layui/layui.js"></script>
    <script type="text/javascript" src="${ctxStatic}/beginner_admin/datas/nav.js"></script>
    <script src="${ctxStatic}/beginner_admin/js/index.js"></script>

    <script>

        layui.config({
            base: '${ctxStatic}/beginner_admin/js/',
            version: new Date().getTime()
        })


        layui.use('layer', function() {
            var $ = layui.jquery,
                layer = layui.layer;
            $('#login_out').on('click', function () {
                layer.open({
                    title: '确定退出吗？',
                    type: 1,
                    btn: ['取消', '确定']
                    ,yes: function(index, layero){
                        layer.closeAll();
                    }
                    ,btn2: function(index, layero){
                        layer.closeAll();
                        window.location.href="${ctx}/manage/loginOut"
                    },
                    shadeClose: true
                });
            });
        });

        var navs = [{
            "title": "会员管理",
            "icon": "fa-cubes",
            "spread": true,
            "children": [{
                "title": "会员查询",
                "icon": "&#xe641;",
                "href": "${ctx}/manage/vip/vipQuery"
            }, {
                "title": "会员添加",
                "icon": "&#xe63c;",
                "href": "${ctx}/manage/vip/vipAdd"
            }]
        }, {
            "title": "商城活动管理",
            "icon": "fa-stop-circle",
            "spread": false,
            "children": [{
                "title": "活动查询",
                "icon": "&#xe641;",
                "href": "${ctx}/manage/shop/shopQuery"
            }, {
                "title": "活动添加",
                "icon": "&#xe63c;",
                "href": "${ctx}/manage/shop/shopAdd"
            }]
        },{
            "title": "生活百科知识",
            "icon": "fa-cubes",
            "spread": false,
            "children": [{
                "title": "知识查询",
                "icon": "&#xe641;",
                "href": "${ctx}/manage/life/lifeQuery"
            }, {
                "title": "知识添加",
                "icon": "&#xe63c;",
                "href": "${ctx}/manage/life/lifeAdd"
            }]
        },{
            "title": "新闻资讯管理",
            "icon": "fa-cubes",
            "spread": false,
            "children": [{
                "title": "资讯查询",
                "icon": "&#xe641;",
                "href": "${ctx}/manage/news/newsQuery"
            }, {
                "title": "新闻添加",
                "icon": "&#xe63c;",
                "href": "${ctx}/manage/news/newsAdd"
            }]
        }, {
            "title": "用户管理",
            "icon": "&#x1002;",
            "spread": false,
            "children": [{
                "title": "用户查询",
                "icon": "fa-check-square-o",
                "href": "${ctx}/manage/userQuery"
            }, /*{
                "title": "用户添加",
                "icon": "&#xe63c;",
                "href": "${ctx}/manage/userAdd"
            }*/]
        }];

    </script>
</div>
</body>

</html>

