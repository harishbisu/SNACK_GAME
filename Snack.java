import java.awt.*;
import java.awt.event.*;
class Snack extends Frame implements ActionListener
{
	Button b1,b2,b3,b4,b5;
	String str="",str1= "1";
	int x=100,y=50,endx=x,endy=y,tx=400,ty=300,score=0;
	boolean l;
	Snack()
	{
		this.setLayout(null);
		setBackground(Color.blue);
		b1=new Button("up");
		b2=new Button("down");
		b3=new Button("left");
		b4=new Button("right");
		b5=new Button("[pause]");
		b1.setBounds(380,520,50,20);
		b2.setBounds(380,560,50,20);
		b3.setBounds(340,540,50,20);
		b4.setBounds(420,540,50,20);
		b5.setBounds(520,540,50,20);
		b1.setBackground(Color.pink);
		b2.setBackground(Color.pink);
		b3.setBackground(Color.pink);
		b4.setBackground(Color.pink);
		b5.setBackground(Color.pink);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		b1.addActionListener( this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval(tx,ty,7,7);
		g.drawRect(1, 1, 795, 500);
		g.setColor(Color.green);
		if(tx-x<10&&tx-x>-10&&ty-y<10&&ty-y>-10)
		{
			g.fillOval(tx,ty,7,7);
			tx=(int)(Math.random()*680);
			ty=(int)(Math.random()*480);
			score++;
		}
		if(str=="[pause]")
		{
			g.setColor(Color.green);
			g.fillRect(x,y,10,10);
			g.setColor(Color.white);
			g.drawString("SCORE:"+score, 50, 50);
		}
		if(str=="right"){
				x+=1;	
				g.setColor(Color.green);
				g.fillRect(x,y,10,10);
				
				if(x>=700)
				{
					x=0;
					repaint();
				}
				moveOn();
		}
		if(str=="down"){
				y+=1;
				g.setColor(Color.green);
				g.fillRect(x,y,10,10);
				
				if(y>=500)
				{
					y=0;
					repaint();
				}
				moveOn();
		}
		if(str=="left"){
				x-=1;
				g.setColor(Color.green);
				g.fillRect(x,y,10,10);
				
				if(x<=0){
					x=700;
					repaint();
				}
				moveOn();
		}
		if(str=="up"){
				y-=1;
				g.setColor(Color.green);
				g.fillRect(x,y,10,10);
				g.drawString("SCORE:"+score, 50, 50);
				
				if(y<=0){
					y=500;
					repaint();
				}
				moveOn();
		}
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		str=ae.getActionCommand();
		str1=str;
		repaint();
		l=true;
	}
	void moveOn()
	{
		if(l)
		{
			try{
					Thread.sleep(15);
				if(str.equals(str1))
					repaint();
			}
			catch(InterruptedException ie){}
		}
	}
	public static void main(String arg[])
	{
		Snack snack=new Snack();
		snack.setSize(800,600);
		snack.setTitle("Snack Game");
		snack.setVisible(true);
	}
}