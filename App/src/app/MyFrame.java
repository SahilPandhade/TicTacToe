/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import static app.App.player1;
import static app.App.player2;
/**
 *
 * @author HP
 */
public class MyFrame extends JFrame implements ActionListener{
    JLabel label3;
    private String turn = player1;
    private final JButton[] buttons;            
    MyFrame(){
        // TODO code application logic here
        buttons = new JButton[9];   
        for(int i= 0;i<9;i++){
            buttons[i] = new JButton(String.valueOf("-"));
            buttons[i].setSize(50,50);
            buttons[i].setFont(new Font("Comic Sans",Font.BOLD,25));
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].setBorder(BorderFactory.createEtchedBorder());
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
        buttons[0].setLocation(100,100);
        buttons[1].setLocation(155,100) ;
        buttons[2].setLocation(210,100);
        buttons[3].setLocation(100,155);
        buttons[4].setLocation(155,155);
        buttons[5].setLocation(210,155);
        buttons[6].setLocation(100,210);
        buttons[7].setLocation(155,210);
        buttons[8].setLocation(210,210);
        
        Border border  =BorderFactory.createLineBorder(Color.black,2);
        label3 = new JLabel();
        label3.setText(turn+"'s turn");
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setBorder(border);
        label3.setBounds(100,270,180,30);
             
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application.
        this.setResizable(false); //prevent this from being resized.
        this.setSize(400,400); //sets x dimension and y dimension.
        this.setLayout(null);
        this.setVisible(true);  //make this visible.
        ImageIcon image = new ImageIcon("tic.png"); //Create a imageIcon
        this.setIconImage(image.getImage()); //change icon of this.
        this.getContentPane().setBackground(Color.white); //Chnage color of background.
        
        this.add(label3);
               
    }
   
    String checkwin(){
        for(int i=0;i<9;i+=3){
            if(!(buttons[i].getText().equals(String.valueOf('-'))) && buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText())){
                reset();
                return buttons[i].getText();  
            }
        }
        for(int i=0;i<3;i++){
            if(!(buttons[i].getText().equals(String.valueOf('-'))) && buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText())){
                reset(); 
                return buttons[i].getText();   
            }
        }
        if(!(buttons[4].getText().equals(String.valueOf('-')))){
            
           //Diagonal 1
            if(buttons[1].getText().equals(buttons[4].getText()) && buttons[1].getText().equals(buttons[8].getText())){
                reset();    
                return buttons[1].getText();    
            } 
            //Diagonal 2
            if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())){
                reset();    
                return buttons[2].getText();  
            }
        
        }
        return "";
    }
       
    void reset(){
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        
        }
    
    }
    void  checkDraw(){
        for(int i=0;i<9;i++){
                    if(buttons[i].getText().equals(String.valueOf('-'))){
                        return;
                    }
                
                }
        label3.setText("Tie!");
        reset();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String text = (String)e.getActionCommand();
        char text2 = turn.equals(player1) ? 'X' : 'O';
        String t;
        turn = turn.equals(player1) ? player2 : player1;
        
        if(text.equals("-")){
                ((JButton)e.getSource()).setText(String.valueOf(text2));
                
                t = checkwin().equals("") ? turn+"'s turn" : (checkwin().equals(String.valueOf('X')) ? player1+" Wins": player2+" Wins!");
                label3.setText(t);
                checkDraw();
                ((JButton)e.getSource()).setEnabled(false);          
            }      
    }
}
