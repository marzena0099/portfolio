package org.example.portfolio;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Date;
import java.time.YearMonth;

@Converter(autoApply = true)
public class YearMonthDateAttributeConverter implements AttributeConverter<YearMonth, Date> {

    @Override
    public Date convertToDatabaseColumn(YearMonth attribute) {
        return (attribute != null) ? Date.valueOf(attribute.atDay(1)) : null;
    }

    @Override
    public YearMonth convertToEntityAttribute(Date dbData) {
        return (dbData != null) ? YearMonth.from(dbData.toLocalDate()) : null;
    }
}
