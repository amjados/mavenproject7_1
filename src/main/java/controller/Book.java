/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;









import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amjad
 */
@Entity
@Table(catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookid", query = "SELECT b FROM Book b WHERE b.bookid = :bookid"),
    @NamedQuery(name = "Book.findBySubject", query = "SELECT b FROM Book b WHERE b.subject = :subject"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
    @NamedQuery(name = "Book.findByPublisher", query = "SELECT b FROM Book b WHERE b.publisher = :publisher"),
    @NamedQuery(name = "Book.findByCopyright", query = "SELECT b FROM Book b WHERE b.copyright = :copyright"),
    @NamedQuery(name = "Book.findByEdition", query = "SELECT b FROM Book b WHERE b.edition = :edition"),
    @NamedQuery(name = "Book.findByPages", query = "SELECT b FROM Book b WHERE b.pages = :pages"),
    @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Book.findByNumberofbooks", query = "SELECT b FROM Book b WHERE b.numberofbooks = :numberofbooks"),
    @NamedQuery(name = "Book.findByNumberofavailblebooks", query = "SELECT b FROM Book b WHERE b.numberofavailblebooks = :numberofavailblebooks"),
    @NamedQuery(name = "Book.findByNumberofborrowedbooks", query = "SELECT b FROM Book b WHERE b.numberofborrowedbooks = :numberofborrowedbooks"),
    @NamedQuery(name = "Book.findByLibrary", query = "SELECT b FROM Book b WHERE b.library = :library"),
    @NamedQuery(name = "Book.findByAvailble", query = "SELECT b FROM Book b WHERE b.availble = :availble"),
    @NamedQuery(name = "Book.findByShelfno", query = "SELECT b FROM Book b WHERE b.shelfno = :shelfno")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer bookid;
    @Size(max = 255)
    @Column(length = 255)
    private String subject;
    @Size(max = 255)
    @Column(length = 255)
    private String title;
    @Size(max = 255)
    @Column(length = 255)
    private String author;
    @Size(max = 255)
    @Column(length = 255)
    private String publisher;
    private Integer copyright;
    private Integer edition;
    private Integer pages;
    @Size(max = 50)
    @Column(length = 50)
    private String isbn;
    private Integer numberofbooks;
    private Integer numberofavailblebooks;
    private Integer numberofborrowedbooks;
    @Size(max = 255)
    @Column(length = 255)
    private String library;
    private Integer availble;
    private Integer shelfno;  
    
    public Book() {
    }

    public Book(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getCopyright() {
        return copyright;
    }

    public void setCopyright(Integer copyright) {
        this.copyright = copyright;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumberofbooks() {
        return numberofbooks;
    }

    public void setNumberofbooks(Integer numberofbooks) {
        this.numberofbooks = numberofbooks;
    }

    public Integer getNumberofavailblebooks() {
        return numberofavailblebooks;
    }

    public void setNumberofavailblebooks(Integer numberofavailblebooks) {
        this.numberofavailblebooks = numberofavailblebooks;
    }

    public Integer getNumberofborrowedbooks() {
        return numberofborrowedbooks;
    }

    public void setNumberofborrowedbooks(Integer numberofborrowedbooks) {
        this.numberofborrowedbooks = numberofborrowedbooks;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public Integer getAvailble() {
        return availble;
    }

    public void setAvailble(Integer availble) {
        this.availble = availble;
    }

    public Integer getShelfno() {
        return shelfno;
    }

    public void setShelfno(Integer shelfno) {
        this.shelfno = shelfno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookid != null ? bookid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookid == null && other.bookid != null) || (this.bookid != null && !this.bookid.equals(other.bookid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Book[ bookid=" + bookid + " ]";
    }
    
}
