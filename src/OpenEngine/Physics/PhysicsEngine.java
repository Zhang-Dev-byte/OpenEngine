package OpenEngine.Physics;

import java.util.ArrayList;
import java.util.List;

import OpenEngine.Core.Vector3f;

public class PhysicsEngine {
	private List<PhysicsObject> objects = new ArrayList<PhysicsObject>();

	public void AddObject(PhysicsObject object) {
		objects.add(object);
	}
	public void Simulate(float delta) {
		for(int i = 0;i<objects.size();i++) {
			objects.get(i).Integerate(delta);
		}
	}
	public void HandleCollisions() {
		for(int i = 0;i<objects.size();i++) {
			for(int j = i+1;j<objects.size();j++) {
				IntersectData data = objects.get(i).getCollider().Intersect(objects.get(j).getCollider());

				if(data.isdoesIntersect()) {
					Vector3f direction = data.getDirection().Normalized();

					objects.get(i).setVelocity(objects.get(i).getVelocity().Mul(-1f));
					objects.get(j).setVelocity(objects.get(j).getVelocity().Mul(-1f));
				}
			}
		}
	}
}
