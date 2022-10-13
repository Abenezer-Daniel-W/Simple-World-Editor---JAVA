import edu.du.dudraw.DUDraw;



public class SandGame {
	public static void main(String[] args) {

		
		SandWorld world1 = new SandWorld(200,200);
		System.out.println("hold s for sand f for floor");
		DUDraw.enableDoubleBuffering();
		while(true) {
			if(DUDraw.hasNextKeyTyped()) {
				char hey = DUDraw.nextKeyTyped();
				if(hey == 's') {
					world1.setMode(1);
				}
				
				if(hey == 'f') {
					world1.setMode(2);
				}
				if(hey=='w') {
					world1.setMode(3);
				}
				if(hey=='c') {
					world1.setMode(4);
				}
			}
			
			
		
			
			
			if(DUDraw.isMousePressed()) {
				world1.placeParticle(DUDraw.mouseX(), DUDraw.mouseY());
			}
			world1.draw();
			world1.display();
			
			world1.gravity();
			DUDraw.show();
			DUDraw.pause(10);

		}
	}
}


