package state;

import contracts.IUpdatePanelUi;
import ui.panels.GameBoardPanel;
import ui.panels.TimeCountPanel;

import java.util.ArrayList;

public class PanelReference {

    private static ArrayList<IUpdatePanelUi> collection = new ArrayList<>();

    public static void push(IUpdatePanelUi element) {
        collection.add(element);
    }

    public static void updatePanelUi() {

        for(int i = 0; i < collection.size(); i++) {
            collection.get(i).updatePanelUi();
        }
    }

    private static GameBoardPanel gameBoardPanel;
    private static TimeCountPanel timeCountPanel;

    public static IUpdatePanelUi getGameBoardPanel() {
        return gameBoardPanel;
    }

    public static void setGameBoardPanel(GameBoardPanel reference) {
        gameBoardPanel = reference;
    }

    public static TimeCountPanel getTimeCountPanel() {
        return timeCountPanel;
    }

    public static void setTimeCountPanel(TimeCountPanel reference) {
        timeCountPanel = reference;
    }
}
