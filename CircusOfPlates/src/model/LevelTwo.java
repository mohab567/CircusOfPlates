package model;



public class LevelTwo implements model.Level {



	@Override
	public int FPS() {
		// TODO Auto-generated method stub
		return 52;
	}
long range1=(long) (60* java.lang.Math.pow(10,9));
long range2=(long) (120 * java.lang.Math.pow(10,9));
	@Override
	public boolean acceptRange(long deltaTime) {
		// TODO Auto-generated method stub
		return deltaTime >= range1 &&
				deltaTime < range2
				;
	}
	@Override
	public String Name() {
		// TODO Auto-generated method stub
		return "second";
	}

}
