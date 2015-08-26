/**
 * 
 */
package predictions2;

import java.io.Serializable;

/**
 * @author anderson
 * 
 */
@SuppressWarnings("serial")
public class Prediction implements Serializable, Comparable<Prediction> {

	private String who; // person
	private String what; // his/her predition
	private int id; // identifier used as lookup key

	public Prediction() {

	}

	/**
	 * @return the who
	 */
	public String getWho() {
		return who;
	}

	/**
	 * @param who
	 *            the who to set
	 */
	public void setWho(String who) {
		this.who = who;
	}

	/**
	 * @return the what
	 */
	public String getWhat() {
		return what;
	}

	/**
	 * @param what
	 *            the what to set
	 */
	public void setWhat(String what) {
		this.what = what;
	}

	/**
	 * @return the ind
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param ind
	 *            the ind to set
	 */
	public void setId(int ind) {
		this.id = ind;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Prediction other) {
		return this.id - other.id;
	}

}
