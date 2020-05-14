package OpenEngine.Components;

import OpenEngine.Core.CoreEngine;
import OpenEngine.Core.GameObject;
import OpenEngine.Core.Transform;
import OpenEngine.Renderer.RenderingEngine;
import OpenEngine.Renderer.Shader;

public abstract class GameComponent
{
	private GameObject m_parent;

	public void Input(float delta) {}
	public void Update(float delta) {}
	public void Render(Shader shader, RenderingEngine renderingEngine) {}

	public void SetParent(GameObject parent)
	{
		this.m_parent = parent;
	}

	public Transform GetTransform()
	{
		return m_parent.GetTransform();
	}

	public void AddToEngine(CoreEngine engine) {}
}