class Solution {
    private static int zeroResult = 0;
    private static int oneResult = 0;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        divideAndConquer(arr,0, 0, arr.length);
        answer[0] = zeroResult;
        answer[1] = oneResult;
        return answer;
    }

    void divideAndConquer(int[][]arr, int x, int y, int wh) { // width,height
        if(isZero(arr, x, y, wh)) {zeroResult++; return;}
        if(isOne(arr, x, y, wh)) {oneResult++; return;}
        if(wh <= 1) return;
        divideAndConquer(arr, x, y, wh/2);
        divideAndConquer(arr, x+wh/2, y, wh/2);
        divideAndConquer(arr, x, y+wh/2, wh/2);
        divideAndConquer(arr,x+wh/2, y+wh/2, wh/2);
    }

    private boolean isOne(int[][] arr, int x, int y, int wh) {
        for(int i=0; i < wh; i++){
            for(int j=0; j < wh; j++){
                if(arr[x+i][y+j] == 0) return false;
            }
        }
        return true;
    }

    private boolean isZero(int[][] arr, int x, int y, int wh) {
        for(int i=0; i < wh; i++){
            for(int j=0; j < wh; j++){
                if(arr[x+i][y+j] == 1) return false;
            }
        }
        return true;
    }
}
