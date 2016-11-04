package view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by Renard on view.
 */
public class TestView extends JFrame{
    public JButton button;
    public BgPanel moldura;
    public BgPanel imgPanel;
    public JLabel statusbar;
    public VerticalMargin vmargin;
    public HorizontalMargin hmargin;

    public TestView(){
        //BgPanel bp = new BgPanel((new ImageIcon(getClass().getResource("intro-cena1.png"))).getImage());
        moldura = new BgPanel("moldura.png");
        statusbar = new JLabel("Debugger");
        //vmargin = new VerticalMargin(100);
        //hmargin = new HorizontalMargin(100);
        imgPanel = new BgPanel("intro-cena2.png");
        this.getContentPane().add(statusbar, BorderLayout.SOUTH);
        this.getContentPane().add(moldura, BorderLayout.CENTER);
        //moldura.setLayout(new BorderLayout());
        //moldura.add(vmargin, BorderLayout.NORTH);
        //moldura.add(hmargin, BorderLayout.WEST);
        moldura.setLayout(new BorderLayout());
        moldura.setBorder(new EmptyBorder(30,40,30,30));
        moldura.add(imgPanel, BorderLayout.WEST);
        this.pack();

        MouseHandler mouseHandler = new MouseHandler();
        moldura.addMouseListener(mouseHandler);
    }

    private class BgPanel extends JPanel{
        private Image img;
        public BgPanel(String imgFileName){
            //this(new ImageIcon(img).getImage());
            this.setImage(imgFileName);
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
            this.setSize(size);
            //this.setLayout(null);
        }
        public BgPanel(Image img){
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
            this.setSize(size);
            this.setLayout(null);
        }
        public void setImage(String imgFileName){
            this.img = (new ImageIcon(getClass().getResource("/resources/"+imgFileName))).getImage();
            this.repaint();
        }

        public void paintComponent(Graphics g){
            g.drawImage(img,0,0,null);
        }
    }

    private class HorizontalMargin extends JPanel{
        public HorizontalMargin(Integer margin){
            Dimension size = new Dimension(10,margin);
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
            this.setSize(size);
            this.setLayout(null);
        }
        public void paintComponent(Graphics g){
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
    }
    private class VerticalMargin extends JPanel{
        public VerticalMargin(Integer margin){
            Dimension size = new Dimension(margin,10);
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
            this.setSize(size);
            this.setLayout(null);
        }
        public void paintComponent(Graphics g){
            g.setColor(Color.BLUE);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
        }
    }

    private class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            button.setText(Math.round(Math.random()*7)+"");
        }
    }
    public class MouseHandler implements MouseListener, MouseMotionListener{
        public void mouseClicked(MouseEvent e) {
            //bp.setImage("intro-cena"+(Math.round(Math.random()*5)+1)+".png");
            statusbar.setText(String.format("Debugger: Clicked at [%d,%d]", e.getX(), e.getY()));
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
        }
    }
    public void testAddButton(){
        JFrame frame = new JFrame();
        button = new JButton("Click Me");
        this.getContentPane().add(button);
        Handler handler = new Handler();
        button.addActionListener(handler);
    }

}
