/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ListService;

import util.ItpdbHibernateUtil;

/**
 *
 * @author Amjad
 */
public class ListController extends SimpleFormController {

    private ListService listService;
    private BookValidator bookVal = new BookValidator();

    public void setListService(ListService listService) 
    {
        this.listService = listService;
    }
    
    public ListController() 
    {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Book.class);
        setCommandName("bookSearch");
        setSuccessView("booksIndexPage");
        setFormView("booksIndexPage");

        setValidator(bookVal);
    }
           
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
              
        ModelAndView mv;
        mv = super.handleRequest(request, response);
        
        //this will display Book List at the page startup.
        if(request.getParameter("approveParam")==null || request.getParameter("approveParam").equalsIgnoreCase("all"))
        {
            List list = getList();
            mv.addObject("lists", list);
        }              
        return mv;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception 
    {
                
        Book book = (Book) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        mv.addObject("booksMessage", book);

        List list = null;
        if(request.getParameter("approveParam")!=null && request.getParameter("approveParam").equalsIgnoreCase("Search"))
        {          
            list = getList(book);     
        }      
            
        mv.addObject("lists", list);    
            
        mv.addObject("bookSearch", book);
 
        return mv;
    }

    private List getList()
    {
        return getList(null);
    }

    private List getList(Book filterVal)
    {

        SessionFactory sessiFac = ItpdbHibernateUtil.getSessionFactory();

        Session sessi = sessiFac.openSession();

        Query query = sessi.createQuery("From Book");

        if (filterVal != null) {
            query = sessi.createQuery("From Book WHERE TITLE like(:val_)");
            query.setString("val_", filterVal.getTitle());
        }
        List messages = query.list();

        sessi.close();

        return messages;
    }  
}