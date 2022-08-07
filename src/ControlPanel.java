import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ControlPanel extends JPanel {

    private static final String NEXT = "Next word";
    private static final String PREVIOUS = "Previous word";
    private static final String DELETE = "Delete from forgotten list";
    private static final String SAVE = "Save forgotten list";
    private static final int FONT_SIZE = 30;

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 600;

    private WordsPanel wordsPanel;
    private JButton mark;
    private JButton previous;
    private JButton save;
    private GREReviewApp app;

    public ControlPanel(WordsPanel wordsPanel, GREReviewApp app) {
        this.wordsPanel = wordsPanel;
        this.app = app;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        initialize();
        add(mark);
        add(previous, BoxLayout.X_AXIS);
        add(save, BoxLayout.X_AXIS);
    }

    private void initialize() {
        setNext();
        setPrevious();
        setSave();
    }

    private void setNext() {
        mark = new JButton(NEXT);
        mark.setFont(new Font("Arial", Font.PLAIN, 24));
        mark.setPreferredSize(new Dimension(1000, 40));
        mark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordsPanel.setWordAndDef(Actions.NEXT);
            }
        });
        mark.setLocation(100, 500);
        mark.setVisible(true);
    }

    private void setPrevious() {
        previous = new JButton(PREVIOUS);
        previous.setFont(new Font("Arial", Font.PLAIN, 24));
        previous.setPreferredSize(new Dimension(1000, 40));
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordsPanel.setWordAndDef(Actions.PREVIOUS);
            }
        });
        previous.setLocation(100, 500);
        previous.setVisible(true);
    }

    private void setSave() {
        save = new JButton(SAVE);
        save.setFont(new Font("Arial", Font.PLAIN, 24));
        save.setPreferredSize(new Dimension(1000, 40));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.saveForgottenWords();
            }
        });
        previous.setLocation(100, 500);
        previous.setVisible(true);
    }



}
