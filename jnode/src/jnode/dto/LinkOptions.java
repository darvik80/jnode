package jnode.dto;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

/**
 * Опции для линков
 * 
 * @author kreon
 * 
 */
public class LinkOptions {
	@DatabaseField(columnName = "link_id", foreign = true, canBeNull = false, uniqueIndexName = "lopt_idx")
	private Link link;
	@DatabaseField(columnName = "option", canBeNull = false, uniqueIndexName = "lopt_idx")
	private String option;
	@DatabaseField(columnName = "value", canBeNull = false, dataType = DataType.LONG_STRING)
	private String value;

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
