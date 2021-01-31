// MaxNum.cpp : Find the highest number from a list of integers
#include "stdafx.h"
#include <stdio.h>
// new instructions
// CMP		value1, value2		; compare value1 and value2 and set flags
// LOOPNZ	label				; decrements ECX by 1, jumps to label if ECX register non-zero
// SHL		destination,count	; shift the bits in the destination left by count
//								; same thing as multiplying by 2 count times
// SHR		destination, count	; shift the destination left
//								; same thing as dividing by 2 count times

int main(int argc, _TCHAR* argv[])
{
	int intval[] = {1, 4, -1, 3};
	char format[] = "Max=%i\n";
	int i;

	int maxval = intval[0];

	for (i = 3; i >= 0; i--) {
		if (maxval >= intval[i]) {		// compare maxval to the array value

		}
		else {
			maxval = intval[i];			// save the array value in maxval if greater
		}
	}	// the size of this portionis 49 bytes

	printf(format, maxval);

	_asm {
				// find the highest value in the array
				// this example is similar to addnumbers
				// uses register indirect addressing mode
				lea esi, [intval]	// get the address of the numbers
				mov eax, [intval]	// EAX is where we store the max value
				; mov ecx, 4		// ECX is our loop counter
				mov ecx, length intval	// Can use the length of intval array for the counter
		label1:	cmp eax, [esi]		// compare eax to array value pointed to by esi
				jge label2			// jump (skip the mov) if eax greater than or equal to array value
				mov eax, [esi]		// copy larger integer array value into storage register EAX
		label2: ; add esi, 4		// increment pointer by 4 to next number in array (int=4 bytes)
				add esi, type intval	// Can increment esi pointer by the size of intval (4 bytes)
				dec ecx				// decrement the loop counter
				jnz label1			// jump back to label1 if ecx is non-zero
				mov [maxval], eax	// save the accumulated value in memory
				// the size of this portion is 26 bytes
	}

	printf(format, maxval);

	_asm {
				// find the highest value in the array
				// this example is similar to addnumbers
				// uses register indirect addressing mode
				lea esi, [intval]	// get the address of the numbers
				mov eax, [intval]	// EAX is where we store the max value
				mov ecx, 4			// ECX is our loop counter
		label3:	cmp eax, [esi]		// compare eax to array value pointed to by esi
				jge label4			// jump (skip the mov) if eax greater than or equal to [esi]
				mov eax, [esi]		// copy larger integer array value into storage register
		label4: add esi, 4			// increment pointer by 4 to next number in array (int=4 ...
				loopnz label3		// jump back to label3 if ecx is non-zero
				mov [maxval], eax	// save the accumulated value in memory
				// the size of this portion is 25 bytes
	}

	printf(format, maxval);

	_asm {

				// find the highest value in the array
				// this uses indexed addressing mode to get the array values
				// and the loop nz instruction

				mov eax, [intval]		// EAX is where we store the max value, copy in value...
				mov ecx, 4				// ECX is our loop counter (need by LOOPNZ), set t...
		label5: shl ecx, 2				// multiply ecx by 4 since integers are 4 bytes
				cmp eax, [intval+ecx-4]	// compare eax to the current array value
				jge label6				// jump (skip the mov) if greater than or equal
				mov eax, [intval+ecx-4]	// copy larger integer array value into storage register
		label6: shr ecx, 2				// divide ecx by 4 so loopnz can decrement it correctly...
				loopnz label5			// jump back to label5 if ecx is non-zero
				mov [maxval], eax		// save the accumulated value in memory
				// the size of this portion is 38 bytes
	}

	printf(format, maxval);

	getchar();
    return 0;
}

