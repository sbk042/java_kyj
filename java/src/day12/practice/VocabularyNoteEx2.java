package day12.practice;

public class VocabularyNoteEx2 {

	public static void main(String[] args) {
		Word wordList[] = {
				new Word("abc"),
				new Word("def","def is define")
		};
		
		VocabularyNote note = new VocabularyNote(wordList);
		//note.print();
		
		Word word = new Word("a", "a");
		note.insert(word);
		//note.print();
		note.insert("b","b is b");
		//note.print();
		
		//note.delete("c"); //없는 단어를 입력 ( 안내문구 출력 되는지 확인 ) No words found출력
		note.delete("a"); //있는 단어를 입력 ( a단어가 삭제 되는지 확인 )
		//note.print();
		
		//note.search("a");
		//note.search("b");
		note.print();
		
		note.insert("b","b");
		//note.print();
		
		note.updateMeaning("b", 2, "B");
		note.updateMeaning("b", 3, "B"); //Wrong number
		//note.print();
		
		note.updateTitle("b", "B");
		// No words found 출력 이미 앞에서 수정해서 수정할 b가 없음
		note.updateTitle("b", "B"); 
		note.print();
	}
}










