import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class Registration extends JFrame {
    private JLabel background, registerLabel, messageLabel;
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JButton registerButton, backButton, nextButton;
    private Connection connection;

    public Registration() {
        connectDatabase();

        // Check if a user is already registered
        if (isUserAlreadyRegistered()) {
            new Home().setVisible(true); // Redirect to Home screen
            dispose();
            return;
        }

        Register();
    }

    // Establish connection to SQLite database
    private void connectDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            Statement statement = connection.createStatement();
            // Create users table if not exists
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT UNIQUE, password TEXT)";
            statement.executeUpdate(createTableSQL);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Check if any user is already registered
    private boolean isUserAlreadyRegistered() {
        String query = "SELECT COUNT(*) FROM users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            resultSet.next();
            return resultSet.getInt(1) > 0; // If count > 0, user exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration");
        setSize(850, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        int leftPanelWidth = 300;
        int leftPanelHeight = 600;
        leftPanel.setPreferredSize(new Dimension(leftPanelWidth, leftPanelHeight));

        ImageIcon originalIcon = new ImageIcon("src/Assets/bg.jpg");
        Image image = originalIcon.getImage().getScaledInstance(leftPanelWidth, leftPanelHeight, Image.SCALE_SMOOTH);
        background = new JLabel(new ImageIcon(image));
        leftPanel.add(background, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setPreferredSize(new Dimension(500, getHeight()));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        registerLabel = new JLabel("Register Yourself");
        registerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        rightPanel.add(registerLabel, gbc);

        gbc.gridy++;
        nameField = new JTextField(20);
        nameField.setBorder(BorderFactory.createTitledBorder("Enter Name"));
        nameField.addKeyListener(new InputChangeListener());
        rightPanel.add(nameField, gbc);

        gbc.gridy++;
        emailField = new JTextField(20);
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));
        emailField.addKeyListener(new InputChangeListener());
        rightPanel.add(emailField, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        passwordField.addKeyListener(new InputChangeListener());
        rightPanel.add(passwordField, gbc);

        gbc.gridy++;
        registerButton = new JButton("Register");
        registerButton.addActionListener(e -> registerButtonActionPerformed());
        rightPanel.add(registerButton, gbc);

        gbc.gridy++;
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        messageLabel.setVisible(false);
        rightPanel.add(messageLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        backButton = new JButton(new ImageIcon("src/Assets/Back To.png"));
        backButton.addActionListener(e -> backButtonActionPerformed());
        rightPanel.add(backButton, gbc);

        gbc.gridx++;
        nextButton = new JButton(new ImageIcon("src/Assets/nx.png"));
        nextButton.addActionListener(e -> nextButtonActionPerformed());
        nextButton.setEnabled(false); // Disable Next button initially
        rightPanel.add(nextButton, gbc);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    private void backButtonActionPerformed() {
        new Splash().setVisible(true);
        this.dispose();
    }

    private void nextButtonActionPerformed() {
        new Home().setVisible(true);
        this.dispose();
    }

    private void registerButtonActionPerformed() {
        messageLabel.setVisible(true);
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            messageLabel.setText("All fields are required!");
            return;
        }

        if (!email.contains("@")) {
            messageLabel.setText("Invalid email address!");
            return;
        }

        if (isEmailRegistered(email)) {
            messageLabel.setText("Email is already registered!");
            return;
        }
        registerUser(name, email, password);
    }
    // Check if the email already exists in the database
    private boolean isEmailRegistered(String email) {
        String query = "SELECT email FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if email exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Register user in the database
    private void registerUser(String name, String email, String password) {
        String insertSQL = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
            messageLabel.setText("Registration successful!");
            nextButton.setEnabled(true); // Enable Next button after successful registration
        } catch (SQLException e) {
            e.printStackTrace();
            messageLabel.setText("Error registering user!");
        }
    }

    // Listener to check if all fields are filled
    private class InputChangeListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            boolean allFilled = !nameField.getText().trim().isEmpty()
                    && !emailField.getText().trim().isEmpty()
                    && passwordField.getPassword().length > 0;
            registerButton.setEnabled(allFilled);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registration().setVisible(true));
    }
}
