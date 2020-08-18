import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Main extends JPanel {

    int BF_WIDTH = 576;
    int BF_HEIGHT = 576;

    int y = 6;
    int x = 7;

    int score = 0;
    int countSteps = 50;
    String gameStatus = "Play Game :)";

    String[][] data = {
            {"B", "G", "B", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"GG", "G", "G", "GG", "G", "GG", "E", "B", "B", "B", "G"},
            {"G", "G", "B", "B", "G", "B", "B", "G", "B", "B", "G"},
            {"G", "G", "B", "B", "M", "B", "B", "M", "B", "B", "G"},
            {"GG", "G", "G", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"G", "M", "B", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"G", "B", "G", "G", "G", "G", "G", "P", "B", "B", "G"},
            {"G", "G", "G", "B", "B", "GG", "G", "GG", "B", "B", "G"},
            {"M", "B", "G", "G", "G", "G", "G", "G", "B", "B", "G"},
            {"M", "B", "Z", "Z", "G", "G", "G", "G", "B", "B", "G"},
            {"G", "G", "G", "B", "B", "G", "G", "G", "B", "B", "G"},
            {"G", "M", "B", "B", "B", "B", "B", "G", "B", "B", "G"}
    };

    void runTheGame() throws Exception {
    move(1);
    }
    void move (int direction) throws Exception{
        if (direction==1){
            while (y>0){
                if(data[y-1][x]=="B"){
                    break;
                }else if(data[y-1][x]=="M"){
                    break;
                }
                data[y][x] = "G";
                y--;
                data[y][x] = "P";
                drawTable();
                Thread.sleep(200);
            }
        }else if (direction==2){
            while (y<11){
                if(data[y+1][x]=="B"){
                    break;
                }else if(data[y+1][x]=="M"){
                    break;
                }
                data[y][x] = "G";
                y++;
                data[y][x] = "P";
                drawTable();
                Thread.sleep(200);
            }
        }else if (direction==3){
            while (x>=0){
                if(data[y][x-1]=="B"){
                    break;
                }else if(data[y][x-1]=="M"){
                    break;
                }
                data[y][x] = "G";
                x--;
                data[y][x] = "P";
                drawTable();
                Thread.sleep(200);
            }
        }else {
            while (x<10){
                if(data[y][x+1]=="B"){
                    break;
                }else if(data[y][x+1]=="M"){
                    break;
                }
                data[y][x] = "G";
                x++;
                data[y][x] = "P";
                drawTable();
                Thread.sleep(200);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.runTheGame();
    }

    // Не смотрите код, что написан ниже. Со временем Вы будете понимать этот код.

    JTable table;
    String[] column = new String[11];
    JLabel labelScore = new JLabel();
    JLabel labelSteps = new JLabel();
    JLabel labelGameStatus = new JLabel();


    public Main() {
        JFrame frame = new JFrame("Goldman");

        table=new JTable();

        table.setTableHeader(null);
        table.setEnabled(false);
        table.setSize(new java.awt.Dimension(300, 300));
        table.setRowHeight(26);
        table.setRowSelectionAllowed(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setUpdateSelectionOnSort(false);
        table.setVerifyInputWhenFocusTarget(false);


        for (int i = 0; i < column.length; i++) {
            column[i] = "";
        }

        drawTable();

        add(table);
        add(labelScore);
        add(labelSteps);
        add(labelGameStatus);
        frame.setMinimumSize(new Dimension(BF_WIDTH,BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    private void score() {
        labelScore.setText("Score: " + score);
    }

    private void countSteps() {
        labelSteps.setText("Count steps: " + countSteps);
    }

    private void gameStatus() {
        labelGameStatus.setText(gameStatus);
    }

    private void drawTable() {


        table.setModel(new DefaultTableModel(data, column));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer_DONT_TOUCH_THIS_FILE());
            TableColumn a = table.getColumnModel().getColumn(i);
            a.setPreferredWidth(26);
        }

        score();
        countSteps();
        gameStatus();

    }

}
