public class Maze{
  public String[][] ary;
  public void convert(String text){
    File fil = new File(text);
    Scanner scan = new Scanner(fil);
    String output = "";
    while(scan.hasNext()){
      output += scan.nextLine();}
    scan = new Scanner(fil);
    ary = new String[scan.nextLine().length()][output.length() / scan.length()];
    scan = new Scanner(fil);
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary[0].length; j++){
        ary[i][j] = scan.next();}}}

  public Maze(String text){
    convert(text);}
  

}
