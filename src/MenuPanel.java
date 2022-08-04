import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    public static final String WELCOME = "Welcome to Using GRE Review App!";
    private GREReviewApp app;

    private JLabel welcome;
    private JButton reviewAll;

    public MenuPanel(GREReviewApp app) {
        this.app = app;
        setPreferredSize(new Dimension(GREReviewApp.WIDTH, GREReviewApp.HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        initialize();
        add(welcome, BorderLayout.NORTH);
        add(reviewAll);
    }

    private void initialize() {
        setWelcome();
        setReviewAll();
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
//        reviewAll.setSize(40, 40);
        reviewAll.setPreferredSize(new Dimension(40, 40));
        reviewAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.setReviewAll(true);
                app.setReviewF(false);
            }
        });
        reviewAll.setLocation(100, 1100);
        reviewAll.setVisible(true);
    }


}
