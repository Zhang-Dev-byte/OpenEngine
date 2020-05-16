package OpenEngine.Physics;

import OpenEngine.Core.Vector3f;

public class IntersectData {
	private boolean doesIntersect;
	private Vector3f direction;

	public boolean isdoesIntersect() {
		return doesIntersect;
	}
	public Vector3f getDirection() {
		return direction;
	}
	public float getDistance() {
		return this.direction.Length();
	}
	public IntersectData(boolean doesIntersect, Vector3f direction) {
		this.doesIntersect = doesIntersect;
		this.direction = direction;
	}
}
