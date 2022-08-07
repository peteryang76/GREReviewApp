import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class WordsPanel extends JPanel {

    private static final int FONT_SIZE = 30;

    private GREReviewApp app;

    private JLabel word;
    private JLabel definition;

    public WordsPanel(GREReviewApp app) {
        this.app = app;
        setPreferredSize(new Dimension(GREReviewApp.WIDTH, GREReviewApp.HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        initialize();
        add(word, BorderLayout.NORTH);
        add(definition, BorderLayout.CENTER);
    }

    private void initialize() {
        word = new JLabel();
        definition = new JLabel();
    }

    public void setWordAndDef(Actions a) {
        int newIndex = 0;
        switch(a) {
            case NEXT:
                newIndex = app.getIndex() + 1;
                int size = app.getListSize();
                if (newIndex < size) {
                    app.setIndex(newIndex);
                }
                break;
            case PREVIOUS:
                newIndex = app.getIndex() - 1;
                if (newIndex >= 0) {
                    app.setIndex(newIndex);
                }
                break;
            case MARK:
                app.addToForgottenWords(app.getIndex());
                break;
            case DELETE:
                app.deleteFromForgottenList(app.getIndex());
                break;
            case SAVE:
                app.saveForgottenWords();
                break;
            default:

        }
        String wordToBeDisplayed = app.displayWord();
        word.setText(wordToBeDisplayed);
        word.setHorizontalAlignment(CENTER);
        word.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        String defToBeDisplayed = app.displayDef();
        definition.setText(defToBeDisplayed);
        definition.setHorizontalAlignment(CENTER);
        definition.setFont(new Font("Arial", Font.PLAIN, 24));
    }


}





