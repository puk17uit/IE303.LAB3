import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shoe Store");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(950, 600);
            frame.setLayout(new BorderLayout());

            
            ArrayList<Product> products = new ArrayList<>();
            products.add(new Product("4DFWD PULSE SHOES", "Adidas", 160.0, "This product is excluded from all promotional discounts and offers.", "assets/img1.png"));
            products.add(new Product("FORUM MID SHOES", "Adidas", 100.0, "This product is excluded from all promotional discounts and offers.", "assets/img2.png"));
            products.add(new Product("SUPERNOVA SHOES", "Adidas", 150.0, "NMD City Stock 2", "assets/img3.png"));
            products.add(new Product("NMD R1 SHOES", "Adidas", 160.0, "NMD City Stock 2", "assets/img4.png"));
            products.add(new Product("ZX 2K BOOST SHOES", "Adidas", 120.0, "NMD City Stock 2", "assets/img5.png"));
            products.add(new Product("ULTRABOOST 22 SHOES", "Adidas", 160.0, "This product is excluded from all promotional discounts and offers.", "assets/img6.png"));
            products.add(new Product("ADIZERO ADIOS PRO 2 SHOES", "Adidas", 160.0, "This product is excluded from all promotional discounts and offers.", "assets/img1.png"));
            products.add(new Product("NITEBALL SHOES", "Adidas", 100.0, "This product is excluded from all promotional discounts and offers.", "assets/img2.png"));

            
            ProductDetailPanel detailPanel = new ProductDetailPanel();
            detailPanel.showProduct(products.get(0));

           
            JPanel listPanel = new JPanel();
            listPanel.setLayout(new GridLayout(0, 4, 25, 25)); // 4 sản phẩm mỗi hàng
            listPanel.setBackground(new Color(240, 240, 240));
            listPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            
            ProductCard[] selectedCard = new ProductCard[1];

            
            for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            final ProductCard[] cardHolder = new ProductCard[1];

            cardHolder[0] = new ProductCard(p, () -> {
                detailPanel.showProduct(p);

                if (selectedCard[0] != null) {
                    selectedCard[0].setSelected(false);
                }

                cardHolder[0].setSelected(true);
                selectedCard[0] = cardHolder[0];
            });

            listPanel.add(cardHolder[0]);

            
            if (i == 0) {
                cardHolder[0].setSelected(true);
                selectedCard[0] = cardHolder[0];
            }
        }


            
            JScrollPane scrollPane = new JScrollPane(listPanel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            
            frame.add(detailPanel, BorderLayout.WEST);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
