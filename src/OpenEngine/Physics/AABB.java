package OpenEngine.Physics;

import OpenEngine.Core.Vector3f;

public class AABB {
	private Vector3f minExtents;
	private Vector3f maxExtents;

	public Vector3f getMinExtents() {
		return minExtents;
	}
	public Vector3f getMaxExtents() {
		return maxExtents;
	}
	public IntersectData IntersectAABB(AABB other) {
		Vector3f distances1 = other.getMinExtents().Sub(this.maxExtents);
		Vector3f distances2 = this.minExtents.Sub(other.getMaxExtents());
		Vector3f distances = new Vector3f(0.0f,0.0f,0.0f);
		distances = distances1.Max(distances2);

		float maxDist = distances.Max();

		return new IntersectData((maxDist < 0.0f), distances);
	}
	public AABB(Vector3f minExtents, Vector3f maxExtents) {
		this.minExtents = minExtents;
		this.maxExtents = maxExtents;
	}
}
