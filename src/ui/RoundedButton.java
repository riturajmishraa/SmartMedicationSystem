package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoundedButton extends JButton {

    private Color normalColor =
        new Color(52,120,246);

private Color hoverColor =
        new Color(33,95,210);

private Color currentColor =
        normalColor;

    public RoundedButton(String text) {

        super(text);

        setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                17
        ));

        setForeground(Color.WHITE);

        setFocusPainted(false);

        setBorderPainted(false);

        setContentAreaFilled(false);

        setOpaque(false);

        setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                currentColor = hoverColor;

                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {

                currentColor = normalColor;

                repaint();
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 =
                (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(currentColor);

        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                25,
                25
        );

        FontMetrics fm =
                g2.getFontMetrics();

        int x =
                (getWidth()-fm.stringWidth(getText()))/2;

        int y =
                (getHeight()+fm.getAscent())/2-3;

        g2.setColor(Color.WHITE);

        g2.setFont(getFont());

        g2.drawString(
                getText(),
                x,
                y
        );

        g2.dispose();
    }
}