package careercup.facebook;

/**
https://careercup.com/question?id=5435425459011584
	Given a list of input tasks to run, and the cooldown interval, output the minimum number of time slots required to run them. 
	// Tasks: 1, 1, 2, 1, 2 
	// Recovery interval (cooldown): 2 
	// Output: 8 (order is 1 _ _ 1 2 _ 1 2 ) 
	Whats the time and space complexity ? What's the ideal case of space complexity ?
*/	

/**
https://careercup.com/question?id=5675602320293888
Given a list of input tasks to run, and the cooldown interval, output the minimum number of time slots required to run them. 
// Tasks: 1, 1, 2, 1, 2 
// Recovery interval (cooldown): 2 
// Output: 8 (order is 1 _ _ 1 2 _ 1 2 ) 

========= 
Tasks are task numbers in that order coming in for execution. Cooling time is time interval required to cool down the machine after executing a task. So it's like if CPU executed task 1 then it needs 2 cooling time intervals before executing another task 1 but meanwhile, it can execute other tasks which are not same as 1 and so on. So before executing any task, you have to check if you have executed same task number before and if yes, then if its cooling time interval is done or not. 
The output is basically the number of cycles/time slots CPU took to execute these tasks in that order (including when task executed and cooling intervals).
 */
public class TasksWithCoolDown {

}
