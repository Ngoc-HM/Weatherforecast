/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entry;

import Gui.PrepareGui;

/**
 *
 * @author Administrator
 */
public class Start {
    public static void main(String[] args) {
        PrepareGui gui = new PrepareGui();
        gui.getWeather().setVisible(true);
    }
}
