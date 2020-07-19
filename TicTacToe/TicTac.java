import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TicTac implements ActionListener
{
JButton b[]=new JButton[9];
Frame f;
TextField tf;
int alternate=0;
TicTac(String s)
{
  f=new Frame(s);
 for(int i=0;i<3;i++)
 {
  b[i]=new JButton();
  b[i].setBounds(100*(i+1),100,100,100);
  b[i].setText("");
  b[i].addActionListener(this);
  f.add(b[i]);
 }
 for(int i=3;i<6;i++)
 {
  b[i]=new JButton();
  b[i].setBounds(100*(i-2),200,100,100);
  b[i].setText("");
  b[i].addActionListener(this);
  f.add(b[i]);
 }
 for(int i=6;i<9;i++)
 {
  b[i]=new JButton();
  b[i].setBounds(100*(i-5),300,100,100);
  b[i].setText("");
  b[i].addActionListener(this);
  f.add(b[i]);
 }
tf=new TextField("new Game");
tf.setBounds(100,500,300,100);
f.add(tf);

f.addWindowListener(new WindowEventListener());
f.setLayout(null);

f.setSize(500,700);
f.setVisible(true);
}
public void resetButtons()
{
 for(int i=0;i<9;i++)
 {
 b[i].setText("");
 }

}
public void actionPerformed(ActionEvent e)
{

 JButton buttonClicked=(JButton)e.getSource();
 if(alternate%2==0)
 { 
  buttonClicked.setText("X");
 }
 else
 {
 buttonClicked.setText("0");
 }
if(checkForWin()==true)
{
 if(alternate%2==0)
 {
 tf.setText("Game over and X is winner");
 alternate=0;
 
 }
 if(alternate%2==1)
 {
 tf.setText("Game over and 0 is winner");
 alternate=0; 
 }
resetButtons();
return;
}
alternate++;

if(alternate==9)
{
tf.setText("Game Over and No winner");
resetButtons();
}
}
public boolean checkForWin()
{
if(checkAdjacent(0,1)&&checkAdjacent(1,2))
{
return true;
}
if(checkAdjacent(3,4)&&checkAdjacent(4,5))
{
return true;
}
if(checkAdjacent(6,7)&&checkAdjacent(7,8))
{
return true;
}
if(checkAdjacent(0,3)&&checkAdjacent(3,6))
{
return true;
}
if(checkAdjacent(1,4)&&checkAdjacent(4,7))
{
return true;
}
if(checkAdjacent(2,5)&&checkAdjacent(5,8))
{
return true;
}
if(checkAdjacent(0,4)&&checkAdjacent(4,8))
{
return true;
}
if(checkAdjacent(2,4)&&checkAdjacent(4,6))
{
return true;
}
return false;
}
public boolean checkAdjacent(int a,int c)
{
if(b[a].getText().equals(b[c].getText())&&!b[a].getText().equals(""))
{return true;
}
else
{
return false;
}
}
public static void main(String [] args)
{
new TicTac("TicTac");
}
}
class WindowEventListener extends WindowAdapter
{
public void windowClosing(WindowEvent e1)
{
System.exit(0);
}
}



