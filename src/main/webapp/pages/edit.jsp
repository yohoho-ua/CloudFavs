<%@page contentType="text/html" pageEncoding="UTF-8" %>


<!DOCTYPE html>


<%@include file="/pages/jspf/left_menu.jspf" %>
<div class="edit_form">
<form action="/fav/servlet.do?action=save" method="post">
    <fieldset align="right">
        <legend>Edit bookmark:</legend>
        <div>
            <label for="id">Bookmark ID</label> <input type="text"
                                                       name="id" value="<c:out value="${bookmark.id}" />"
                                                       readonly="readonly" placeholder="Bookmark ID"/>
        </div>

        <div>
            <label for="owner_id">Owner</label> <input type="text"
                                                       name="owner_id" value="<c:out value="${bookmark.owner_id}" />"
                                                       readonly="readonly" placeholder="Bookmark ID"/>
        </div>

        <div>
            <label for="title">Title</label> <input type="text"
                                                    name="title" value="<c:out value="${bookmark.title}" />"
                                                    placeholder="Title"/>
        </div>

        <div>
            <label for="url">URL</label> <input type="text"
                                                name="url" value="<c:out value="${bookmark.url}" />"
                                                placeholder="URL"/>
        </div>
        <div>
            <label for="date_created">Created</label> <input type="text"
                                                             name="date_created"
                                                             value="<c:out value="${bookmark.date_created}" />"
                                                             placeholder="date created"/>
        </div>

        <div>
            <label for="date_updated">Updated</label> <input type="text"
                                                             name="date_updated"
                                                             value="<c:out value="${bookmark.date_updated}" />"
                                                             placeholder="date updated"/>
        </div>
        <div>
            <label for="description">Description</label> <input type="text"
                                                                name="description"
                                                                value="<c:out value="${bookmark.description}" />"
                                                                placeholder="description"/>
        </div>
        <div>
            <label for="catalog_id">Catalog</label> <input type="text"
                                                           name="catalog_id"
                                                           value="<c:out value="${bookmark.catalog_id}" />"
                                                           placeholder="catalog id"/>
        </div>

        <div>
            <input type="submit" value="Submit"/>
        </div>
    </fieldset>
</form>
</div>