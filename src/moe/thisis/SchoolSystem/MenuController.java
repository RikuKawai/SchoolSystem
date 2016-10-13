package moe.thisis.SchoolSystem;

import java.io.File;
import java.io.IOException;

import moe.thisis.SchoolSystem.StudentSystem;
import moe.thisis.SchoolSystem.Student;

public class MenuController {
	
	private StudentSystem main;
	
	public MenuController() {
		
	}
	
	public void entryAdd() throws IOException {
		Student tempStudent = new Student();
		main.getStudentInput(tempStudent);
		main.getStudRecs().add(tempStudent);
	}
}
