package cn.jjx.coding.leetcode.labuladong.backtracing;

public class LC37_解数独 {

    public boolean solveSudoku(char[][] board){
        return solveSudokuHelper(board);
    }

    public boolean solveSudokuHelper(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    continue;
                }
                for(char k='1';k<='9';k++){
                    if(isVaildSudoku(i,j,k,board)){
                        board[i][j]=k; //判断i,j这个位置放置k是否合适
                        if(solveSudokuHelper(board)){
                            return true;  //如果找到合适立即返回
                        }
                        board[i][j]='.'; //不合适立即撤销
                    }
                }
                //如果9个数都不合适，那么直接返回false
                return false;
            }
        }
        return true;
    }


    public boolean isVaildSudoku(int row,int col,char val,char[][]board){
        for(int i=0;i<9;i++){
            if(board[row][i] == val) return false;
            if(board[i][col] == val) return false;
            if(board[(row/3)*3+i/3][(col/3)*3+i%3]==val) return false;
        }
        return true;
    }
}
