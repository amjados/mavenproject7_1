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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.AddService;
import util.ItpdbHibernateUtil;

/**
 *
 * @author Amjad
 */

public class AddController extends SimpleFormController {

    private AddService addService;
    private BookValidator bookVal = new BookValidator();

    public void setAddService(AddService addService) 
    {
        this.addService = addService;
    }

    public AddController() 
    {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Book.class);
        setCommandName("bookAddNew");
        setSuccessView("booksIndexPage");
        setFormView("booksAddNewPage");

        setValidator(bookVal);

    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws ServletException 
    {
        //for editing the Book
        if (request.getParameter("approveParam") == null && request.getParameter("id") != null) {
            int intValId = Integer.parseInt(request.getParameter("id"));
            Book selectedObj = getSelectedBook(intValId); 
            return selectedObj;
        }

        return new Book();
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception
    {
        Book book = (Book) command;
        
        ModelAndView mv = new ModelAndView("redirect:/list.htm");;

        int proceededBookId = -1;

        //check if it's New Book( dont have ID) 
        //if not new will update it.
        if (book != null && (book.getBookid() == null || book.getBookid() <= 0)) {
            proceededBookId = addBook(book);
        } else {
            proceededBookId = updateBook(book);
        }
        
        if (proceededBookId <= 0) {
            mv = new ModelAndView(getFormView());
            mv.addObject("bookAddNew", book);
            mv.addObject("errorMsg", "Error.");

        }
        
        //Reset the Form Withe New Book
        mv.addObject("bookSearch", new Book());



        return mv;
    }

    public int addBook(Book book_) 
    {

        SessionFactory sessiFac = ItpdbHibernateUtil.getSessionFactory();

        Session sessi = sessiFac.openSession();

        List messages = sessi.createQuery("select max(bookid) as max from Book").list();
        Integer maxBookId = (Integer) messages.get(0);

        sessi.beginTransaction();


        book_.setBookid(maxBookId + 1);

        sessi.save(book_);
        sessi.getTransaction().commit();

        sessi.close();
        //sessiFac.close();



        return book_.getBookid();

    }

    private Book getSelectedBook(int intValId) throws ServletException 
    {
        Session sessi = null;

        try {
            SessionFactory sessiFac = ItpdbHibernateUtil.getSessionFactory();

            sessi = sessiFac.openSession();

            Query query = sessi.createQuery("From Book WHERE BOOKID =:val_");

            query.setInteger("val_", intValId);

            List messages = query.list();

            if (messages.size() > 0) {
                Book book = (Book) messages.get(0);
                return book;
            }
            return new Book();
        } finally {
            sessi.close();
        }
    }

    private int updateBook(Book book_) 
    {

        SessionFactory sessiFac = ItpdbHibernateUtil.getSessionFactory();

        Session sessi = sessiFac.openSession();

        //List messages = sessi.createQuery("select max(bookid) as max from Book").list();
        //Integer maxBookId = (Integer) messages.get(0);

        sessi.beginTransaction();


        //book_.setBookid(maxBookId + 1);

        sessi.update(book_);
        sessi.getTransaction().commit();

        sessi.close();
        //sessiFac.close();



        return book_.getBookid();

    }
}