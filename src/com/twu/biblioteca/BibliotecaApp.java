package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.twu.biblioteca.components.BookInfoMenu;
import com.twu.biblioteca.exception.MenuInputException;
import org.apache.commons.lang3.*;
import com.twu.biblioteca.components.BookInfo;
import com.twu.biblioteca.components.MenuTool;

public class BibliotecaApp {

    public static void main(String[] args) throws MenuInputException {
        List<BookInfo> bookInfos = prepareBooksInfo();
        List<MenuTool> menuTools = prepareMenus(bookInfos);
        System.out.println(showWelcomeMsg());
        Scanner scanner = new Scanner(System.in);
        showMenuTools(menuTools);

        Stack<Object> stack = new Stack<>();
        stack.push("ROOT");

        int mendCode;

        while (!stack.isEmpty()){
            String menuId = scanner.nextLine();
            mendCode = getMenuCode(menuId);

            if (mendCode == 0) {
                stack.pop();
                if (!stack.isEmpty()) {
                    displayMenuDetail(stack);
                }
                continue;
            }

            Object menu = stack.peek();

            if (menu instanceof String) {
                MenuTool menuTool = displayMenu(menuTools, mendCode);
                stack.push(menuTool);
            }

            if (menu instanceof MenuTool) {
                ((MenuTool) menu).displayDetail(mendCode);
            }

        }

    }

    private static void displayMenuDetail(Stack<Object> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Object menu = stack.peek();
        if (menu instanceof String) {
            showMenuTools(prepareMenus(prepareBooksInfo()));
        }
        else{
            ((MenuTool) menu).display();
        }
    }

    private static int getMenuCode(String menuId) throws MenuInputException {
        int mendCode;
        if (StringUtils.isNumeric(menuId)) {
            mendCode = Integer.valueOf(menuId);
        } else {
            throw new MenuInputException("The input is illegal");
        }
        return mendCode;
    }

    private static MenuTool displayMenu(List<MenuTool> menuTools, Integer menuCode) throws MenuInputException {
        if (menuCode == 0) {
            return null;
        }
        if (menuCode > menuTools.size()) {
            System.out.println("Select a valid option!");
        }
        MenuTool menuTool = menuTools.get(menuCode - 1);
        menuTool.display();
        return menuTool;
    }

    private static void showMenuTools(List<MenuTool> menuTools) {
        System.out.println("Here is the Menu Option, please input the number to choose the menu.");
        for (int i = 0; i < menuTools.size(); i++) {
            MenuTool menuTool = menuTools.get(i);
            String menuInfo = (i + 1) + ". " + menuTool.getMenuName();
            System.out.println(menuInfo);
        }
    }

    static String showWelcomeMsg() {
        return "Welcome to BibliotecaApp!";
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

    static List<MenuTool> prepareMenus(List<BookInfo> bookInfos) {
        List<MenuTool> menuTools = new ArrayList<>();
        BookInfoMenu bookInfoMenu = new BookInfoMenu("Show BookList");
        bookInfoMenu.setBookInfos(bookInfos);
        menuTools.add(bookInfoMenu);
        return menuTools;
    }
}
