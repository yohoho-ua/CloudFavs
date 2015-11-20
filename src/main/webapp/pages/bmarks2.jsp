
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>



<%@include file="/pages/jspf/left_menu.jspf" %>

<div class="book_list">
    <c:forEach items="${bookmarks}" var="bm">
        <div class="book_info">
            <div class="book_title">
          <p><c:out value="${bm.title}" /></p>
            </div>
            <div class="book_image">
                    <%--<a href="#"><img src="<%=request.getContextPath()%>/ShowImage?index=<%=list.indexOf(bm)%>" height="250" width="190" alt="Обложка"/></a>--%>
                <a href="<c:out value="${bm.url}" />"><img src="/fav/resources/images/ammonite-silhouette-ammonoidea_small.jpg"  width="120" alt="preview"/></a>
            </div>
            <div class="book_details">
                <br><strong>url:</strong> <c:out value="${bm.url}" />
                <br><strong>description: </strong><c:out value="${bm.description}" />
                <br><strong>catalog: </strong><c:out value="${bm.catalog_id}" />
                <br> <a href="/fav/servlet.do?action=edit&bm_id=<c:out value="${bm.id}" />">
                <img src="/fav/resources/images/edit.png" width="20" alt="edit"/></a>
                <a href="/fav/servlet.do?action=delete&bm_id=<c:out value="${bm.id}" />">
                <img src="/fav/resources/images/DeleteRed.png" width="20" alt="edit"/></a>
              </div>
            </div>
    </c:forEach>
    <a href="/fav/servlet.do?action=insert&cat_id=${sessionScope.currentCatalog}">
        <div class="book_add" >
           <span class="add" style="font-size: large; color: aliceblue">add</span>

        </div>
    </a>




</div>