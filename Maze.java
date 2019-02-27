import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public String[][] ary;
  public int strX, strY, counter;
  public static final int moves[] = {1, -1};

  public void convert(String text) throws FileNotFoundException{
    File fil = new File(text);
    Scanner scan = new Scanner(fil);
    String output = "";
    while(scan.hasNextLine()){
      output += scan.nextLine();
      output += "\n";
    }
    scan = new Scanner(fil);
    ary = new String[output.length() / (scan.nextLine().length() + 1)][scan.nextLine().length()];
    int counter = 0;
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        ary[i][j] = output.substring(counter, counter + 1);
        counter ++;
      }}}

  public Maze(String text) throws FileNotFoundException{
    counter = 0;
    convert(text);
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        if(ary[i][j].equals("S")){
          strY = i;
          strX = j + 1;}}}}

  public boolean valid(int[][] covered, int row, int col){
    return row >= 0 && row < ary.length && col >=  0 && col < ary[0].length && covered[row][col] == 0 &&  (!ary[row][col].equals("#"));
  }
  public String toString(){
    String output = "";
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        output += ary[i][j];}}
    return output;
  }
  public int solve(){
    System.out.println(strY + " " + strX);
    solveH(strY, strX, new int[ary.length][ary[0].length], 0, 0);
    return counter;}


  public boolean solveH(int row, int col, int[][] covered, int dirR, int dirC){
      if((ary[row][col].equals("E")))
      {return true;}
    if(! valid(covered, row, col)){
      counter --;
      return false;}
    counter ++;
    covered[row][col] ++;
    ary[row][col] = "-";
     return solveH(row + 1, col, covered, 1, 0) || solveH(row, col + 1, covered, 0, 1)
    || solveH(row - 1, col, covered, -1, 0) || solveH(row, col - 1, covered, 0, -1);

      }


}
