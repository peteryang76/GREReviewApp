import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    public static final String WELCOME = "Welcome to Using GRE Review App!";
    private GREReviewApp app;
    private WordsPanel wordsPanel;
    private ControlPanelA controlPanelA;

    private JLabel welcome;
    private JButton reviewAll;
    private JButton reviewF;

    public MenuPanel(GREReviewApp app, WordsPanel wordsPanel, ControlPanelA controlPanelA) {
        this.app = app;
        this.wordsPanel = wordsPanel;
        this.controlPanelA = controlPanelA;
        setPreferredSize(new Dimension(GREReviewApp.WIDTH, GREReviewApp.HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        initialize();
        add(welcome, BoxLayout.X_AXIS);
        add(reviewAll);
        add(reviewF);
    }

    private void initialize() {
        setWelcome();
        setReviewAll();
        setReviewForgotten();
    }

    private void setWelcome() {
        welcome = new JLabel();
        welcome.setText(WELCOME);
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 30));
        welcome.setVisible(true);
    }

    private void setReviewAll() {
        reviewAll = new JButton("Review All Words");
        reviewAll.setFont(new Font("Arial", Font.PLAIN, 24));
        reviewAll.setPreferredSize(new Dimension(1000, 40));
        reviewAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setReviewAll(true);
                app.setReviewF(false);
                setVisible(false);
                wordsPanel.setVisible(true);
                controlPanelA.setVisible(true);

            }
        });
        reviewAll.setLocation(100, 500);
        reviewAll.setVisible(true);
    }

    private void setReviewForgotten() {
        reviewF = new JButton("Review Forgotton Words List");
        reviewF.setFont(new Font("Arial", Font.PLAIN, 24));
        reviewF.setPreferredSize(new Dimension(1000, 40));
        reviewF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setReviewAll(false);
                app.setReviewF(true);
//                setVisible(false);
            }
        });
        reviewF.setLocation(100, 500);
        reviewF.setVisible(true);
    }

}
