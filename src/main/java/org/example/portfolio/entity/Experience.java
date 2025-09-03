package org.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.portfolio.YearMonthDateAttributeConverter;
import java.time.YearMonth;

@Entity
@Data
@Table(name = "Experience")
public class Experience
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    private String title;
    @Column(name = "start_date")
    @Convert(converter = YearMonthDateAttributeConverter.class)
    private YearMonth startDate;

    @Column(length = 6000)
    private String description;
    @Column(name = "end_date")
    @Convert(converter = YearMonthDateAttributeConverter.class)
    private YearMonth endDate;
}
