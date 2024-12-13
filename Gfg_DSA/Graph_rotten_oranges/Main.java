import java.util.LinkedList;
import java.util.Queue;

class Main{
    public int orangesRottings(int[][] grid){

        int count = 0;
        int time = -1;
        Queue<int[]> queue = new LinkedList<int[]>();

        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2) queue.add(new int[] {i, j});
                if(grid[i][j] == 1) count++;
            }
        }

        if(queue.isEmpty() && count == 0) return 0;
        if(queue.isEmpty() && count > 0) return -1;

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] top = queue.poll();

                for(int i = 0; i < 4; i++){
                    int dx = top[0] + x[i];
                    int dy = top[1] + y[i];
                    if(dx >= 0 && dy >= 0 && dx < row && dy < col && grid[dx][dy] == 1){
                        grid[dx][dy] = 2;
                        queue.add(new int[] {dx, dy});
                        count -= 1;
                    }
                }
                size -= 1;
            }
            time += 1;
        }
        return count == 0 ? time : -1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int result = main.orangesRottings(grid);
        System.out.println("Minimum number of minutes: " + result);
    }
}