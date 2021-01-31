#include "stdafx.h"
#include "string.h"

#define MAX_SZ 7

int main()
{
	
	char myArray[MAX_SZ] = "Helloo";
	char newArray[MAX_SZ];
	memset(newArray, 0, sizeof(newArray));
	


	_asm {
		mov		ecx, MAX_SZ - 1
		mov		esi, 0

		pushIt:
		movzx	eax, myArray[esi]
			push	eax
			inc	esi
			loop	pushIt


			mov		ecx, MAX_SZ - 1
			mov		esi, 0

			popIt:
		pop		eax
			mov		newArray[esi], al
			inc		esi
			loop	popIt

			lea		eax, newArray
			push	eax
			call	printf
			add		esp, 4
		
	}
	return 0;
}
