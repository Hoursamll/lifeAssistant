<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctxStatic}/layuidemo/css/form.min.css">
    <link rel="stylesheet" href="${ctxStatic}/layuidemo/css/plugin/cropper.min.css">
</head>
<body>

<div id="main-wrap" class="animated fadeIn">
    <div class="main-title">
        <h1>商城活动信息</h1>
        <div class="toolbar">
            <!--此处可以添加标题右侧的工具按钮-->
        </div>
    </div>
    <hr>
    <div class="main-content">
        <form class="layui-form" action="${ctx}/manage/shop/shopSave" accept-charset="utf-8" method="post">
            <input id="id" type="hidden" name="id" value="${shop.id}" required lay-verify="title" autocomplete="off" class="layui-input">
            <div class="layui-form-item">
                <label class="layui-form-label">活动标题：</label>
                <div class="layui-input-block">
                    <input id="carName" name="title"  required value="${shop.title}"  lay-verify="title" placeholder="如 清仓大甩卖" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">活动内容：</label>
                <div class="layui-input-block">
                    <input id="length" name="message"  required value="${shop.message}"  lay-verify="title" placeholder="如 全场9.9。。。" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">开始时间：</label>
                <div class="layui-input-block">
                    <input type="text" name="startDate" required id="startDate" lay-verify="date" value="<fmt:formatDate value="${shop.startDate}" type="date"/>" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">结束时间：</label>
                <div class="layui-input-block">
                    <input type="text" name="endDate" required id="endDate" lay-verify="date" value="<fmt:formatDate value="${shop.endDate}" type="date"/>" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">活动海报</label>
                <div class="layui-input-block">
                    <fieldset class="layui-elem-field">
                        <div class="layui-field-box" style="width:150px">
                            <section>
                                <div>
                                    <input type="file" name="file" id="file" class="layui-upload-file">
                                    <input type="text" style="width:300px" readonly required name="imgUrl" id="imgUrl" value="${shop.imgUrl}">
                                </div>
                            </section>
                        </div>
                    </fieldset>
                </div>
            </div>
            <div class="layui-form-item" style="margin-top: 20px">
                <div class="layui-input-block">
                    <%--<button class="layui-btn" data-type="content" lay-submit="" lay-filter="demo1">保存</button>--%>
                    <input type="submit" name="btn_submit" id="btn_submit" value="保存" class="layui-btn" >
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    <button type="button" class="layui-btn layui-btn-primary do-action" data-type="doGoBack" data-href="${ctx}/manage/shop/shopQuery">返回</button>
                </div>
            </div>
        </form>

    </div>
</div>

<script src="${ctxStatic}/layuidemo/plugin/layui/layui.js"></script>
<script src="${ctxStatic}/layuidemo/js/form.min.js"></script>
<script src="${ctxStatic}/layuidemo/js/jquery1.8.0.min.js"></script>
<script src="${ctxStatic}/layuidemo/js/profile.min.js"></script>
<script src="${ctxStatic}/layui/lay/modules/laydate.js"></script>

<script type="text/javascript">

    <!--上传之后台返回的提示信息-->
    var message = '${message}';
    if(message !== ''){
        alert('${message}');
    }

</script>

<script>

    layui.config({base:"${ctxStatic}/layuidemo/plugin/layui/lay/modules/mplus/"}).extend({common:"common.min",datatable:"datatable/jquery.dataTables.min",sweetalert:"sweetalert/sweetalert.min",echarts:"echarts/echarts.min",echarts_common:"echarts/echarts.common.min",echarts_simple:"echarts/echarts.simple.min",icheck:"iCheck/icheck.min",cropper:"cropper/cropper.min",chosen:"chosen/chosen.min"});layui.use(["layer","jquery","datatable","icheck","chosen"],function(){var a=layui.layer,b=layui.jquery;b(".icheck").iCheck({checkboxClass:"icheckbox_square-green"});b(".mplus-select").chosen({width:"100%"});b(".mplus-select ~ .layui-form-select").remove();b(function(){var c=b("table th input:checkbox");var d=b('input[name="uuid"]');c.on("ifChecked ifUnchecked",function(e){if(e.type=="ifChecked"){d.iCheck("check")}else{d.iCheck("uncheck")}});d.on("ifChanged",function(e){if(d.filter(":checked").length==d.length){c.prop("checked","checked")}else{c.removeProp("checked")}c.iCheck("update")});d.on("ifChanged",function(e){if(d.filter(":checked").length>1){b("#batch_delete_btn").show()}else{b("#batch_delete_btn").hide()}});b(".dataTable").dataTable({searching:true,paging:true,lengthChange:true,info:true,ordering:true,order:[1,"desc"],orderMulti:true,columnDefs:[{targets:0,searchable:false},{orderable:false,targets:0},{orderable:false,targets:6}],processing:true,autoWidth:false,deferRender:true,lengthMenu:[5,10,25,50,100],pageLength:10,orderClasses:false,pagingType:"full_numbers",language:{emptyTable:"暂无数据！",info:"显示第 _START_ 条到第 _END_ 条，共 _TOTAL_ 条",infoEmpty:"共 _TOTAL_ 条",infoFiltered:"(从 _MAX_ 条数据中过滤)",lengthMenu:"每页显示 _MENU_ 条",loadingRecords:"加载中，请稍等。。。",paginate:{first:"首页",last:"尾页",next:"下一页",previous:"上一页"},processing:"数据处理中。。。",search:"搜索：",zeroRecords:"暂无匹配的记录"},stateSave:true});b(".table-sort tbody").on("click","tr",function(){if(b(this).hasClass("selected")){b(this).removeClass("selected")}else{b("tr.selected").removeClass("selected");b(this).addClass("selected")}})});if(self.frameElement.tagName=="IFRAME"){parent.layer.closeAll()}});changeMainHeight();window.onresize=function(){changeMainHeight()};function changeMainHeight(){var a=document.getElementById("main-wrap");if(a){a.style.minHeight=window.parent.document.documentElement.clientHeight-185+"px"}};

    <%--上传logo--%>
    layui.use('upload', function(){
        layui.upload({
            url: '${ctx}/manage/shop/uploadShopPic'
            ,method: 'post'
            ,before: function (input) {
                layer.msg("图片上传中...", {icon: 16, time: false, shade: 0.1});
            }
            ,success: function(result){ //上传成功后的回调
                if(result.code == 0){
                    $('#imgUrl').attr("value", result.data.src);
                }else {
                    $('#imgUrl').attr("value", "上传失败");
                }
                layer.closeAll();
            }
        });
    });

    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
                layer = layui.layer,
                layedit = layui.layedit,
                laydate = layui.laydate;

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');
        //自定义验证规则
        form.verify({
            title: function(value) {
                if(value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            },
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            content: function(value) {
                layedit.sync(editIndex);
            }
        });
    })


</script>

</body>
</html>
