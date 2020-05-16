package OpenEngine.Physics;

import OpenEngine.Core.Vector3f;

public class Plane {
	private Vector3f normal;
	private float distance;


	public Plane(Vector3f normal, float distance) {
		this.normal = normal;
		this.distance = distance;
	}
	public Plane Normailize() {
		float magnitude = this.normal.Length();
		return new Plane(this.normal.Div(magnitude),this.distance / magnitude);
	}
	public IntersectData IntersectSphere(BoundingSphere other) {
		float distFromSphereCenter = Math.abs(this.normal.Dot(other.getCenter()) + this.distance);
		float distFromSphere = distFromSphereCenter - other.getRadius();

		return new IntersectData(distFromSphere < 0,this.normal.Mul(distFromSphere));

	}
	public Vector3f getNormal() {
		return normal;
	}
	public float getDistance() {
		return distance;
	}
}
