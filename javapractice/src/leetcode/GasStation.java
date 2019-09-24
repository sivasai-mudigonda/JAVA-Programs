/**
 * 
 */
package leetcode;

/**
 * @author u230107
 *
 *         LeetCode Ques - 134 {Gas Station}
 *         https://leetcode.com/problems/gas-station/
 *
 *         There are N gas stations along a circular route, where the amount of
 *         gas at station i is gas[i]. You have a car with an unlimited gas tank
 *         and it costs cost[i] of gas to travel from station i to its next
 *         station (i+1). You begin the journey with an empty tank at one of the
 *         gas stations. Return the starting gas station’s index if you can
 *         travel around the circuit once in the clockwise direction, otherwise
 *         return -1. Note: If there exists a solution, it is guaranteed to be
 *         unique. Both input arrays are non-empty and have the same length.
 *         Each element in the input arrays is a non-negative integer.
 *
 *         Example 1: Input: gas = [1,2,3,4,5] cost = [3,4,5,1,2] Output: 3
 *         Explanation: Start at station 3 (index 3) and fill up with 4 unit of
 *         gas. Your tank = 0 + 4 = 4 Travel to station 4. Your tank = 4 - 1 + 5
 *         = 8 Travel to station 0. Your tank = 8 - 2 + 1 = 7 Travel to station
 *         1. Your tank = 7 - 3 + 2 = 6 Travel to station 2. Your tank = 6 - 4 +
 *         3 = 5 Travel to station 3. The cost is 5. Your gas is just enough to
 *         travel back to station 3. Therefore, return 3 as the starting index.
 *         Example 2: Input: gas = [2,3,4] cost = [3,4,3] Output: -1
 *         Explanation: You can't start at station 0 or 1, as there is not
 *         enough gas to travel to the next station. Let's start at station 2
 *         and fill up with 4 unit of gas. Your tank = 0 + 4 = 4 Travel to
 *         station 0. Your tank = 4 - 3 + 2 = 3 Travel to station 1. Your tank =
 *         3 - 3 + 3 = 3 You cannot travel back to station 2, as it requires 4
 *         unit of gas but you only have 3. Therefore, you can't travel around
 *         the circuit once no matter where you start.
 *
 *         Time Complexity =O(N) Space Complexity =o(1)
 */
public class GasStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GasStation obj = new GasStation();

		int[] gas1 = { 1, 2, 3, 4, 5 };
		int[] cost1 = { 3, 4, 5, 1, 2 };
		System.out.println("starting gas station’s index = " + obj.canCompleteCircuit(gas1, cost1)); // Expected Result
																										// = 3

		int[] gas2 = { 2, 3, 4 };
		int[] cost2 = { 3, 4, 3 };
		System.out.println("starting gas station’s index = " + obj.canCompleteCircuit(gas2, cost2)); // Expected Result
																										// = -1
	}

	private int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
			return -1;
		}
// We assume index=0 initially to find out if we can travel around the circuit once
		int startingGasStation = 0;
		int totalRequiredGas = 0; // tracks the sum of the gas required to reach startingGasstation
		int suplusGas = 0; // Additional Gas that is left over
		for (int station = 0; station < gas.length; station++) {
// Gas Required to reach next station = gas[station]-cost[station]
			suplusGas += gas[station] - cost[station];
			totalRequiredGas += gas[station] - cost[station];
			if (suplusGas < 0) {
				suplusGas = 0;
//If sum of gas less than sum of cost, the travel can not be back to the original station.
// so update the startingGasStation to next station and find out if we can travel around the circuit once.
				startingGasStation = station + 1;
			}
		}
		return totalRequiredGas >= 0 ? startingGasStation : -1;
	}
}