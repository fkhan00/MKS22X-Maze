import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public String[][] ary;
  public static final int moves[] = {1, -1};

  public void convert(String text) throws FileNotFoundException{
    File fil = new File(text);
    Scanner scan = new Scanner(fil);
    String output = "";
    while(scan.hasNext()){
      output += scan.nextLine();}
    scan = new Scanner(fil);
    ary = new String[scan.nextLine().length()][output.length() / scan.nextLine().length()];
    scan = new Scanner(fil);
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        ary[i][j] = scan.next();}}}

  public Maze(String text) throws FileNotFoundException{
    convert(text);}

  public boolean valid(int[][] covered, int row, int col){
    return row >= 0 && row < ary.length && col >=  0 && col < ary.length && covered[row][col] == 0 && ! ary[row][col].equals("#");
  }
  public boolean solveH(int row, int col, int[][] covered, int dirR, int dirC){
    try{
      if((ary[row][col] + ary[row][col + 1]).equals("#E")){
        return true;}}
    catch(IndexOutOfBoundsException e){
      return false;}
    if(! valid(covered, row, col)){
      return false;}
    covered[row][col] ++;
    for(int i = 0; i < moves.length; i++){
      if(solveH(row + moves[i], col, covered, moves[i], 0) || solveH(row, col + moves[i], covered, 0, moves[i])){
        return true;}
      else{
        return solveH(row - dirR, col - dirC, covered, 0, 0);}}
    return false;}


}
