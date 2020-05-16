package OpenEngine.Physics;

import OpenEngine.Core.Vector3f;

public class PhysicsObject {
	private Vector3f velocity;
	private Vector3f position;
	private Vector3f oldPosition;
	private Collider boundingSphere;

	public PhysicsObject(Vector3f velocity,Collider collider) {
		this.velocity = velocity;
		this.position = collider.getCenter();
		this.oldPosition = position;
	}
	public Collider getBoundingSphere() {
		return boundingSphere;
	}
	public void setBoundingSphere(Collider boundingSphere) {
		this.boundingSphere = boundingSphere;
	}
	public Vector3f getVelocity() {
		return velocity;
	}
	public Vector3f getPosition() {
		return position;
	}
	public Collider getCollider() {
		Vector3f difference = this.position.Sub(this.oldPosition);
		this.oldPosition = this.position;
		this.boundingSphere.Transform(difference);
		return boundingSphere;
	}
	public void setVelocity(Vector3f velocity) {
		this.velocity = velocity;
	}
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	public PhysicsObject(Vector3f velocity, Vector3f position) {
		this.velocity = velocity;
		this.position = position;
	}

	public void Integerate(float delta) {
		this.position = this.position.Add(this.velocity.Mul(delta));
	}

}
