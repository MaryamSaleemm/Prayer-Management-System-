import javax.swing.*;
import java.awt.*;
public class ImagePanel extends JPanel {
    private Image image;
    // Constructor to load the image
    public ImagePanel(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
    }
    @Override
    protected void paintComponent(Graphics g) { //The Graphics class is the abstract base class for all graphics contexts that allow an application to draw onto components
        super.paintComponent(g); // Component background and other default rendering are handled properly
        if (image != null) {
            // Draw the image to fit the panel
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
