import javax.swing.*;
import java.awt.*;

public class GREReviewAppUI extends JFrame {
    private GREReviewApp app;
    private WordsPanel wordsPanel;
    private MenuPanel menuPanel;


    public GREReviewAppUI() {
        super("GRE Review App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 1200));;
        app = new GREReviewApp();
        wordsPanel = new WordsPanel(app);
        menuPanel = new MenuPanel(app, wordsPanel);

        wordsPanel.setVisible(true);
        menuPanel.setVisible(true);

        add(wordsPanel);
        add(menuPanel, BorderLayout.NORTH);

        pack();
        centreOnScreen();
        setVisible(true);

//        while(app.getReviewF() || app.getReviewAll()) {
//            wordsPanel.setVisible(true);
//            menuPanel.setVisible(false);
//        }
    }

//    private void setWordAndDef() {
//        String wordToBeDisplayed = app.displayWord();
//        word.setText(wordToBeDisplayed);
//        word.setHorizontalAlignment(CENTER);
//        word.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
//        String defToBeDisplayed = app.displayDef();
//        definition.setText(defToBeDisplayed);
//        definition.setHorizontalAlignment(CENTER);
//        definition.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
//    }

//    private void setLeftBottomButton() {
//        previousButton = new JButton(PREVIOUS);
//        previousButton.setPreferredSize(new Dimension(40, 30));
//        previousButton.setLocation(40, 40);
//
//        previousButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int newIndex = app.getIndex() - 1;
//                if (newIndex >= 0) {
//                    app.setIndex(newIndex);
//                }
//                setWordAndDef();
//            }
//        });
//    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }
}
