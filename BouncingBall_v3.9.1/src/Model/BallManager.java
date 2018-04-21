package Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Common.Configuration;

public class BallManager {

	private HashMap<String, BallGroup> ballGroups;

	public BallManager() {
		ballGroups = new HashMap<>();
	}

	public HashMap<String, BallGroup> getBallGroups() {
		return ballGroups;
	}

	public void setBallGroups(HashMap<String, BallGroup> ballGroups) {
		this.ballGroups = ballGroups;
	}

	public void setGroupMove(String key, boolean isMove) {

		if (ballGroups.containsKey(key))
			ballGroups.get(key).setMove(isMove);
	}

	public void addBall(String key) {
		if (ballGroups.containsKey(key))
			ballGroups.get(key).addBall();
	}

	public void removeBall(String key) {
		if (ballGroups.containsKey(key))
			ballGroups.get(key).removeBall();
	}

	public void addGroup(String key, Color ballColor) {

		if (!ballGroups.containsKey(key)) {
			ballGroups.put(key, new BallGroup(ballColor));
		}
		addBall(key);
	}

	public void removeGroup(String key) {
		if (ballGroups.containsKey(key)) {
			ballGroups.get(key).removeAll();
			ballGroups.remove(key);
		}
	}

	public void increaseXY() {

		Iterator<Entry<String, BallGroup>> ballItr = ballGroups.entrySet().iterator();
		while (ballItr.hasNext()) {
			Map.Entry<String, BallGroup> ballEntry = (Map.Entry<String, BallGroup>) ballItr.next();
			if (ballEntry.getValue().isMove()) {
				ArrayList<Ball> ballList = ballEntry.getValue().getBallList();
				for (int i = 0; i < ballList.size(); i++) {
					Ball ball = ballList.get(i);
					if (ball.getBallX() < 0 || ball.getBallX() + ball.getVelocityX()
							+ ball.getBallWidth() >= Configuration.GRAPHICVIEW_WIDTH - Configuration.EDGE_WIDTH)
						ball.setVelocityX(ball.getVelocityX() * -1);

					if (ball.getBallY() < 0 || ball.getBallY() + ball.getVelocityY()
							+ ball.getBallHeight() >= Configuration.GRAPHICVIEW_HEIGHT - Configuration.EDGE_HEIGHT)
						ball.setVelocityY(ball.getVelocityY() * -1);

					ball.setBallX(ball.getBallX() + ball.getVelocityX() * ball.getBallSpeed());
					ball.setBallY(ball.getBallY() + ball.getVelocityY() * ball.getBallSpeed());
				}
			}
		}
	}
	
	public ArrayList<Oval> ballTooval() {
		
		ArrayList<Oval> ovalList = new ArrayList<>();
		
		Iterator<Entry<String, BallGroup>> ballItr = ballGroups.entrySet().iterator();
		while (ballItr.hasNext()) {
			Map.Entry<String, BallGroup> ballEntry = (Map.Entry<String, BallGroup>) ballItr.next();
			ArrayList<Ball> ballList = ballEntry.getValue().getBallList();
			for(int i=0; i<ballList.size(); i++) {
				Ball ball = ballList.get(i);
				Oval oval = new Oval(ballEntry.getValue().getBallColor(), ball.getBallX(), ball.getBallY(), ball.getBallWidth(), ball.getBallHeight());
				ovalList.add(oval);
			}
			
		}
		
		return ovalList;
		
	}
}
