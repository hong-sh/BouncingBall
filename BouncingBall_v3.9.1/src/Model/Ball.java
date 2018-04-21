package Model;

public class Ball {

	private int ballX;
	private int ballY;
	private int ballWidth;
	private int ballHeight;
	private int velocityX;
	private int velocityY;
	private int ballSpeed;

	public Ball() {
		this.ballX = 10;
		this.ballY = 10;
		this.ballWidth = 10;
		this.ballHeight = 10;
		this.velocityX = 2;
		this.velocityY = 3;
		this.ballSpeed = 1;
	}

	public int getBallX() {
		return ballX;
	}

	public void setBallX(int ballX) {
		this.ballX = ballX;
	}

	public int getBallY() {
		return ballY;
	}

	public void setBallY(int ballY) {
		this.ballY = ballY;
	}

	public int getBallWidth() {
		return ballWidth;
	}

	public void setBallWidth(int ballWidth) {
		this.ballWidth = ballWidth;
	}

	public int getBallHeight() {
		return ballHeight;
	}

	public void setBallHeight(int ballHeight) {
		this.ballHeight = ballHeight;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	public int getBallSpeed() {
		return ballSpeed;
	}

	public void setBallSpeed(int ballSpeed) {
		this.ballSpeed = ballSpeed;
	}

}
