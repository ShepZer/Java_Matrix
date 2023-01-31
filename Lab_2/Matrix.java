//Доп: добавить метод, который сортирует столбцы матрицы по возрастанию суммы.
import java.util.Scanner;

public class Matrix{
	
	public int cur_row;
	public int cur_column;
	public int[][] matrix;

	public static void main (String[] args){
		
		Matrix cl = new Matrix (5, 5);
		
		cl.setElement(0,0,100);
		cl.setElement(1,1,99);
		cl.setElement(2,2,11);
		cl.setElement(3,4,-11);
		cl.setElement(0,4,70);

		System.out.println(cl);
		
		cl.sortSum();
		
		System.out.println(cl);
	}

	public void sortSum (){

		for (int n = 0; n < cur_row; n++){
			for (int j = 1; j < cur_row; j++){

				int prevSum = 0;

				for (int i = 0; i < cur_row; i++){
                        	prevSum = prevSum + matrix[i][j - 1];
				}
 
				int curSum = 0;

				for (int i = 0; i < cur_row; i++){
					curSum = curSum + matrix[i][j];
				}
 		
				if (prevSum > curSum){
					for (int k = 0; k < cur_row; k++){
						int temp = matrix[k][j];
						matrix[k][j] = matrix[k][j - 1];
						matrix[k][j - 1] = temp;
					}
				}
			}
		}
	}

	public Matrix (int row_i, int column_j){

		cur_row = row_i;
		cur_column = column_j;
		matrix = new int [cur_row][cur_column];

		for(int i = 0; i < cur_row; i++){
			for(int j = 0; j < cur_column; j++){
				if(i == j){
					matrix[i][j] = 1;
				}
			}
		}
	}

	public Matrix sum (Matrix q){
		for(int i = 0; i < cur_row; i++){
			for(int j = 0; j < cur_column; j++){
				q.matrix[i][j] = q.matrix[i][j] + q.matrix[i][j];
			}
		}
		return q;
	}

	public Matrix product (Matrix q){

		Matrix matrix = new Matrix(cur_row, cur_column);

		for(int i = 0; i < cur_row; i++){
			for(int j = 0; j < cur_column; j++){
				matrix.setElement(i, j, 0);
			}
		}

		for(int i = 0; i < cur_row; i++){
			for(int j = 0; j < cur_column; j++){
				for(int k = 0; k < cur_row; k++){
					matrix.matrix[i][j] = matrix.matrix[i][j] + this.matrix[i][k] * q.matrix[k][j];
				}
			}
		}
		
		return matrix;
	}

	public void setElement (int row, int column, int value){
		matrix[row][column] = value;
	}
	
	public int getElement (int row, int column){
		return matrix[row][column];
	}

	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < cur_row; i++){
			for(int j = 0; j < cur_column; j++){ 
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		} 
		String text = sb.toString();
		return text;
	}
}