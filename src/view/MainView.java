package view;

import controller.PartidaController;
import controller.ProgressoController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Renard on view.
 */
public class MainView extends JFrame{
    public BgPanel moldura;
    public BgPanel cenaImgPanel;
    public BgPanel card;
    public JLabel statusbar;
    public JTextArea textArea;
    public PartidaController partidaController = PartidaController.getInstance();
    public MouseHandler mouseHandler;

    private static MainView instance;
    //Singleton
    public static MainView getInstance() {
        if (instance == null) instance = new MainView();
        return instance;
    }

    private MainView(){
        //define o título do frame (exibido no topo da janela)
        super("SanFrancisco pre-alpha");

        //instancia os componentes
        //BgPanel bp = new BgPanel((new ImageIcon(getClass().getResource("intro-cena1.png"))).getImage());
        moldura = new BgPanel("moldura-completa.png");
        statusbar = new JLabel("Debugger");
        cenaImgPanel = new BgPanel("intro-cena1.png");
        card = new BgPanel("DefaultCard.png");
        CustomContainer textContainer = new CustomContainer(640,220);
        CustomContainer hrzGap = new CustomContainer(105,105);
        CustomContainer vrtGap = new CustomContainer(70,70);
        CustomContainer cardContainer = new CustomContainer(270,420);
        CustomContainer imgCenaContainer = new CustomContainer(550,420);


        //adiciona ao frame o painel primário - var "moldura" - e a statusbar para debug
        this.getContentPane().add(statusbar, BorderLayout.SOUTH);
        this.getContentPane().add(moldura, BorderLayout.CENTER);

        //Configura o groupLayout e a borda do painel moldura
        GroupLayout groupLayout = new GroupLayout(moldura);
        moldura.setLayout(groupLayout);
        moldura.setBorder(new EmptyBorder(30, 10, 20, 20));

        //Configura os conatiners para os paineis de imagens
        imgCenaContainer.setBorder(new EmptyBorder(12, 22, 0, 0));
        imgCenaContainer.add(cenaImgPanel);
        cardContainer.setBorder(new EmptyBorder(33,2,0,0));
        cardContainer.add(card);


        //Configura a TextArea
        textArea = new JTextArea(10,50);
        textArea.setFont(new Font("Special Elite", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        //textArea.setOpaque(false);
        //JScrollPane scrollPane = new JScrollPane(textArea);
        //scrollPane.setOpaque(false);
        textContainer.setLayout(new BorderLayout());
        textContainer.setBorder(new EmptyBorder(0, 20, 10, 0));
        textContainer.add(textArea, BorderLayout.CENTER);
        textContainer.setBgColor(Color.white);
        //textContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
        String lorem = "\nNo salao principal, estao em exibicao as obras mais preciosas - as grandes estrelas do evento.\nA Noite Estrelada, de Van Gogh…\n"+
        "A Persistencia da Memoria, de Salvador Dali...\nEntre elas, posicionada bem no meio do salao, \nesta a atracao principal:\n"+
        "O Cetro Real.";
        textArea.setText(lorem);


        //posiciona os elementos no painel moldura, utilizando GroupLayout
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup()
                        .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(imgCenaContainer)
                                        .addComponent(hrzGap)
                                        .addComponent(cardContainer)
                        )
                        .addComponent(vrtGap)
                        .addComponent(textContainer)

        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(imgCenaContainer)
                                        .addComponent(hrzGap)
                                        .addComponent(cardContainer)
                        )
                        .addComponent(vrtGap)
                        .addComponent(textContainer)
        );

        this.pack();

        //adiciona os listeners nos componentes necessários
        mouseHandler = new MouseHandler();
        moldura.addMouseListener(mouseHandler);
        moldura.addMouseMotionListener(mouseHandler);
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

    private class CustomContainer extends JPanel{
        Integer width;
        Integer height;
        Color color/* = Color.ORANGE*/;
        //GroupLayout groupLayout;
        public CustomContainer(Integer width, Integer height){
            this.width = width;
            this.height = height;
            Dimension size = new Dimension(width, height);
            this.setPreferredSize(size);
            this.setMinimumSize(size);
            this.setMaximumSize(size);
            this.setSize(size);
            //this.groupLayout = new GroupLayout(this);
        }
        public void setBgColor(Color bgColor){
            this.color = color;
            this.repaint();
        }
        public void paintComponent(Graphics g){
            if(color != null) {
                g.setColor(color);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
        }
    }
    public class MouseHandler implements MouseListener, MouseMotionListener{
        public void mouseClicked(MouseEvent e) {
            if(e.getX()>45 && e.getX()<273 && e.getY()>457 && e.getY()<500){
                consoleDebug("cena anterior");
                partidaController.cenaAnterior();
            }else if(e.getX()>318 && e.getX()<545 && e.getY()>457 && e.getY()<500){
                consoleDebug("próxima");
                partidaController.proximaCena();
            }else if(e.getX()>620 && e.getX()<650 && e.getY()>230 && e.getY()<255){
                consoleDebug("card ant");
                partidaController.evidenciaAnterior();
            }else if(e.getX()>947 && e.getX()<974 && e.getY()>230 && e.getY()<255){
                consoleDebug("next card");
                partidaController.proximaEvidencia();
            }else if(e.getX()>680 && e.getX()<915 && e.getY()>487 && e.getY()<533){
                consoleDebug("invest");
                partidaController.investigaCena();
            }else if(e.getX()>680 && e.getX()<915 && e.getY()>548 && e.getY()<596){
                consoleDebug("colet");
                partidaController.interrogaSuspeito();
            }else if(e.getX()>680 && e.getX()<915 && e.getY()>610 && e.getY()<703){
                partidaController.acusar();
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
            if(e.getX()>45 && e.getX()<273 && e.getY()>457 && e.getY()<500){
                consoleDebug("cena anterior");
            }else if(e.getX()>318 && e.getX()<545 && e.getY()>457 && e.getY()<500){
                consoleDebug("próxima");
            }else if(e.getX()>620 && e.getX()<650 && e.getY()>230 && e.getY()<255){
                consoleDebug("card ant");
            }else if(e.getX()>947 && e.getX()<974 && e.getY()>230 && e.getY()<255){
                consoleDebug("next card");
            }else if(e.getX()>680 && e.getX()<915 && e.getY()>487 && e.getY()<533){
                consoleDebug("invest");
            }else if(e.getX()>680 && e.getX()<915 && e.getY()>548 && e.getY()<596){
                consoleDebug("colet");
            }else if(e.getX()>680 && e.getX()<915 && e.getY()>610 && e.getY()<703){
                consoleDebug("ACUSAR!");
            }
        }
    }
    public void consoleDebug(String text){
        statusbar.setText("Debugger: "+text);
    }
    public void updateText(String text){ textArea.setText(text); }
    public void updateCenaImg(String imgFileName){ cenaImgPanel.setImage(imgFileName); }
    public void updateCardImg(String imgFileName){ card.setImage(imgFileName); }
    public void disableMouseEvents(){
        moldura.removeMouseListener(MainView.getInstance().mouseHandler);
    }
}
