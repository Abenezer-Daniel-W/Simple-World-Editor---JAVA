
public class trial {
	public static void main(String[] args) {
		//A shallow copy
		int[][] list = new int[5][5];
		int num = 1;
		for(int i =0; i < 5 ; i++){
			for(int j =0; j < 5 ; j++){
				list[i][j] += num;
				num++;
			}
		}
		for(int i =5; i < 0 ; i--){
			for(int j =5; j < 0 ; j--){
				System.out.print(list[i][j]);
			}
		}
	}
}
