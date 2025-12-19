package main;

import controller.PasienController;
import view.PasienFrame;

public class NauraFarmaApp {
    public static void main(String[] args) {
        PasienFrame frame = new PasienFrame();
        new PasienController(frame);
        frame.setVisible(true);
    }
}
