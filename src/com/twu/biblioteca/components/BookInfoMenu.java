package com.twu.biblioteca.components;

import java.util.List;

/**
 * Created on 16/9/30.
 */
public class BookInfoMenu extends MenuTool{
    private List<BookInfo> bookInfos;

    public BookInfoMenu(String menuName) {
        super(menuName);
    }

    public void setBookInfos(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }

    public List<BookInfo> getBookInfos() {
        return bookInfos;
    }

    @Override
    public void display() {
        setMenuSelected();
        System.out.println("Here is the book list, input book number to checkout, input 0 to exit this menu.");
        for (int i = 0; i < bookInfos.size(); i++) {
            BookInfo bookInfo = bookInfos.get(i);
            if (bookInfo.isBorrowed()) {
                continue;
            }
            System.out.println("No." + (i + 1) + " " + bookInfo.getName() + ", " + bookInfo.getAuthor() + ", "
                    + bookInfo.getYearPublished());
        }
    }

    @Override
    public void displayDetail(int menuCode) {
        BookInfo bookInfo;
        if (menuCode > bookInfos.size()) {
            System.out.println("That book is not available.");
        } else {
            System.out.println("Thank you! Enjoy the book");
            bookInfo = bookInfos.get(menuCode - 1);
            bookInfo.setBorrowed();
        }
        display();
    }
}
