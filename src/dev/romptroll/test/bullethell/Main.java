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
		window = new Window(1000, 500, "Test");
		window.setInputHandler(input = (Input) Engine.input);
		Window.setContext(window);
		renderer = Engine.renderer;
		renderer.clearColor(255, 255, 255, 255);
		camera = new Camera(renderer);
		gameScene = new Scene();
		
		GameComponent playerScript = new GameComponent() {
			public void update(float delta) {
				float angle = (float) Math.atan2(input.mouseX, input.mouseY);
				renderer.rotate(angle);
				
				if(input.keys[GLFW_KEY_W]) {
					parent.transform.y+=2;
				}
				if(input.keys[GLFW_KEY_S]) {
					parent.transform.y-=2;
				}
				if(input.keys[GLFW_KEY_A]) {
					parent.transform.x-=2;
				}
				if(input.keys[GLFW_KEY_D]) {
					parent.transform.x+=2;
				}
			}
		};
		
		class TextureRenderer extends GameComponent {
			public Texture texture = new Texture("C:/Users/Ludwig Bogsveen/Desktop/assets/bullethell/null.png");
			public int width = 64;
			public int height = 64;
			public TextureRenderer(Texture texture) {
				if(texture != null) this.texture = texture;
			}
			public void render() {
				Engine.renderer.drawImage(texture, (int)parent.transform.x, (int)parent.transform.y, width, height);
			}
		};
		
		GameObject player = new GameObject();
		player.addComponent(playerScript);
		player.addComponent(new TextureRenderer(new Texture("C:/Users/Ludwig Bogsveen/Desktop/assets/bullethell/player.png")));
		gameScene.addObject(player);
	}


	@Override
	public void update(float delta) {
		glfwPollEvents();
		gameScene.update(delta);
	}

	@Override
	public void render() {
		renderer.clear();
		gameScene.render();
		window.swapBuffers();
	}
}
