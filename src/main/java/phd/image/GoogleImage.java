package phd.image;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

public class GoogleImage extends OpticalImage {
	private static int ROADCOLOUR = Color.WHITE.getRGB();
	
	private static int[][] neighbours;
	static {
		neighbours = new int[][] {
			new int[] {-1, -1},
			new int[] {-1, 1},
			new int[] {1, -1},
			new int[] {1, 1},
			new int[] {0, 1},
			new int[] {0, -1},
			new int[] {1, 0},
			new int[] {-1, 0}};
	}	
	
	public GoogleImage(Coordinates x, Coordinates y) {
		super(x, y);
	}

	public double roadDistance(Coordinates origin) {
		boolean[][] visited = new boolean[bufferImage.getWidth()][];
		for (int i = 0; i < bufferImage.getWidth(); i++) {	
			visited[i] = new boolean[bufferImage.getHeight()];
		}
		
		Queue<Coordinates> q = new LinkedList<Coordinates>();
		q.offer(origin);
		visited[origin.x][origin.y] = true;
		
		// breadth-first search for next road
		Coordinates c = null;
		while (!q.isEmpty()) {
			c = q.poll();
			
			Color color = new Color(bufferImage.getRGB(c.x, c.y));
			int red = color.getRed();
			int green = color.getGreen();
			int blue = color.getBlue();
			
			if (red >= 252 && green >= 252 && blue >= 252) {
				break;
			} else {
				offerNeighbours(q, visited, c);
			}
		}
		
		if (c == null)
			return Integer.MAX_VALUE;
		else {
			return Math.sqrt(Math.pow(origin.x - c.x, 2) + Math.pow(origin.y - c.y, 2));
		}
	}

	private void offerNeighbours(Queue<Coordinates> q, boolean[][] visited, Coordinates c) {
		for (int i = 0; i < neighbours.length; i++) {
			int nX = c.x + neighbours[i][0];
			int nY = c.y + neighbours[i][1];

			if (nX > 0 && nY > 0 && nX < bufferImage.getWidth() && 
					nY < bufferImage.getHeight() &&
					!visited[nX][nY]) {
				q.offer(new Coordinates(nX, nY));
				visited[nX][nY] = true;				
			}
		}		
	}

}
