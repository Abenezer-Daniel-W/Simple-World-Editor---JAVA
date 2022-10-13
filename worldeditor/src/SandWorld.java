import edu.du.dudraw.DUDraw;

public class SandWorld {
	private int mode; 
	private int[][] world;
	public SandWorld(int r, int c) {
		world = new int[r][c];
		mode = 1;
		for(int row = 0; row< world.length; row++) {
			for(int col = 0; col < world[0].length; col++) {
				world[row][col] = 0;
			}
		}
		DUDraw.setCanvasSize(r,c);

		DUDraw.setXscale(0, r);
		DUDraw.setYscale(0, c);

	}
	public void draw() {
		for(int row = 1; row < world.length; row++) {
			for(int col = 1; col < world[0].length; col++) {
				if(world[row][col] == 0) {
					DUDraw.setPenColor(DUDraw.WHITE);
					DUDraw.filledSquare(col+0.5, row+0.5, 0.5);
				}
				if(world[row][col] == 1) {
					DUDraw.setPenColor(255,172, 61);
					DUDraw.filledRectangle(col, row+0.5, 0.5, 0.5);
					DUDraw.filledRectangle(col+0.5, row, 0.5, 0.5);
					DUDraw.filledRectangle(col, row, 0.5, 0.5);
					DUDraw.filledRectangle(col+0.5, row+0.5, 0.5, 0.5);
				}
				if(world[row][col] == 2) {
					DUDraw.setPenColor(0,0,0);
					DUDraw.filledRectangle(col, row+0.5, 0.5, 0.5);
					DUDraw.filledRectangle(col+0.5, row, 0.5, 0.5);
					DUDraw.filledRectangle(col, row, 0.5, 0.5);
					DUDraw.filledRectangle(col+0.5, row+0.5, 0.5, 0.5);
				}
				if(world[row][col] == 3) {
					DUDraw.setPenColor(0,191,255);
					DUDraw.filledRectangle(col, row+0.5, 0.5, 0.5);
					DUDraw.filledRectangle(col+0.5, row, 0.5, 0.5);
					DUDraw.filledRectangle(col, row, 0.5, 0.5);
					DUDraw.filledRectangle(col+0.5, row+0.5, 0.5, 0.5);
				}
				if(world[row][col] == 4) {
					DUDraw.setPenColor(169,169,169);
					DUDraw.filledRectangle( col,row, 10, 10);				
				}
			}
		}
	}
	//click method enables the user to draw
	public void placeParticle(double xPos, double yPos) {
		int r;
		int c;
		if(mode == 1) {
			c = (int) xPos;
			r = (int) yPos;
			world[r][c] = 1;
		}
		if(mode == 2) {
			c = (int) xPos;
			r = (int) yPos;
			world[r][c] = 2;
		}
		if(mode == 3) {
			c = (int) xPos;
			r = (int) yPos;
			world[r][c] = 3;
		}
		if(mode == 4) {
			c = (int) xPos;
			r = (int) yPos;
			world[r][c] = 4;
		}
	}
	//gravity make the particles fall down
	public void gravity() {
		for(int row= 1; row < world.length; row++) {
			for(int col = 1; col < world[0].length; col++) {
				if(world[row][col] == 1 && world[row-1][col] == 0) {
					world[row][col] = 0; 
					world[row-1][col] = 1;
				}

			}
		}
		for(int row= 1; row < world.length; row++) {
			for(int col = 1; col < world[0].length; col++) {
				if(world[row][col] == 3 && world[row-1][col] == 0) {
					world[row][col] = 0; 
					world[row-1][col] = 3;
				}
				if(world[row][col] == 3 && world[row][col-1] == 0 ) {
					world[row][col] = 0; 
					world[row][col-1] = 3;
				}
				if(world[row][col] == 3 && world[row][col+1] == 0) {
					world[row][col] = 0; 
					world[row][col+1] = 3;
				}
			}
		}
	}

	public void setMode(int newMode) {
		this.mode = newMode;
	}
	public void display() {
		if(mode== 2) {
			DUDraw.setPenColor(DUDraw.BLACK);
			DUDraw.text(40, 195, "Floor");
		}
		if(mode== 1) {
			DUDraw.setPenColor(DUDraw.BLACK);
			DUDraw.text(40, 195, "sand");
		}
		if(mode== 3) {
			DUDraw.setPenColor(DUDraw.BLACK);
			DUDraw.text(40, 195, "water");
		}
		if(mode== 3) {
			DUDraw.setPenColor(DUDraw.BLACK);
			DUDraw.text(40, 195, "cloud");
		}

	}



}



