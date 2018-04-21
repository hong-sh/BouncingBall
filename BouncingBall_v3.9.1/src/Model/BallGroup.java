package Model;

import java.awt.Color;
import java.util.ArrayList;

public class BallGroup {

	private boolean isMove;
	private Color ballColor;
	private ArrayList<Ball> ballList;

	public BallGroup(Color ballColor) {
		this.ballList = new ArrayList<>();
		this.isMove = true;
		this.ballColor = ballColor;
	}

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

	public Color getBallColor() {
		return ballColor;
	}

	public void setBallColor(Color ballColor) {
		this.ballColor = ballColor;
	}

	public ArrayList<Ball> getBallList() {
		return ballList;
	}

	public void setBallList(ArrayList<Ball> ballList) {
		this.ballList = ballList;
	}

	public int getBallListSize() {
		return ballList.size();
	}

	public Ball getBall(int index) {
		return ballList.get(index);
	}

	public void addBall() {
		Ball ball = new Ball();
		ballList.add(ball);
	}

	public void removeBall() {
		if (ballList.size() > 0)
			ballList.remove(ballList.size() - 1);
	}

	public void removeAll() {
		for (int i = 0; i < ballList.size(); i++) {
			ballList.remove(0);
		}
	}

}
