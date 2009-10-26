package mikera.stats;

import mikera.engine.Grid;
import mikera.engine.Octreap;
import mikera.engine.TreeGrid;
import mikera.util.TextUtils;

public class PerformanceTest {

	public static final int PRERUNS=10;
	public static final int RUNS=100;
	
	public static void main(String[] args) {
		setup();
		
		for (int i=0; i<PRERUNS; i++) {
			a();
			b();
		}
		
		long astart=System.nanoTime();
		for (int i=0; i<RUNS; i++) {
			a();
		}		
		long atime=System.nanoTime()-astart;
		
		long bstart=System.nanoTime();
		for (int i=0; i<PRERUNS; i++) {
			b();
		}		
		long btime=System.nanoTime()-bstart;

		System.out.println("a time = "+TextUtils.leftPad(Long.toString(atime/RUNS),12)+" ns");
		System.out.println("b time = "+TextUtils.leftPad(Long.toString(btime/RUNS),12)+" ns");
	}
	
	/**
	 * Setup code here
	 */
	
	static Grid<Integer> g1;
	static Grid<Integer> g2;
	private static void setup() {
		g1=new Octreap<Integer>();
		g2=new TreeGrid<Integer>();
	}
	
	/**
	 * Enter code to time here
	 */
	private static void a() {
		testGrid(g1);
	}
	
	private static void b() {
		testGrid(g2);
	}
	
	private static void testGrid(Grid<Integer> g) {
		g.clear();
		g.setBlock(0, 0, 0, 30, 30, 30, 1);
		g.setBlock(0, 0, 0, 3, 3, 3, 2);
		g.set(2,2,2,3);
	}
}