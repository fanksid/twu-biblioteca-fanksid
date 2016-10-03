package com.twu.biblioteca;


import com.twu.biblioteca.components.BookInfo;
import com.twu.biblioteca.components.BookInfoMenu;
import com.twu.biblioteca.components.MenuTool;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {
    private List<BookInfo> bookInfos;
    private List<MenuTool> menuTools;

    @Before
    public void setUp() throws Exception {
        bookInfos = BibliotecaApp.prepareBooksInfo();
        menuTools = BibliotecaApp.prepareMenus(bookInfos);
    }

    @Test
    public void shouldOutputWelcomeMsg() {
        assertEquals("Welcome to BibliotecaApp!", BibliotecaApp.showWelcomeMsg());
    }

    @Test
    public void shouldReturnMenus() throws Exception {
        assertEquals(1, BibliotecaApp.prepareMenus(new ArrayList<>()).size());
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

    @Test
    public void whenRunPrepareMenusShouldCreateBookInfoMenu() throws Exception {
        assertTrue(BibliotecaApp.prepareMenus(new ArrayList<>()).get(0) instanceof BookInfoMenu);
    }

    @Test
    public void whenDisplayMenuShouldMakeIsSelectedTrue() throws Exception {
        MenuTool menuTool = menuTools.get(0);
        menuTool.displayDetail(1);
        assertTrue(menuTool instanceof BookInfoMenu);
        assertTrue(((BookInfoMenu)menuTool).getBookInfos().get(0).isBorrowed());
    }
}
