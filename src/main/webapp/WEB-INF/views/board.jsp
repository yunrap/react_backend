<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layout/header.jsp" %>
<%@ include file="/WEB-INF/layout/sidebar.jsp" %>
<!DOCTYPE html>
<html>
<head>

</head>
<h1>Board sample</h1>
<body>
<%--enctype="multipart/form-data"--%>
    <form name="form" id="form" method="post" action="/board/insertBoard"  >
        <!-- table_view -->
        <section class="tbl_wrap_view">
            <table class="tbl_view01">
                <colgroup>
                    <col width="180px;" />
                    <col width="55%" />
                    <col width="180px;" />
                    <col width="" />
                </colgroup>
                <tr>
                    <th scope="row">제목</th>
                    <td>
                        <div class="">
                            <input type="text" id="boardSubject" class="" placeholder="제목 입력" name="boardSubject" />
                        </div>
                    </td>
<%--                    <th>노출여부</th>--%>
<%--                    <td>--%>
<%--                        <div class="">--%>
<%--                            <label class="">--%>
<%--                                <input type="radio" name="nTop" id="nTopY" value="Y" checked="checked" />--%>
<%--                                <span class=""></span>노출</label>--%>
<%--                            <label class="">--%>
<%--                                <input type="radio" name="nTop" id="nTopY" value="N" />--%>
<%--                                <span class=""></span>미노출</label>--%>
<%--                        </div>--%>
<%--                    </td>--%>
                </tr>
                <tr>
                    <th scope="row">작성자</th>
                    <td>
                        <div class="">
                            <input type="text" id="boardWriter" class="" placeholder="작성자 입력" name="boardWriter" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">내용</th>
                    <td colspan="3">
                        <div class="">
                            <textarea name="" id="boardContent" cols="" rows="5" class=""
                                      placeholder="공지사항 내용 입력"></textarea>
                        </div>
                        <div id="errnContent"></div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">첨부파일</th>
                    <td colspan="3">
                        <section>
                            <ul class="" id="fileview">
                                <li id="li0" style="padding-bottom:3px">
                                    <div class="">
                                        <input type='file' name='uploadFile' multiple />
                                    </div>
                                </li>
                            </ul>
                        </section>
<%--                        <section class="">--%>
<%--                            <span id="errnFile" class="">5MB 이내의 허용된 확장자 파일만 첨부할 수 있습니다. (jpg, png, jpeg,--%>
<%--                                bmp, tiff,tif, pdf만 가능)</span>--%>
<%--                        </section>--%>
                    </td>
                </tr>
            </table>
        </section>
        <!-- //table_view -->
        <!-- button -->
        <section class="">
        <%-- <button type="button" class="">목록</button>--%>
            <section>
                <%--<button type="button" class="">취소</button>--%>
                <button type="submit" id="submit" class="">저장</button>
            </section>
        </section>
        <!-- //button -->
    </form>
<script>

    $(document).ready(function () {
        // $("#regBtn").click(function(){
        //
        //     console.log("등록");
        // })
    });
</script>

</body>
</html>
<%@ include file="/WEB-INF/layout/footer.jsp" %>
