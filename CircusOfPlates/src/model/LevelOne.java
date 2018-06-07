package model;



public class LevelOne implements model.Level {

	@Override
	public int FPS() {
		// TODO Auto-generated method stub
		return 45;
	}
    long range = (long) (60 * java.lang.Math.pow(10,9));
	@Override
	public boolean acceptRange(long deltaTime) {
		// TODO Auto-generated method stub
		return deltaTime < range;
	}
	@Override
	public String Name() {
		// TODO Auto-generated method stub
		return "First";
	}



}
