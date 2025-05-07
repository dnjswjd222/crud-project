package com.shinhan.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JavaBeans 기술에서 사용가능해야한다. (default 생성자, getter/setter 필요)
//DTO(Data Transfer Object)
//칼럼의 이름과 필드가 일치하는 것이 좋다
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpDTO {
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private Double salary;
	private Double commission_pct;
	private Integer manager_id;
	private Integer department_id;
}
