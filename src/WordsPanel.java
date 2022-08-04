import javax.swing.*;
import java.awt.*;

public class WordsPanel extends JPanel {

    private static final String NEXT = "Next word";
    private static final String PREVIOUS = "Previous word";
    private static final String MARK = "Mark as forgotten";
    private static final String DELETE = "Delete from forgotten list";
    private static final String Save = "Save forgotten list";

    private GREReviewApp app;

    public WordsPanel(GREReviewApp app) {
        setPreferredSize(new Dimension(GREReviewApp.WIDTH, GREReviewApp.HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        this.app = app;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



    }

    private void drawApp(Graphics g) {
        app.draw(g);
    }



}
