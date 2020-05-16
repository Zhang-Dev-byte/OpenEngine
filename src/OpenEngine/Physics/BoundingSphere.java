package OpenEngine.Physics;

import OpenEngine.Core.Vector3f;

public class BoundingSphere extends Collider{
	private Vector3f center;
	private float radius;

	public BoundingSphere(Vector3f center, float radius) {
		super(ColliderType.TYPE_SPHERE);
		this.center = center;
		this.radius = radius;
	}
	public Vector3f getCenter() {
		return center;
	}
	public float getRadius() {
		return radius;
	}
	public IntersectData InstersectBoundingSphere(BoundingSphere other) {
		float radiusDist = this.radius + other.radius;
		Vector3f direction = (other.getCenter().Sub(center));
		float centerDist = direction.Length();
		float dist = centerDist - radiusDist;
		direction = direction.Div(centerDist);

		return new IntersectData(dist < 0,direction.Mul(dist));
	}
	@Override
	public IntersectData Intersect(Collider other){
		if(this.getType() == ColliderType.TYPE_SPHERE && other.getType() == ColliderType.TYPE_SPHERE) {
			BoundingSphere self = (BoundingSphere)this;
			return self.InstersectBoundingSphere((BoundingSphere)other);
		}else {
			return null;
		}
	}
	@Override
	public void Transform(Vector3f translation) {
		this.center.Add(translation);
	}


}
