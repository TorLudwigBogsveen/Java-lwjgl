package dev.romptroll.test.bullethell;

import static org.lwjgl.glfw.GLFW.*;
import dev.romptroll.engine.core.Application;
import dev.romptroll.engine.core.Engine;
import dev.romptroll.engine.core.Input;
import dev.romptroll.engine.graphics.Camera;
import dev.romptroll.engine.graphics.Renderer;
import dev.romptroll.engine.graphics.Texture;
import dev.romptroll.engine.graphics.Window;
import dev.romptroll.engine.scene.GameComponent;
import dev.romptroll.engine.scene.GameObject;
import dev.romptroll.engine.scene.Scene;

public class Main implements Application {
	
	private Window window;
	private Camera camera;
	private Scene gameScene;
	private Input input;
	private Renderer renderer;
			
	public static void main(String[] args) {
		Engine.init(new Main());
	}
	
	public void init() {
		window = new Window(1920, 1080, "Test", true);
		window.setInputHandler(input = new Input());
		Window.setContext(window);
		renderer = new Renderer(window);
		renderer.clearColor(255, 255, 255, 255);
		camera = new Camera(renderer);
		gameScene = new Scene(renderer);
		
		class TextureRenderer extends GameComponent {
			Texture texture = new Texture("bullethell/null.png");
			int width = 64;
			int height = 64;
			TextureRenderer(Texture texture) {
				if(texture != null) this.texture = texture;
			}
			public void render(Renderer ren) {
				ren.drawImage(texture, (int)parent.transform.x, (int)parent.transform.y, width, height);
			}
		};
		
		class BulletScript extends GameComponent {
			TextureRenderer ren;
			float velX;
			float velY;
			public void update(float delta) {
				parent.transform.x += velX;
				parent.transform.y += velY;
			}
		}
		
		GameComponent playerScript = new GameComponent() {
			public void update(float delta) {
				parent.transform.rotate((float) Math.toDegrees(Math.atan2((parent.transform.x+(window.getWidth()/2))-input.mouseX, (parent.transform.y+(window.getHeight()/2))-input.mouseY)));
				
				if(input.buttons[GLFW_MOUSE_BUTTON_LEFT]) {
					GameObject bullet = new GameObject();
					BulletScript script = new BulletScript();
					script.velX = 0;
					script.velY = 3f;
					bullet.addComponent(script);
					bullet.addComponent(new TextureRenderer(new Texture("bullethell/bullet.png")));
					bullet.transform.x = parent.transform.x;
					bullet.transform.y = parent.transform.y;
					gameScene.addObject(bullet);
				}
				if(input.keys[GLFW_KEY_W]) parent.transform.y+=2;
				if(input.keys[GLFW_KEY_S]) parent.transform.y-=2;
				if(input.keys[GLFW_KEY_A]) parent.transform.x-=2;
				if(input.keys[GLFW_KEY_D]) parent.transform.x+=2;
			}
		};
		
		GameObject player = new GameObject();
		player.addComponent(playerScript);
		player.addComponent(new TextureRenderer(new Texture("bullethell/player.png")));
		gameScene.addObject(player);
	}


	@Override
	public void update(float delta) {
		glfwPollEvents();
		if(input.keys[GLFW_KEY_ESCAPE]) System.exit(0);
		gameScene.update(delta);
	}

	@Override
	public void render() {
		renderer.clear();
		gameScene.render();
		window.swapBuffers();
	}
}
