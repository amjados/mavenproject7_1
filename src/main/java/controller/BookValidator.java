/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Amjad
 */
public class BookValidator implements Validator {

    private int DEFAULT_MIN_PAGES = 0;
    private int DEFAULT_MAX_PAGES = 1500;
    private int minPages = DEFAULT_MIN_PAGES;
    private int maxPages = DEFAULT_MAX_PAGES;

    /**
     * Logger for this class and subclasses
     */
    @Override
    public boolean supports(Class clazz) {

        return Book.class.getName().equals(clazz.getName());

    }

    @Override
    public void validate(Object obj, Errors errors) {

        Book pi = (Book) obj;

        if (pi == null) {
            errors.rejectValue("pages", "error.not-specified", null, "Value required.");
            return;
        }

        if (pi.getPages() != null && pi.getPages() > maxPages) 
        {
            errors.rejectValue("pages", "error.too-high",new Object[]{new Integer(maxPages)}, "Value too high.");
        }

        if (pi.getPages() != null && pi.getPages() <= minPages) 
        {
            errors.rejectValue("pages", "error.too-low",new Object[]{new Integer(minPages)}, "Value too low.");
        }

        if (pi.getSubject() ==null || pi.getSubject().length()<=0) 
        {
            errors.rejectValue("subject", "error.required",new Object[]{"Subject"}, "Value Is Required.");
        }

        if (pi.getTitle() ==null || pi.getTitle().length()<=0) 
        {
            errors.rejectValue("title", "error.required",new Object[]{"Title"}, "Value Is Required.");
        }

    }

    public void setMinPages(int i) {

        minPages = i;

    }

    public int getMinPages() {

        return minPages;

    }

    public void setMaxPages(int i) {

        maxPages = i;

    }

    public int getMaxPages() {

        return maxPages;

    }
}