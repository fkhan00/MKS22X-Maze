import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public String[][] ary;
  public int strX, strY;

  public void convert(String text) throws FileNotFoundException{
    File fil = new File(text);
    Scanner scan = new Scanner(fil);
    String output = "";
    while(scan.hasNextLine()){
      output += scan.nextLine();}
    scan = new Scanner(fil);
    ary = new String[output.length() / scan.nextLine().length()][scan.nextLine().length()];
    scan = new Scanner(fil);
    int counter = 0;
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        ary[i][j] = scan.next();
        counter ++;
      }}}

  public Maze(String text) throws FileNotFoundException{
    convert(text);
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        if(ary[i][j].equals("S")){
          strY = i;
          strX = j;}}}}

  public boolean valid( int row, int col){
    return row >= 0 && row < ary.length && col >=  0 && col < ary[0].length && ! ary[row][col].equals("@") &&  (!ary[row][col].equals("#"));
  }
  public String toString(){
    String output = "";
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        output += ary[i][j];}}
    return output;
  }
  public int solve(){
    solveH(strY, strX, 0);
    int counter = 0;
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        counter ++;}}
    return counter;}

  public boolean solveH(int row, int col, int steps){
    if(ary[row][col].equals("E")){
      return true;}
    System.out.println(toString());
    if(valid(row, col)){
      ary[row][col] = "@";
      if(solveH(row + 1, col, steps + 1)){
        return true;}
      if(solveH(row - 1, col, steps + 1)){
          return true;}
      if(solveH(row , col + 1, steps + 1)){
        return true;}
      if(solveH(row , col - 1, steps + 1)){
        return true;}
      ary[row][col] = ".";
      return false;}
    return false;}


}
