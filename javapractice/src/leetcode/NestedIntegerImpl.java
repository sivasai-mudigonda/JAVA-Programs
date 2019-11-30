/**
 * 
 */
package leetcode;

import java.util.List;

/**
 * @author SivaM
 *
 */
public class NestedIntegerImpl implements NestedInteger {
	private List<NestedInteger> list;
	private Integer integer;

	public NestedIntegerImpl(List<NestedInteger> list) {
		this.list = list;
	}
	
	public NestedIntegerImpl(Integer integer) {
		this.integer = integer;
	}

	@Override
	public boolean isInteger() {
		return integer != null;
	}

	@Override
	public Integer getInteger() {
		return integer;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}
}
