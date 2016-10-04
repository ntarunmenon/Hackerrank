package problems;

public class Aamzon {

	private static int[][] lockerMap ;
	static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
		lockerMap = new int[cityLength][cityWidth];
		
		for(int lockerIndex = 0; lockerIndex < lockerXCoordinates.length; lockerIndex++){
			lockerMap[lockerXCoordinates[lockerIndex] - 1][lockerYCoordinates[lockerIndex] -1] = -1;
		}
		
		for(int i = 0; i < cityLength;i++){
			for(int j=0;j < cityWidth;j++){
				if(lockerMap[i][j] != -1){
					for(int lockerIndex = 0; lockerIndex < lockerXCoordinates.length; lockerIndex++){
						if(lockerMap[i][j] == 0 || lockerMap[i][j] > distance(i, j, lockerXCoordinates[lockerIndex] - 1, lockerYCoordinates[lockerIndex] - 1)){
							lockerMap[i][j] = distance(i, j, lockerXCoordinates[lockerIndex] -1, lockerYCoordinates[lockerIndex] - 1);
						}
					}
				}
			}
		}
		for(int lockerIndex = 0; lockerIndex < lockerXCoordinates.length; lockerIndex++){
			lockerMap[lockerXCoordinates[lockerIndex]	- 1][lockerYCoordinates[lockerIndex] -1] = 0;
		}
		print();
		return lockerMap;
	}
	
	public static int distance(int xL,int yL,int x,int y){
		return Math.abs(xL - x) + Math.abs(yL - y);
	}
	
	public static void main(String[] args) {
		getLockerDistanceGrid(5,7,new int[]{2,2,4},new int[]{2,3,7});
	}
	
	public static void print(){
		  
		for (int[] row : lockerMap)
		{
			 printRow(row);
		}
	}
	
	 public static void printRow(int[] row) {
	        for (int i : row) {
	            System.out.print(i);
	            System.out.print("\t");
	        }
	        System.out.println();
	    }
}


