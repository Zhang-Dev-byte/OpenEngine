package OpenEngine.Physics;

import OpenEngine.Core.Vector3f;

public abstract class Collider {

	private ColliderType type;
	public enum ColliderType{
		TYPE_SPHERE ,
		TYPE_AABB,
		TYPE_SIZE
	}
	public Collider(ColliderType type) {
		this.type = type;
	}

	public ColliderType getType() {
		return type;
	}
	public abstract void Transform(Vector3f translation);
	public abstract IntersectData Intersect(Collider other);
	public abstract Vector3f getCenter();
}
