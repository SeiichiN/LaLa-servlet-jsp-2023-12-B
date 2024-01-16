package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SetImageListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	String img_pencil = "<img src='img/pencil.png' alt='編集'>";
    	context.setAttribute("img_pencil", img_pencil);
    	String img_trash = "<img src='img/trash.png' alt='削除'>";
    	context.setAttribute("img_trash", img_trash);
    	String img_find = "<img src='img/find.png' alt='検索'>";
    	context.setAttribute("img_find", img_find);
    	
    }
	
}
