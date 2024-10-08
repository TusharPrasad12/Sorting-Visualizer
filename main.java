import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Ecexutor;

public clas Main extends JApplet {
    public static dinal long serialVersionUID = 1L;
    private SortPanel[] sortPanels = new SortPanel[9];
    private static int size = 100;
    private int SleepTime=2;
    private String animationName="";

    public Main(){
        setLayout(new GridLayout(1,1,0,0));
        SortPanelsHolder sortPanelsHolder = new SortPanelsHolder();
        sortPanelsHolder.setLayout(new GridLayout(0,3,0,0));
        sortPanelsHolder.setBackground(Color.BLACK);
        sortPanelsHolder.setForeground(Color.BLACK);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 3;
        int height = screenSize.height / 3;
        sortPanels[0] = new SelectionSortPanel("Selection Sort", SleepTime , width , height );
        sortPanels[1] = new ShellSortPanel("Shell Sort", SleepTime , width , height );
        sortPanels[2] = new InsertionSortPanel("Insetion Sort", SleepTime , width , height );
        sortPanels[3] = new MergeSortPanel("Merge Sort", SleepTime , width , height );
        sortPanels[4] = new QuickSortPanel("Quick Sort", SleepTime , width , height );
        sortPanels[5] = new HeapSortPanel("Heap Sort", SleepTime , width , height );
        sortPanels[6] = new BubbleSortPanel("Bubble Sort", SleepTime , width , height );
        sortPanels[7] = new CombSortPanel("Comb Sort", SleepTime , width , height );
        sortPanels[8] = new CocktailSortPanel("Cocktail Sort", SleepTime , width , height );

        for(int i=0;i<sortPanels.length;i++){
            sortPanels[i].setVisible(false);
            sortPanelsHolder.add(sortPanels[i]);
        }
        add(sortPanelsHolder);
    }

    class sortPanelsHolder extends JPanel{
        private static long serialVersionUID = 1L;

        @Override
        protected void paintComponenet(Graphics g){
            super.paintComponenet(g);
            g.setColor(Color.GREEN);
            Font animationName = new Font(Font.MONOSPACED,Font.Bold,150);
            FontMetrics animatioNameFontMetrix = getFontMetrics(animationNameFont);
            g.setFont(animationNameFont);
            int x = (getWidth()-animatioNameFontMetrix.StringWidth(animationName)) / 2;
            int y = (getHeight()-animatioNameFontMetrix.getLeading()) / 2;
            g.drawString(animationName,x,y);
        }
    }

    public void beginAnimation(String animationName, int[] list){
        try{
            this.animationName=animationName;
            repaint();
            Thread.sleep(2000);
            this.animationName="";
            repaint();
            for(int i=0;i<sortPanels.length;i++){
                sortPanels[i].setList(list);
                sortPanels[i].setVisible(true);
            }
            Thread.sleep(1000);
            ExecutorService executor.newFixedThreadPool(sortPanels.length);
            for(int i = 0;i<sortPanels.length;i++){
                executor.execute(sortPanels[i]);
            }
            executor.shutdown();
            while(!executor.isTerminated()){
                Thread.sleep(100);
            }
            Thread.sleep(1000);
            for(int i = 0;i<sortPanels.length;i++){
                sortPanels[i].setVisible(fase);
            }

        }
        catch(InterruptedExcption e){
            e.printStackTrace();
        }
    }

    public static void main(String[args]){
        JFrame frame=new JFrame("Sorting algorithm");
        Main main = new Main();
        frame.add(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        int[] list=new int[size];

        for(int i=0;i<list.length;i++){
            list[i]=i+1;
        }

        for(int i = o;i<list.length;i++){
            int index = (int)(Math.random()*list.length);
            int temp=list[i];
            list[i] = list[index];
            list[index]=temp;
        }
        main.beginAnimation("Random",list);

        for(int i = 0;i<list.length;i++){
            list[i]=(1+i/(size/4)*(size/4));
        }
        for(int i = o;i<list.length;i++){
            int index = (int)(Math.random()*list.length);
            int temp=list[i];
            list[i] = list[index];
            list[index]=temp;
        }
        main.beginAnimation("few unique",list);

        for(int i=0;i<list.length;i++){
            list[i]=size-i;
        }
        main.beginAnimation("Reversed",list);
        for(int i=0;i<list.length/2;i++){
            list[i]=i+1;
        }
        for(int i=list.length/2;i<list.length;i++){
            list[i]=i+2;
        }
        list[list.length-1]=list.length/2+1;
        main.beginAnimation("Almost Sorted",list);
    }

}