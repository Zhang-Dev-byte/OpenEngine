
mesh = luajava.newInstance( "OpenEngine.Renderer.Mesh", "monkey3.obj" );

gameobj = luajava.newInstance("OpenEngine.Core.GameObject")

gameobj:AddComponent(luajava.newInstance("OpenEngine.Components.MeshRenderer",mesh,luajava.newInstance("OpenEngine.Renderer.Material",nil,0,0,nil,nil,0,0)))

gameobj:GetTransform():GetPos():Set(10,5,5)

game:AddObject(gameobj)