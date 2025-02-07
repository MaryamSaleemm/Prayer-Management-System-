
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    public Splash() {
        SplashScreen();
    }
    private void SplashScreen() {
        setTitle("Prayer Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Set the frame size
        int frameWidth = screenWidth -400;
        int frameHeight = screenHeight - 70;
        setSize(frameWidth, frameHeight);

        // Load and scale background image to full screen
        ImageIcon originalIcon = new ImageIcon("src/Assets/bgcomplete.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImage));
        background.setLayout(new GridBagLayout()); // Use GridBagLayout to position items

        // Text labels
        JLabel titleLabel = new JLabel("\"Welcome to the Prayer Management System\"");
        titleLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLACK);

        JLabel quoteLabel = new JLabel("\"Salah will be the first question on the Day of Judgment.\"");
        quoteLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
        quoteLabel.setForeground(Color.BLACK);

        // Panel for text (centered)
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false); // Transparent panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        contentPanel.add(quoteLabel, gbc);

        // Add components to the frame
        background.add(contentPanel);
        add(background, BorderLayout.CENTER);

        setVisible(true);

        // Timer to automatically transition to the next frame after a delay
        Timer timer = new Timer(3000, e -> {
            new Registration().setVisible(true); // Show the next frame (Registration)
            dispose(); // Close the splash screen
        });
        timer.setRepeats(false); // Ensure the timer only triggers once
        timer.start(); // Start the timer
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Splash::new);
    }
}
