package in.co.vertex.feedback.model;

// Generated Mar 29, 2010 6:46:32 PM by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Option generated by hbm2java
 */
public class Option implements java.io.Serializable {

	private int optionId;
	private String label;
	private Set<Question> questions = new HashSet<Question>(0);

	public Option() {
	}

	public Option(String label) {
		this.label = label;
	}

	public Option(String label, Set<Question> questions) {
		this.label = label;
		this.questions = questions;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}