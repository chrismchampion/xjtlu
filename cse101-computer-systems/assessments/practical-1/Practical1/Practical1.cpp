// Practical1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"


int main(int argc, _TCHAR* argv[])
{
	char message1[] = "Give me a first number: ";
	char message2[] = "\nGive me a second number: ";
	char message3[] = "\nThe numbers are equal! \n";
	char message4[] = "\nThe numbers are not equal! \n";
	char message5[] = "Type in any integer and press RETURN key to finish: ";
	char format[] = "%d"; // format string for the scanf function

	int first;
	int second;
	int end;

	_asm {
		lea eax, message1
		push eax			; PRINTING THE FIRST MESSAGE
		call printf
		add esp, 4

		lea eax, first
		push eax
		lea eax, format		; READING the FIRST NUMBER
		push eax
		call scanf_s
		add esp, 8

		lea eax, message2
		push eax			; PRINTING the SECOND MESSAGE
		call printf
		add esp, 4

		lea eax, second
		push eax
		lea eax, format		; READING the SECOND NUMBER
		push eax
		call scanf_s
		add esp, 8

		mov eax, first
		sub eax, second
		jnz nequal

		equal: lea eax, message3
			   push eax
			   call printf	; PRINTING "Numbers are equal"
			   add esp, 4
			   jmp finish	; JUMP to finish

		nequal: lea eax, message4
				push eax	; PRINTING "Numbers are not equal"
				call printf
				add esp, 4

		finish: lea eax, message5
				push eax	; PRINTING the FIFTH MESSAGE
				call printf
				add esp, 4

				lea eax, end
				push eax
				lea eax, format
				push eax
				call scanf_s
				add esp, 8
	}
    return 0;
}

