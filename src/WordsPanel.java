import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.CENTER;

public class WordsPanel extends JPanel {

    private static final String NEXT = "Next word";
    private static final String PREVIOUS = "Previous word";
    private static final String MARK = "Mark as forgotten";
    private static final String DELETE = "Delete from forgotten list";
    private static final String Save = "Save forgotten list";
    private static final int FONT_SIZE = 30;

    private GREReviewApp app;

    private JLabel word;
    private JLabel definition;
    private JButton next;
    private JButton previous;
    private JButton mark;
    private JButton delete;
    private JButton save;

    public WordsPanel(GREReviewApp app) {
        this.app = app;
        setPreferredSize(new Dimension(GREReviewApp.WIDTH, GREReviewApp.HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        initialize();
        add(word, BorderLayout.NORTH);
        add(definition, BorderLayout.CENTER);
        add(next, BorderLayout.SOUTH);
        add(previous, BorderLayout.SOUTH);
    }

    private void initialize() {
        word = new JLabel();
        definition = new JLabel();
        setWordAndDef();
        setNext();
        setPrevious();
    }

    private void setWordAndDef() {
        String wordToBeDisplayed = app.displayWord();
        word.setText(wordToBeDisplayed);
        word.setHorizontalAlignment(CENTER);
        word.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        String defToBeDisplayed = app.displayDef();
        definition.setText(defToBeDisplayed);
        definition.setHorizontalAlignment(CENTER);
        definition.setFont(new Font("Arial", Font.PLAIN, 24));
    }

    private void setNext() {
        next = new JButton(NEXT);
        next.setFont(new Font("Arial", Font.PLAIN, 24));
        next.setPreferredSize(new Dimension(1000, 40));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newIndex = app.getIndex() + 1;
                int size = app.getListSize();
                if (newIndex < size) {
                    app.setIndex(newIndex);
                }
                setWordAndDef();
            }
        });
        next.setLocation(100, 500);
        next.setVisible(true);
    }

    private void setPrevious() {
        previous = new JButton(PREVIOUS);
        previous.setFont(new Font("Arial", Font.PLAIN, 24));
        previous.setPreferredSize(new Dimension(1000, 40));
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newIndex = app.getIndex() - 1;
                if (newIndex >= 0) {
                    app.setIndex(newIndex);
                }
                setWordAndDef();
            }
        });
        previous.setLocation(100, 500);
        previous.setVisible(true);
    }

}





