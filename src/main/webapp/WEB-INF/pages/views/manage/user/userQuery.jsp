<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctxStatic}/layuidemo/plugin/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctxStatic}/layuidemo/css/list.min.css">
</head>
<body>

<div id="main-wrap" class="animated fadeIn">
    <div class="main-title">
        <h1>用户列表</h1>
        <div class="toolbar">
            <%--<button class="layui-btn layui-btn-small do-action" data-type="doAdd" data-href="${ctx}/manage/userAdd">
                <i class="layui-icon">&#xe608;</i> 添加用户
            </button>--%>
        </div>
    </div>
    <hr>
    <div class="main-content">
        <table class="table-sort table-box dataTable">
            <thead>
            <tr>
                <th><input type="checkbox" class="icheck"></th>
                <th>用户编号</th>
                <th>用户名</th>
                <th>用户手机号</th>
                <th>用户邮箱</th>
                <%--<th>用户类型</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${user}">
                <tr>
                    <td><input type="checkbox" name="uuid" class="icheck"></td>
                    <td>${user.number}</td>
                    <td>${user.userName}</td>
                    <td>${user.phone}</td>
                    <td>${user.eamil}</td>
                    <%--<form class="layui-form" accept-charset="utf-8" >
                        <c:choose>
                            <c:when test="${user.type == 1}">
                                <td>普通用户</td>
                            </c:when>
                            <c:otherwise>
                                <td>管理员</td>
                            </c:otherwise>
                        </c:choose>
                    </form>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

<script src="${ctxStatic}/layuidemo/plugin/layui/layui.js"></script>
<script src="${ctxStatic}/layuidemo/js/list.min.js"></script>
<script src="${ctxStatic}/layuidemo/js/form.min.js"></script>
<script src="${ctxStatic}/layuidemo/js/jquery1.8.0.min.js"></script>
<script>

    layui.config({base:"${ctxStatic}/layuidemo/plugin/layui/lay/modules/mplus/"}).extend({common:"common.min",datatable:"datatable/jquery.dataTables.min",sweetalert:"sweetalert/sweetalert.min",echarts:"echarts/echarts.min",echarts_common:"echarts/echarts.common.min",echarts_simple:"echarts/echarts.simple.min",icheck:"iCheck/icheck.min",cropper:"cropper/cropper.min",chosen:"chosen/chosen.min"});layui.use(["layer","jquery","datatable","icheck","chosen"],function(){var a=layui.layer,b=layui.jquery;b(".icheck").iCheck({checkboxClass:"icheckbox_square-green"});b(".mplus-select").chosen({width:"100%"});b(".mplus-select ~ .layui-form-select").remove();b(function(){var c=b("table th input:checkbox");var d=b('input[name="uuid"]');c.on("ifChecked ifUnchecked",function(e){if(e.type=="ifChecked"){d.iCheck("check")}else{d.iCheck("uncheck")}});d.on("ifChanged",function(e){if(d.filter(":checked").length==d.length){c.prop("checked","checked")}else{c.removeProp("checked")}c.iCheck("update")});d.on("ifChanged",function(e){if(d.filter(":checked").length>1){b("#batch_delete_btn").show()}else{b("#batch_delete_btn").hide()}});b(".dataTable").dataTable({searching:true,paging:true,lengthChange:true,info:true,ordering:true,order:[1,"desc"],orderMulti:true,columnDefs:[{targets:0,searchable:false},{orderable:false,targets:0},{orderable:false,targets:6}],processing:true,autoWidth:false,deferRender:true,lengthMenu:[5,10,25,50,100],pageLength:10,orderClasses:false,pagingType:"full_numbers",language:{emptyTable:"暂无数据！",info:"显示第 _START_ 条到第 _END_ 条，共 _TOTAL_ 条",infoEmpty:"共 _TOTAL_ 条",infoFiltered:"(从 _MAX_ 条数据中过滤)",lengthMenu:"每页显示 _MENU_ 条",loadingRecords:"加载中，请稍等。。。",paginate:{first:"首页",last:"尾页",next:"下一页",previous:"上一页"},processing:"数据处理中。。。",zeroRecords:"暂无匹配的记录"},stateSave:true});b(".table-sort tbody").on("click","tr",function(){if(b(this).hasClass("selected")){b(this).removeClass("selected")}else{b("tr.selected").removeClass("selected");b(this).addClass("selected")}})});if(self.frameElement.tagName=="IFRAME"){parent.layer.closeAll()}});changeMainHeight();window.onresize=function(){changeMainHeight()};function changeMainHeight(){var a=document.getElementById("main-wrap");if(a){a.style.minHeight=window.parent.document.documentElement.clientHeight-185+"px"}};

    function showUserPic(picUrl) {
        layui.use('layer', function() {
            var $ = layui.jquery,
                    layer = layui.layer;
            layer.open({
                title: false,
                type: 1,
                content: '<img src=' + picUrl + '>',
                area: ['200px', '200px'],
                shadeClose: true
            });
        });
    }

    function alertDel(id) {
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.open({
                content: '确定删除该条广告吗？'
                ,btn: ['确定', '取消']
                ,yes: function(index, layero){

                    $.ajax({
                        type: 'POST',
                        url: '${ctx}/manage/banner/bannerDel',
                        data: {"id": id},
                        dataType: "JSON",
                        beforeSend:function(){
                            layer.load(2);
                        },
                        success: function (data) {
                            layer.closeAll();
                            window.location.href="${ctx}/manage/banner/bannerQuery"
                        },
                        error: function (e) {
                            alert("删除失败！");
                            layer.closeAll();
                        }
                    });

                }
                ,btn2: function(index, layero){

                    //return false 开启该代码可禁止点击该按钮关闭
                }
                ,cancel: function(){
                    //右上角关闭回调

                    //return false 开启该代码可禁止点击该按钮关闭
                }
            });

        });
    }
</script>
<script>
</script>

</body>
</html>
