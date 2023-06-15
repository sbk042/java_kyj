package day12.practice;

import java.util.Scanner;

public class VocabularyNoteEx {

	public static void main(String[] args) {
		// 영어 단어을 만들기 위해 필요한 클래스를 만들고 테스트해보세요.
		// 단어장안에는 여러개의 단어뜻들이 있음 
		Word word1 = new Word("vocabulary", "the most that make up a large");
	    word1.print();
	    word1.addMeaning("all of the words known and used by a person");
		word1.print();
		word1.removeMeaning(1);
		word1.print();
	}

}


