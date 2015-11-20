package controller;

import dao.BookmarkDao;
import dao.CatalogDao;
import domain.Bookmark;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Zim on 20.11.2015.
 */
public class BookmarkControlller extends HttpServlet {
    private CatalogDao catDao;
    private BookmarkDao bDao;
    public static final String MAIN_PAGE = "/pages/main.jsp";
    public static final String LIST_PAGE = "/pages/bmarks2.jsp";
    public static final String INSERT_OR_EDIT = "/pages/edit.jsp";

    public BookmarkControlller() {

        catDao = new CatalogDao();
        bDao = new BookmarkDao();

    }


    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");
        System.out.println(action);
        if (action.equalsIgnoreCase("delete")) {
            forward = MAIN_PAGE;
            int bm_id = Integer.parseInt(request.getParameter("bm_id"));
            bDao.delete(bm_id);
           // request.getSession().setAttribute("bookmarks", bDao.getByCatalog(Integer.parseInt(request.getParameter("cat_id"))));
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            request.getSession().setAttribute("catalogs", catDao.getAll() );
            request.getSession().setAttribute("bookmark", bDao.getByPK(Integer.parseInt(request.getParameter("bm_id"))));
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else if (action.equalsIgnoreCase("list")) {
            forward = LIST_PAGE;
            request.getSession().setAttribute("catalogs", catDao.getAll());
            request.getSession().setAttribute("bookmarks", bDao.getByCatalog(Integer.parseInt(request.getParameter("cat_id"))));
        }
        else if (action.equalsIgnoreCase("save")) {
            forward = LIST_PAGE;
            request.getSession().setAttribute("catalogs", catDao.getAll() );
            Bookmark bookmark = new Bookmark();
            bookmark.setOwner_id(5);
            bookmark.setUrl( request.getParameter( "url" ) );
            bookmark.setTitle( request.getParameter( "title" ) );
            bookmark.setDescription( request.getParameter( "description" ) );
            bookmark.setCatalog_id(Integer.parseInt( request.getParameter( "catalog_id" ) ));

            String bm_id = request.getParameter("id");
            Date date = new Date();
            if( bm_id == null || bm_id.isEmpty() ) {
                bookmark.setDate_created(new Timestamp(date.getTime()));
                bookmark.setDate_updated(new Timestamp(date.getTime()));
                bDao.create(bookmark);
            }else {
                Timestamp created =  Timestamp.valueOf(request.getParameter("date_created"));
                bookmark.setDate_created(created);
                bookmark.setDate_updated(new Timestamp(date.getTime()));
                bookmark.setId(Integer.parseInt(request.getParameter("id")) );
                System.out.println("id = " + bookmark.getId());
                bDao.update(bookmark);
            }
        }

        else {
            forward = MAIN_PAGE;
            request.setAttribute("catalogs", catDao.getAll());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
}
