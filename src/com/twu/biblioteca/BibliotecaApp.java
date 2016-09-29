package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import com.twu.biblioteca.components.BookInfo;
import com.twu.biblioteca.components.MenuTool;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<BookInfo> bookInfos = prepareBooksInfo();
        List<MenuTool> menuTools = prepareMenus();
        System.out.println(showWelcomeMsg());

        showBookListInfo(bookInfos);
    }

    static String showWelcomeMsg() {
        return "Welcome to BibliotecaApp!";
    }

    private static void showBookListInfo(List<BookInfo> bookInfos) {
        System.out.println("Here is the book list:");
        for (int i = 0; i < bookInfos.size(); i++) {
            BookInfo bookInfo = bookInfos.get(i);
            System.out.println((i + 1) + ". " + bookInfo.getName() + ", " + bookInfo.getAuthor() + ", "
                    + bookInfo.getYearPublished());
        }
    }

    static List<BookInfo> prepareBooksInfo() {
        List<BookInfo> bookInfos = new ArrayList<>();
        CreateBookAndAdd(bookInfos);
        return bookInfos;
    }

    private static void CreateBookAndAdd(List<BookInfo> bookInfos) {
        BookInfo bookInfo1 = new BookInfo("ChildHood", "GoerKi", "1992");
        BookInfo bookInfo2 = new BookInfo("ChildHood2", "GoerKi", "1993");
        BookInfo bookInfo3 = new BookInfo("ChildHood3", "GoerKi", "1994");
        bookInfos.add(bookInfo1);
        bookInfos.add(bookInfo2);
        bookInfos.add(bookInfo3);
    }

    static List<MenuTool> prepareMenus() {
        List<MenuTool> menuTools = new ArrayList<>();
        MenuTool menuTool1 = new MenuTool("BookList");
        menuTools.add(menuTool1);
        return menuTools;
    }
}
