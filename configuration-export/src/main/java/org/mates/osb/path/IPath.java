package org.mates.osb.path;

public interface IPath {

	/**
	 * Adds last child to path.
	 * 
	 * @param name
	 */
	public void addChild(String name);

	/**
	 * Builds path from root to last child. Items are separated by separator
	 * string.
	 * 
	 * @param separator
	 * @return
	 */
	public String buildPath(String separator);

	/**
	 * Array of string. each element represents one resource in path. root
	 * project should be at first position.
	 * 
	 * @return
	 */
	public String[] toArray();

}
