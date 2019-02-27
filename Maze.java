import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public String[][] ary;
  public int strX, strY;
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
    convert(text);
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        if(ary[i][j].equals("S")){
          strY = i;
          strX = j;}}}}

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
  public boolean solve(){
    System.out.println(strY + " " + strX);
    return solveH(strY, strX, new int[ary.length][ary[0].length], 0, 0);}

  public boolean solveH(int row, int col, int[][] covered, int dirR, int dirC){
      if((ary[row][col].equals("E")))
      {
        return true;}
    if(! valid(covered, row, col)){
      return false;}
    covered[row][col] ++;
    ary[row][col] = "-";
    System.out.println(toString());
    if( solveH(row + 1, col, covered, 1, 0) || solveH(row, col + 1, covered, 0, 1)
    || solveH(row - 1, col, covered, -1, 0) || solveH(row, col - 1, covered, 0, -1)){
      return true;}
    // situation for if stuck within four walls
      }


}
