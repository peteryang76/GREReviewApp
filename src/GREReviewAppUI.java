import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.CENTER;

public class GREReviewAppUI extends JFrame {
    private GREReviewApp app;
    private WordsPanel wordsPanel;
    private MenuPanel menuPanel;
    private static final String NEXT = "Next word";
    private static final String PREVIOUS = "Previous word";
    private static final String MARK = "Mark as forgotten";
    private static final String DELETE = "Delete from forgotten list";
    private static final String Save = "Save forgotten list";
    private static final int FONT_SIZE = 24;
    private JLabel word;
    private JLabel definition;
    private JButton previousButton;

    private String wordToBeDisplayed;
    private String defToBeDisplayed;

    public GREReviewAppUI() {
        super("GRE Review App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 1200));;
        app = new GREReviewApp();
        wordsPanel = new WordsPanel(app);
        menuPanel = new MenuPanel(app);
        word = new JLabel("Word");
        definition = new JLabel("Definition");

        add(wordsPanel);
        setWordAndDef();
        add(word, BorderLayout.NORTH);
        add(definition, BorderLayout.CENTER);

        setLeftBottomButton();
        add(previousButton, BorderLayout.SOUTH);
//        JButton midBottom = new JButton(MARK);
//        JButton rightBottom = new JButton(NEXT);
//
//        add(midBottom);
//        add(rightBottom);
        pack();
        centreOnScreen();
        setVisible(true);
    }

    private void setWordAndDef() {
        wordToBeDisplayed = app.displayWord();
        word.setText(wordToBeDisplayed);
        word.setHorizontalAlignment(CENTER);
        word.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        defToBeDisplayed = app.displayDef();
        definition.setText(defToBeDisplayed);
        definition.setHorizontalAlignment(CENTER);
        definition.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
    }

    private void setLeftBottomButton() {
        previousButton = new JButton(PREVIOUS);
        previousButton.setPreferredSize(new Dimension(40, 30));
        previousButton.setLocation(40, 40);

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newIndex = app.getIndex() - 1;
                if (newIndex >= 0) {
                    app.setIndex(newIndex);
                }
                setWordAndDef();
            }
        });
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }
}
