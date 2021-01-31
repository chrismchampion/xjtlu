// Practical3.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"


int main(int argc, _TCHAR* argv[])
{

	char colonMsg[] = ": ";
	char commaMsg[] = ", ";
	char programStartMessage[] = "Select total number of positive integers (between 2-5): ";
	char invalidInputMessage[] = "\nYou entered invalid input.\n";
	char enterIntMessage[] = "\nEnter positive integer ";
	char loopTerminatesMessage[] = "\nProgram terminates and has looped 4 times.\n";
	char bubbleSortMessage[] = "\nYour integers from lowest to highest is \n";
	char totalAmountMessage[] = "\n\nThe total amount is: ";
	char endMessage[] = "\n\nType in any integer and press RETURN key to finish: ";
	char format[] = "%d"; // format string for the scanf function

	char testArrayValMsg[] = "\n\nThe values in test array are: ";
	int testArrayCounter = 5;
	int testArray[] = { 1,3,7,9,2 };

	//int numberArray[5];
	int numberArray[5];
	int numOfIntsEntered = 0;

	char numIntsEnteredMsg[] = "\nYou entered this many numbers: ";

	int counter;
	int maxLoopVal = 5;
	int minLoopVal = 2;
	int totalAmt;
	int end;

	_asm {
	// 1. GET COUNTER VALUE
	lea eax, programStartMessage	// eax points to first character in progStartMsg array
	push eax						// push eax reg. to stack
	// print message and read the counter in (loops back for invalid user input)
	getCounter :	call printf			// Begin Loop: Call C printf function
					lea eax, counter	// eax points to counter
					push eax			// push eax reg. to stack
					lea eax, format		// eax points to format string for int input with scanf
					push eax			// push formatted string value to stack
					call scanf_s		// Call C scan function to read in counter
					add esp, 8			// Add 8 bytes for counter and format push to eax

					// Compare input with permissable max/min value
					mov eax, counter	// move counter value into eax for comparing
					mov ebx, maxLoopVal	// move max loop value of 5 into ebx for comparing
					cmp eax, ebx		// compare the two values and jump if ebx > eax
					jg invalidInput		// jumps or falls through

					mov ebx, minLoopVal	// move min loop value of 2 into ebx
					cmp eax, ebx		// compare and jump if ebx < eax
					jl invalidInput		// jumps or falls through

					jmp leaveLoop		// If counter between 2 and 6 leave loop 

					invalidInput :	lea eax, invalidInputMessage
									push eax
									call printf
									add esp, 4	// Add 4 bytes for invalid input msg push to eax
									jmp getCounter

	leaveLoop : add esp, 4	// Add 4 bytes to stack pointer for programStartMessage push to eax

	// 2. GET VALUES FROM USER TO STORE IN numberArray
	mov ebx, counter				// Move the counter into ebx register
	//push ebx						// push to the stack to decrement in enterIntMessage loop

						// push to the stack for printing
	lea esi, numberArray
	printEnterMsg : 	
		lea		eax, enterIntMessage	; eax points to first char in enterIntMessage array
		push	eax
		call	printf					; Begin Loop: Call C function to print enterIntMsg
		add		esp, 4
		inc		numOfIntsEntered		; Increment num of ints entered (init with 0)
					
					mov eax, numOfIntsEntered // Load value of numOfIntsEntered
					push eax
					lea eax, format
					push eax
					call printf
					add esp, 8

					lea eax, colonMsg
					push eax
					call printf
					add esp, 4	// Prints enterIntMessage + numOfItsEntered + ": "

					push esi
					lea eax, format
					push eax
					call scanf_s			// Call C scan function to read in counter
					add esp, 8

					cmp [esi], 0
					//jl OUTSIDE_LOOP

					add esi, 4
								// Add 20 bytes to stack pointer for five eax pushes
					dec ebx					// Decrement counter
					jnz printEnterMsg		// Jump if counter != 0, else fall through
	//add esp, 4						// Add 8 bytes to stack pointer for ebx and eax push


	// PRINT NUM OF INTS ENTERED MSG
	lea eax, numIntsEnteredMsg
	push eax
	call printf
	add esp, 4

	// PRINT NUM OF INTS ENTERED VAL
	mov eax, numOfIntsEntered
	push eax
	lea eax, format
	push eax
	call printf
	add esp, 8

	//mov esi, 0
	//intArray[esi]
	//intArray[esi+4]
	// Add up array values, move to to totalAmt
	lea esi, numberArray
	mov ebx, numOfIntsEntered
	mov eax, 0
	label1: add eax, [esi]
			add esi, 4
			dec ebx
			jnz label1
	mov totalAmt, eax

	// Print totalAmountMessage
	lea eax, totalAmountMessage
	push eax
	call printf
	add esp, 4

	// Print totalAmt
	push totalAmt
	lea eax, format
	push eax
	call printf
	//add esp, type intArray
	add esp, 8

	// PRINT TEST ARRAY MESSAGE
	lea eax, testArrayValMsg
	push eax
	call printf
	add esp, 4

	// PRINT TEST ARRAY w/ ebx
	/*lea esi, testArray
	mov ebx, testArrayCounter
	//push ebx

	loopArr:	mov eax, [esi]
				add esi, 4
				push eax
				lea eax, format
				push eax
				call printf
				add esp, 8	
				dec ebx
				
				jnz loopArr
	//add esp, 4*/

	// PRINT TEST ARRAY w/ ecx
	/*lea esi, testArray
	mov ecx, testArrayCounter
				// push ecx onto the stack to restore after function call
	loopArr:	push ecx
				mov eax, [esi]
				add esi, 4
				push eax
				lea eax, format
				push eax
				call printf
				add esp, 8
				pop ecx	// pop ecx to retrieve value
				loop loopArr*/	// decrement ecx by 1, loop if not 0

	// PRINT numberArray
	lea esi, numberArray
	mov ecx, numOfIntsEntered
				// push ecx onto the stack to restore after function call
	loopNumArr:	push ecx
				mov eax, [esi]
				add esi, 4
				push eax
				lea eax, format
				push eax
				call printf
				add esp, 8
				pop ecx	// pop ecx to retreive value
				loop loopNumArr	// decrement ecx by 1, loop if not 0

	// Print endMessage and enter int to Quit
	finish :	lea eax, endMessage	//; Load effective address of endMessage into eax register
				push eax			//; Push eax to the stack
				call printf		//; Print endMessage
				add esp, 4			//; Add 4 bytes to stack pointer for eax push

				lea eax, end		//; Load effective address of int var end into eax register
				push eax			//; Push eax to the stack
				lea eax, format		//; Load effective address of format char[] into eax register
				push eax			//; Push eax to the stack
				call scanf_s		//; Call scanf_s function for user input
				add esp, 8			//; Add 8 bytes to the stack pointer for the two eax pushes
	}
	return 0;
}