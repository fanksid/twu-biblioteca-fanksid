package com.twu.biblioteca.components;

/**
 * Created on 16/9/29.
 */
public class MenuTool {
    private String menuName;
    private boolean isSelected;

    MenuTool(String menuName) {
        this.menuName = menuName;
        isSelected = false;
    }

    public String getMenuName() {
        return menuName;
    }

    public void display() {

    }

    void setMenuSelected() {
        this.isSelected = true;
    }

    public void displayDetail(int mendCode) {
    }
}
