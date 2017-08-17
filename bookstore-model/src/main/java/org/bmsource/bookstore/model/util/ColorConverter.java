package org.bmsource.bookstore.model.util;

import javax.persistence.AttributeConverter;

public class ColorConverter implements AttributeConverter<Color, String> {

	@Override
	public String convertToDatabaseColumn(Color attribute) {
		if (attribute != null) {
			return attribute.getR() + "|" + attribute.getG() + "|" + attribute.getB();
		} else {
			return null;
		}
	}

	@Override
	public Color convertToEntityAttribute(String dbData) {
		if (dbData != null) {
			String[] rgb = dbData.split("\\|");
			return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
		} else {
			return new Color(0, 0, 0);
		}

	}

}
