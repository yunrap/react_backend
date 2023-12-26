<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<%@ include file="/WEB-INF/layout/sidebar.jsp" %>
<!DOCTYPE html>
<html>
<head>

</head>
<h1>sample</h1>
<body>
<div class='wrap'>
    <form method="post" id="searchFormPopup" name="searchFormPopup" onsubmit="return false;">
        <div class="group-form">
            <label for="LOG_DT">Log Date</label>
            <input type="text" class="control-form dateicon fa-calendar" placeholder="Log Date" id="LOG_DT" name="logDt">
        </div>
        <div class="tbl-input-area">
            <input type="text" id="searchValue" name="searchValue" class="control-form"
                   placeholder="text">
            <input type="text" id="searchText" name="searchText" class="control-form"
                   placeholder="text">
        </div>
    </form>
</div>
<button id="clickBtn">데이터 불러오기테스트</button>
<script>
    $('#test').css('border','1px solid blue');
    $(document).ready(function () {

        $("#clickBtn").click(function () {

            var searchObject = $("#searchFormPopup").getFormObject();
            alert(JSON.stringify(searchObject));

            comm.ajaxPost({
                url: "/json/getDataList.json",
                data: searchObject,
                async : false,
                fnSuccess : function(jsonData) {
                    console.log(jsonData);
                }
            });

        });

        //시작일, 종료일 화면에 셋팅
        var startDay = new Date();
        comm.datepicker('LOG_DT',startDay,null); //오늘 날짜인 yyyymmdd형식으로 value값 지정
    });
</script>

</body>
</html>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
