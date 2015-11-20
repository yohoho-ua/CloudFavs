
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<jsp:useBean id="bmDao" class="dao.BookmarkDao" scope="page"/>

<%@include file="/pages/jspf/left_menu.jspf" %>

<div class="book_list">



    <%
        ArrayList<Bookmark> list = new ArrayList<Bookmark>();
        if (request.getParameter("cat_id") != null) {
            int catId = Integer.valueOf(request.getParameter("cat_id"));
            list = bmDao.getByCatalog(catId);
        }
    %>
    <h5 style="text-align: left; margin-top:20px;">bookmarks found: <%=list.size() %> </h5>

    <%
        session.setAttribute("currentBMList", list);
        for (Bookmark bm : list) {

    %>

    <div class="book_info">
        <div class="book_title">
            <p> <%=bm.getTitle()%></p>
        </div>
        <div class="book_image">
            <%--<a href="#"><img src="<%=request.getContextPath()%>/ShowImage?index=<%=list.indexOf(bm)%>" height="250" width="190" alt="Обложка"/></a>--%>
            <a href="#"><img src="/fav/resources/images/ammonite-silhouette-ammonoidea_small.jpg"  width="120" alt="preview"/></a>
        </div>
        <div class="book_details">
            <br><strong>url:</strong> <%=bm.getUrl()%>
            <br><strong>description:</strong> <%=bm.getDescription()%>


            <br><strong>Catalog:</strong> <%%>
            <p style="margin:10px;"> <a href="#">Читать</a></p>
        </div>
    </div>


    <%}%>



</div>