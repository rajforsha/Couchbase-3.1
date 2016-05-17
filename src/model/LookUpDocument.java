package model;

import java.util.List;

/**
 * @author shashi
 *
 */
public class LookUpDocument implements Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3878731580596880501L;
	private String rootId;
	private List<String> chilIds;

	/**
	 * @return the rootId
	 */
	public String getRootId() {
		return rootId;
	}

	/**
	 * @param rootId
	 *            the rootId to set
	 */
	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	/**
	 * @return the chilIds
	 */
	public List<String> getChilIds() {
		return chilIds;
	}

	/**
	 * @param chilIds
	 *            the chilIds to set
	 */
	public void setChilIds(List<String> chilIds) {
		this.chilIds = chilIds;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LookUpDocument [rootId=" + rootId + ", chilIds=" + chilIds + "]";
	}

}
