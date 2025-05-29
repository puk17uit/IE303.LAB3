import java.awt.*;
import javax.swing.*;

public class ProductDetailPanel extends JPanel {
    private JLabel imageLabel = new JLabel();
    private JLabel nameLabel = new JLabel();
    private JLabel priceLabel = new JLabel();
    private JLabel brandLabel = new JLabel();
    private JLabel descriptionLabel = new JLabel();

    public ProductDetailPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 600));
        setBackground(Color.WHITE);

        
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setOpaque(false);
        imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        add(imagePanel, BorderLayout.NORTH);

       
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);
        textPanel.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0)); 

    
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        separator.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.add(separator);
        textPanel.add(Box.createRigidArea(new Dimension(0, 8)));

        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.add(nameLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 4)));

        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.add(priceLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 2)));

        brandLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        brandLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.add(brandLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 2)));

        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        descriptionLabel.setForeground(new Color(120, 120, 120));
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.add(descriptionLabel);

        add(textPanel, BorderLayout.CENTER);
    }

    public void showProduct(Product p) {
        nameLabel.setText(p.name);
        priceLabel.setText("$" + p.price);
        brandLabel.setText(p.brand);
        descriptionLabel.setText("<html><div style='text-align:left;'>" + p.description + "</div></html>");

        ImageIcon icon = new ImageIcon(p.imagePath);
        Image scaled = icon.getImage().getScaledInstance(250, 160, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaled));
    }
}
