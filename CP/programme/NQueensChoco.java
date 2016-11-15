import java.util.Scanner;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.variables.integer.IntegerVariable;
import localsearch.constraints.alldifferent.AllDifferent;
import localsearch.functions.basic.FuncPlus;
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
public class NQueensChoco {

	int numberOfQueen;
	CPModel cpModel;
	IntegerVariable[] queens;
	
	private void stateModel(){
		cpModel = new CPModel();
		queens = Choco.makeIntVarArray("Q", numberOfQueen,1, numberOfQueen);
		for(int i = 0; i < numberOfQueen; i++){
			for(int j = i + 1; j < numberOfQueen; j++){
				cpModel.addConstraint(Choco.neq(queens[i], queens[j]));
				cpModel.addConstraint(Choco.neq(Choco.plus(queens[i], i), Choco.plus(queens[j], j)));
				cpModel.addConstraint(Choco.neq(Choco.minus(queens[i], i), Choco.minus(queens[j], j)));
			}
		}
	}
	
	private void search(){
		CPSolver solver = new CPSolver();
		solver.read(cpModel);
		solver.solveAll();
		
		for(int i = 0; i < numberOfQueen; i++){
			System.out.println("queens["+(i+1)+"] = "+solver.getVar(queens[i]).getValue());
		}
	}
	public void solve(int numOfQueen){
		this.numberOfQueen = numOfQueen;
		stateModel();
		search();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfQueen;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of the queen : ");
		numberOfQueen = sc.nextInt();
		NQueensChoco queen = new NQueensChoco();
		queen.solve(numberOfQueen);

	}

}
