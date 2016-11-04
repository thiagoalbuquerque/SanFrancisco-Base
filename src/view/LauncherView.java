package view;

import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by Renard on view.
 */
public class LauncherView extends JFrame{

    public CustomContainer nameContainer;
    public BgImgPanel bg;
    public JLabel statusbar;
    public JTextArea nameTextArea;

    private static LauncherView instance;
    public PartidaController partidaController;

    //Singleton
    public static LauncherView getInstance() {
        if (instance == null) instance = new LauncherView();
        return instance;
    }

    private LauncherView(){
        super("SanFrancisco Alpha Release");

        //instancia os componentes
        statusbar = new JLabel("Debugger");
        bg = new BgImgPanel("launcher1.png");
        nameTextArea = new JTextArea(1,8);
        nameTextArea.setFont(new Font("Special Elite", Font.BOLD, 20));
        nameTextArea.setLineWrap(true);
        nameTextArea.setWrapStyleWord(true);
        nameContainer = new CustomContainer(238,100);
        nameContainer.setBorder(new EmptyBorder(10,0,0,0));
        bg.setBorder(new EmptyBorder(450, 170, 220, 170));
        //nameContainer.setBgColor(Color.PINK);
        nameContainer.add(nameTextArea);
        bg.add(nameContainer);


        this.add(statusbar, BorderLayout.SOUTH);
        this.add(bg, BorderLayout.CENTER);



        EventHandler handler = new EventHandler();
        bg.addMouseListener(handler);
        bg.addMouseMotionListener(handler);

        this.pack();
    }

    private class CustomContainer extends JPanel{
        Integer width;
        Integer height;
        Color color = null;
        public CustomContainer(Integer width, Integer height){
            this.width = width;
            this.height = height;
            Dimension size = new Dimension(width, height);
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
            this.setSize(size);
        }
        public void setBgColor(Color bgColor){
            this.color = bgColor;
            this.repaint();
        }
        public void paintComponent(Graphics g){
            if(color != null) {
                g.setColor(color);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
        }
    }

    private class BgImgPanel extends JPanel {
        private Image img;

        public BgImgPanel(String imgFileName) {
            //this(new ImageIcon(img).getImage());
            this.setImage(imgFileName);
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
            this.setSize(size);
            //this.setLayout(null);
        }

        public BgImgPanel(Image img) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
            this.setSize(size);
            this.setLayout(null);
        }

        public void setImage(String imgFileName) {
            this.img = (new ImageIcon(getClass().getResource("/resources/" + imgFileName))).getImage();
            this.repaint();
        }

        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }


        private class EventHandler implements MouseListener, MouseMotionListener{
        public void mouseClicked(MouseEvent e) {
            //statusbar.setText(String.format("Debugger: Clicked at [%d,%d]", e.getX(), e.getY()));
            //USUARIO ESCOLHE COME�AR UM NOVO JOGO
            if(e.getX()>210 && e.getX()<370 && e.getY()>280 && e.getY()<332){
                //instance.consoleDebug(nameTextArea.getText());
                String playerName = nameTextArea.getText();
                dispose();
                partidaController = PartidaController.getInstance();
                partidaController.novaPartida(playerName);
                System.out.println(
                        ProgressoController.getInstance().progresso.jogador.nome + " - " +
                                ProgressoController.getInstance().progresso.nomeCasoAtual
                );
                //USUARIO ESCOLHE CONTINUAR UM JOGO ANTERIOR
            }else if(e.getX()>210 && e.getX()<370 && e.getY()>340 && e.getY()<390){
                String playerName = nameTextArea.getText();
                dispose();
                partidaController = PartidaController.getInstance();
                partidaController.continuaPartida(playerName);
                System.out.println(
                        ProgressoController.getInstance().progresso.jogador.nome + " - " +
                                ProgressoController.getInstance().progresso.nomeCasoAtual
                );
            }
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
            //instance.consoleDebug("Mouse at [" + e.getX() + "," + e.getY() + "]");
            if(e.getX()>210 && e.getX()<370 && e.getY()>280 && e.getY()<332){
                bg.setImage("launcher2.png");
            }else if (e.getX() > 210 && e.getX()<370 && e.getY()>367 && e.getY()<417){
               bg.setImage("launcher3.png");
            }else bg.setImage("launcher1.png");

            }
    }

    public void consoleDebug(String text){
        statusbar.setText("Debugger: "+text);
    }

}
