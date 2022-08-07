import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanelA extends ControlPanel {

    private static final String MARK = "Mark as forgotten";

    private  JButton mark;
    private WordsPanel wordsPanel;

    public ControlPanelA(WordsPanel wordsPanel, GREReviewApp app) {
        super(wordsPanel, app);
        this.wordsPanel = wordsPanel;
        setMark();
        add(mark);
    }

    private void setMark() {
        mark = new JButton(MARK);
        mark.setFont(new Font("Arial", Font.PLAIN, 24));
        mark.setPreferredSize(new Dimension(1000, 40));
        mark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordsPanel.setWordAndDef(Actions.MARK);
            }
        });
        mark.setLocation(100, 500);
        mark.setVisible(true);
    }
}
