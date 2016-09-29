package com.twu.biblioteca;


import com.twu.biblioteca.components.BookInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void shouldOutputWelcomeMsg() {
        assertEquals("Welcome to BibliotecaApp!", BibliotecaApp.showWelcomeMsg());
    }

    @Test
    public void shouldReturnMenus() throws Exception {
        assertEquals(1, BibliotecaApp.prepareMenus().size());
    }

    @Test
    public void shouldPrepareSeveralBooksInfo() throws Exception {
        assertEquals(3, BibliotecaApp.prepareBooksInfo().size());

    }

    @Test
    public void shouldReturnBookDetails() throws Exception {
        BookInfo bookInfo = BibliotecaApp.prepareBooksInfo().get(0);
        assertEquals("ChildHood", bookInfo.getName());
        assertEquals("GoerKi", bookInfo.getAuthor());
        assertEquals("1992", bookInfo.getYearPublished());
    }

}
