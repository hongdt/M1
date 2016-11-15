import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import localsearch.constraints.basic.LessOrEqual;
import localsearch.constraints.basic.LessThan;
import localsearch.functions.conditionalsum.ConditionalSum;
import localsearch.model.ConstraintSystem;
import localsearch.model.IFunction;
import localsearch.model.LocalSearchManager;
import localsearch.model.VarIntLS;
import localsearch.selectors.MinMaxSelector;

/**
 * 
 */

/**
 * @author ga-ptit
 *
 */
class Move{
	int i;// index of the variable
	int val;// value to be assigned
	public Move(int i, int val){
		this.i = i; this.val = val;
	}
}
public class BACP {

	/**
	 * @param args
	 */
	private int n; //number of the courses
	private int P; //number of the semesters
	private int[] c;//c[i] number of credits of course i
	private int minCourses;
	private int maxCourses;
	private int minCredits;
	private int maxCredits;
	private int[] I;
	private int[] J;//course I[k] must be before course J[k]
	
	private LocalSearchManager ls;
	private ConstraintSystem S;
	private VarIntLS[] x;
	
	IFunction obj = null;
	Random R = new Random();
	
	// tabu infor
	int[][] tabu;
	int tbl;
	int nic;
	int bestViolations;
	
	public BACP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void stateModel(){
		ls = new LocalSearchManager();
		S = new ConstraintSystem(ls);
		x = new VarIntLS[n];
		for(int i = 0; i < x.length; i++){
			x[i] = new VarIntLS(ls, 1, P);
		}
		
		for(int k = 0; k < I.length; k++){
			int i = I[k];
			int j = J[k];
			S.post(new LessThan(x[i], x[j]));
		}
		
		int[] w = new int[n];
		for(int i = 0; i < w.length; i++) w[i] = 1;
		for(int p = 1; p <= P; p++){
			ConditionalSum Y = new ConditionalSum(x, w, p);
			S.post(new LessOrEqual(minCourses, Y));
			S.post(new LessOrEqual(Y, maxCourses));
		}
		
		for(int p = 1; p <= P; p++){
			ConditionalSum Y = new ConditionalSum(x, c, p);
			S.post(new LessOrEqual(minCredits, Y));
			S.post(new LessOrEqual(Y, maxCredits));
		}
		
		ls.close();
	}
	
	public void readData(String fn){
		try{
			Scanner in = new Scanner(new File(fn));
			n = in.nextInt();
			P = in.nextInt();
			minCredits = in.nextInt();
			maxCredits = in.nextInt();
			minCourses = in.nextInt();
			maxCourses = in.nextInt();
			
			c = new int[n];
			for(int i = 0; i < n; i++){
				c[i] = in.nextInt();
			}
			
			int szL = in.nextInt();//sxL = 38
			I = new int[szL];
			J = new int[szL];
			
			for(int k = 0; k < szL; k++){
				I[k] = in.nextInt() - 1;
				J[k] = in.nextInt() - 1;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void restart(){
		for(int i = 0; i < n; i++)
			for(int v= 0; v < n; v++)
				tabu[i][v] = -1;
		nic = 0;
		for(int i = 0; i < P; i++){
			int v = R.nextInt(P);
			x[i].setValuePropagate(v);
		}
		if(bestViolations > S.violations())
			bestViolations = S.violations();
	}
	public void tabuSearch(int maxIter, int maxStable, int tblen){
		ArrayList<Move> moves = new ArrayList<Move>();
		tabu = new int[n][n];
		this.tbl = tblen;
		
		bestViolations = S.violations();
		for(int it = 0; it < maxIter; it++){
			moves.clear();
			int minDelta = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++){
				for(int v = x[i].getMinValue(); v <= x[i].getMaxValue(); v++){
					// consider the move (i,v)
					int d = S.getAssignDelta(x[i], v);
					if(tabu[i][v] <= it || d + S.violations() < bestViolations){
						// legal move
						if(d < minDelta){
							moves.clear();
							minDelta = d;
							moves.add(new Move(i,v));
						}else if(d == minDelta){
							moves.add(new Move(i,v));
						}
					}
				}
			}
			if(moves.size() == 0){
				restart();
			}else{
				
				// apply the move
				// select a move randomly from moves
				Move m = moves.get(R.nextInt(moves.size()));
				
				x[m.i].setValuePropagate(m.val);
				System.out.println("test x[" + m.i + "] = " + x[m.i].getValue());
				tabu[m.i][m.val]= it + tbl;// update tabu
				
				if(S.violations() < bestViolations){
					bestViolations = S.violations();
					nic = 0;// counter the number of iterations the best is not improved
				}else{
					nic++;
					if(nic > maxStable){
						restart();
					}
				}
			}
			System.out.println("tabuSearch, step " + it + ", S = " + S.violations() + ", best = " + bestViolations);
			if(bestViolations == 0) break;
		}

		for(int i = 0; i < n; i++)
			System.out.println("x[" + i + "] = " + x[i].getValue());
	}
	public void search(int maxIter){
		
		// generate initial solution randomly
		for(int i = 0; i < n; i++){
			int v = R.nextInt(n);
			x[i].setValuePropagate(v);
		}
		
		int k = 0;
		MinMaxSelector mms = new MinMaxSelector(S);
		while(k < maxIter && S.violations() > 0){
			VarIntLS sel_x = mms.selectMostViolatingVariable();
			int sel_v = mms.selectMostPromissingValue(sel_x);
			
			sel_x.setValuePropagate(sel_v);// local move
			
			k++;
			//System.out.println("Step " + k + ", S.violations = " + S.violations() + ", sel_x = x[" + sel_x.getID() + "], sel_v = " + sel_v);
			System.out.println("Step " + k + ", S.violations = " + S.violations());
		}
		
		
		
		// print solution
		for(int i = 0; i < n; i++)
			System.out.println("x[" + i + "] = " + x[i].getValue());
	}
	
	//int timeLimit
	public void solve(){
		readData("bacp.in01");
		stateModel();
		//search(10000);
		tabuSearch(100000, 100, 30);
		//return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BACP bacp = new BACP();
		bacp.solve();
	}

}
