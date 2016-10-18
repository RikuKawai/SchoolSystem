package moe.thisis.SchoolSystem;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "studRecs")
public class StudRecsWrapper {
	private List<Student> studRecs;
	
	@XmlElement(name = "student")
	public List<Student> getStudRecs() {
		return studRecs;
	}
	public void setStudRecs(List<Student> studRecs) {
		this.studRecs = studRecs;
	}
}
