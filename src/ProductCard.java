import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ProductCard extends JPanel {
    private boolean isSelected = false;

    public ProductCard(Product product, Runnable onClick) {
        setPreferredSize(new Dimension(200, 240));
        setBackground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new BorderLayout());
        setBorder(createBorder(false));

        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);

        JLabel nameLabel = new JLabel("<html><div style='text-align: center'><b>" + product.name + "</b></div></html>");
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descLabel = new JLabel(product.description);
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        descLabel.setForeground(new Color(150, 150, 150));
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(Box.createVerticalStrut(5));
        topPanel.add(nameLabel);
        topPanel.add(Box.createVerticalStrut(2));
        topPanel.add(descLabel);
        topPanel.add(Box.createVerticalStrut(5));

        add(topPanel, BorderLayout.NORTH);

        
        ImageIcon icon = new ImageIcon(product.imagePath);
        Image scaled = icon.getImage().getScaledInstance(180, 130, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(scaled));
        imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(imgLabel);
        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);

        
        JLabel brandLabel = new JLabel(product.brand);
        brandLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JLabel priceLabel = new JLabel("$" + product.price);
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 13));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        bottomPanel.add(brandLabel, BorderLayout.WEST);
        bottomPanel.add(priceLabel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                onClick.run();
            }

            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (!isSelected) setBackground(new Color(245, 250, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                if (!isSelected) setBackground(Color.WHITE);
            }
        });
    }

    private Border createBorder(boolean selected) {
        Color borderColor = selected ? new Color(30, 144, 255) : new Color(220, 220, 220);
        return BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(borderColor, selected ? 2 : 1, true),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
        setBorder(createBorder(selected));
        setBackground(selected ? new Color(245, 250, 255) : Color.WHITE);
    }
}
