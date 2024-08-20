import java.awt.color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FrontMetrics;
import java.awt.Graphics;

import javax.swing.Jpanel;
public abstract class SortPanel extends Jpanel implements Runnable{
    private static final long serialVersionUID =1L;
    protected static final int BORDER_WIDTH=10;
    private Dimension preferredDimension;
    protected int size;
    protected int[] list;
    protected int SleepTime;
    private String name;

    public SortPanel(String name, int SleepTime , int width , int height){
        preferredDimension=new Dimension(width,height);
        this.name=name;
        this.SleepTime=SleepTime;
        setBackground(color.Black);
    }

    public void setList(int[] List){
        reset();
        this.size=list.length();
        this.list=java.util.Arrays.copyOf(list,size);
        setBackground(Color.black);

    }

    @Override
    protected void paintComponenet(Graphics g){
        super.paintComponenet(g);
        g.setColor(Color.White);
        g.drawRect(BORDER_WIDTH ,BORDER_WIDTH , getWidth() - 2 * BORDER_WIDTH , getWidth()-2 * BORDER_WIDTH);

        Font nameFOnt =new Font(Font.MONOSPACE, Font.BOLD , 18);
        FrontMetrics nameFontMetrix = getMetrics(nameFont);
        g.setColor(Color.BLACK);
        g.fillRect((getWidth() - nameFontMetrix.String(name)) / 2 , 0 , nameFontMetrix.StringWidth(name),BORDER_WIDTH  + nameFontMetrix.getAscent() / 3);
        g.setColor(Color.ORANGE);
        g.setFont(nameFont);
        g.drawString(name,(getWidth() - nameFontMetrix(name)) / 2, BORDER_WIDTH + nameFontMetrix.getAscent() / 3);

    }

    @Override
    public abstract void run();
    public abstract void reset();




}