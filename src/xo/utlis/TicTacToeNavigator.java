/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xo.utlis;

import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import xo.board.BoardMultiPlayerOflineModeController;
//import xo.board.BoardMultiPlayerOnlineModeController;
//import xo.board.BoardSinglePlayerModeController;

/**
 *
 * @author mo_fathy
 */
public class TicTacToeNavigator {

    public static final NavigationDestination LANDING = new NavigationDestination("landing/FXMLLanding.fxml", "LANDING");
    public static final NavigationDestination BOARD_OFFLINE_MULTIPLAYERS = new NavigationDestination("board/FXMLBoard.fxml", "PVP");
    public static final NavigationDestination BOARD_PLAYER_VS_EASY_AI = new NavigationDestination("board/FXMLBoard.fxml", "COMPUTER EASY");
    public static final NavigationDestination HISTORY = new NavigationDestination("history/FXMLHistory.fxml", "HISTORY");
    public static final NavigationDestination LEVELS = new NavigationDestination("levels/FXMLLevels.fxml", "LEVELS");
    public static final NavigationDestination MEDIA = new NavigationDestination("media/FXMLMedia.fxml", "MEDIA");
    public static final NavigationDestination MODES = new NavigationDestination("modes/FXMLModes.fxml", "MODES");
    public static final NavigationDestination ONE_PLAYER_NAME_CHOOSER = new NavigationDestination("one_player_name_chooser/FXMLOnePlayerNameChooser.fxml", "PLAYER NAME");
    public static final NavigationDestination TWO_PLAYER_NAME_CHOOSER = new NavigationDestination("two_players_name_chooser/FXMLTwoPlayersNameChooser.fxml", "PLAYER NAME");
public static final NavigationDestination SING_IN = new NavigationDestination("signin/FXMLsingin.fxml", "PLAYER NAME");
    private static final Stack<NavigationDestination> destinations = new Stack<>();

    private static void navigateTo(Stage stage, Parent root, String title) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    private static void navigateTo(Node node, Parent root, String title) {
        Stage stage = (Stage) node.getScene().getWindow();
        navigateTo(stage, root, title);
    }

    private static void navigateTo(Event event, Parent root, String title) {
        navigateTo((Node) event.getSource(), root, title);
    }

    public static void navigateTo(Event event, Initializable controller, NavigationDestination navigationDestination) throws IOException {
        FXMLLoader loader = new FXMLLoader(xo.Xo.class.getResource(navigationDestination.getDestination()));
        loader.setController(controller);
        navigateTo(event, (Parent) loader.load(), navigationDestination.getTitle());
        destinations.push(navigationDestination);
    }

    public static void navigateTo(Stage stage, Initializable controller, NavigationDestination navigationDestination) throws IOException {
        FXMLLoader loader = new FXMLLoader(xo.Xo.class.getResource(navigationDestination.getDestination()));
        loader.setController(controller);
        navigateTo(stage, (Parent) loader.load(), navigationDestination.getTitle());
        destinations.push(navigationDestination);
    }

    public static void navigateTo(Event event, NavigationDestination navigationDestination) throws IOException {
        FXMLLoader loader = new FXMLLoader(xo.Xo.class.getResource(navigationDestination.getDestination()));
        navigateTo(event, (Parent) loader.load(), navigationDestination.getTitle());
        destinations.push(navigationDestination);
    }

    public static void navigateTo(Node node, NavigationDestination navigationDestination) throws IOException {
        FXMLLoader loader = new FXMLLoader(xo.Xo.class.getResource(navigationDestination.getDestination()));
        navigateTo(node, (Parent) loader.load(), navigationDestination.getTitle());
        destinations.push(navigationDestination);
    }

    public static void previous(Stage stage) throws IOException {
        navigateTo(stage, destinations.pop());
    }

    public static void previous(Event event) throws IOException {
        destinations.pop();
        navigateTo(event, destinations.pop());
    }

    public static void pop() {
        destinations.pop();
    }

    public static void navigateTo(Stage stage, NavigationDestination navigationDestination) throws IOException {
        FXMLLoader loader = new FXMLLoader(xo.Xo.class.getResource(navigationDestination.getDestination()));
        navigateTo(stage, (Parent) loader.load(), navigationDestination.getTitle());
        destinations.push(navigationDestination);
    }

}
