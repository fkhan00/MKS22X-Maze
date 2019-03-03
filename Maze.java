import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  // representation of maze
  public String[][] ary;
  // stores posiiton of Start
  public int strX, strY;

  // takes in a string representation of File
  // adds elements of file to ary to represent the maze
  public void convert(String text) throws FileNotFoundException{
    File fil = new File(text);
    Scanner scan = new Scanner(fil);
    String output = "";
    // converts file contents into string
    while(scan.hasNextLine()){
      output += scan.nextLine();}
    scan = new Scanner(fil);
    // uses length of output and length of each line to create dimensions for maze
    ary = new String[output.length() / scan.nextLine().length()][scan.nextLine().length()];
    scan = new Scanner(fil);
    int counter = 0;
    // adds content into the maze
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        ary[i][j] = output.substring(counter, counter + 1);
        counter ++;
      }}}
  // constructor initializes maze and start position
  public Maze(String text) throws FileNotFoundException{
    convert(text);
    // once start is found, store its row and col index into strY and strX
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        if(ary[i][j].equals("S")){
          strY = i;
          strX = j;}}}}

  public boolean valid( int row, int col){
    // returns true if within bounds of Maze
    // not on wall and not going backwards
    return row >= 0 && row < ary.length && col >=  0 && col < ary[0].length && ! ary[row][col].equals("@") &&  (!ary[row][col].equals("#"));
  }
  // basic toString
  public String toString(){
    String output = "";
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        output += ary[i][j];}
      output += "\n";
      }
    return output;
  }
  //wrapper class returning number of steps taken to get from S to E
  public int solve(){
    //calls on solveH to find path
    if(!solveH(strY, strX, 0)){
      return -1;}
    int counter = 0;
    // count number of steps taken and returns it
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        if(ary[i][j].equals("@")){
        counter ++;}}}
    System.out.println(toString());
    return counter;}

  public boolean solveH(int row, int col, int steps){
    // if reached the end return true
    if(ary[row][col].equals("E")){
      return true;}
    // if this is a valid posiiton
    if(valid(row, col)){
      // mark the position
      ary[row][col] = "@";
      // check if each possible move leads to a solution and if so return true
      if(solveH(row + 1, col, steps + 1)){
        return true;}
      if(solveH(row - 1, col, steps + 1)){
          return true;}
      if(solveH(row , col + 1, steps + 1)){
        return true;}
      if(solveH(row , col - 1, steps + 1)){
        return true;}
      // if you reached here, you're stuck
      // go back to the previous fork in the maze
      //as you go back mark the patch on the maze as .
      ary[row][col] = ".";
      // return false moves the function to the next if statement
      return false;}
      // if not valid return false
    return false;}


}
