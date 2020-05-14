package OpenEngine.Components;

import OpenEngine.Renderer.Material;
import OpenEngine.Renderer.Mesh;
import OpenEngine.Renderer.RenderingEngine;
import OpenEngine.Renderer.Shader;

public class MeshRenderer extends GameComponent
{
	private Mesh     m_mesh;
	private Material m_material;

	public MeshRenderer(Mesh mesh, Material material)
	{
		this.m_mesh = mesh;
		this.m_material = material;
	}

	@Override
	public void Render(Shader shader, RenderingEngine renderingEngine)
	{
		shader.Bind();
		shader.UpdateUniforms(GetTransform(), m_material, renderingEngine);
		m_mesh.Draw();
	}
}