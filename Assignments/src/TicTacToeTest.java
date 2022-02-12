import org.junit.jupiter.api.*;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;


class TicTacToeTest {

    /**
     * Test for checking if the board of the game is created correctly
     * Test should be successful for board dimensions - 3x3, 4x3, 4x5
     */
    @Test
    void createBoardTest_1() {
        int rows = 3;
        int columns = 3;

        int[][] expResult = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] actResult = TicTacToe.createBoard(rows, columns);
        assertArrayEquals(expResult, actResult, "The Board created does not have the size 3x3");
    }
    @Test
    void createBoardTest_2() {
        int rows = 4;
        int columns = 3;

        int[][] expResult = {{0,0,0,},{0,0,0},{0,0,0},{0,0,0}};
        int[][] actResult = TicTacToe.createBoard(rows, columns);
        assertArrayEquals(expResult, actResult, "The Board created does not have the size 4x3");
    }
    @Test
    void createBoardTest_3() {
        int rows = 4;
        int columns = 5;

        int[][] expResult = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        int[][] actResult = TicTacToe.createBoard(rows, columns);
        assertArrayEquals(expResult, actResult, "The Board created does not have the size 4x5");
    }

    /**
     * Test to check if the total number of rows are calculating correctly
     * The test should be successful for rows length 3,4,5
     */
    @Test
    void rowsInTest_1() {
        int[][] testBoard = {{0,0,0},{0,0,0},{0,0,0}};

        int expResult = 3;
        int actResult = TicTacToe.rowsIn(testBoard);
        assertEquals(expResult, actResult, "Total no. of rows is not 3");
    }
    @Test
    void rowsInTest_2() {
        int[][] testBoard = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

        int expResult = 4;
        int actResult = TicTacToe.rowsIn(testBoard);
        assertEquals(expResult, actResult, "Total no. of rows is not 4");
    }
    @Test
    void rowsInTest_3() {
        int[][] testBoard = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

        int expResult = 5;
        int actResult = TicTacToe.rowsIn(testBoard);
        assertEquals(expResult, actResult, "Total no. of rows is not 5");
    }

    /**
     * Test to check if the total number of columns are calculating correctly
     * The test should be successful for rows length 3,4,5
     */
    @Test
    void columnsInTest_1() {
        int[][] testBoard = {{0,0,0},{0,0,0},{0,0,0}};

        int expResult = 3;
        int actResult = TicTacToe.columnsIn(testBoard);
        assertEquals(expResult, actResult, "Total no. of columns is not 3");
    }
    @Test
    void columnsInTest_2() {
        int[][] testBoard = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        int expResult = 4;
        int actResult = TicTacToe.columnsIn(testBoard);
        assertEquals(expResult, actResult, "Total no. of columns is not 4");
    }
    @Test
    void columnsInTest_3() {
        int[][] testBoard = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};

        int expResult = 5;
        int actResult = TicTacToe.columnsIn(testBoard);
        assertEquals(expResult, actResult, "Total no. of columns is not 5");
    }

    /**
     *Test to check if the indicated row/column value is open(EMPTY) to play and make a move
     * Test should be successful if there is an EMPTY(0) space in the board or not
     */
    @Test
    void canPlayTest_1() {
        int[][] testBoard = {{0,2,1,2},{1,1,2,2},{1,2,2,1}};
        int row = 0;
        int column = 0;

        boolean expResult = true;
        boolean actResult = TicTacToe.canPlay(testBoard, row, column);
        assertEquals(expResult, actResult, "The index of the space indicated is not open");
    }
    @Test
    void canPlayTest_2() {
        int[][] testBoard = {{1,2,1,2},{1,1,2,2},{1,2,2,1}};
        int row = 1;
        int column = 2;

        boolean expResult = false;
        boolean actResult = TicTacToe.canPlay(testBoard, row, column);
        assertEquals(expResult, actResult, "The index of the space indicated is not open");
    }
    @Test
    void canPlayTest_3() {
        int[][] testBoard = {{0,2,1,2},{1,1,2,2},{1,2,2,1},{0,0,0,2}};
        int row = 3;
        int column = 2;

        boolean expResult = true;
        boolean actResult = TicTacToe.canPlay(testBoard, row, column);
        assertEquals(expResult, actResult, "The index of the space indicated is not open");
    }
    @Test
    void canPlayTest_4() {
        int[][] testBoard = {{0,0,0,0},{0,0,0,1},{0,0,0,0}};
        int row = 1;
        int column = 3;

        boolean expResult = false;
        boolean actResult = TicTacToe.canPlay(testBoard, row, column);
        assertEquals(expResult, actResult, "The index of the space indicated is not open");
    }

    /**
     * Test to check if the piece is being assigned in the indicated location
     * Test should be successful if the piece is being assigned correctly
     */
    @Test
    void playTest_1() {
        int[][] testBoard = {{0,0,0,0},{0,0,0,1},{0,0,0,0}};
        int row = 0;
        int column = 1;
        int piece = 1;

        int[][] expResult = {{0,1,0,0},{0,0,0,1},{0,0,0,0}};
        TicTacToe.play(testBoard, row,column, piece);
        assertArrayEquals(expResult, testBoard);
    }
    @Test
    void playTest_2() {
        int[][] testBoard = {{0,0,0,0},{0,0,0,1},{0,0,0,0}};
        int row = 1;
        int column = 0;
        int piece = 2;

        int[][] expResult = {{0,0,0,0},{2,0,0,1},{0,0,0,0}};
        TicTacToe.play(testBoard, row,column, piece);
        assertArrayEquals(expResult, testBoard);
    }
    @Test
    void playTest_3() {
        int[][] testBoard = {{2,1,0,0},{0,0,0,1},{0,1,0,0}};
        int row = 2;
        int column = 3;
        int piece = 1;

        int[][] expResult = {{2,1,0,0},{0,0,0,1},{0,1,0,1}};
        TicTacToe.play(testBoard, row,column, piece);
        assertArrayEquals(expResult, testBoard);
    }

    /**
     * Test to check if the board is filled or EMPTY
     * Test will be successful if the boolean value matches the status of the board
     */
    @Test
    void fullTest_1() {
        int[][] testBoard = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        boolean expResult = false;
        boolean actResult = TicTacToe.full(testBoard);
        assertEquals(expResult, actResult, "The board is showing to be full but its not");
    }
    @Test
    void fullTest_2() {
        int[][] testBoard = {{1,2,1,2},{1,1,1,1},{2,2,2,2}};

        boolean expResult = true;
        boolean actResult = TicTacToe.full(testBoard);
        assertEquals(expResult, actResult, "The board is showing to be EMPTY but its not");
    }
    @Test
    void fullTest_3() {
        int[][] testBoard = {{1,0,1,0},{0,2,0,2},{0,2,1,0}};

        boolean expResult = false;
        boolean actResult = TicTacToe.full(testBoard);
        assertEquals(expResult, actResult, "The board is showing to be full but its not");
    }

    /**
     *Test to check if the player wins by having 3 consecutive pieces in a row
     *Test will be successful if the player wins in row combination
     */
    @Test
    void winInRowTest_1() {
        int[][] testBoard = {{1,1,1,0},{0,2,0,2},{0,2,1,0}};
        int row = 0;
        int piece = 1;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInRow(testBoard, row, piece);
        assertEquals(expResult, actResult, "The player has won via row combination");
    }
    @Test
    void winInRowTest_2() {
        int[][] testBoard = {{1,1,1,0},{0,2,2,2},{0,2,1,0}};
        int row = 1;
        int piece = 2;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInRow(testBoard, row, piece);
        assertEquals(expResult, actResult, "The player has won via row combination");
    }
    @Test
    void winInRowTest_3() {
        int[][] testBoard = {{1,1,1,0},{0,2,1,2},{0,1,1,2}};
        int row = 0;
        int piece = 2;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInRow(testBoard, row, piece);
        assertEquals(expResult, actResult, "The player has not won via row combination");
    }
    @Test
    void winInRowTest_4() {
        int[][] testBoard = {{1,1,1,0},{0,0,0,0},{0,2,1,0}};
        int row = 1;
        int piece = 2;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInRow(testBoard, row, piece);
        assertEquals(expResult, actResult, "The player has not won via row combination");
    }
    @Test
    void winInRowTest_5() {
        int[][] testBoard = {{1,1,1,0},{0,2,2,2},{2,2,1,0}};
        int row = 0;
        int piece = 2;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInRow(testBoard, row, piece);
        assertEquals(expResult, actResult, "The player has not won via row combination");
    }

    /**
     *Test to check if the player wins by having 3 consecutive pieces in a column
     *Test will be successful if the player wins in column combination
     */
    @Test
    void winInColumn_1() {
        int[][] testBoard = {{1,1,1,0},{0,2,1,2},{0,1,1,2}};
        int column = 0;
        int piece = 1;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInColumn(testBoard, column, piece);
        assertEquals(expResult, actResult, "The player has not won via column combination");
    }
    @Test
    void winInColumn_2() {
        int[][] testBoard = {{1,2,1,0},{0,2,1,2},{0,2,1,2}};
        int column = 1;
        int piece = 2;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInColumn(testBoard, column, piece);
        assertEquals(expResult, actResult, "The player has won via column combination");
    }
    @Test
    void winInColumn_3() {
        int[][] testBoard = {{1,2,1,0},{0,2,1,2},{0,2,1,2},{0,0,0,2}};
        int column = 3;
        int piece = 2;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInColumn(testBoard, column, piece);
        assertEquals(expResult, actResult, "The player has won via column combination");
    }
    @Test
    void winInColumn_4() {
        int[][] testBoard = {{0,1,0,0},{1,2,1,0},{0,2,1,2},{0,2,1,2}};
        int column = 3;
        int piece = 1;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInColumn(testBoard, column, piece);
        assertEquals(expResult, actResult, "The player has not won via column combination");
    }
    @Test
    void winInColumn_5() {
        int[][] testBoard = {{1,2,2,0},{0,2,1,2},{0,2,1,2},{0,1,1,0},{1,1,0,0}};
        int column = 2;
        int piece = 1;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInColumn(testBoard, column, piece);
        assertEquals(expResult, actResult, "The player has won via column combination");
    }

    /**
     *Test to check if the player wins by having 3 consecutive pieces in a backslash diagonal
     *Test will be successful if the player wins in backslash diagonal combination
     */
    @Test
    void winInDiagonalBSTest_1() {
        int[][] testBoard = {{1,2,2,0},{0,1,1,2},{0,2,1,2},{0,1,2,0},{1,1,0,0}};
        int piece = 1;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInDiagonalBS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has won via BS Diagonal combination");
    }
    @Test
    void winInDiagonalBSTest_2() {
        int[][] testBoard = {{1,2,2,0},{0,1,2,2},{0,2,1,2},{0,1,2,0},{1,1,0,0}};
        int piece = 2;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInDiagonalBS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has won via BS Diagonal combination");
    }
    @Test
    void winInDiagonalBSTest_3() {
        int[][] testBoard = {{0,2,2,0},{0,1,1,2},{0,2,0,2},{0,1,2,0},{1,1,0,0}};
        int piece = 1;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInDiagonalBS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has won not via BS Diagonal combination");
    }
    @Test
    void winInDiagonalBSTest_4() {
        int[][] testBoard = {{0,2,2,0,0},{0,1,1,2,1},{0,2,1,0,1},{0,0,2,1,0},{1,1,0,0,2}};
        int piece = 1;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInDiagonalBS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has won via BS Diagonal combination");
    }
    @Test
    void winInDiagonalBSTest_5() {
        int[][] testBoard = {{0,2,2,0,0},{0,1,1,2,1},{0,2,1,0,1},{0,0,2,1,0},{1,1,0,0,2}};
        int piece = 2;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInDiagonalBS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has not won via BS Diagonal combination");
    }

    /**
     *Test to check if the player wins by having 3 consecutive pieces in a forward slash diagonal
     *Test will be successful if the player wins in forward slash diagonal combination
     */
    @Test
    void winInDiagonalFSTest_1() {
        int[][] testBoard = {{0,2,2,0,0},{0,1,1,2,1},{0,2,1,0,1},{0,0,2,1,0},{1,1,0,0,2}};
        int piece = 2;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInDiagonalFS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has not won via FS Diagonal combination");
    }
    @Test
    void winInDiagonalFSTest_2() {
        int[][] testBoard = {{0,2,2,0,0},{0,1,1,2,1},{0,2,2,0,1},{0,2,2,1,0},{1,1,0,0,2}};
        int piece = 2;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInDiagonalFS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has won via FS Diagonal combination");
    }
    @Test
    void winInDiagonalFSTest_3() {
        int[][] testBoard = {{0,2,2,0},{0,1,1,2},{0,2,0,1},{0,0,1,0},{1,1,0,0}};
        int piece = 1;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInDiagonalFS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has won via FS Diagonal combination");
    }
    @Test
    void winInDiagonalFSTest_4() {
        int[][] testBoard = {{0,2,2,0},{0,1,0,2},{0,2,0,1},{0,0,0,0},{1,1,0,0}};
        int piece = 1;

        boolean expResult = false;
        boolean actResult = TicTacToe.winInDiagonalFS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has not won via FS Diagonal combination");
    }
    @Test
    void winInDiagonalFSTest_5() {
        int[][] testBoard = {{0,1,2,0},{0,2,1,2},{2,2,0,1},{0,0,0,0},{1,1,0,1}};
        int piece = 2;

        boolean expResult = true;
        boolean actResult = TicTacToe.winInDiagonalFS(testBoard, piece);
        assertEquals(expResult, actResult, "The player has won via FS Diagonal combination");
    }

    /**
     * Test to check if the game produces hint for the player
     * Test will be successful if the row/column value returned matches the last move made
     */
    @Test
    void hintTest_1() {
        int[][] testBoard = {{1,1,0},{2,0,0},{0,2,0}};
        int piece = 1;

        int[] expResult = {0,2};
        int[] actResult = TicTacToe.hint(testBoard, piece);
        assertArrayEquals(expResult, actResult);
    }
    @Test
    void hintTest_2() {
        int[][] testBoard = {{2,2,0},{0,1,0},{0,1,0},{0,0,0}};
        int piece = 1;

        int[] expResult = {3,1};
        int[] actResult = TicTacToe.hint(testBoard, piece);
        assertArrayEquals(expResult, actResult);
    }
    @Test
    void hintTest_3() {
        int[][] testBoard = {{1,1,2,0,0},{0,0,1,0,0},{0,2,1,2,0},{0,0,0,0,0}};
        int piece = 2;

        int[] expResult = {-1,-1};
        int[] actResult = TicTacToe.hint(testBoard, piece);
        assertArrayEquals(expResult, actResult);
    }
    @Test
    void hintTest_4() {
        int[][] testBoard = {{1,0,2,1},{1,2,2,0},{0,0,0,0}};
        int piece = 1;

        int[] expResult = {2,0};
        int[] actResult = TicTacToe.hint(testBoard, piece);
        assertArrayEquals(expResult, actResult);
    }
    @Test
    void hintTest_5() {
        int[][] testBoard = {{1,1,2,1,0},{2,2,1,2,1},{1,2,1,2,1}};
        int piece = 2;

        int[] expResult = {-1,-1};
        int[] actResult = TicTacToe.hint(testBoard, piece);
        assertArrayEquals(expResult, actResult);
    }

    /**
     * Test to check if the factorial value is calculated correctly
     */
    @Test
    void factorialTest_1() {
        int x = 1;
        int y = 1;

        BigInteger expResult = BigInteger.valueOf(y);
        BigInteger actResult = TicTacToe.factorial(x);
        assertEquals(expResult, actResult);
    }
    @Test
    void factorialTest_2() {
        int x = 14;
        BigInteger y = new BigInteger("87178291200");

        BigInteger actResult = TicTacToe.factorial(x);
        assertEquals(y, actResult);
    }
    @Test
    void factorialTest_3() {
        int x = 4;
        BigInteger y = new BigInteger("24");

        BigInteger actResult = TicTacToe.factorial(x);
        assertEquals(y, actResult);
    }
    @Test
    void factorialTest_4() {
        int x = 2;
        BigInteger y = new BigInteger("2");

        BigInteger actResult = TicTacToe.factorial(x);
        assertEquals(y, actResult);
    }
    @Test
    void factorialTest_5() {
        int x = 9;
        BigInteger y = new BigInteger("362880");

        BigInteger actResult = TicTacToe.factorial(x);
        assertEquals(y, actResult);
    }
}