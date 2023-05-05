import java.util.*;

public class Solution{
    
    public static void main(String[] args){
        int lives = 200;
        Scanner myScanner = new Scanner(System.in);
        String[] input = new String[20];
        for(int i=0;i<20;i++){
            input[i]=myScanner.nextLine();
        }
        
        int posX=Integer.parseInt(myScanner.nextLine());
        int posY=Integer.parseInt(myScanner.nextLine());
        
        boolean[][] maze = new boolean[20][20];
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(input[i].charAt(j)=='X'){
                    maze[i][j]=false;
                }else{
                    maze[i][j]=true;
                }
            }
        }
        Brain myBrain = new Brain();
        
        
       while(lives>0){
            String move =myBrain.getMove(maze[posX-1][posY],maze[posX+1][posY],maze[posX][posY+1],maze[posX][posY-1]);
            if(move.equals("north")&&maze[posX-1][posY]){
                posX--;
            }else if(move.equals("south")&&maze[posX+1][posY]){
                posX++;
            }else if(move.equals("east")&&maze[posX][posY+1]){
                posY++;
            }else if(move.equals("west")&&maze[posX][posY-1]){
                posY--;
            }
            lives--;
            if(posY%19==0||posX%19==0){
                System.out.println(posX+","+posY);
                System.exit(0);
            }
        }
        System.out.println("You died in the maze!");
    }


public static class Brain{
    
    static Stack<String> mazedirection = new Stack<>();
     static int x = 20;
     static int y = 20;
     static boolean[][] visitedLocation = new boolean[40][40];
    
    public String getMove(boolean north, boolean south, boolean east, boolean west){
        
            visitedLocation[x][y] = true;

         if (south == false) {
             visitedLocation[x - 1][y] = true; // if south = false mrk it to true
         }

         if (east == false) {
             visitedLocation[x][y + 1] = true;
         }

         if (north == false) {
             visitedLocation[x + 1][y] = true;
         }

         if (west == false) {
             visitedLocation[x][y - 1] = true;
         }


         if (!visitedLocation[x - 1][y]) {
             x--;
             mazedirection.push("south");
             return "North";
         }
         if (!visitedLocation[x][y + 1]) {
             y++;
             mazedirection.push("west");
             return "East";
         }
         if (!visitedLocation[x + 1][y]) {
             x++;
             mazedirection.push("North");
             return "South";
         }
         if (!visitedLocation[x][y - 1]) {
             y--;
             mazedirection.push("East");
             return "West";
         } else {
             String mydirection = mazedirection.peek();
             mazedirection.pop();


             if (mydirection == ("north")) {
                 x--;
                 return "north";
             } else if (mydirection == ("south")) {
                 x++;
                 return "south";
             } else if (mydirection == ("east")) {
                 y++;
                 return "east";
             } else {
                 y--;
                 return "west";

             }
         }
    }
}
}
