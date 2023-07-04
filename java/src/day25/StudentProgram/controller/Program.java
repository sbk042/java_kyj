package day25.StudentProgram.controller;

import java.util.Scanner;

//1. 맨처음 입력해주기
public interface Program {
	void printMenu(); //메뉴 출력 기능
	void run(); //실제 프로그램 동작하는 기능 
	void runMenu(int menu, Scanner sc);//메뉴에 따라서 실행하는 기능
}
